package Array;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;

        for(int num : nums){
            if(num == 0){
                count0++;
            } else if (num == 1) {
                count1++;
            }
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(count0 > 0){
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else {
                nums[i] = 2;
            }
        }
    }
}
