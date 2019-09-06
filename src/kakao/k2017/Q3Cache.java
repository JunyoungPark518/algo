package kakao.k2017;

import java.util.*;

public class Q3Cache {

    public int solution(int cacheSize, String[] cities) {

        int execTime = 0;
        List<String> list = new ArrayList<>();

        Map<String, Integer> cacheList = new HashMap<>();
        for(int i=0; i<cacheSize; i++) {
            list.add(cities[i].toLowerCase());
        }

        if(cacheSize == 0)
            list.add(cities[0].toLowerCase());

        String city = "";
        for(int i=0; i<cities.length; i++) {
            city = cities[i].toLowerCase();
            if(cacheList.containsKey(city) && list.contains(city)) {
                cacheList.put(city, cacheList.get(city)+1);
                execTime += 1;
            }
            else {
                list.remove(0);
                list.add(city);
                cacheList.put(city, 1);
                execTime += 5;
            }
        }

        System.out.println(cacheList);
        System.out.println(list);
        System.out.println("execTime >>> " + execTime);
        System.out.println();
        return execTime;
    }

    public static void main(String[] args) {
        Q3Cache q = new Q3Cache();
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        q.solution(3, cities);
        q.solution(3, cities2);
        q.solution(2, cities3);
        q.solution(5, cities4);
        q.solution(2, cities5);
        q.solution(0, cities6);

    }
}
