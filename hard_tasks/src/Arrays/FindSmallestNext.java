package Arrays;

public class FindSmallestNext {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }

    private static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean[] seen = new boolean[len + 2];

        for (int num : nums) {
            if (num > 0 && num <= len + 1) {
                seen[num] = true;
            }
        }

        for (int i = 1; i < seen.length; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        return -1;
    }
}
