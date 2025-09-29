// package programmers.java.lv1;

import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 문자열 내 p와 y의 개수
 * 
 */
public class ProgrammersLv1Q4 {
    /*     
    public static void main(String[] args) {
        System.out.println(
            solution("pPoooyY")
        );
    }
    */
    public static boolean solution(String s) {
        s = s.toLowerCase(); // 문자열 s 내용 모두 소문자로 바꾸기
        boolean answer = true;
        int pCount = 0; // p의 개수
        int yCount = 0; // y의 개수

        for ( int i=0;i<s.length();i++ ) {
            char c = s.charAt(i);

            if(c == 'p') pCount++;
            if(c == 'y') yCount++;
        }

        if(pCount != yCount) answer = false;
        return answer;
    }

}