package String;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(()";
        String s1 = ")()())";
        String s2 = "";
        String s3 = ")(";
        System.out.println("S: " + longestValidParentheses(s));
        System.out.println("S1: " + longestValidParentheses(s1));
        System.out.println("S2: " + longestValidParentheses(s2));
        System.out.println("S3: " + longestValidParentheses(s3));
    }

    private static int longestValidParentheses(String s) {
        Stack<Integer> openParentheses = new Stack<>();
        int count = 0;
        openParentheses.push(-1);

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                openParentheses.push(i);
            } else {
                openParentheses.pop();
                if(openParentheses.isEmpty()){
                    openParentheses.push(i);
                } else {
                    count = Math.max(count, i - openParentheses.peek());
                }
            }
        }
        return count;
    }
}
