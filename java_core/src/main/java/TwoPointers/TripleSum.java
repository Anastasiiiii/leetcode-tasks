package TwoPointers;

import java.util.*;

public class TripleSum {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(numbers));
        System.out.println(threeSum2(numbers));
    }

    //With double loop; O(n^2) - worse decision
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> numbers = new ArrayList<>();
        int target = 0;
        int l = nums.length;

        for (int i = 0; i < l - 2; i++) {
            Set<Integer> s = new HashSet<>();
            int curr_sum = target - nums[i];

            for (int j = i + 1; j < l; j++) {
                int required_value = curr_sum - nums[j];

                if (s.contains(required_value)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(required_value);
                    list.sort(null);
                    if (!numbers.contains(list)) {
                        numbers.add(list);
                    }
                }
                s.add(nums[j]);
            }
        }
        return numbers;
    }

    //Two pointers - O(n^2) - better decision
    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> numbers = new ArrayList<>();
        Arrays.sort(nums); //O(n log n) time

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1, target = -nums[i];

                //Two Pointers
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        numbers.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //To avoid duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return numbers;
    }
}
