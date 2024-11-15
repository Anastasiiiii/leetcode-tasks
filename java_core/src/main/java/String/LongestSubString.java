package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.regex.Pattern.matches;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "pwwkew";
        String s3 = "";
        String s4 = " ";
        String s5 = "au";
        String s6 = "auk";
        System.out.println(s + " " + lengthOfLongestSubstring(s));
        System.out.println(s2 + " " + lengthOfLongestSubstring(s2));
        System.out.println(s3 + " " + lengthOfLongestSubstring(s3));
        System.out.println(s4 + " " + lengthOfLongestSubstring(s4));
        System.out.println(s5 + " " + lengthOfLongestSubstring(s5));
        System.out.println(s6 + " " + lengthOfLongestSubstring(s6));
    }

    private static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        List<Integer> hash = new ArrayList<>();

        if(s.isEmpty()) {
            return 0;
        } else if (!s.matches(".*[a-zA-Z].*") || s.length() == 1){
            return 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            } else {
                hash.add(list.size());
                int index = list.indexOf(s.charAt(i));
                list = list.subList(index + 1, list.size());
                list.add(s.charAt(i));
            }
        }

        hash.add(list.size());
        return Collections.max(hash);
    }
}
