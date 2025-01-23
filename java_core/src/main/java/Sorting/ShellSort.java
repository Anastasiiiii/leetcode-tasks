package Sorting;

import java.util.Arrays;
import java.util.List;

public class ShellSort {
    private static void shellSort(int[] array) {
        int n = array.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save array[i] in temp and make a hole at position i
                int temp = array[i];

                // Shift earlier gap-sorted elements up until the correct location for array[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Put temp (the original array[i]) in its correct location
                array[j] = temp;
            }
        }
    }

    private static void shellSortForList(List<Integer> list) {
        if(list == null || list.size() <= 1){
            return;
        }
        int n = list.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = list.get(i);

                int j;
                for (j = i; j >= gap && list.get(j - gap) > temp; j -= gap) {
                    list.set(j, list.get(j - gap));
                }

                list.set(j, temp);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 34, 54, 2, 3};

        System.out.println("Original Array:");
        printArray(array);

        shellSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);

        List<Integer> list = Arrays.asList(2, 1, 5, 7, 3, 8, 9);
        shellSortForList(list);
        System.out.println(list);
    }

    // Helper method to print the array
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
