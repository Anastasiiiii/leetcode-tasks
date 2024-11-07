package Bitwise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BitwiseAnd {
    public static void main(String[] args) {
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println("Largest combination with bitwise and greater than zero: " + largestCombination(candidates));

        System.out.println("*****************************");
        int a = 2;
        int b = 5;

        int result = a | b;
        System.out.println(result);
    }

    private static int largestCombination(int[] candidates) {
        int maxCount = 0;

        // Loop through all 32 bit positions
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            // Check how many numbers have the current bit set
            for (int candidate : candidates) {
                if ((candidate & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Keep track of the largest count of numbers that share a common bit
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
