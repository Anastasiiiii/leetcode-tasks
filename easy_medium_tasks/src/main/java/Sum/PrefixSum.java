package Sum;

import java.util.Stack;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 5, 15};
        //prefix_arr = {10, 30, 40, 45, 60}
        System.out.println(prefixSum(arr));
    }

    private static Stack<Integer> prefixSum(int[] arr) {
        Stack<Integer> prefixSum = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (prefixSum.isEmpty()) {
                prefixSum.add(arr[i]);
            } else {
                int sum = prefixSum.lastElement() + arr[i];
                prefixSum.add(sum);
            }
        }
        return prefixSum;
    }
}
