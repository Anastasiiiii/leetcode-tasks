package String;

public class PalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = "cbbd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s1));
        System.out.println("****************************");
        System.out.println(longestPalindromeManachers(s));
        System.out.println(longestPalindromeManachers(s1));
    }

    //O(n^2)
    private static String longestPalindrome(String s) {
        if(s == null) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //even palindrome
            int len2 = expandAroundCenter(s, i, i + 1); //odd palindrome
            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    //Manacher's Algorithm
    //This algorithm is specifically designed to find the longest palindrome.
    //It operates in linear time O(n), leveraging the symmetry of palindromes.

    private static String longestPalindromeManachers(String s){
        String t = preprocess(s);
        int[] p = new int[t.length()]; //palindrome radius
        int center = 0, right = 0;

        for (int i = 0; i < t.length(); i++) {
            int mirror = 2 * center - i;
            if(i < right){
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (i + 1 + p[i] < t.length() && i - 1 - p[i] >= 0 &&
                    t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])){
                p[i]++;
            }

            if(i + p[i] > right){
                center = i;
                right = i + p[i];
            }
        }

        int maxLength = 0, centerIndex = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i] > maxLength){
                maxLength = p[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLength) / 2;
        return s.substring(start, start + maxLength);
    }

    private static String preprocess(String s){
        StringBuilder sb = new StringBuilder("^");
        //"babad" -> "^#b#a#b#a#d#$
        for(char c : s.toCharArray()){
            sb.append("#").append(c);
        }
        sb.append("#$");
        return sb.toString();
    }
}
