package Tasks;

public class StringTask {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        String haystack1 = "sadbutsad";
        String needle1 = "leetcode";

        System.out.println(strStr(haystack, needle));
        System.out.println(strStr(haystack1, needle1));
    }
    //Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    public static int strStr(String haystack, String needle) {

        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
