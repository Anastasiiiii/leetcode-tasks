package Tasks;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateArrayToRight(arr, 3);
        rotateArray(arr, 3);
        //rotateArrayToRightTwo(arr, 3);
    }

    private static void rotateArray(int[] nums, int k) {
        int last = nums.length - 1;
        int first = 0;

        while (k > 0) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
            k--;
            System.out.println(Arrays.toString(nums));
        }
    }

    private static void rotateArrayToRight(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, n);
        System.out.println(Arrays.toString(nums));
        int m = 10 % 7;
        int s = (6 + m) % 7;
        System.out.println(s);
    }
}