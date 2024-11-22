package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code1 = {5,7,1,4};
        int k1 = 3;
        int[] code2 = {1,2,3,4};
        int k2 = 0;
        int[] code3 = {2,4,9,3};
        int k3 = -2;
        System.out.println(Arrays.toString(decrypt(code1, k1)));
        System.out.println(Arrays.toString(decrypt(code2, k2)));
        System.out.println(Arrays.toString(decrypt(code3, k3)));
    }

    private static int[] decrypt(int[] code, int k) {
        for (int i = 0; i < code.length; i++) {
            if(k == 0){
                code[i] = 0;
            } else {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += code[j];
                }
                code[i] = sum;
            }
        }
        return code;
    }
}
