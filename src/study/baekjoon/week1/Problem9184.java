package study.baekjoon.week1;

import java.util.List;

/**
 * 재귀 호출만 생각하면 신이 난다! 아닌가요?
 * <p>
 * 다음과 같은 재귀함수 w(a, b, c)가 있다.
 * <p>
 * if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns: 1
 * <p>
 * if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20, 20, 20)
 * <p>
 * if a < b and b < c, then w(a, b, c) returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
 * <p>
 * otherwise it returns: w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1) 위의 함수를
 * 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)
 * <p>
 * a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
 */

// w(1, 1, 1) =
public class Problem9184 {

    private List<Input> testCases;

    public Problem9184() {
        testCases = List.of(
            Input.of(1, 1, 1),
            Input.of(2, 2, 2),
            Input.of(10, 4, 6),
            Input.of(50, 50, 50),
            Input.of(-1, 7, 18)
        );
    }

    public Long w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1L;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (a < b && b < c) {
            return w(a, b, c - 2);
//            return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            // == a, b, c-2
        } else {
            return w(2 * a - 2, 2 * b, 2 * c);
//            return  w(a-1, b, c) + w(a-1, b-1, c) // 2a-2, 2b-1, 2c
//                + w(a-1, b, c-1) - w(a-1, b-1, c-1); // 0, +1, 0
        }
    }

    public static void main(String[] args) {
        Problem9184 problem9184 = new Problem9184();
        for (Input input : problem9184.testCases) {
            System.out.println(input.w(input));
        }

    }

}

class Input {

    private int a;
    private int b;
    private int c;
    private int result;

    public Input(int result) {
        this.result = result;
    }

    public Input(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Input of(int a, int b, int c) {
        return new Input(a, b, c);
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getC() {
        return this.c;
    }

    public void subA() {
        this.a = a - 1;
    }

    public void subB() {
        this.b = b - 1;
    }

    public void subC() {
        this.c = c - 1;
    }

    public String toString() {
        return "A : " + a + ", B : " + b + ", C : " + c;
    }

    public Input w(Input input) {
        System.out.println("input = " + input);
        if (input.getA() > 20 || input.getB() > 20 || input.getC() > 20) {
            return w(Input.of(20, 20, 20));
        }

        if (input.getA() < input.getB() && input.getB() < input.getC()) {
            return w(of(a, b, c - 1))
                .add(
                    w(of(a, b - 1, c - 1))
                )
                .sub(
                    w(of(a, b - 1, c))
                );
        } else {
            return w(Input.of(2 * input.getA() - 2, 2 * input.getB(), 2 * input.getC()));
        }
    }

    public Input add(Input input) {
        if (input.getA() <= 0 || input.getB() <= 0 || input.getC() <= 0) {
            return new Input(1);
        }
        return Input.of(this.a + input.getA(), this.b + input.getB(), this.c + input.getC());
    }

    public Input sub(Input input) {
        return Input.of(this.a - input.getA(), this.b - input.getB(), this.c - input.getC());
    }
}
