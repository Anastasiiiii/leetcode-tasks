package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

        System.out.println("*******************************");
        String s1 = "abc";
        String t1 = "ahbdc";
        System.out.println(isSubsequence(s1, t1));

        System.out.println("*******************************");
        String s2 = "aec";
        String t2 = "abcde";
        System.out.println(isSubsequence(s2, t2));

        System.out.println("*******************************");
        String s3 = "aaaaaa";
        String t3 = "bbaaaa";
        System.out.println(isSubsequence(s3, t3));
    }

    private static boolean isSubsequence(String s, String t) {
        int index = 0;

        // Traverse through `s` and try to find each character in `t` in order
        for (char ch : s.toCharArray()) {
            index = t.indexOf(ch, index);

            // If character not found or is out of order, return false
            if (index == -1) {
                return false;
            }
            // Move to the next position in `t` after the found character
            index++;
        }

        return true;
    }
}
