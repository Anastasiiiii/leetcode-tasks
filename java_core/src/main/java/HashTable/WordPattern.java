package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String patern2 = "aaaa";
        String pattern3 = "aba";
        String s = "dog cat cat dog";
        String s1 = "dog cat cat fish";
        String s2 = "dog dog dog dog";
        String s3 = "dog cat cat";
        System.out.println("Does the word follow the pattern? " + wordPattern(pattern, s));
        System.out.println("Does the word follow the pattern? " + wordPattern(pattern, s1));
        System.out.println("Does the word follow the pattern? " + wordPattern(patern2, s));
        System.out.println("Does the word follow the pattern? " + wordPattern(pattern, s2));
        System.out.println("Does the word follow the pattern? " + wordPattern(pattern3, s3));
        System.out.println("*************************************************");
        System.out.println("Does the word follow the pattern? " + wordPatternTwoHashMaps(pattern, s));
        System.out.println("Does the word follow the pattern? " + wordPatternTwoHashMaps(pattern, s1));
        System.out.println("Does the word follow the pattern? " + wordPatternTwoHashMaps(patern2, s));
        System.out.println("Does the word follow the pattern? " + wordPatternTwoHashMaps(pattern, s2));
        System.out.println("Does the word follow the pattern? " + wordPatternTwoHashMaps(pattern3, s3));
    }
    /*Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
    Specifically:
    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.*/

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        String[] s_arr = s.split(" ");
        for(String el : s_arr){
            words.add(el);
        }
        System.out.println(words);
        char[] pattern_arr = pattern.toCharArray();
        if(pattern_arr.length != s_arr.length){
            return false;
        }
        int start = 0;
        while(start < pattern_arr.length){
            if(!map.containsKey(pattern_arr[start]) && !map.containsValue(s_arr[start])){
                map.put(pattern_arr[start], s_arr[start]);
                words.remove(s_arr[start]);
            } else if(!map.containsKey(pattern_arr[start]) && map.containsValue(s_arr[start])) {
                words.add(s_arr[start]);
            } else if (!map.get(pattern_arr[start]).equals(s_arr[start])){
                words.add(s_arr[start]);
            } else if(map.containsValue(s_arr[start])){
                words.remove(s_arr[start]);
            }
            start++;
        }
        System.out.println(map);
        System.out.println(words);
        return words.isEmpty();
    }

    //The second option
    public static boolean wordPatternTwoHashMaps(String pattern, String s){
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if(map.containsKey(c)){
                if(!map.get(c).equals(word)){
                    return false;
                }
            } else {
                if(reverseMap.containsKey(word)) {
                    return false;
                }

                map.put(c, word);
                reverseMap.put(word, c);
            }
        }
        return true;
    }
}
