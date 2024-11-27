package Sorting;

public class SecondMaxInt {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7};
        System.out.println(secondMax(arr));
        System.out.println(findSecondMaximum(arr));
    }


    private static Integer secondMax(int[] nums) {
        // TODO: Find the second largest number in nums

        if (nums.length == 0) {
            return null;
        }

        int last = nums.length - 1;
        quickSort(nums, 0, last);

        int maximum = nums[last];
        for (int i = last; i >= 0; i--) {
            if (nums[i] != maximum) {
                return nums[i];
            }
        }

        return null;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static Integer findSecondMaximum(int[] nums){
        // TODO: Find the second largest number in nums
        if(nums.length == 0){
            return null;
        }

        Integer maximum = null;
        Integer secondMax = null;

        for(int num : nums){
            if(maximum == null || num > maximum){
                secondMax = maximum;
                maximum = num;
            } else if ((secondMax == null || num > secondMax) && num < maximum) {
                secondMax = num;
            }
        }
        return secondMax;
    }

}