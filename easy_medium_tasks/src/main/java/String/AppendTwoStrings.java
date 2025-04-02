package String;

import java.util.Arrays;

public class AppendTwoStrings {
    public static void main(String[] args) {
        String string1 = "peach";
        String string2 = "apple";
        System.out.println(solution(string1, string2));
    }

    private static String solution(String string1, String string2) {
        //TODO: You are given two strings, string1 and string2. Your goal is to determine a new string, string3, that is formed by characters that occur in both string1 and string2 in the same order as they occur in string1.
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];
        for (char c : string2.toCharArray()) {
            count[c - 'a']++;
        }
        System.out.println(Arrays.toString(count));

        for (char c : string1.toCharArray()) {
            if (count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }
        return result.toString();
    }
}
