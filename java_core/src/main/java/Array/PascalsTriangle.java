package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        //output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(generate(numRows));

        int n = 1;
        System.out.println(generate(n));

        int index = 3;
        System.out.println(getRow(index));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>();
        triangleList.add(new ArrayList<>(List.of(1)));

        if (numRows > 1) {
            triangleList.add(new ArrayList<>(List.of(1, 1)));
        }

        while (triangleList.getLast().size() != numRows) {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.addFirst(1);
            for (int j = 1; j < triangleList.getLast().size(); j++) {
                int s = triangleList.getLast().get(j) + triangleList.getLast().get(j - 1);
                nums.add(s);
            }
            nums.addLast(1);
            triangleList.add(nums);
        }

        return triangleList;
    }

    private static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangleList = new ArrayList<>();
        triangleList.add(new ArrayList<>(List.of(1)));
        int size = rowIndex + 1;

        if (size > 1) {
            triangleList.add(new ArrayList<>(List.of(1, 1)));
        }

        while (triangleList.getLast().size() != size) {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.addFirst(1);
            for (int j = 1; j < triangleList.getLast().size(); j++) {
                int s = triangleList.getLast().get(j) + triangleList.getLast().get(j - 1);
                nums.add(s);
            }
            nums.addLast(1);
            triangleList.add(nums);
        }

        return triangleList.getLast();
    }
}
