package Array;

import java.util.Arrays;

public class TripletValue {
    public static void main(String[] args){
       int[] nums = {12, 6, 1, 2, 7};
       int[] nums2 = {1, 10, 3, 4, 19};
       int[] nums3 = {1000000, 1, 1000000};
//       System.out.println(maximumTripletValue(nums));
//       System.out.println("**************************");
//       System.out.println(maximumTripletValue(nums2));
//       System.out.println("*************************");
//       System.out.println(maximumTripletValue(nums3));
//       System.out.println("*************************");
//       System.out.println();
       System.out.println(maximumTripletValue2(nums));
        System.out.println(maximumTripletValue2(nums3));
    }

    private static long maximumTripletValue(int[] nums) {
        long max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                   long res = findValue(nums[i], nums[j], nums[k]);
                   max = Math.max(max, res);
                   if(max == res){
                       System.out.println("Res: " + count++ + " Result: " + res);
                       System.out.println("Num1: " + nums[i] + "  Num2: " + nums[j] + " Num3: " + nums[k]);
                   }
                }
            }
        }

        System.out.println("Max value after counting: " + max);
        return Math.max(max, 0);
    }

    private static long findValue(int num1, int num2, int num3){
        return (long) (num1 - num2) * num3;
    }


    private static long maximumTripletValue2(int[] nums){
        int n = nums.length;
        if(n < 3) return 0;

        int[] prefix_max = new int[n];
        int[] suffix_max = new int[n];

        prefix_max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix_max[i] = Math.max(prefix_max[i - 1], nums[i]);
        }

        suffix_max[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffix_max[i] = Math.max(suffix_max[i + 1], nums[i]);
        }

        long maxValue = Integer.MIN_VALUE;

        for(int j = 1; j < n - 1; j++){
            int leftMax = prefix_max[j - 1];
            int rightMax = suffix_max[j + 1];
            long value = findValue(leftMax, nums[j], rightMax);
            maxValue = Math.max(maxValue, value);
        }

        return Math.max(0, maxValue);
    }


}
