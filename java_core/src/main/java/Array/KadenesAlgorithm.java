package Array;

public class KadenesAlgorithm {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums){
        int maxFactor = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            maxFactor = Math.max(maxFactor, maxEndingHere);
        }

        return maxFactor;
    }
}
