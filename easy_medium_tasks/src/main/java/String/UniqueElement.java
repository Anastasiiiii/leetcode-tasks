package String;

import java.util.HashMap;
import java.util.Hashtable;

public class UniqueElement {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("aabb"));
        System.out.println(firstUniqueChar("llemetcmode"));
    }

    private static int firstUniqueChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        System.out.println(map);

        for(int  i = 0; i < l; i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}
