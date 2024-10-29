package TwoPointers;

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String lowerCaseString = s.toLowerCase();
        //Replace all non-alphanumeric characters
        String newString = lowerCaseString.replaceAll("[^a-zA-Z0-9]", "");
        char[] subArr = newString.toCharArray();
        int left = 0;
        int right = subArr.length - 1;
        while (left < right) {
            if(subArr[left] != subArr[right]) {
                return false;
            } else {
                left++;
                right --;
            }
        }
        System.out.println(newString);
        return true;
    }
}
