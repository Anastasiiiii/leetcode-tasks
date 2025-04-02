package Array;

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(adjacentSort(arr)));
    }

    private static int[] bubbleSort(int[] arr){
        boolean swapped;
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if(swapped == false){
                break;
            }
        }

        return arr;
    }

    private static int[] adjacentSort(int[] arr){
        int n = arr.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return arr;
    }
}
