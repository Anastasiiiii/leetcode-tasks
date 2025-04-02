package ListOfTheLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merging {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 4, 7));
        lists.add(Arrays.asList(2, 5));
        lists.add(Arrays.asList(3, 6, 8, 9));
        System.out.println(mergeNSortedLists(lists));
    }

    public static List<Integer> mergeNSortedLists(List<List<Integer>> lists) {
        // TODO: implement the function to merge sorted lists
        List<Integer> mergedList = new ArrayList<>();
        int[] pointers = new int[lists.size()];

        while (true) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find the minimum value among the current pointers
            for (int i = 0; i < lists.size(); i++) {
                if (pointers[i] < lists.get(i).size() && lists.get(i).get(pointers[i]) < minValue) {
                    minValue = lists.get(i).get(pointers[i]);
                    minIndex = i;
                }
            }

            // If no minimum index is found, all lists are exhausted
            if (minIndex == -1) {
                break;
            }

            // Add the smallest element to the merged list
            mergedList.add(minValue);

            // Move the pointer forward in the list from which the smallest element was taken
            pointers[minIndex]++;
        }

        return mergedList;
    }
}
