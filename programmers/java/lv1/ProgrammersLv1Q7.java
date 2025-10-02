// package programmers.java.lv1;

import java.util.*;
import java.util.stream.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 약수의 개수와 덧셈
 * 
 */
public class ProgrammersLv1Q7 {
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // 서비스 로직 시작 시간(성능테스트 위함)
        
        System.out.println(
            solution(13, 17)
        );

        long endTime = System.currentTimeMillis(); // 서비스 로직 종료 시간(return 직전, 성능 테스트 위함)

	    long durationTimeSec = endTime - startTime;
	    System.out.println(durationTimeSec + "m/s"); // 밀리세컨드
	    
        
    }
    
    /*
    // 약 0 m/s
    public static int solution(int left, int right) {
        
        int answer = 0;

        for(int i=left; i<=right; i++) {
            answer +=updateNumber(i);
        }
	    
        return answer;
    }

    private static int updateNumber(int i) {
        int divisor=1;
        int cnt =0;
        
        while(divisor*divisor <= i){
            
            if(i%divisor == 0) {
                if(divisor*divisor == i){
                    cnt++;
                } else {
                    cnt +=2;
                }
            }

            divisor++;
        }

        if(cnt %2 != 0) i *=-1;

        return i;
    }
    */
    
    // 8m/s
    public static int solution(int left, int right) {
    return IntStream.rangeClosed(left, right)
        .map(i -> {
            int r = (int) Math.sqrt(i);
            return (r * r == i) ? -i : i;
        })
        .sum();
    } 
}