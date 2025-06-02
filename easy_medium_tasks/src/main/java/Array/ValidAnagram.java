package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "eat";
        String s2 = "tea";
        System.out.println(isValid(s1, s2));
        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isValid(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        int[] freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for(int count : freq){
            if(count != 0) return false;
        }

        return true;
    }


    //Second option
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
}
