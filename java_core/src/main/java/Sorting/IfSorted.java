package Sorting;

import java.util.*;

public class IfSorted {
    public static void main(String[] args) {
        int[] nums = {8, 4, 2, 30, 15};
        int[] nums2 = {20, 16};
        System.out.println("Original Array: " + Arrays.toString(nums));
        sortArray(nums);
        System.out.println("\nSorted Array: " + Arrays.toString(nums));

        System.out.println("*********************************");
        System.out.println(canSortArray(nums));
        System.out.println(canSortArray(nums2));
        System.out.println(Integer.bitCount(20));
        System.out.println(Integer.bitCount(16));

        System.out.println("*********************************");
        int[] nums3 = {125, 92, 159};
        System.out.println("nums3: " + canSortArray(nums3));

        int[] nums4 = {16, 245, 125};
        System.out.println(canSortArray(nums4));
        countBit(nums4);

        int[] arr = {75, 34, 30};
        System.out.println(canSortArray(arr));

        System.out.println("*****************************************");
        int[] arr2 = {136, 256, 10};
        System.out.println(canSortArray(arr2));
    }

    /*You are given a 0-indexed array of positive integers nums.
    In one operation, you can swap any two adjacent elements if they have the same number of set bits.
    You are allowed to do this operation any number of times (including zero).
    Return true if you can sort the array, else return false.*/

    private static int[] sortArray(int[] nums) {
        int l = nums.length;
        for (int gap = l / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < l; i++) {
                int temp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
        //System.out.println(Arrays.toString(nums));
//        for (int i = 0; i < nums.length; i++) {
//            //to convert an Integer to a binary string representative
//            System.out.println(Integer.bitCount(nums[i]));
//
//        }
        return nums;
    }

    private static boolean canSortArray(int[] nums) {
        boolean isSorted = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]){
                isSorted = false;
                break;
            }
        }
        if(isSorted) return true;

        //Group elements by their set bit count
        Map<Integer, List<Integer>> bitCountGroups = new LinkedHashMap<>();
        for(int num : nums) {
            int bitCount = Integer.bitCount(num);
            bitCountGroups.computeIfAbsent(bitCount, k -> new ArrayList<>()).add(num);
        }
        System.out.println(bitCountGroups);

        //Sort each group individually
        for(List<Integer> group : bitCountGroups.values()){
            Collections.sort(group);
        }

        System.out.println(bitCountGroups);

        //Reconstruct the array by merging sorted groups
        int[] reconstructedArray = new int[nums.length];
        int index = 0;
        for(List<Integer> group : bitCountGroups.values()){
            for (int num : group){
                reconstructedArray[index++] = num;
            }
        }

        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);

        System.out.println(Arrays.toString(reconstructedArray));
        System.out.println(Arrays.toString(sortedArray));

        return Arrays.equals(reconstructedArray, sortedArray);
    }

    private static void countBit(int[] nums) {
        System.out.println("Original array: " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("Sorted array" + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Number of bits of " + i + " : " + Integer.bitCount(nums[i]));
        }
    }
}
