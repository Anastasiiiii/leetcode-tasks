package HashTable;

import java.util.HashSet;

public class HashTable {

    public static void main(String[] args){
        HashSet set = new HashSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        System.out.println(set);

        if(set.contains("Apple")){
            System.out.println("An apple is in the set");
        }

        set.remove("Banana");
        System.out.println(set);

        for(Object fruit : set){
            System.out.println(fruit);
        }

    }


}
