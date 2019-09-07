package lib.algo.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class StringLib {

    // 토큰
    public List<String> token(String param){
        long time = System.currentTimeMillis();
        StringTokenizer tokenizer = new StringTokenizer(param);
        List<String> list = new LinkedList<>();
        while(tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        System.out.println("Exec Time : " + (System.currentTimeMillis() - time) + "ms");
        return list;
    }

    // 역순정렬
    public String reverse(String param) {
        long time = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for(int i=param.length(); i>0; i--) {
            sb.append(param.charAt(i-1));
        }

        System.out.println("Exec Time : " + (System.currentTimeMillis() - time) + "ms");
        return sb.toString();
    }

    // 역순정렬2 (비추)
    public String reverse2(String param) {
        long time = System.currentTimeMillis();

        String sb = "";
        for(int i=param.length(); i>0; i--) {
            sb += param.charAt(i-1);
        }

        System.out.println("Exec Time : " + (System.currentTimeMillis() - time) + "ms");
        return sb;
    }

    // 공통 prefix 찾기
    public String common(List<String> param) {
        if(param.size() < 2)
            return "";

        if(isBlank(param.get(0)))
            return "";

        int index = 0;
        String first = param.get(0);
        for(int i=0; i<first.length(); i++) {
            char c = first.charAt(i);
            for(int j=1; j<param.size(); j++) {
                if(i == param.get(j).length() || param.get(j).charAt(i) == c) {
                    index = i;
                }
            }
        }
        return first.substring(0, index);
    }

    // 좌우 대칭 문자열
    public boolean isPalindrome(String input) {
        int size = input.length();
        for(int i=0; i<size/2; i++) {
            if(input.charAt(i) != input.charAt(size-i-1))
                return false;

        }
        return true;
    }

    // 공백 구분
    public boolean isBlank(String s) {
        if(s == null || s.length() == 0 || "".equals(s.trim()))
            return true;

        return false;
    }

    // 자카드 유사도
    public double getJakad(String s1, String s2) {
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

//        System.out.println(list1);
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
//        System.out.println(min);
//        System.out.println(max);

        return (double) (min.size() * 65536 ) / max.size() ;
    }

    public static void main(String[] args) {
        String testVal = "This is my String JY Park";

        StringLib sort = new StringLib();

        System.out.println(sort.token(testVal));
        System.out.println(sort.reverse(testVal));

        StringBuilder sb = new StringBuilder();
        for(long l=0; l<1000000L; l++) {
            sb.append('a');
        }

        sort.token(sb.toString());
        sort.reverse(sb.toString());
//        sort.reverse2(sb.toString());

        List<String> common = new LinkedList<>();
        common.add("apple");
        common.add("append");
        common.add("apologize");
        System.out.println(sort.common(common));

        String palindrome = "12321";
        System.out.println("isPalindrome >>> " + palindrome + " : " + sort.isPalindrome(palindrome));
        palindrome = "1357531";
        System.out.println("isPalindrome >>> " + palindrome + " : " + sort.isPalindrome(palindrome));
        palindrome = "135717531";
        System.out.println("isPalindrome >>> " + palindrome + " : " + sort.isPalindrome(palindrome));
        palindrome = "135753166";
        System.out.println("isPalindrome >>> " + palindrome + " : " + sort.isPalindrome(palindrome));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(sort.getJakad("FRANCE", "FRENCH"));
        System.out.println(sort.getJakad("aaaa", "AAAA12"));
        System.out.println(sort.getJakad("handshake", "shake hands"));
    }

}
