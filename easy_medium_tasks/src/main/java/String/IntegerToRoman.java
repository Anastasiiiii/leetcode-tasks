package String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1987));
    }
    //3749

    private static String intToRoman(int num) {
        StringBuilder newNum = new StringBuilder();
        Map<Integer, String> table = new LinkedHashMap<>();
        table.put(1000, "M");
        table.put(900, "CM");
        table.put(500, "D");
        table.put(400, "CD");
        table.put(100, "C");
        table.put(90, "XC");
        table.put(50, "L");
        table.put(40, "XL");
        table.put(10, "X");
        table.put(9, "IX");
        table.put(5, "V");
        table.put(4, "IV");
        table.put(1, "I");

        System.out.println(table);

        for(int el : table.keySet()){
            while (num >= el){
                num -= el;
                newNum.append(table.get(el));
            }
        }

        return newNum.toString();
    }

}
