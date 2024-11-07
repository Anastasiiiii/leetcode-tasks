package Sorting;

import java.util.*;

public class IfSorted {
    public static void main(String[] args) {
        int[] nums = {8, 4, 2, 30, 15};
        int[] nums2 = {20, 16};

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

        System.out.println("****************************************");
        int[] arr3 = {11, 174, 254, 251};
        System.out.println(canSortArray(arr3));

        System.out.println("******************************************");
        int[] arr4 = {5, 3, 8};
        System.out.println(canSortArray(arr4));

        System.out.println("******************************************");
        int[] arr5 = {174, 175, 234, 188};
        System.out.println(canSortArray(arr5));
    }

    /*You are given a 0-indexed array of positive integers nums.
    In one operation, you can swap any two adjacent elements if they have the same number of set bits.
    You are allowed to do this operation any number of times (including zero).
    Return true if you can sort the array, else return false.*/

//    public static boolean canSortArray(int[] nums) {
//        // Перевірка, чи масив вже відсортований
//        boolean isSorted = true;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                isSorted = false;
//                break;
//            }
//        }
//        if (isSorted) return true;
//
//        System.out.println(Arrays.toString(nums));
//
//        // Групування елементів за кількістю одиниць у бітовому поданні
//        Map<Integer, List<Integer>> bitCountGroups = new LinkedHashMap<>();
//        List<Integer> currentGroup = null;
//        LinkedList<Integer> sortedNumbers = new LinkedList<>();
//        int previousBitCount = -1;
//
//        int n = 0;
//        while (n < nums.length - 1 && nums[n] <= nums[n + 1]){
//            sortedNumbers.add(nums[n]);
//            n++;
//        }
//        //sortedNumbers.add(nums[n]);
//
//        for (int i = n+1; i < nums.length; i++) {
//                int bitCount = Integer.bitCount(nums[i]);
//
//                if (bitCount == previousBitCount) {
//                    currentGroup.add(nums[i]);
//                } else {
//                    if (currentGroup != null) {
//                        bitCountGroups.put(previousBitCount, currentGroup);
//                    }
//                    currentGroup = new ArrayList<>();
//                    currentGroup.add(nums[i]);
//                }
//                previousBitCount = bitCount;
//        }
//
//        if (currentGroup != null) {
//            bitCountGroups.put(previousBitCount, currentGroup);
//        }
//
//        System.out.println("Already sorted numbers: " + sortedNumbers);
//        System.out.println("Bit count groups: " + bitCountGroups);
//
//        // Сортування кожної групи окремо
//        for (List<Integer> group : bitCountGroups.values()) {
//            Collections.sort(group);
//        }
//
//        System.out.println("Sorted bit count groups: " + bitCountGroups);
//        // Відновлення масиву шляхом об'єднання відсортованих груп
//        int[] reconstructedArray = new int[nums.length];
//        int index = 0;
//
//        if (!sortedNumbers.isEmpty()) {
//            for (int num : sortedNumbers) {
//                reconstructedArray[index++] = num;
//            }
//        }
//
//        for (List<Integer> group : bitCountGroups.values()) {
//            for (int num : group) {
//                reconstructedArray[index++] = num;
//            }
//        }
//
//        System.out.println(Arrays.toString(reconstructedArray));
//        // Перевірка, чи збігається відновлений масив з відсортованою копією
//        int[] sortedArray = nums.clone();
//        Arrays.sort(sortedArray);
//
//        // Порівняння відновленого масиву з відсортованим
//        return Arrays.equals(reconstructedArray, sortedArray);
//    }

    public static boolean canSortArray(int[] nums) {
        // Перевірка, чи масив вже відсортований
        boolean isSorted = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return true;

        System.out.println("Original array: " + Arrays.toString(nums));

        // Знаходимо найдовший відсортований префікс
        LinkedList<Integer> sortedNumbers = new LinkedList<>();
        int i = 0;
        while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
            sortedNumbers.add(nums[i]);
            i++;
        }
        sortedNumbers.add(nums[i]);  // Додаємо останній елемент префіксу

        // Групування решти елементів за кількістю одиниць у бітовому поданні
        Map<Integer, List<Integer>> bitCountGroups = new LinkedHashMap<>();
        for (int j = i + 1; j < nums.length; j++) {
            int bitCount = Integer.bitCount(nums[j]);
            bitCountGroups.computeIfAbsent(bitCount, k -> new ArrayList<>()).add(nums[j]);
        }

        System.out.println("Already sorted numbers: " + sortedNumbers);
        System.out.println("Bit count groups: " + bitCountGroups);

        // Сортування кожної групи окремо
        for (List<Integer> group : bitCountGroups.values()) {
            Collections.sort(group);
        }

        System.out.println("Sorted bit count groups: " + bitCountGroups);

        // Відновлення масиву шляхом об'єднання відсортованих груп
        int[] reconstructedArray = new int[nums.length];
        int index = 0;

        // Додаємо відсортований префікс на початок reconstructedArray
        for (int num : sortedNumbers) {
            reconstructedArray[index++] = num;
        }

        // Додаємо відсортовані групи за кількістю одиниць
        for (List<Integer> group : bitCountGroups.values()) {
            for (int num : group) {
                reconstructedArray[index++] = num;
            }
        }

        // Перевірка, чи збігається відновлений масив з відсортованою копією
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);

        System.out.println("Reconstructed array: " + Arrays.toString(reconstructedArray));
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        // Порівняння відновленого масиву з відсортованим
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
