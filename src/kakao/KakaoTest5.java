package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KakaoTest5 {

    public static void main(String[] args) {
        int[] foodTimes = {3,1,2};

        solution(foodTimes, 5);
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;
        int length = food_times.length;

        if(length < 1 || length > 200000) {
            return 0;
        }

        if(k > 2000000) {
            return 0;
        }

        for(int a=0; a<k; a++) {

            if(answer == length) {
                answer = 0;
            }

            if(food_times[answer] > 1000 || food_times[answer] < 1) {
                return 0;
            }

            int i = food_times[answer];
            if(i > 0) {
                food_times[answer]--;
            }
            else
                answer++;

            answer++;
        }
        answer = (answer+1)%length;
        return answer;
    }

    public static int solution2(int[] food_times, long N){
        HashMap<String, Integer> map = new HashMap();
        for (int i = 1; i < food_times.length+1; i++){
            map.put(String.valueOf(i), food_times[i-1]);
        }

        int tmp = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++){
            if(map.get(String.valueOf(tmp)) == null) {
                tmp++;
            }
            if(map.get(String.valueOf(tmp))== null){
                cnt --;
            }else{
                map.put(String.valueOf(tmp), map.get(String.valueOf(tmp))-1);
            }
            System.out.println(map.toString());

        }

        return 0;
    }
}
