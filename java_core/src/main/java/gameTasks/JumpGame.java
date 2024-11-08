package gameTasks;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));

        System.out.println(jump(nums));
        System.out.println(jump(nums1));
        System.out.println(jump(nums3));
    }

    private static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int farthest = 0;  // Track the farthest position you can reach

        for (int i = 0; i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= last) {
                return true;
            }
        }

        return false;
    }

    private static int jump(int[] nums) {
        int last = nums.length - 1;
        int farthest = 0;  // Track the farthest position you can reach

        for (int i = 0; i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (farthest == last) {
                return farthest;
            }
        }
        return -1;
    }

}
