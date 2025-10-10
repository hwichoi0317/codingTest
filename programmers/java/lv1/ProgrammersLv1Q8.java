// package programmers.java.lv1;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv1. 짝수와 홀수
 * 
 */
public class ProgrammersLv1Q8 {
    
    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis(); // 서비스 로직 시작 시간(성능테스트 위함)
        
        System.out.println(solution(-1));

        long endTime = System.currentTimeMillis(); // 서비스 로직 종료 시간(return 직전, 성능 테스트 위함)

	    long durationTimeSec = endTime - startTime;
	    System.out.println(durationTimeSec + "m/s"); // 밀리세컨드
        
    }
    
    public static String solution(int num) {
        return Math.abs(num)%2 == 1? "Odd":"Even";
    } 
}