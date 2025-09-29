import java.util.*;
import java.util.stream.Stream;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv2. 하노이의 탑
 * 
 */
public class ProgrammersLv2Q5 {
    
    public static void main(String[] args) {
        int[][] answer = solution(3);

        /*
        for(int i=0; i<answer.length; i++){
            System.out.println(
                Arrays.toString(answer[i]) 
            );
        }
        */

        Stream.of(answer)
            .map(Arrays::toString) // 각 int[] 배열을 문자열로 변환
            .forEach(System.out::println); // 변환된 문자열을 출력
        
    }
    
    private static List<int[]> arr = new ArrayList<>();

    public static int[][] solution(int n) {
        move(n, 1, 2, 3);
        int[][] answer = arr.stream()
                .toArray(int[][]::new);
        return answer;
    }

    /**
    * cnt개의 원판을 start기둥에서 mid 기둥을 거쳐 end기둥으로 옮깁니다. 
    *
    * @param cnt 원판 개수 
    * @param start 이동 시작 기둥
    * @param mid 이동 중간에 거쳐가는 기둥
    * @param end 이동 목적지 기둥
    */
    private static void move(int cnt, int start, int mid, int end) {
        if (cnt < 1) {
            return;
        }
        move(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end});
        move(cnt - 1, mid, start, end);
    }

}