// package programmers.java.lv1;

import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 핸드폰 번호 가리기
 * 
 */
public class ProgrammersLv1Q5 {
    
    public static void main(String[] args) {
        System.out.println(
            solution("027778888")
        );
    }
    
    public static String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        
        int length = phone_number.length();
        while(length > 4) {
            answer.append("*");
            length--;
        }
        answer.append(phone_number.substring(phone_number.length()-4,phone_number.length()));
        
        
        return answer.toString();
    }

}