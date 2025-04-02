package HashTable;

import java.util.HashMap;

public class Task1 {
    public static void main(String[] args){
        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("John", 12345);
        empIds.put("Carl", 45678);
        empIds.put("Mary", 36478);

        System.out.println(empIds);

        System.out.println(empIds.get("Carl"));
        System.out.println(empIds.containsKey("Carl"));
        System.out.println(empIds.containsValue(6));
        empIds.put("Carl", 67);
        System.out.println(empIds);

        empIds.replace("Carl", 777);
        System.out.println(empIds);

        empIds.putIfAbsent("Mike", 222);
        System.out.println(empIds);

        empIds.remove("Mary");
        System.out.println(empIds);
    }
}
