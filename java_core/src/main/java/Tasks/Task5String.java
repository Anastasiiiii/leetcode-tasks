package Tasks;

import java.util.Arrays;
import java.util.HashMap;

public class Task5String {
    public static void main(String[] args) {
        String ransomNote = "ab";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

        String nums = "123";
        System.out.println(Arrays.toString(toInteger(nums)));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.getOrDefault(c, 0) <= 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    private static boolean isomorphicNumbers(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> s_map = new HashMap();
        HashMap<Character, Character> t_map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char char_s = s.charAt(i);
            char char_t = t.charAt(i);

            if (s_map.containsKey(char_s)) {
                if (s_map.get(char_s) != char_t) {
                    return false;
                }
            } else {
                s_map.put(char_s, char_t);
            }

            if (t_map.containsKey(char_t)) {
                if (t_map.get(char_t) != char_s) {
                    return false;
                }
            } else {
                t_map.put(char_t, char_s);
            }
        }
        return true;
    }

    private static int[] toInteger(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char char_s = s.charAt(i);
            int int_s = Integer.parseInt(String.valueOf(char_s));
            arr[i] = int_s;
        }
        return arr;
    }
}
