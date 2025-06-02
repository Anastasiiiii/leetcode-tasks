package HashTable;

import java.util.*;

public class TopK {
    public static void main(String[] args) {
       int[] nums = {1, 1, 1, 2, 2, 3};
       int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }

        return result;

    }
}
