package String;

public class FancyString {
    public static void main(String[] args) {
        String s = "leeetcode";
        String s1 = "aaabaaaa";
        System.out.println(makeFancyString(s));
        System.out.println(makeFancyString(s1));
    }

    private static String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();

        int count = 1;

        str.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}
