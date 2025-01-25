package Math;

import java.util.HashMap;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(3));
        System.out.println(findFactorial2(3, new HashMap<>()));
    }

    private static int findFactorial(int n){
        //0! = 1
        if(n == 0){
            return 1;
        }

        else {
            return n * findFactorial(n - 1);
        }
    }

    private static int findFactorial2(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }

        if(n <= 1){
            return 1;
        }

        int result = n * findFactorial2(n - 1, map);
        map.put(n, result);
        return result;
    }
}
