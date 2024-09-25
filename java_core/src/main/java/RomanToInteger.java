import java.util.ArrayList;
import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";
        System.out.println(romanToInt(s));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
    }

    public static int romanToInt(String s){
        HashMap<String, Integer> table = new HashMap<>();
        ArrayList<String> stringParts = new ArrayList<>();
        int num = 0;
        //Adding elements to the table
        table.put("I", 1);
        table.put("V", 5);
        table.put("X", 10);
        table.put("L", 50);
        table.put("C", 100);
        table.put("D", 500);
        table.put("M", 1000);
        table.put("IV", 4);
        table.put("IX", 9);
        table.put("XL", 40);
        table.put("XC", 90);
        table.put("CD", 400);
        table.put("CM", 900);

        //checking if the string has romans combinations; adding combinations or separate parts into the arrayList
        for (int i = 0; i < s.length(); i++) {
            if(i+1 < s.length()) {
                String combination = s.substring(i, i+2);
                if (combination.equals("IV") || combination.equals("IX") ||
                    combination.equals("XL") || combination.equals("XC") ||
                    combination.equals("CD") || combination.equals("CM")) {
                    stringParts.add(combination);
                    i++;
                    continue;
                }
            }
            stringParts.add(String.valueOf(s.charAt(i)));
        }
        System.out.println(stringParts);

        //convert into integer
        for(String part : stringParts) {
            if (table.containsKey(part)) {
                num += table.get(part);
            } else {
                System.out.println("Error");
            }
        }
        return num;
    }
}
