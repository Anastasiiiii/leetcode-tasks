package String;

import java.util.Arrays;

public class CommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"traffic", "tractor", "transport"};
        System.out.println(efficient_LCP(strs));
    }

    //O(strs.length⋅log(strs.length)+max_length)
    private static String efficient_LCP(String[] strs) {
        // TODO: To find longest common prefix in the given array of strings.
        Arrays.sort(strs);

        String shortest = strs[0];
        String longest = strs[strs.length - 1];

        for (int i = 0; i < shortest.length(); i++) {
            if(shortest.charAt(i) != longest.charAt(i)){
                return shortest.substring(0, i);
            }
        }

        return shortest;
    }
}
