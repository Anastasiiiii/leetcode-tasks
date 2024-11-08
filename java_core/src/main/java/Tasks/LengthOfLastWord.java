package Tasks;

import java.util.*;

public class LengthOfLastWord {

    /*
    * Given a string s consisting of words and spaces, return the length of the last word in the string.
     A word is a maximal substring consisting of non-space characters only.
    * */
    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
        String[] str = {"flower", "flow", "flight"};
        //longestCommonPrefix(str);
        System.out.println("The longest prefix: " + horizontalScanning(str));
        System.out.println("The longest prefix with binary Search: " + binarySearchOfTheLongestPrefix(str));

        int[] arr1 = new int[]{1, 10, 100};
        int[] arr2 = new int[]{1000};

        int[] arr3 = new int[]{10};
        int[] arr4 = new int[]{11, 17};

        int[] arr5 = new int[]{1, 3};
        int[] arr6 = new int[]{32, 22};

        System.out.println("The longest common prefix: " + longestCommonPrefix(arr1, arr2));
        System.out.println("The longest common prefix: " + longestCommonPrefix(arr3, arr4));
        System.out.println("The longest common prefix: " + longestCommonPrefix(arr5, arr6));
        System.out.println("The second option");
        System.out.println("The longest common prefix: " + longestCommonPrefixInt(arr1, arr2));
        System.out.println("The longest common prefix: " + longestCommonPrefixInt(arr3, arr4));
        System.out.println("The longest common prefix: " + longestCommonPrefixInt(arr5, arr6));
        System.out.println("The third option");
        System.out.println("The longest common prefix: " + longestCommonPrefixInt2(arr1, arr2));
        System.out.println("The longest common prefix: " + longestCommonPrefixInt2(arr3, arr4));
        System.out.println("The longest common prefix: " + longestCommonPrefixInt2(arr5, arr6));
    }

    private static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        String[] letters = words[words.length - 1].split("");
        return letters.length;
    }

    //Write a function to find the longest common prefix string amongst an array of strings.
    //If there is no common prefix, return an empty string "".

    private static String horizontalScanning(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        System.out.println(prefix);
        //Compare with each row
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    private static String binarySearchOfTheLongestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    /*You are given two arrays with positive integers arr1 and arr2.
    A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit.
    For example, 123 is a prefix of the integer 12345, while 234 is not.
    A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b. For example, 5655359 and 56554 have a common prefix 565 while 1223 and 43456 do not have a common prefix.
    You need to find the length of the longest common prefix between all pairs of integers (x, y) such that x belongs to arr1 and y belongs to arr2.
    Return the length of the longest common prefix among all pairs. If no common prefix exists among them, return 0.*/

    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return 0;
        }
        HashSet<String> prefixes = new HashSet<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            String str1 = String.valueOf(arr1[i]);
            String str2 = String.valueOf(arr2[j]);

            int minLength = Math.min(str1.length(), str2.length());
            int k = 0;
            while (k < minLength && str1.charAt(k) == str2.charAt(k)) {
                k++;
            }

            String commonPrefix = str1.substring(0, k);
            if (!commonPrefix.isEmpty()) {
                prefixes.add(commonPrefix);
            }

            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int maxLength = 0;
        for (String prefix : prefixes) {
//            int length = (int) (Math.log10(prefix) + 1);
//            maxLength = Math.max(maxLength, length);
            maxLength = Math.max(maxLength, prefix.length());
        }
        return maxLength;
    }

    //Variant 2
    private static int longestCommonPrefixInt(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return 0;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int maxLength = 0;

        for (int num1 : arr1) {
            for (int num2 : arr2) {
                String str1 = String.valueOf(num1);
                String str2 = String.valueOf(num2);

                int minLength = Math.min(str1.length(), str2.length());
                int k = 0;
                while (k < minLength && str1.charAt(k) == str2.charAt(k)) {
                    k++;
                }

                maxLength = Math.max(maxLength, k);
            }
        }
        return maxLength;
    }

    //The third Variant
    private static int longestCommonPrefixInt2(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return 0;
        }

        HashSet<Integer> prefixes = new HashSet<>();
        for (int num1 : arr1) {
            while (!prefixes.contains(num1) && num1 > 0) {
                prefixes.add(num1);
                num1 /= 10;
            }
        }
        int maxLength = 0;
        for (int num2 : arr2) {
            while (!prefixes.contains(num2) && num2 > 0) {
                num2 /= 10;
            }
            if (num2 > 0) {
                maxLength = Math.max(maxLength, (int) Math.log10(num2) + 1);
            }
        }

        return maxLength;
    }
}
