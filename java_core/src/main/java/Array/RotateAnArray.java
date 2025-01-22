package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(groupReverse(array, 3)));

        System.out.println("**************************");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        rearrangeArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("****************************");
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
        rearrangeArray2(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    private static void rotateArray(int[] nums, int k) {
        //TODO: Manually perform a rotation by k positions using a series of steps to break down and reassemble the array content.

        k = k % nums.length;
        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the rest of the array
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int startPoint, int endPoint) {
        while (startPoint < endPoint) {
            int temp = nums[startPoint];
            nums[startPoint] = nums[endPoint];
            nums[endPoint] = temp;
            startPoint++;
            endPoint--;
        }
    }

    private static List<Integer> shuffleArray(List<Integer> nums, int k) {
        // TODO: shuffle an array
        List<Integer> resultedList = new ArrayList<>(nums);
        List<Integer> toMoveList = new ArrayList<>();

        for (int i = k - 1; i < nums.size(); i += k) {
            toMoveList.add(nums.get(i));
            resultedList.set(i, null);
        }

        //resultedList.removeIf(item -> item == null);
        resultedList.removeIf(Objects::isNull);

        resultedList.addAll(toMoveList);

        return resultedList;
    }

    private static int[] groupReverse(int[] nums, int k) {
        int startPoint = 0;
        int endPoint = k - 1;

        while (startPoint < nums.length) {
            endPoint = Math.min(startPoint + k - 1, nums.length - 1);
            reverse(nums, startPoint, endPoint);
            startPoint += k;
        }

        return nums;
    }

    private static void rearrangeArray(int[] nums) {
        //TODO: Write a function that rearranges the array so that the middle half of the elements (considering the left and right quarters have been eliminated) move to the beginning of the array. The remaining elements, the left and right quarters, should move to the end of the array.
        List<Integer> toMoveList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        int n = nums.length;
        int quarters = n / 4;

        for (int i = 0; i < quarters; i++) {
            toMoveList.add(nums[i]);
        }

        for (int i = quarters; i < n - quarters; i++) {
            resultList.add(nums[i]);
        }

        for (int i = n - quarters; i < n; i++) {
            toMoveList.add(nums[i]);
        }

        resultList.addAll(toMoveList);
        for (int i = 0; i < n; i++) {
            nums[i] = resultList.get(i);
        }
    }

    private static void rearrangeArray2(int[] nums) {
        //TODO: Write a function that rearranges the array so that the middle half of the elements (considering the left and right quarters have been eliminated) move to the beginning of the array. The remaining elements, the left and right quarters, should move to the end of the array.
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        System.out.println("****");
        System.out.println(Arrays.toString(temp));
        int quarters = n / 4;
        int index = 0;
        System.out.println("Index: " + index);
        for (int i = quarters; i < n - quarters; i++) {
            nums[index] = temp[i];
            index++;
        }

        System.out.println("****");
        System.out.println("Temp: " + Arrays.toString(temp));
        System.out.println("Nums: " + Arrays.toString(nums));

        System.out.println("Index: " + index);
        for (int i = 0; i < quarters; i++) {
            nums[index] = temp[i];
            index++;
        }
        System.out.println("****");
        System.out.println("Temp: " + Arrays.toString(temp));
        System.out.println("Nums: " + Arrays.toString(nums));

        System.out.println("Index: " + index);
        for (int i = n - quarters; i < n; i++) {
            nums[index] = temp[i];
            index++;
        }
        System.out.println("****");
        System.out.println("Temp: " + Arrays.toString(temp));
        System.out.println("Nums: " + Arrays.toString(nums));
    }
}
