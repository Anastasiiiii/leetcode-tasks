package Array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println(singleNumber(nums3));
    }

    //[2, 2, 1] = 1
    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int index = 0;
        if(nums.length < 3){
            return nums[0];
        }
        while (index < nums.length){
            if (index == 0 && nums[index] != nums[index + 1]){
                return nums[index];
            } else if(index == nums.length - 1 && nums[index] != nums[index - 1]){
                return nums[index];
            } else if (nums[index] != nums[index + 1] && nums[index] != nums[index - 1]) {
                return nums[index];
            }
            index++;
        }

        return -1;
    }
}
