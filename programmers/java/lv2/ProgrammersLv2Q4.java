import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv2. [3차] 압축
 * 
 */
public class ProgrammersLv2Q4 {
    
    public static void main(String[] args) {
        System.out.println(
            Arrays.toString( solution("TOBEORNOTTOBEORTOBEORNOT") 
            )
        );
    }
    
    public static int[] solution(String msg) {
        long startTime = System.currentTimeMillis(); // 서비스 로직 시작 시간(성능테스트 위함)

        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> alphabetMap = new HashMap<>(); // 단어와 그에 해당하는 색인 번호 값 Map
        initMap(alphabetMap); // alphabetMap에 A~Z에 해당하는 색인 번호 값 추가

        int stringIndex = 0;
        int indexNumber = 0;

        while ( stringIndex < msg.length() ) {
            
            String s = msg.substring(stringIndex, stringIndex+1);

            while(stringIndex < msg.length() && alphabetMap.containsKey(s)) {
                indexNumber = alphabetMap.get(s);

                stringIndex++;
                if(stringIndex > msg.length()-1) break;
                s +=msg.charAt(stringIndex);
            }

            answerList.add(indexNumber);
            alphabetMap.put(s, alphabetMap.size()+1);
        }

        long endTime = System.currentTimeMillis(); // 서비스 로직 종료 시간(return 직전, 성능 테스트 위함)

	    long durationTimeSec = endTime - startTime;
	    System.out.println(durationTimeSec + "m/s"); // 밀리세컨드
	    // System.out.println((endTime / 1000) + "sec"); // 세컨드(초 단위 변환)

        return answerList.stream()
                              .mapToInt(Integer::intValue) // 언박싱
                              .toArray();
    }

    /**
    * parameter로 전달 받은 Map에 A: 1, B:2,...Z:26과 같이 요소를 추가합니다.
    *
    * @param alphabetMap {알파벳: 숫자} 데이터를 추가할 Map객체
    */
    private static void initMap(Map<String, Integer> alphabetMap) {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabetMap.put(String.valueOf(c), c - 'A' + 1);
        }               
    }

}