import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LengthOfLastWord {

    /*
    * Given a string s consisting of words and spaces, return the length of the last word in the string.
     A word is a maximal substring consisting of non-space characters only.
    * */
    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
        String[] str = {"flower", "flow", "flight"};
        //longestCommonPrefix(str);
        System.out.println("The longest prefix: " + horizontalScanning(str));
        System.out.println("The longest prefix with binary Search: " + binarySearchOfTheLongestPrefix(str));
    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        String[] letters = words[words.length - 1].split("");
        return letters.length;
    }

    //Write a function to find the longest common prefix string amongst an array of strings.
    //If there is no common prefix, return an empty string "".

    public static String horizontalScanning(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        System.out.println(prefix);
        //Compare with each row
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String binarySearchOfTheLongestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
