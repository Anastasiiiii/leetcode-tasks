package Tasks;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String s = "whats the matter with Kansas";
        System.out.println(reverseString(s));
        //output: stahw eht rettam htiw sasnaK
    }

    private static String reverseString(String s) {
        StringBuilder newString = new StringBuilder();

        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            newString.append(word);
            if (i < words.length - 1) { // Add a space only if it's not the last word
                newString.append(" ");
            }
        }

        return newString.toString();
    }
}
