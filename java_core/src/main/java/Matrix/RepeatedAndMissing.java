package Matrix;

import java.util.*;

public class RepeatedAndMissing {
    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};
        int[][] grid1 = {{9,1,7},{8,9,2},{3,4,6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid1)));
    }

    private static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        result[0] = toList(grid, set);

        System.out.println(set);

        for(int el : set){
            if(!set.contains(el + 1)){
                result[1] = el + 1;
                break;
            }
        }

        return result;
    }

    private static int toList(int[][] grid, HashSet<Integer> set){
        int repeatedNum = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!set.add(ints[j])) {
                    repeatedNum = ints[j];
                } else {
                    set.add(ints[j]);
                }
            }
        }
        return repeatedNum;
    }
}
