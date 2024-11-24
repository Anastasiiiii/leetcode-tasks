package String;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello WORLD";
        String s1 = "abc123XYz!";
        System.out.println(reverseString(s));
        System.out.println(solution(s));

        System.out.println((int) 'A');
        System.out.println((int) 'a');
        System.out.println((int) 'B');
        System.out.println((int) 'b');
        System.out.println((int) 'Y');
        System.out.println((int) 'y');
    }

    private static String reverseString(String s) {
        StringBuilder reverseString = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();

        for(int i = s.length() - 1; i >= 0; i--) reverseString.append(s.charAt(i));
        return reverseString.toString();
    }

    private static List<Integer> solution(String s) {
        // TODO: implement solution
        List<Integer> list = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();
        vowels.add('o');
        vowels.add('i');
        vowels.add('e');
        vowels.add('u');
        vowels.add('a');
        System.out.println(vowels);

        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                list.add(i);
            }
        }
        return list;
    }

    private static String shiftByOneCharacter(String s) {
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'z'){
                newString.append('a');
            } else if(s.charAt(i) == 'Z'){
                newString.append('A');
            } else if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
                newString.append((char) ((int) s.charAt(i) + 1));
            } else {
                newString.append(s.charAt(i));
            }
        }
        return newString.toString();
    }
}