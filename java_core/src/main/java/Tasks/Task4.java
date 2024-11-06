package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */

public class Task4 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] expectedNums = {2, 2};

        int k = removeElement(nums, val);
        Integer[] sortedNums = Arrays.stream(Arrays.copyOf(nums, k))
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(sortedNums, Collections.reverseOrder());

        System.out.println(Arrays.toString(sortedNums));
        Arrays.sort(nums, 0, k);
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

        //Remove duplicates
        int[] numbers = {0, 0, 2, 2, 2, 3, 3, 3};

        int n = removeDuplicates(numbers);
        Integer[] newNums = Arrays.stream(Arrays.copyOf(numbers, n))
                .boxed()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(newNums));

        System.out.println("removeTwiceDuplicates");
        //Remove twice duplicates
        int[] numbers2 = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3};
        int m = removeTwiceDuplicates(numbers2);
        Integer[] newNums2 = Arrays.stream(Arrays.copyOf(numbers2, m))
                .boxed()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(newNums2));

        int[] majArray = {3, 3, 4};

        System.out.println("Majority element: " + majorityElement(majArray));

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Profit: " + maximumProfit(prices));

        int[] altPrices = {7, 6, 4, 3, 1};
        System.out.println("Profit2: " + maximumProfit((altPrices)));

        int[] prices2 = {1};
        System.out.println("Profit: " + maximumProfit(prices2));

        int[] numsT = {1, 3, 5, 6};
        int target = 5;
        int target2 = 2;

        int[] numsT1 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println(searchInsert(numsT, target));
        System.out.println(searchInsert(numsT, target2));
        System.out.println(searchInsert(numsT1, target3));

        System.out.println("search insert with binary search");
        System.out.println(searchInsertBinary(numsT, target));
        System.out.println(searchInsertBinary(numsT, target2));
        System.out.println(searchInsertBinary(numsT1, target3));

    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
    The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
    The remaining elements of nums are not important as well as the size of nums. Return k.
     */

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int limit = nums.length - 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < limit; i++) {
            if (nums[i] != nums[i + 1]) {
                temp[k++] = nums[i];
            }
        }
        temp[k++] = nums[limit];
        if (k >= 0) System.arraycopy(temp, 0, nums, 0, k);
        return k;
    }

    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
    The relative order of the elements should be kept the same.
    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
    More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
    Return k after placing the final result in the first k slots of nums.
    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     */
    public static int removeTwiceDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static int majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int el = nums[0];
        int count = 1;
        int maxCount = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        System.out.println(list);

        maxCount = Collections.max(list);
        count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count == maxCount) {
                    el = nums[i - 1];
                    break;
                }
                count = 1;
            }
        }
        if (count == maxCount) {
            el = nums[nums.length - 1];
        }

        return el;
    }

    public static int maxProfit(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();
        if (prices.length > 1) {
            int count = prices.length - 1;


            while (count >= 0) {
                for (int i = 0; i < count; i++) {
                    int dif = prices[count] - prices[i];
                    list.add(dif);
                }
                count--;
            }
            int max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (max < list.get(i))
                    max = list.get(i);
            }

            if (max > 0) {
                return max;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */
    public static int maximumProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /*
    *Given a sorted array of distinct integers and a target value, return the index if the target is found.
    * If not, return the index where it would be if it were inserted in order.
    * O(n) - time; O(1) - space
    * */
    public static int searchInsert(int[] nums, int target) {
        int limit = nums.length - 1;
        for (int i = 0; i < limit; i++) {
            if (nums[i] == target) {
                return i;
            } else if(target > nums[i] && target < nums[i+1]) {
                return i + 1;
            } else if (target > nums[limit]) {
                return limit + 1;
            }
        }
        return -1;
    }
    //O(log n) - binary search
    public static int searchInsertBinary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) /2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}