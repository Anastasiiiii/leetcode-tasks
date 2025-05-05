package String;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    private static String removeDuplicateLetters(String s) {
        int[] lastSeen = new int[26];
        boolean[] used = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0;  i < s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if(used[index]){
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && lastSeen[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                used[removed - 'a'] = false;
            }

            stack.push(c);
            used[index] = true;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
