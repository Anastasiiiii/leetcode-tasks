package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {3, 1, 4, 2};

        System.out.println(find132pattern(nums)); //false
        System.out.println(find132pattern(nums2)); // true
    }

    private static boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peekFirst()) {
                second = stack.removeFirst();
            }

            stack.addFirst(nums[i]);
        }

        return false;
    }
}
