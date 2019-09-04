package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KakaoTest7 {

    public static void main(String[] args) {
        new KakaoTest7().solution();
    }
    public void solution() {
        List<String> input1 = Arrays.asList("apples", "apps", "ape");

        if(input1.size() == 0)
            return;

        String s = input1.get(0);
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            for(int j=1; j<input1.size(); j++){
                if(i == s.length()

                        && input1.get(j).charAt(i) != c) {
                    max = i;
                }
            }
        }

        System.out.println(s.substring(0, max));

    }
}
