package TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {20, 30, 10, 50, 4, 5};
        int target = 70;
        System.out.println(findSumPare(arr, target));

        int[] numbers = {2,7,11,15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target1)));
    }

    //Two-Pointer Technique – O(n) time and O(1) space
    /*
    Given a sorted array arr (sorted in ascending order) and a target, find if there exists any pair of elements (arr[i], arr[j]) such that their sum is equal to the target.
     */
    public static boolean findSumPare(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if(sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static int[] twoSum(int[] numbers, int target) {
        List<Integer> numbersList = Arrays.stream(numbers).boxed().toList();
        Arrays.sort(numbers);
        int[] arr = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                arr[0] = numbersList.indexOf(numbers[left]) + 1;
                arr[1] = numbersList.indexOf(numbers[right]) + 1;
                return arr;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(numbersList);
        return new int[]{0, 0};
    }
}
