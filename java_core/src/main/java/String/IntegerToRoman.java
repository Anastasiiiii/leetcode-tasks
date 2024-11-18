package String;

import java.util.HashMap;

public class IntegerToRoman {
    public static void main(String[] args) {

    }
    //3749

    private static String intToRoman(int num) {
        HashMap<Integer, String> table = new HashMap<>();
        table.put(1, "I");
        table.put(5, "V");
        table.put(10, "X");
        table.put(50, "L");
        table.put(100, "C");
        table.put(500, "D");
        table.put(1000, "M");

        return "M";
    }
}
