package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};

        System.out.println(Arrays.toString(selectionSortMethod(arr)));
    }

    //Time complexity: O(n)
    //Space complexity: O(1)

    public static int[] selectionSortMethod(int[] arr) {
        // TODO: Implement selection sort algorithm
        int endPoint = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = findMinValue(arr, i, endPoint);
            swapMethod(arr, minIndex, i);
        }
        return arr;
    }

    //Method to find an index of the minValue in particular segment of the array
    private static int findMinValue(int[] arr, int startPoint, int endPoint){
        int minValue = arr[startPoint];
        int minIndex = startPoint;

        for (int i = startPoint + 1; i <= endPoint; i++) {
            if(arr[i] < minValue){
                minValue = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Method to swap the minimum value in the array with the element
     * that comes immediately after the last occurrence of the minimum value.
     */

    private static void swapMethod(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
