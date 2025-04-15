package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestSubset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(largestDivisibleSubset(nums));
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        reverseArray(nums);
        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length - 1; i++){
            for (int j = 1; j < nums.length; j++) {
                if(nums[i] != nums[j] && nums[i] % nums[j] == 0){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    break;
                }
            }
        }

        return list;
    }


    private static void reverseArray(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
