package Math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    //A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
    public static void main(String[] args) {
        System.out.println(isPrime(23));
        System.out.println(findNextPrime(23));
        System.out.println(getPrimeFactors(28));
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            System.out.println(i);
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int findNextPrime(int n){
        int m = n + 1;
        while (!isPrime(m)){
            m++;
        }
        return m;
    }

    private static List<Integer> getPrimeFactors(int n) {
        // TODO: Implement the function that returns all prime factors of n
        List<Integer> primeFactors = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(isPrime(i) && n % i == 0){
                primeFactors.add(i);
            }
        }
        return primeFactors;
    }
}
