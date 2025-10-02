import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv2. 수식 최대화
 * 
 */
public class ProgrammersLv2Q3 {
    /* 
    public static void main(String[] args) {
        System.out.println(
            Arrays.toString( solution(6, 6
                , new int[][]{ {2,2,5,4},{3,3,6,6},{5,1,6,3} }) 
            )
        );
    }
    */
    
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        // 행렬 만들기
        int num = 1;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                matrix[i][j] = num++;
            }
        }

        int idx = 0;
        for(int[] query : queries) {
            answer[idx++] = move(matrix, query); // 행렬 테두리 시계 방향으로 회전 및 회전한 숫자들 중 최솟값 answer[idx]에 대입
        }

        return answer;
    }

    /**
    * 주어진 행렬에서 지정된 영역의 테두리를 시계 방향으로 한 칸 회전시킵니다.
    *
    * @param matrix 회전할 대상 행렬
    * @param query  회전할 영역의 좌표 {시작 행, 시작 열, 끝 행, 끝 열}
    *               (예: {2, 2, 5, 4} → (2,2)에서 (5,4)까지의 테두리)
    * @return 회전 과정에서 이동한 값들 중 최솟값
    */
    private static int move(int[][] matrix, int[] query) {
        int startRow = query[0]-1; // 시작점 row index
        int startCol = query[1]-1; // 시작점 column index 
        int endRow = query[2]-1; // 종점 row index
        int endCol = query[3]-1; // 종점 column index

        int srSc = matrix[startRow][startCol]; // 시작점 값(왼쪽 위)
        int srEc = matrix[startRow][endCol]; // 오른 쪽 위 값
        int erEc = matrix[endRow][endCol]; // 종점 값(오른 쪽 아래)
        int erSc = matrix[endRow][startCol]; // 왼 쪽 아래 값

        int min = (matrix.length)*(matrix[0].length); // 이동한 값 중 최솟값
        
        // 오른 쪽으로 이동
        for(int i=endCol; i >= startCol+1; i--){
            if(i == startCol+1) {
                matrix[startRow][i] = srSc;    
            } else {
                matrix[startRow][i] = matrix[startRow][i-1];
            }

            min = (matrix[startRow][i] < min) ? matrix[startRow][i] : min;
        }

        // 아래로 이동
        for(int i=endRow;i >= startRow+1;i--){
            if(i == startRow+1) {
                matrix[i][endCol] = srEc;    
            } else {
                matrix[i][endCol] = matrix[i-1][endCol];
            }

            min = (matrix[i][endCol] < min) ? matrix[i][endCol] : min;
        }

        // 왼 쪽으로 이동
        for(int i=startCol; i <= endCol-1; i++){
            if(i == endCol-1) {
                matrix[endRow][i] = erEc;    
            } else {
                matrix[endRow][i] = matrix[endRow][i+1];
            }

            min = (matrix[endRow][i] < min) ? matrix[endRow][i] : min;
        }

        // 위로 이동
        for(int i=startRow;i <= endRow-1;i++){
            if(i == endRow-1) {
                matrix[i][startCol] = erSc;    
            } else {
                matrix[i][startCol] = matrix[i+1][startCol];
            }
                
            min = (matrix[i][startCol] < min) ? matrix[i][startCol] : min;
        }

        return min;
    }

}