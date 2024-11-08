package TwoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        HashSet<Integer> digits = new HashSet<>();

        while (n != 1 && !digits.contains(n)) {
            digits.add(n);
            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return n == 1;
    }
}
