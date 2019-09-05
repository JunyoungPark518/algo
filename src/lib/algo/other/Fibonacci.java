package lib.algo.other;

public class Fibonacci {

    public static int[] table;

    public static int fibonacci(int data) {
        if(data <= 1)
            return 1;

        return fibonacci(data-1) + fibonacci(data-2);
    }

    public static int run(int data) {
        if(data <= 1) {
            table[data] = 1;
            return 1;
        }

        if(table[data] > 0)
            return table[data];

        table[data] = run(data-1) + run(data-2);
        return table[data];
    }

    public static void main(String[] args) {
        table = new int[8];
        for(int i=0; i<8; i++) {
            System.out.println(fibonacci(i));
        }
    }

}
