// package programmers.java.lv1;

import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 자연수 뒤집어 배열로 만들기
 * 
 */
public class ProgrammersLv1Q1 {
    /* 
    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(ProgrammersLv1Q1.solution(12345))
        );
    }
    */

    public static int[] solution(long n) {
        String nString = Long.toString(n); 
        int length = nString.length(); // n의 자릿수
        int[] answer = new int[length];

        int idx=0;

        // 자연수 뒤집어 배열로 만들기
        for(int i=length-1;i >= 0;i--) {
            answer[idx] = nString.charAt(i) - '0';
            idx++;
        }

        return answer;
    }

}