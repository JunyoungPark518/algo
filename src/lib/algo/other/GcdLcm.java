package lib.algo.other;

public class GcdLcm {

    // int[0] = gcd , int[1] = lcm
    public static int[] get(int a, int b) {
        if(b > a) {
            int temp = b;
            b = a;
            a = temp;
        }
        int[] result = {gcd(a, b), (a * b / gcd(a, b))};
        return result;
    }

    public static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(">>>>>>>> GCD >>>>>>>>>");
        System.out.println(get(24, 36)[0]);
        System.out.println(">>>>>>>> LCM >>>>>>>>>");
        System.out.println(get(24, 36)[1]);
    }
}
