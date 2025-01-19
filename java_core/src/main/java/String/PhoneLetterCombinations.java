package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class PhoneLetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return resultList;
        }

        // Create a mapping of numbers to their corresponding letters
        Hashtable<Character, List<Character>> numbersCombinations = new Hashtable<>();
        numbersCombinations.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        numbersCombinations.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        numbersCombinations.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        numbersCombinations.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        numbersCombinations.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        numbersCombinations.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        numbersCombinations.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        numbersCombinations.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        // Start backtracking to generate combinations
        backtrack(resultList, numbersCombinations, digits, 0, new StringBuilder());
        return resultList;
    }

    private static void backtrack(List<String> resultList, Hashtable<Character, List<Character>> numbersCombinations,
                                  String digits, int index, StringBuilder currentCombination) {
        // Base case: If the current combination length matches the input digits, add to the result
        if (index == digits.length()) {
            resultList.add(currentCombination.toString());
            return;
        }

        // Get the characters corresponding to the current digit
        char digit = digits.charAt(index);
        List<Character> characters = numbersCombinations.get(digit);

        // Iterate through each character and recurse
        for (char ch : characters) {
            currentCombination.append(ch); // Add the character
            backtrack(resultList, numbersCombinations, digits, index + 1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // Backtrack
        }
    }
}
