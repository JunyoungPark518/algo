package kakao;

import java.util.*;

public class KakaoTest2 {


    public static void main(String[] args) {
        String[] arr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(arr));

    }

    public static String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        if(record.length < 1 || record.length > 100000)
            return null;

        Map<String, String> map = new HashMap<String, String>();
        for(int i=0; i<record.length; i++) {
            String uid = record[i].split(" ")[1];
            if(record[i].contains("Enter")) {
                if(record[i].split(" ")[2].length() < 11)
                    map.put(uid, record[i].split(" ")[2]);
            }
            else if(record[i].contains("Change") && map.get(uid) != null) {
                if(record[i].split(" ")[2].length() < 11)
                    map.put(uid, record[i].split(" ")[2]);
            }
        }

        for(int i=0; i<record.length; i++) {
            String uid = record[i].split(" ")[1];
            if(record[i].contains("Enter")) {
                list.add(map.get(uid) + "님이 들어왔습니다.");
            }
            else if(record[i].contains("Leave")) {
                list.add(map.get(uid) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[list.size()]);
    }

}

