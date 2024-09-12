import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairOfNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4};
        int sum = 8;
        int[] nums2 = {1, 2, 3, 9};
        int sum2 = 8;
        int[] nums3 = {5, 1, 3, 4};
        int sum3 = 8;
        int[] nums4 = {9, -1, 3, 4};
        int sum4 = 8;
        System.out.println(Arrays.toString(findPairOfNumbers(nums, sum)));
        System.out.println(Arrays.toString(findPairOfNumbers(nums2, sum2)));
        System.out.println(Arrays.toString(findPairOfNumbers(nums3, sum3)));
        System.out.println(Arrays.toString(findPairOfNumbers(nums4, sum4 )));

        System.out.println("The other method");
        System.out.println(hasPairWithSum(nums, sum));
        System.out.println(hasPairWithSum(nums2, sum2));
        System.out.println(hasPairWithSum(nums3, sum3));
        System.out.println(hasPairWithSum(nums4, sum4));

        System.out.println("The other method");
        System.out.println(secondPairCheckWithSum(nums, sum));
        System.out.println(secondPairCheckWithSum(nums2, sum2));
        System.out.println(secondPairCheckWithSum(nums3, sum3));
        System.out.println(secondPairCheckWithSum( nums4, sum4));
    }
    public static int[] findPairOfNumbers(int[] nums, int sum){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int current = nums[i] + nums[j];
                if(current == sum){
                    return new int[] {nums[i], nums[j]};
                }
            }
        }
        return new int[] {-1, -1};
    }
    public static boolean hasPairWithSum(int[] nums, int sum) {
        int first = 0;
        int last = nums.length - 1;
        while (last > first) {
            int firstSum = nums[first] + nums[last];
            if (firstSum == sum) {
                System.out.println("The answers: " + nums[first] + " , " + nums[last]);
                return true;
            } else if (firstSum < sum) {
                first++;
            } else {
                last--;
            }
        }

        return false;
    }

    public static boolean secondPairCheckWithSum(int[] nums, int sum){
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            int target = sum - num;
            if (numbers.contains(target)){
                System.out.println("The answers are: " + num + " , " + target);
                return true;
            } else {
                numbers.add(num);
            }
        }
        return false;
    }
}
