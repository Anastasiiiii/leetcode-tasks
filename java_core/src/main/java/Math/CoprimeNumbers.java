package Math;

public class CoprimeNumbers {

    public static void main(String[] args) {
        System.out.println(areCoprime(15, 28));
        System.out.println(areCoprime(12, 18));

        System.out.println(isPrime(11));
        System.out.println(isPrime(6));
        System.out.println(isPrime(7));
        System.out.println(isPrime(24));

        System.out.println();
        System.out.println(nthPrime(1));
    }


    public static boolean areCoprime(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        if(a == 1){
            return true;
        }

        return false;

    }

    private static boolean isPrime(int a){
        if(a <= 1){
            return false;
        }

        for (int i = 2; i < Math.sqrt(a); i++) {
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }

    private static int nthPrime(int n) {
        int p = 2;

        while (n > 0) {
            if(isPrime(p)){
                n--;
            }
            if (n == 0){
                return p;
            }
            p++;
        }
        return p;
    }
}
