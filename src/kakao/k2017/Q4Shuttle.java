package kakao.k2017;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4Shuttle {

    public void solution(int n, int t, int m, String[] timetable) {
        String answer = "09:00";
        List<Long> list = sort(timetable);
        System.out.println(list);

        // 9시까지 되는 경우
        if(list.size() < m) {
            System.out.println("answer >>> " + answer);
        }
        // 정원이 작은 경우
        else if(list.size() >= n * m) {
            System.out.println("answer >>> " + parseTime(list.get(n*m-1)-t));
        }
        //
        else {
            System.out.println("answer >>> " + parseTime(list.get(m-1)));
        }


    }

    public String parseTime(Long time) {
        String hour = String.valueOf(time/60).length() == 1 ? "0" + String.valueOf(time/60) : String.valueOf(time/60);
        String min = String.valueOf(time%60).length() == 1 ? "0" + String.valueOf(time%60) : String.valueOf(time%60);
        return hour + ":" + min;
    }
    public List<Long> sort(String[] timetable) {
        return Arrays.stream(timetable).map(
                time -> Long.parseLong(time.split(":")[0]) * 60 +
                        Long.parseLong(time.split(":")[1])
        ).sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Q4Shuttle q = new Q4Shuttle();
        String[] q1t = {"08:00", "08:01", "08:02", "08:03"};
        q.solution(1,1,5, q1t);
        String[] q2t = {"09:10", "09:09", "08:00"};
        q.solution(2,10,2, q2t);
        String[] q3t = {"09:00", "09:00", "09:00", "09:00" };
        q.solution(2,1,2, q3t);
        String[] q4t = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        q.solution(1,1,5, q4t);
        String[] q5t = {"23:59"};
        q.solution(1,1,1, q5t);
    }
}
