package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonSubstring {
    public static void main(String[] args) {
        String s = "bananabananaba";
        System.out.println(findMostCommonSubstring(s, 5));
    }

    private static String findMostCommonSubstring(String s, int length) {
        //TODO:  To write a function that will find and return the most common substring of a given length in the input string. If two or more substrings have the same maximum frequency, you should return the lexicographically smallest one.
        HashMap<String, Integer> countFrequency = new HashMap<>();
        for (int i = 0; i <= s.length() - length; i++) {
            String subString = s.substring(i, i + length);
            countFrequency.put(subString, countFrequency.getOrDefault(subString, 0) + 1);
        }

        ArrayList<String> mostCommonSubStringList = new ArrayList<>();

        Integer maxValue = Integer.MIN_VALUE;
        for (HashMap.Entry<String, Integer> entry : countFrequency.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }

        for (HashMap.Entry<String, Integer> entry : countFrequency.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                mostCommonSubStringList.add(entry.getKey());
            }
        }

        System.out.println("Most common substrings: " + mostCommonSubStringList);

        if (mostCommonSubStringList.size() == 1) {
            return mostCommonSubStringList.get(0);
        } else if (!mostCommonSubStringList.isEmpty()) {
            String theShortest = mostCommonSubStringList.get(0);

            for (int i = 1; i < mostCommonSubStringList.size(); i++) {
                if (mostCommonSubStringList.get(i).compareTo(theShortest) < 0) {
                    theShortest = mostCommonSubStringList.get(i);
                }
            }
            return theShortest;

        } else {
            return "";
        }

    }
}

