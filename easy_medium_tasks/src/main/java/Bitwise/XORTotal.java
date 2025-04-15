package Bitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class XORTotal {
    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(subsetXORSum(nums));
    }

    private static int subsetXORSum(int[] nums) {
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> current = new ArrayList<>();
        int index = 0;

        generateCombinations(nums, index, current, sum);

        return sum.get();
    }

    private static void generateCombinations(int[] nums, int index, List<Integer> current, AtomicInteger sum){
        if(!current.isEmpty()){
            int temp = 0;
            for(int el : current){
                temp ^= el;
            }
            sum.addAndGet(temp);
        }

        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            generateCombinations(nums, i + 1, current, sum);
            current.removeLast();
        }
    }
}
