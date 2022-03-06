package study.baekjoon.week1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
 * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 *
 * 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
 * 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는
 * 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
 *
 * 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
 * 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 */
public class Problem2606 {

    private List<Link> computers;
    private int computerCounts;

    public Problem2606() {
        this.computerCounts = 7;
        this.computers = List.of(
            Link.of(1, 2),
            Link.of(2, 3),
            Link.of(1, 5),
            Link.of(5, 2),
            Link.of(5, 6),
            Link.of(4, 7)
        );
    }

    public boolean isConnected(Link first, Link second) {
        if(first.getFirst() == second.getSecond()) {
            return true;
        }
        if(second.getFirst() == first.getSecond()) {
            return true;
        }
        return false;
    }

    public int solution(int virus) {
        int result = -1;
        Set<Integer> defectedList = new HashSet<>();
        final List<Link> spreadList = has(virus);
        for(int index = 0; index < computerCounts-2; index++) {
            if(isConnected(computers.get(index), computers.get(index+1))) {
                defectedList.add(computers.get(index).getFirst());
                defectedList.add(computers.get(index).getSecond());
                defectedList.add(computers.get(index+1).getFirst());
                defectedList.add(computers.get(index+1).getSecond());
            }
        }
        result += defectedList.size();
        return result;
    }

    public List<Link> has(int virus) {
        return computers.stream()
            .filter(link -> !link.isChecked())
            .filter(link -> link.getFirst() == virus || link.getSecond() == virus)
            .peek(Link::setDefected)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        final Problem2606 problem2606 = new Problem2606();
        problem2606.solution(1);
    }
}

class Link {
    private int first;
    private int second;
    private boolean checked;

    public Link(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public static Link of(int first, int second) {
        return new Link(first, second);
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }

    public void setDefected() {
        this.checked = true;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public String toString() {
        return "First : " + this.first +
            " / Second : " + this.second;
    }
}
