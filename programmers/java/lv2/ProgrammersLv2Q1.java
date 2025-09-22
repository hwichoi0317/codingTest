import java.util.*;

/**
 * 출처: 프로그래머스 코딩테스트 > Lv2. [3차]방금그곡
 * 
 */
public class ProgrammersLv2Q1 {
    /* 
    public static void main(String[] args) {
        System.out.println(
            solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
    */
    
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = changeLyrics(m);
        int longestPlayTime = 0;

        for(String musicinfo : musicinfos) {
            String[] musicinfoArray = musicinfo.split(",");
            String startTime = musicinfoArray[0]; // 음악 재생 시작시간
            String endTime = musicinfoArray[1]; // 음악 재생 종료시간
            String subTitle = musicinfoArray[2]; // 음악 제목
            String lyrics = changeLyrics(musicinfoArray[3]); // 음악 가사

            int playTime = getPlayTime(startTime, endTime); // 음악 재생 시간


            String playLyrics = getPlayLyrics(lyrics, playTime); // 재생 된 음악 가사
            
            // 재생 된 음악 가사에 네오가 들었던 가사(m)이 포함 되었는 지 검사
            if(playLyrics.contains(m)){
                if( playTime > longestPlayTime ) {
                    answer = subTitle;
                    longestPlayTime = playTime;
                }        
            }
        }


        return answer;
    }

    /*
    노래가 지속되는 시간(분 단위) return
    */ 
    private static int getPlayTime(String startTime, String endTime){
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int startMinute = Integer.parseInt(startTime.split(":")[1]);
        int endHour = Integer.parseInt(endTime.split(":")[0]);
        int endMinute = Integer.parseInt(endTime.split(":")[1]);

        int playTime = (endHour*60+endMinute)-(startHour*60+startMinute);

        return playTime;
    }

    /*
    재생 된 전체 가사 return
    */
    private static String getPlayLyrics(String lyrics, int playTime){
        StringBuilder playLyrics = new StringBuilder();
        // int lyricsLen = lyrics.replaceAll("#", "").length();

        int i=0;
        int time=0;
        while( time < playTime ) {
            char lyric = lyrics.charAt(i%(lyrics.length()));
            
            playLyrics.append(lyric);
            i++;
            if(lyric != '#') time++;
        }    

        return playLyrics.toString();
    }

    /*
    가사 중 #이 포함 된 가사 소문자로 치환(예: C# -> c)
    */
    private static String changeLyrics(String lyrics) {
        StringBuilder sb = new StringBuilder(lyrics.length());
        
        for (int i = 0; i < lyrics.length(); i++) {
            char c = lyrics.charAt(i);
            if (i + 1 < lyrics.length() && lyrics.charAt(i + 1) == '#') {
                sb.append(Character.toLowerCase(c)); // C# -> 'c'
                i++; // '#' 건너뜀
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}