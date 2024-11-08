package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class ArrayListVsArrays {
    public static void main(String[] args) {
        String[] friendsArray = new String[4];
        String[] a = {"A", "B", "C", "D"};

        ArrayList<String> friendsArrayList = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 34));
        ArrayList<String> friendsArrayList2 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println(friendsArrayList2);
        System.out.println(numbers);

        System.out.println(numbers.get(1));
        System.out.println(numbers.size());

        //add an element
        numbers.add(5);
        System.out.println(numbers);

        //set
        a[3] = "K";
        System.out.println(Arrays.toString(a));
        numbers.set(3, 55);
        System.out.println(numbers);

        numbers.remove(2);
        System.out.println(numbers);

        //Linked list
        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("John");
        namesLinkedList.add("Mary");
        namesLinkedList.add("Kate");
        namesLinkedList.add(1, "Jerry");

        System.out.println(namesLinkedList.get(2));
        System.out.println(namesLinkedList);
    }
}
