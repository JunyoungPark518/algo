package study.baekjoon.week0;

/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * 출력
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class Q1463 {


    public int func(int x) {

        if(x < 1 && x >= 1000000) {
            return 0;
        }

        int cnt = 1;

        x-=1;
        while(x != 1) {
            if(x % 3 == 0) {
                x /= 3;
                cnt++;
            }
            else if(x % 2 == 0) {
                x /= 2;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int answer1 = new Q1463().func(10);
        System.out.println(answer1);
    }

}
