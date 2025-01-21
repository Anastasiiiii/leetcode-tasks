package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        //7, 6, 5, 4, 3, 2, 1
        //5, 6, 7, 4, 3, 2, 1
        //5, 6, 7, 1, 2, 3, 4
        rotateArray(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 5 6 7 1 2 3 4

        System.out.println(shuffleArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 3));
    }

    private static void rotateArray(int[] nums, int k){
        //TODO: Manually perform a rotation by k positions using a series of steps to break down and reassemble the array content.

        k = k % nums.length;
        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the rest of the array
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int startPoint, int endPoint){
        while(startPoint < endPoint){
            int temp = nums[startPoint];
            nums[startPoint] = nums[endPoint];
            startPoint++;
            endPoint--;
        }
    }

    private static List<Integer> shuffleArray(List<Integer> nums, int k) {
        // TODO: implement the function here
        List<Integer> resultedList = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            resultedList.add(nums.get(i));
        }

        for(int i = k - 1; i < nums.size(); i += k){
            nums.remove(i);
            nums.add(resultedList.get(i));
        }

        return nums;
    }
}
