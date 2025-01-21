package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sumCombinations = new ArrayList<>();


        return sumCombinations;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> sumCombinations,
                                  ArrayList<Integer> currentCombination){
        for(int candidate: candidates){
            while (target > 0){
                target -= candidate;
                if(arrayContains(candidates, target)){

                }
            }
        }
    }

    private static boolean arrayContains(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
