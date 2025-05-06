package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Domino {
    public static void main(String[] args) {
        int[][] dominoes = {{1, 2},{2, 1},{3, 4},{5, 6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    //int key = 10 * Math.min(a, b) + Math.max(a, b);
    private static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int[] domino : dominoes) {
            int key = 10 * Math.min(domino[0], domino[1]) + Math.max(domino[0], domino[1]);
            result += count.getOrDefault(key, 0);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        System.out.println(count);

        return result;
    }

    private static boolean isEqual(int[] nums1, int[] nums2){
        return Math.min(nums1[0], nums1[1]) == Math.min(nums2[0], nums2[1]) && Math.max(nums1[0], nums1[1]) == Math.max(nums2[0], nums2[1]);
    }
}
