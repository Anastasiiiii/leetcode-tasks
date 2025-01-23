package ArrayList;

import javax.swing.*;
import java.util.*;

public class Merging {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        System.out.println(mergeSortedListsDescendingUnique(list1, list2));
    }

    private static List<Integer> mergeSortedListsDescendingUnique(List<Integer> list1, List<Integer> list2) {
        // TODO: Implement the function

        ArrayList<Integer> mergedList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = list1.size(), m = list2.size();
        int i = n - 1, j = m - 1;

        while (i >= 0 && j >= 0) {
            if (list1.get(i) >= list2.get(j)) {
                if (set.add(list1.get(i))) {
                    mergedList.add(list1.get(i));
                }
                i--;
            } else {
                if (set.add(list2.get(j))) {
                    mergedList.add(list2.get(j));
                }
                j--;
            }
        }

        while (i >= 0) {
            if (set.add(list1.get(i))) {
                mergedList.add(list1.get(i));
            }
            i--;
        }

        while (j >= 0) {
            if (set.add(list2.get(j))) {
                mergedList.add(list2.get(j));
            }
            j--;
        }

        System.out.println("MergedList without reversing: " + mergedList);
        Collections.sort(mergedList);
        return mergedList;
    }
}
