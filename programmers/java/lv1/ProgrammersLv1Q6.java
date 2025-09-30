// package programmers.java.lv1;

import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 없는 숫자 더하기
 * 
 */
public class ProgrammersLv1Q6 {
    
    public static void main(String[] args) {
        System.out.println(
            solution(new int[]{1,2,3,4,6,7,8,0})
        );
    }
    
    public static int solution(int[] numbers) {
        int answer = 45;
        
        for(int number:numbers) {
            answer -= number;
        }
        
        return answer;
    }

}