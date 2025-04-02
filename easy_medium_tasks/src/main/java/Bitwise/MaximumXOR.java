package Bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumXOR {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3};
        int maximumBit = 2;

        System.out.println(Arrays.toString(getMaximumXor(nums, maximumBit)));
    }

    private static int[] getMaximumXor(int[] nums, int maximumBit) {
        int target = (1 << maximumBit) - 1;
        System.out.println(target);
        List<Integer> result_list = new ArrayList<>();
        int temp = 0;

        //to count XOR for all elements of the array
        for (int num : nums) {
            temp ^= num;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result_list.add(temp ^ target);
            temp ^= nums[i];
        }

        int[] newNums = new int[result_list.size()];
        for (int i = 0; i < result_list.size(); i++) {
            newNums[i] = result_list.get(i);
        }

        return newNums;
    }

}