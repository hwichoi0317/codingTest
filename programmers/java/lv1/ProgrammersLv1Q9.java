// package programmers.java.lv1;

import java.util.Arrays;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. x만큼 간격이 있는 n개의 숫자
 * 
 */
public class ProgrammersLv1Q9 {
    
    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis(); // 서비스 로직 시작 시간(성능테스트 위함)
        
        System.out.println(Arrays.toString(solution(2,5)));

        long endTime = System.currentTimeMillis(); // 서비스 로직 종료 시간(return 직전, 성능 테스트 위함)

	    long durationTimeSec = endTime - startTime;
	    System.out.println(durationTimeSec + "m/s"); // 밀리세컨드
        
    }
    
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for (int i=1;i <= n;i++) {
            answer[i-1] = (long)x * i; 
        }
        return answer;
    }
}