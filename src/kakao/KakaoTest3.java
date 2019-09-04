package kakao;

import java.util.*;

public class KakaoTest3 {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(N, stages);

        int N2 = 4;
        int[] stages2 = {4,4,4,4,4};
        solution(N2, stages2);

    }

    public static int[] solution(int N, int[] stages) {
        if(N < 1 || N > 500) {
            return null;
        }
        if(stages.length < 1 || stages.length > 200000) {
            return null;
        }

        int mother = stages.length;
        Map<Integer, Double> map = new HashMap<>();
        for(int i = 1; i < N+1 ; i ++) {
            int cnt = getCount(i, stages);
            if(mother != 0)
                map.put(i, (double) cnt / mother);
            else
                map.put(i, 0.0);
            mother -= cnt;
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, new Comparator(){

            @Override
            public int compare(Object i1, Object i2) {
                if(map.get(i1) > map.get(i2)){
                    return -1;
                } else if(map.get(i1) < map.get(i2)){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(keySetList);
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = keySetList.get(i).intValue();
        }
        return answer;
    }

    private static int getCount(int stage, int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(stage == arr[i])
                count++;
        }
        return count;
    }
}
