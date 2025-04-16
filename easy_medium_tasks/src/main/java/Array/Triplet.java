package Array;

import java.util.ArrayList;
import java.util.List;

public class Triplet {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7, b = 2, c = 3;

        int[] arr2 = {7,3,7,3,12,1,12,2,3};
        int a1 = 5, b1 = 8, c1 = 1;


        System.out.println(countGoodTriplets(arr, a, b, c));
        System.out.println("*********************");
        System.out.println(countGoodTriplets(arr2, a1, b1, c1));
        System.out.println(Math.abs(7 - 12));
    }

    private static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int windowSize = 3;
        List<List<Integer>> list = new ArrayList<>();

        int index = 0;
        while (index <= arr.length - windowSize) {
            for (int i = index + 1; i <= arr.length - 2; i++) {
                for (int j = i + 1; j <= arr.length - 1; j++) {
                    if (checkCondition(arr[index], arr[i], a) && checkCondition(arr[i], arr[j], b) && checkCondition(arr[index], arr[j], c)) {
                        list.add(List.of(arr[index], arr[i], arr[j]));

                    }
                }

            }
            index++;
        }
        System.out.println(list);

        return list.size();
    }

    private static boolean checkCondition(int firstNum, int secondNum, int preRes) {
        return Math.abs(firstNum - secondNum) <= preRes;
    }
}
