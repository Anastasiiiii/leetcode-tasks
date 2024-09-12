import java.util.Stack;

public class FindDublicatesInString {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDublivates(s));
        System.out.println(removeDublicatesInString(s));
    }
    private static String removeDublivates(String s) {
        StringBuilder stack = new StringBuilder();

        for(char c : s.toCharArray()){
            if(stack.length() > 0 && stack.charAt(stack.length() - 1)==c){
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }

    private static String removeDublicatesInString(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for(char c : stack){
            result.append(c);
        }

        return result.toString();
    }
}
