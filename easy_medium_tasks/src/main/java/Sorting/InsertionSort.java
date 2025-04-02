package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(insertionSortMethod(arr)));
    }

    //Time complexity: O(n^2)
    private static int[] insertionSortMethod(int[] arr){
        // TODO: implement the Insertion Sort algorithm

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(arr[i] < arr[j]){
                    swapMethod(arr, i, j);
                    System.out.println("i = : " + i + " j = : " + j + " Array: " + Arrays.toString(arr));
                }
            }
        }

        return arr;
    }

    private static void swapMethod(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
