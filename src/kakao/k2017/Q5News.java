package kakao.k2017;

import java.util.ArrayList;
import java.util.List;

public class Q5News {

    // 자카드 유사도
    public double solution(String s1, String s2) {
        if(isBlank(s1) || isBlank(s2))
            return 0.0;

        double d = 0.0;
        s1 = s1.toUpperCase().replaceAll(" ", "");
        s2 = s2.toUpperCase().replaceAll(" ", "");

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(int i=0; i<s1.length()-1; i++) {
            list1.add(s1.substring(i, i+2));
        }

        for(int i=0; i<s2.length()-1; i++) {
            list2.add(s2.substring(i, i+2));
        }

        List<String> min = new ArrayList<>();
        List<String> max = new ArrayList<>();
        for(String s : list1) {
            if(list2.contains(s)) {
                min.add(s);
            }
            else {
                max.add(s);
            }
        }
        max.addAll(list1);
        return (double) (min.size() * 65536 ) / max.size() ;
    }

    // 공백 구분
    public boolean isBlank(String s) {
        if(s == null || s.length() == 0 || "".equals(s.trim()))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Q5News q = new Q5News();
        System.out.println(q.solution("FRANCE", "FRENCH"));
        System.out.println(q.solution("aaaa", "AAAA12"));
        System.out.println(q.solution("handshake", "shake hands"));
    }
}
