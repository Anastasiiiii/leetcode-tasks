package Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSum {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(findSum(input, target)));

        int[] input2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(findSum(input2, target2)));

        int[] input3 = {3, 2, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(findSum(input3, target3)));

        int[] input4 = {3, 2, 2, 4};
        int target4 = 6;
        System.out.println(Arrays.toString(findSum(input4, target4)));

        int[] input5 = {3, 4, 3, 90};
        int target5 = 6;
        System.out.println(Arrays.toString(findSum(input5, target5)));
    }

    private static int[] findSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
