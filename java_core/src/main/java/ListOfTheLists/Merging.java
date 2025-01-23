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
        if (lists == null || lists.size() <= 1) {
            return null;
        }

        ArrayList<Integer> mergedList = new ArrayList<>();
        while(true){
            for (List<Integer> list : lists) {
                if (!list.isEmpty()) {
                    int s = findTheSmallest(list);
                    mergedList.add(s);
                    list.remove(s);
                }
            }
        }

        return mergedList;
    }

    private static int findTheSmallest(List<Integer> list){
        if(list == null || list.size() <= 1){
            return -1;
        }

        int minValue = list.get(0);

        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < minValue){
                minValue = list.get(i);
            }
        }

        return minValue;
    }
}
