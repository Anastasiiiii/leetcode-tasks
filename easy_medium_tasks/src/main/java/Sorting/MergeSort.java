package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 5};
        System.out.println(Arrays.toString(mergeSortMethod(arr)));
    }

    private static int[] mergeSortMethod(int[] array) {
        // TODO: Implement the merge sort algorithm
        if (array.length <= 1) {
            return array;
        }
        int midPoint = array.length / 2;

        int[] firstSubarray = new int[midPoint];
        int[] secondSubarray = new int[array.length - midPoint];

        System.arraycopy(array, 0, firstSubarray, 0, midPoint);
        System.arraycopy(array, midPoint, secondSubarray, 0, array.length - midPoint);

        firstSubarray = mergeSortMethod(firstSubarray);
        secondSubarray = mergeSortMethod(secondSubarray);

        return merge(firstSubarray, secondSubarray);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[n + m];

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < n) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < m) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
}
