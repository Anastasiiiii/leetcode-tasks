package Math;

import java.util.ArrayList;
import java.util.List;

public class RecursionSum {
    public static void main(String[] args) {
        System.out.println(getSum(5));
        System.out.println(generateListFromNTo1(5));
        System.out.println(2 / 10);
    }

    private static int getSum(int n){
        if (n == 0) {
            return 0;
        }

        else {
            return n + getSum(n - 1);
        }
    }

    private static List<Integer> generateListFromNTo1(int n) {
        // TODO: implement
        List<Integer> generatedList = new ArrayList<>();
        if(n <= 0){
            return generatedList;
        }

        generatedList.add(n);
        generatedList.addAll(generateListFromNTo1(n - 1));

        return generatedList;
    }
}
