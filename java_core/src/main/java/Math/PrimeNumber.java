package Math;

public class PrimeNumber {
    //A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
    public static void main(String[] args) {
        System.out.println(isPrime(23));

    }

    private static boolean isPrime(int number){
        if(number <= 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(number); i++){
            System.out.println(i);
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
