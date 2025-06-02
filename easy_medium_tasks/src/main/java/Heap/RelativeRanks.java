package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    private static String[] findRelativeRanks(int[] score) {
        HashMap<Integer, String> ranks = new HashMap<>();
        ranks.put(1, "Gold Medal");
        ranks.put(2, "Silver Medal");
        ranks.put(3, "Bronze Medal");

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int el : score) {
            heap.offer(el);
        }

        int len = score.length;
        String[] result = new String[len];
        for(int i = 0; i < len; i++){
            int el = heap.poll();
            if(ranks.containsKey(el)){
                result[i] = ranks.get(el);
            } else {
                result[i] = Integer.toString(el);
            }
        }

        return result;
    }
}
