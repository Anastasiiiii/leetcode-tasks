package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class MinEnd {
    public static void main(String[] args) {
        int n = 3;
        int x = 4;

        int n1 = 2;
        int x1 = 7;

        int n2 = 4;
        int x2 = 1;

        System.out.println(minEnd(n, x));
        System.out.println("************************");
        System.out.println(minEnd(n1, x1));
        System.out.println("************************");
        System.out.println(minEnd(n2, x2));
    }
    private static long minEnd(int n, int x) {
        long m = x;

        for(int i = 1; i < n; i++){
            m = (m | x) +1;

            while((m & x) != x) {
                m++;
            }
        }

        return m;
    }
}
