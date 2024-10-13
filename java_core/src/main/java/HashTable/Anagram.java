package HashTable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    /*Given two strings s and t, return true if t is an anagram of s, and false otherwise.*/
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Count characters from the first string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            System.out.println("Default solution: " + map.getOrDefault(c, 0));
        }

        System.out.println(map);
        // Subtract character counts based on the second string
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);  // Remove the character from the map if the count becomes zero
            }
        }

        // If the map is empty, the strings are anagrams
        return map.isEmpty();
    }

}
