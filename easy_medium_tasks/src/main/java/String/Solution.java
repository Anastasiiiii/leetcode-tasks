package String;
import java.util.ArrayList;

    public class Solution {
    public static ArrayList<Integer> mergeSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Append remaining elements of list1, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Append remaining elements of list2, if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(3);
        list1.add(5);

        list2.add(2);
        list2.add(4);
        list2.add(6);

        ArrayList<Integer> mergedList = mergeSortedLists(list1, list2);
        System.out.println("Merged List: " + mergedList);
    }
}