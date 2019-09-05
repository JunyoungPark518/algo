package lib.algo.other;

public class Factorial {


    public static int factorial(int data) {
        if(data <= 1)
            return 1;

        return factorial(data-1) * data;
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
