package Array;

public class isMonotonic {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {6, 5, 5, 4};
        int[] arr3 = {1, 3, 2};
        int[] arr4 = {1};
        int[] arr5 = {1, 2};
        int[] arr6 = {2, 1};

        System.out.println(isMonolitic(arr1)); //true
        System.out.println(isMonolitic(arr2)); //true
        System.out.println(isMonolitic(arr3)); //false
        System.out.println(isMonolitic(arr4));
        System.out.println(isMonolitic(arr5));
        System.out.println(isMonolitic(arr6));
        System.out.println("***********************");
        System.out.println(isMonolitic2(arr1)); //true
        System.out.println(isMonolitic2(arr2)); //true
        System.out.println(isMonolitic2(arr3)); //false
        System.out.println(isMonolitic2(arr4));
        System.out.println(isMonolitic2(arr5));
        System.out.println(isMonolitic2(arr6));
    }

    /*An array is monotonic if it is either monotone increasing or monotone decreasing.
    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
    An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
    Given an integer array nums, return true if the given array is monotonic, or false otherwise.*/

    private static boolean isMonolitic(int[] arr) {
        if (arr.length < 2) {
            return false;
        }

        String state = "increase";
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i] < arr[i + 1]) {
                    state = "increase";
                } else state = "decrease";
                break;
            }
        }

        if (state.equals("increase")) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isMonolitic2(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        int last = arr.length - 1;
        if (arr[0] <= arr[last]) {
            for (int i = 1; i <= last; i++) {
                if (arr[i] < arr[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= last; i++) {
                if (arr[i] > arr[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
