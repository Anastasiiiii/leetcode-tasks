package Bitwise;

public class BitwiseSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;
        System.out.println(minimumSubarrayLength(nums, k));
        int[] nums1 = {2, 1, 8};
        int k1 = 10;
        System.out.println(minimumSubarrayLength(nums1, k1));
        int[] nums2 = {1, 2};
        int k2 = 0;
        System.out.println(minimumSubarrayLength(nums2, k2));
        int[] nums3 = {1, 2, 32, 21};
        int k3 = 55;
        System.out.println(minimumSubarrayLength2(nums3, k3));
        int a = 1;
        int b = 4;
        int c = a | a;
        int d = a | b;
        int g = a | a | b;
        System.out.println(c + " " + d + " " + g);
    }

    private static int minimumSubarrayLength(int[] nums, int k) {

        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                return 1;
            } else {
                result |= nums[i];
                count++;
            }
        }

        if(result > k){
            return count;
        }
        return -1;
    }

    //Sliding window
    private static int minimumSubarrayLength2(int[] nums, int k){
        int left = 1;
        int right = nums.length;
        int minLength = -1; //to track the shortest valid subarray

        //Binary search ot the length of subarray
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (hasValidSubArray(nums, k, mid)) {
                minLength = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minLength;
    }

    private static boolean hasValidSubArray(int[] nums, int targetSum, int windowSize){
        int arrayLength = nums.length;
        int[] bitCounts = new int[32]; //tracks count of set bits at each position

        //Sliding Window approach
        for(int right = 0; right < arrayLength; right++){
            //Add current number to window
            updateBitCounts(bitCounts, nums[right], 1);

            //Remove leftmost number if window exceeds size
            if(right >= windowSize){
                updateBitCounts(bitCounts, nums[right - windowSize], -1);
            }

            //Check if current window is valid
            if(right >= windowSize - 1 && convertBitCountsToNumber(bitCounts) >= targetSum) {
                return true;
            }

        }
        return false;
    }

    private static void updateBitCounts(int[] bitCounts, int number, int delta){
        for(int bitPosition = 0; bitPosition < 32; bitPosition++){
            //Check if bit set at current position
            if(((number >> bitPosition) & 1) != 0) {
                bitCounts[bitPosition] += delta;
            }
        }
    }

    //Converts bit count array back to number using OR operation
    private static int convertBitCountsToNumber(int[] bitCounts) {
        int number = 0;
        for(int bitPosition = 0; bitPosition < 32; bitPosition++){
            if(bitCounts[bitPosition] != 0){
                number |= 1 << bitPosition;
            }
        }

        return number;
    }
}
