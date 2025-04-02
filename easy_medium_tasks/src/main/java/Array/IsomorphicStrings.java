package Array;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    /*Given two strings s and t, determine if they are isomorphic.
      Two strings s and t are isomorphic if the characters in s can be replaced to get t.
      All occurrences of a character must be replaced with another character while preserving the order of characters.
      No two characters may map to the same character, but a character may map to itself.*/

    private static boolean isIsomorphic(String s, String t) {
        int[] arr_s = new int [128];
        int[] arr_t = new int [128];

        for (int i=0; i < s.length(); i++){
            char char_s = s.charAt(i);
            char char_t = t.charAt(i);

            if(arr_s[char_s]==0) arr_s[char_s] = char_t;
            if(arr_t[char_t]==0) arr_t[char_t] = char_s;

            if(arr_s[char_s] != char_t || arr_t[char_t] != char_s){
                return false;
            }
        }
        return true;
    }
}
