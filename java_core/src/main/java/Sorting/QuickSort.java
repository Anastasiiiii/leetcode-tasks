package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 10};
        int high = arr.length - 1;
        int low = 0;
        quickSort(arr, low, high);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            //Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            //Recursively sort elements before and after the partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; //the last element
        int i = low - 1; //index of the smaller element

        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){ //If current element is less than equal to pivot
                i++;
                swap(arr, i, j);
            }
        }
        //swap the pivot element to its correct position
        swap(arr, i + 1, high);
        return i + 1; //return the partition index
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
