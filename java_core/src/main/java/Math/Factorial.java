package Math;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(3));
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
}
