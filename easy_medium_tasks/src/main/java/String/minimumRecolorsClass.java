package String;

public class minimumRecolorsClass {
    public static void main(String[] args) {
        String blocks = "WBWBBBW";
        int k = 2;

        String blocks1 = "WBBWWBBWBW";
        int k1 = 7;

        String blocks2 = "BWWWBB";
        int k2 = 6;

        String blocks3 = "WWBBBWBBBBBWWBWWWB";
        int k3 = 16;

        System.out.println(minimumRecolors(blocks, k));
        System.out.println(minimumRecolors(blocks1, k1));
        System.out.println(minimumRecolors(blocks2, k2));
        System.out.println(minimumRecolors(blocks3, k3));
    }

    private static int minimumRecolors(String blocks, int k) {

        int min = blocks.length();
        int left = 0;
        int right = k;

        if (blocks.length() == k) {
            min = blocks.length() - blocks.replace("W", "").length();
        } else {

            while (right <= blocks.length()) {
                String subStr = blocks.substring(left, right);
                int count = subStr.length() - subStr.replace("W", "").length();

                System.out.println(subStr.replace("W", ""));

                if (count < min) {
                    min = count;
                }
                left++;
                right++;
            }
        }

        return min;
    }
}
