package Array;

import java.util.ArrayList;
import java.util.List;

public class ListShift {
    public static void main(String[] args) {
        List<Integer> ls = List.of(1, 2, 3, 4, 5);
        int shift = 2;
        System.out.println(shiftListElements(ls, shift));

    }

    private static List<Integer> shiftListElements(List<Integer> ls, int shift) {
        // TODO: To create a Java function that should shift every element in the list to the right (for a positive shift) or to the left (for a negative shift) by shift positions.
        List<Integer> resultList = new ArrayList<>();
        if(ls.isEmpty()){
            return null;
        }

        int l = ls.size();
        shift = ((shift % l) + l) % l;
        for (int i = 0; i < l; i++) {
            resultList.add(0);
        }

        for (int i = 0; i < l; i++) {
            int newIndex = (i + shift) % l;
            resultList.set(newIndex, ls.get(i));
        }

        return resultList;
    }
}
