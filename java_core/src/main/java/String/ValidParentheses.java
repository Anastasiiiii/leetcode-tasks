package String;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        String s1 = "(}";
        String s2 = "()[]{}";
        String s3 = "([])";
        String s4 = "([)]";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }
    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //An input string is valid if:
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Every close bracket has a corresponding open bracket of the same type.

    private static boolean isValid(String s) {
        HashMap<Character, Character> parenthesesPares = new HashMap<>();
        parenthesesPares.put('(', ')');
        parenthesesPares.put('{', '}');
        parenthesesPares.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (parenthesesPares.containsKey(c)) {
                stack.push(c);
                System.out.println(stack);
            } else if (parenthesesPares.containsValue(c)) {
                if (stack.isEmpty() || parenthesesPares.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
