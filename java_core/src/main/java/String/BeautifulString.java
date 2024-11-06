package String;

import com.sun.jdi.IntegerValue;

import java.util.HashSet;

public class BeautifulString {
    public static void main(String[] args) {
        String s = "1001";
        System.out.println(minChanges(s));
        String s1 = "10";
        System.out.println(minChanges(s1));
        String s2 = "0000";
        System.out.println(minChanges(s2));

        System.out.println("*******************************");
        System.out.println(minChanges2(s));
        System.out.println(minChanges2(s1));
        System.out.println(minChanges2(s2));
    }

    /*You are given a 0-indexed binary string s having an even length.
    A string is beautiful if it's possible to partition it into one or more substrings such that:
        1. Each substring has an even length.
        2. Each substring contains only 1's or only 0's.
        3. You can change any character in s to 0 or 1.
    Return the minimum number of changes required to make the string s beautiful.*/

    //s={1001} minChanges=2 -> sNew = {1100}
    private static int minChanges(String s) {
        int minChanges = 0;
        String[] subStr = s.split("");

        for (int i = 0; i < subStr.length; i += 2) {
            if (!subStr[i].equals(subStr[i + 1])) {
                minChanges++;
            }
        }
        return minChanges;
    }

    private static int minChanges2(String s) {
        int minChanges = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                minChanges++;
            }
        }
        return minChanges;
    }
}
