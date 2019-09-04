package kakao;

import java.util.HashMap;
import java.util.Map;

public class KakaoTest4 {

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution2(relation));

    }

    public static int solution(String[][] relation) {
        int answer = 0;
        boolean isCandidate;

        Map compare = new HashMap();
        for(String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for(String val : row) {
                sb.append(val);
            }

            isCandidate = true;
            for(int i=1; i<row.length; i++) {
                System.out.println(row[i]);
                if(!compare.containsKey(row[i])) {
                    compare.put(row[i], "Y");
                    isCandidate = false;
                }
            }

            if(isCandidate)
                answer++;
        }

        System.out.println(answer);
        return answer;
    }

    private static boolean isCandidate(String[] row) {
        return false;

    }

    public static int solution2(String[][] relation) {
        int answer = 1;

        for (int i = 0; i < relation.length; i++){
            String rel = relation[i][0]+relation[i][1]+relation[i][2]+relation[i][3];
            int cnt = 0;
            System.out.println(rel);
            for (int j = 0; j < relation.length; j++){
                String rel2 = relation[i][1]+relation[i][2];
                if(rel.indexOf(rel2) != -1){
                    cnt ++;
                }
            }
        }

        return answer;
    }
}



