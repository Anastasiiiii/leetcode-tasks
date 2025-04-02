package ListOfTheLists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    * [[5, 10], [1], [20, 30, 15]]
    * */
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        //List1
        list1.add(5);
        list1.add(10);
        lists.add(list1);
        //List2
        list2.add(1);
        lists.add(list2);
        //List3
        list3.add(20);
        list3.add(30);
        list3.add(15);
        lists.add(list3);
        System.out.println(lists);
    }
}
