package HashTable;

import java.util.*;

public class Duplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int[] nums4 = {1, 5, 9, 1, 5, 9};
        int[] nums5 = {8, 7, 15, 1, 6, 1, 9, 15};
        int k = 3;
        int k1 = 2;
        int indexDiff = 3;
        int valueDiff = 0;
        int indexDiff1 = 2;
        int indexDiff2 = 1;
        int valueDiff1 = 3;
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(nums2));
        System.out.println("***********************************");
        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicate(nums3, k1));
        System.out.println("************************************");
        System.out.println(containsNearbyDuplicate2(nums, k));
        System.out.println(containsNearbyDuplicate2(nums3, k1));
        System.out.println("************************************");
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        System.out.println(containsNearbyAlmostDuplicate(nums4, indexDiff1, valueDiff1));
        System.out.println(containsNearbyAlmostDuplicate(nums5, indexDiff2, valueDiff1));
        System.out.println("************************************");
        System.out.println(containsNearbyAlmostDuplicate2(nums, indexDiff, valueDiff));
        System.out.println(containsNearbyAlmostDuplicate2(nums4, indexDiff1, valueDiff1));
        System.out.println(containsNearbyAlmostDuplicate2(nums5, indexDiff2, valueDiff1));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(Math.random());
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-1){
            if (nums[i] == nums[i+1]) {
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = i + 1;
        while (i < nums.length - 1) {
            if(nums[i] == nums[j]){
                int r = j - i;
                if(r <= k) {
                    set.add(r);
                    return true;
                }
            } else {
                j++;
            }
            i++;
        }
        System.out.println(set);
        return false;
    }
    private static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int previousIndex = map.get(nums[i]);
                if(i - previousIndex <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }

    /*
    You are given an integer array nums and two integers indexDiff and valueDiff.
    Find a pair of indices (i, j) such that:
    i != j,
    abs(i - j) <= indexDiff.
    abs(nums[i] - nums[j]) <= valueDiff, and Return true if such pair exists or false otherwise.
     */

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int previousIndex = map.get(nums[i]);
                if(i != previousIndex){
                    int j = Math.abs(i - previousIndex);
                    if(j <= indexDiff){
                        int k = Math.abs(nums[i] - nums[previousIndex]);
                        if(k <= valueDiff){
                            return true;
                        }
                    }
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }

    private static boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j) {
                    int m = Math.abs(i - j);
                    if (m <= indexDiff) {
                        int k = Math.abs(nums[i] - nums[j]);
                        if (k <= valueDiff) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
