package String;

public class RepeatedSubstring {
    public static void main(String[] args) {
        String s = "abababab";
        System.out.println(findLongestRepeatedString(s));
    }

    private static String findLongestRepeatedString(String s){
        //TODO: to create a function that checks whether the string s consists of one repeated substring.
        int length = s.length();

        for (int subLength = length / 2; subLength >= 1; subLength--) {
            if(length % subLength == 0){
                String candidate = s.substring(0, subLength);
                StringBuilder repeated = new StringBuilder();

                for (int i = 0; i < length / subLength; i++) {
                    repeated.append(candidate);
                }

                if(repeated.toString().equals(s)){
                    return candidate;
                }
            }
        }
        return "";
    }
}
