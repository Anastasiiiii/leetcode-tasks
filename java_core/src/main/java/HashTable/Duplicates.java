package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k = 3;
        int k1 = 2;
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(nums2));
        System.out.println("***********************************");
        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicate(nums3, k1));
        System.out.println("************************************");
        System.out.println(containsNearbyDuplicate2(nums, k));
        System.out.println(containsNearbyDuplicate2(nums3, k1));
    }

    public static boolean containsDuplicate(int[] nums) {
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

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
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
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
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

}
