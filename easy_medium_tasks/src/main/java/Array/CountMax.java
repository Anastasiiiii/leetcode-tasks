package Array;

import java.util.Arrays;
import java.util.Collections;

public class CountMax {
    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 2, 3};
        System.out.println(maximumCount(nums));

        int[] nums2 = {-2, -1, -1, 1, 2, 3};
        System.out.println(maxCount2(nums2));

        int[] nums3 = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println(maxCount2(nums3));
    }

    //O(n)
    private static int maximumCount(int[] nums) {
        int countPos = 0;
        int countNeg = 0;

        for(int num : nums){
            if(num > 0){
                countPos++;
            } else if(num < 0){
                countNeg++;
            }
        }


        return Math.max(countPos, countNeg);
    }

    //O(lg(n))
    private static int findFirstPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int result = nums.length;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > 0){
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int findFirstZeroOrPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int result = nums.length;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] >= 0){
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int maxCount2(int[] nums){
        Arrays.sort(nums);
        int firstZeroOrPositive = findFirstZeroOrPositive(nums);
        int firstPositive = findFirstPositive(nums);


        int negCount = firstZeroOrPositive;
        System.out.println("Neg: " + negCount);
        int posCount = nums.length - firstPositive;
        System.out.println("Positive: " + posCount);

        return Math.max(negCount, posCount);
    }










}
