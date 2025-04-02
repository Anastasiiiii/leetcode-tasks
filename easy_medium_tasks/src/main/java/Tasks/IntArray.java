package Tasks;

import java.util.Arrays;

public class IntArray {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] digits1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne(digits1)));
    }

    //You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    // The digits are ordered from most significant to least significant in left-to-right order.
    // The large integer does not contain any leading 0's.
    //Increment the large integer by one and return the resulting array of digits.
    private static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            System.out.println("Error");
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
