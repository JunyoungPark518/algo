package kakao.k2017;

public class Q7Givingday {
    public int solution(String[] lines) {
        int answer = 0;
        String prefix = "2016-09-15 ";

        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(prefix)) {
                lines[i] = lines[i].replace(prefix, "");
            }
        }

        double entryTime = 0.0;
        double endTime = 0.0;
        for(int i=0; i<lines.length*2; i++) {
            if((i%2) == 0) {
                entryTime = parse(lines[i/2], false);
            }
            else {
                endTime = parse(lines[i/2], true);
            }

            for(float j = (float) entryTime; j < endTime; j++) {
                int tmpTraffics = 0;
                for(int k=0; k<lines.length; k++) {
                    double start = parse(lines[k], false);
                    double end = parse(lines[k], true);
                    if(!(start < j && end < j) && !(start > j+1 && end > j+1))
                        tmpTraffics ++;
                }

                if(tmpTraffics > answer)
                    answer = tmpTraffics;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public Double parse(String time, boolean isEndTime) {
        double d = Double.parseDouble(time.split(":")[2].split(" ")[0]);
        if(isEndTime) d += Double.parseDouble(time.split(":")[2].split(" ")[1].replaceAll("s", ""));
        int hm = Integer.parseInt(time.split(":")[0]) * 3600 +
                Integer.parseInt(time.split(":")[1]) * 60;
        return toFixed((double) hm + d - (isEndTime ? 0.001 : 0));
    }

    public Double toFixed(Double val){
        String v = String.valueOf(val);
        int pos = v.indexOf(".");
        if(v.length() > pos+4)
            v = v.substring(0, pos+4);
        return Double.parseDouble(v);
    }

    public static void main(String[] args) {
        Q7Givingday q = new Q7Givingday();
        String[] q1 = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        String q2[] = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        String q3[] = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        q.solution(q1);
        q.solution(q2);
        q.solution(q3);
    }
}
