// package programmers.java.lv1;

import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 자릿수 더하기
 * 
 */
public class ProgrammersLv1Q2 {
    /* 
    public static void main(String[] args) {
        System.out.println(
            solution(987)
        );
    }
    */
    public static int solution(int n) {
        String nString = Integer.toString(n); 
        int length = nString.length(); // n의 자릿수
        int answer = 0;

        // 자릿수 더하기
        for(int i=0; i < length; i++) {
            answer += nString.charAt(i) - '0';
        }

        return answer;
    }

}