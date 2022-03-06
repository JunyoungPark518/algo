package study.baekjoon.week1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 */
public class Problem1931 {

    private int conferenceCount;

    private List<Conference> conferences;

    public Problem1931() {
        this.conferenceCount = 11;
        this.conferences = List.of(
            Conference.of(1, 4),
            Conference.of(3, 5),
            Conference.of(0, 6),
            Conference.of(5, 7),
            Conference.of(3, 8),
            Conference.of(5, 9),
            Conference.of(6, 10),
            Conference.of(8, 11),
            Conference.of(8, 12),
            Conference.of(2, 13),
            Conference.of(12, 14)
        );
    }

    public Conference getMinStart() {
        Comparator<Conference> comparator = Comparator.comparingInt(Conference::getStart);
        return conferences.stream().min(comparator).get();
    }

    public Conference getMinDiff() {
        Conference result = new Conference(0, 24);
        int diff = 24;
        for(Conference conference : conferences) {
            if(conference.getEnd() - conference.getStart() < diff) {
                result = conference;
                diff = conference.getEnd() - conference.getStart();
            }
        }
        return result;
    }

    public boolean isNext(Conference arg1, Conference arg2) {
        return arg1.getEnd() < arg2.getStart();
    }

    public int solution() {
        int result = 1;
        int saved = 0;
        for(int index = 0; index < conferences.size(); index++) {
            ArrayList<Conference> pop = new ArrayList<>(conferences);
            Conference basement = conferences.get(index);
            System.out.println("basement = " + basement);
            result = 1;
            for(int recursive = 0; recursive < pop.size(); recursive++) {
                final Conference compareObject = pop.get(recursive);
                if(isNext(basement, compareObject)) {
                    result++;
                    basement = compareObject;
                    System.out.println("diff = " + compareObject);
                    pop.remove(recursive);
                    recursive = 0;
                }
            }
            if(result > saved) {
                saved = result;
            }
        }

        System.out.println("saved = " + saved);
        return saved;
    }

    public static void main(String[] args) {
        final Problem1931 problem1931 = new Problem1931();
        problem1931.solution();
    }
}

class Conference {

    private Integer start;
    private Integer end;

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Conference(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public static Conference of(Integer start, Integer end) {
        return new Conference(start, end);
    }

    public String toString() {
        return "Start: " + this.start + " / End: " + this.end;
    }
}