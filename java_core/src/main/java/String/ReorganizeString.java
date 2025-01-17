package String;

import HashTable.HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class ReorganizeString {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aaaab";

        System.out.println(reorganizeString(s1));
        System.out.println(reorganizeString(s2));
    }

    private static String reorganizeString(String s){
        HashMap<Character, Integer> table = new HashMap<>();
        char[] s_arr = s.toCharArray();
        System.out.println(Arrays.toString(s_arr));
        int count = 0;
        for (int i = 0; i < s_arr.length-1; i++) {
            if(s_arr[i] == s_arr[i+1]){
                count++;
            } else {
                table.put(s_arr[i], count+1);
                count = 0;
            }
        }
        System.out.println(table);
        return s;
    }
}
