package Array;

import java.util.*;

public class DistinctNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        int[] nums2 = {4, 5, 6, 4, 4};
        System.out.println(minimumOperations(nums));
        System.out.println(minimumOperations(nums2));
    }

    private static int minimumOperations(int[] nums) {
        int count = 0;
        while(nums.length > 0){
            if(nums.length >= 3 && !isDistinct(nums)){
                nums = Arrays.copyOfRange(nums, 3, nums.length);
                count++;
            } else if (nums.length < 3 && !isDistinct(nums)){
                count++;
                break;
            } else {
                break;
            }
        }
        return count;
    }

    private static boolean isDistinct(int[] nums){
        Set<Integer> set = new HashSet<>();
        if(nums == null || nums.length == 0){
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return false;
            }
        }

        return true;
    }
}
