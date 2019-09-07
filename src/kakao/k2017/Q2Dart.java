package kakao.k2017;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * Question : https://jay-ji.tistory.com/13?category=732905
 */
public class Q2Dart {

    public int soultion(String param) {
        Map<String, Function> util = new HashMap<>();
        util.put("S", new Function() {
            @Override
            public Object apply(Object o) {
                return (int) Math.pow((int) o, 1);
            }
        });
        util.put("D", new Function() {
            @Override
            public Object apply(Object o) {
                return (int) Math.pow((int) o, 2);
            }
        });
        util.put("T", new Function() {
            @Override
            public Object apply(Object o) {
                return (int) Math.pow((int) o, 3);
            }
        });
        util.put("#", new Function() {
            @Override
            public Object apply(Object o) {
                return (int) o * -1;
            }
        });
        util.put("*", new Function() {
            @Override
            public Object apply(Object o) {
                return (int) o;
            }
        });
        int result = 0;
        for(int i=0; i<param.length(); i++) {
            char c = param.charAt(i);
            System.out.println(" c >> " + c);
            if(c == 'S') {

            }
            else if(c == 'D')
                result += (int) Math.pow(result, 2);
            else if(c == 'T')
                result += (int) Math.pow(result, 3);
            else if(c == '*')
                result *= 2;
            else if(c == '#')
                result *= (-1);
            else
                result = (int) c - 48;
            System.out.println("result >>> " + result);

//            if(util.containsKey(param.substring(i,i+1))) {
//                if("*".equals(param.substring(i,i+1))){
//                    result *= Integer.parseInt(param.substring(i-2,i-1));
//                }
//                else
//                    result += (int) util.get(param.substring(i,i+1)).apply(result);
//
//                System.out.println("util");
//            }
//            else {
//                result = Integer.parseInt(param.substring(i,i+1));
//                System.out.println("else");
//            }
//            System.out.println(result);

        }
        return result;
    }

    public static void main(String[] args) {
        int result = new Q2Dart().soultion("1S2D*3T");
        System.out.println(result);
    }
}
