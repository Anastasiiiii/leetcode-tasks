package Tasks;

import java.util.HashSet;

public class UglyNumber {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(isUgly(n));
    }

    private static boolean isUgly(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}
