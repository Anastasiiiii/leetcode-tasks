package Array;

import Tasks.Array;

import java.util.*;

public class CandySwap {
    public static void main(String[] args) {
       int[] aliceSizes = {1, 1};
       int[] bobSizes = {2, 2};
        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
    }

    private static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] answer = new int[2];
        int sumA = findArraySum(aliceSizes);
        int sumB = findArraySum(bobSizes);

        int delta = (sumB - sumA) / 2;
        //b = a + delta;

        List<Integer> list = new ArrayList<>();
        for(int el : bobSizes){
            list.add(el);
        }

        for(int el : aliceSizes){
            if(list.contains(el + delta)){
                answer[0] = el;
                answer[1] = el + delta;
            }
        }

        return answer;
    }

    private static int findArraySum(int[] array){
        int sum = 0;
        for(int arr : array){
            sum += arr;
        }
        return sum;
    }
}
