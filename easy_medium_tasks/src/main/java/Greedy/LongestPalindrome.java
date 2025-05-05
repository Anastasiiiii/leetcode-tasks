package Greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int total = 0;
        boolean hashOdd = false;

        for(char c : s.toCharArray()){
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for(char k : hash.keySet()){
            if(hash.get(k) % 2 == 0){
                total += hash.get(k);
            } else {
                total += hash.get(k) - 1;
                hashOdd = true;
            }
        }

        if(hashOdd) total += 1;

        return total;
    }

    
}
