// package programmers.java.lv1;

import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 정수 내림차순으로 배치하기
 * 
 */
public class ProgrammersLv1Q3 {
    /* 
    public static void main(String[] args) {
        System.out.println(
            solution(118372)
        );
    }
    */
    public static long solution(long n) {
        StringBuilder answer = new StringBuilder();
        String nString = Long.toString(n);
        char[] nCharArray = new char[nString.length()]; // 정수n의 자릿수를 담은 char배열
        

        // 정수 n의 자릿수 nCharArray배열에 담기
        for(int i=0; i<nString.length(); i++){
            nCharArray[i] = nString.charAt(i); 
        }
        
        Arrays.sort(nCharArray); // 배열 nCharArray 오름차순화
        
        // 배열 nCharArray 요소 중 큰 것부터 answer변수에 append
        for(int i=nCharArray.length-1; i>=0;i--) {
            answer.append(nCharArray[i]);
        }
        
        return Long.parseLong(answer.toString());
    }

}