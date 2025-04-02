package Array;

import java.util.List;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] listA = {1, 2, 3, 4, 5};
        int[] listB = {2, 3, 4};
        int[] listC = {3, 4, 6};
        System.out.println(solution(listA, listB));
        System.out.println(solution(listA, listC));

        int[] listD = {1, -1, 3, -2, 3, 2, 5};
        int[] listE = {3, 2};
        System.out.println(solution(listD, listE));

        int[] listF = {5, 4, 3, 2, 1};
        int[] listG = {1, 2, 3};
        System.out.println(solution(listF, listG));
    }

    public static boolean solution(int[] listA, int[] listB) {
        // TODO: To determine if listB is a contiguous subarray of listA.
        int listBLength = listB.length;
        int endPoint = listA.length - listBLength;

        for (int i = 0; i <= endPoint; i++) {
            if(listA[i] == listB[0]){
                if(ifSubArray(listA, listB, i)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean ifSubArray(int[] listA, int[] listB, int startIndex){
        for (int i = 0; i < listB.length; i++) {
            if(listA[startIndex] != listB[i]){
                return false;
            }
            startIndex++;
        }
        return true;
    }
}
