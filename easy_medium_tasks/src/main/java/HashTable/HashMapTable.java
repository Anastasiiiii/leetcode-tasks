package HashTable;

import java.util.HashMap;

public class HashMapTable {
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 25);

        System.out.println(map);

        Object value = map.get("Apple");
        System.out.println(value);

        map.remove("Banana");
        System.out.println(map);

        for(Object key : map.keySet()){
            System.out.println("Key: " + key + " , Value: " + map.get(key));
        }
    }
}
