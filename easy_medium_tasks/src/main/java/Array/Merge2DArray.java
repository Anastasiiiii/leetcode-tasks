package Array;

import java.util.*;

public class Merge2DArray {
    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};

        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
    }

    private static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> pairs = new HashMap<>();

        //Going through the first array
        goThroughArray(nums1, pairs);
        System.out.println(pairs);

        //Go through the second array
        goThroughArray(nums2, pairs);

        //Convert HashMap keys to a sorted list
        List<Integer> sortedKeys = new ArrayList<>(pairs.keySet());
        Collections.sort(sortedKeys);

        int[][] result = new int[sortedKeys.size()][2];
        int index = 0;

        for(int key : sortedKeys){
            result[index][0] = key;
            result[index][1] = pairs.get(key);
            index++;
        }

        return result;
    }

    private static void goThroughArray(int[][] nums, HashMap<Integer, Integer> pairs){
        for (int i = 0; i < nums.length; i++) {
            if(pairs.containsKey(nums[i][0])){
                pairs.put(nums[i][0], pairs.get(nums[i][0]) + nums[i][1]);
            } else {
                pairs.put(nums[i][0], nums[i][1]);
            }
        }
    }
}
