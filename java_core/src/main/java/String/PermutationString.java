package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationString {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permutation(nums));

    }


    //Time: O[(n!)n]
    //Space: O[n]

    private static List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> results = new ArrayList<>();

        backtrack(results, new ArrayList<Integer>(), nums);

        return results;
    }

    private static void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){

        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int num : nums){
            //If we get same number
            if(tempList.contains(num)){
                continue;
            }

            //Add the new element
            tempList.add(num);

            //Go back to try another element
            backtrack(resultList, tempList, nums);

            //remove the element
            tempList.remove(tempList.size() - 1);

        }
    }
}
