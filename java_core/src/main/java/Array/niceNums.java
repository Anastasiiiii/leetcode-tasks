package Array;

public class niceNums {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
        System.out.println(longestNiceSubarray(nums));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(3));
        int num = 5;
        num ^= 3;
        System.out.println(Integer.toBinaryString(num));

        int[] nums1 = {3, 1, 5, 11, 13};
        System.out.println(longestNiceSubarray(nums1));


    }

    private static int longestNiceSubarray(int[] nums) {
        int start = 0;
        int end = 1;
        int result = 1;

        while (end < nums.length - 1) {
            if (((nums[start] & nums[end]) == 0)) {
                result++;
                end++;
                start++;
            } else {
                start++;
            }
        }

        return result;
    }
}
