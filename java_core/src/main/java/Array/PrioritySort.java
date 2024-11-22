package Array;

import java.util.Arrays;

public class PrioritySort {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 4};
        int[] nums2 = {2, 1, 3, 4};
        int[] nums3 = {0};
        System.out.println(Arrays.toString(sortArrayByParity(nums1)));
        System.out.println(Arrays.toString(sortArrayByParity(nums2)));
        System.out.println(Arrays.toString(sortArrayByParity(nums3)));
    }

    private static int[] sortArrayByParity(int[] nums) {
        Arrays.sort(nums);
        int[] sortedNums = new int[nums.length];
        int step = 0;
        int left = 0;
        int right = nums.length - 1;
        while (step < nums.length) {
            if(nums[step] % 2 == 0){
                sortedNums[left] = nums[step];
                step++;
                left++;
            } else {
                sortedNums[right] = nums[step];
                step++;
                right--;
            }
        }
        return sortedNums;
    }
}
