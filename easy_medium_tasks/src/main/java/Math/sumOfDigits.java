package Math;

public class sumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigitsRaisedToPositions(253));
        System.out.println(recursionOption(253));
    }

    private static int sumOfDigitsRaisedToPositions(int n){
        int result = 0;
        if(n == 0){
            return result;
        }
        int index = 1;
        while (n != 0){
            int digit = n % 10;
            result += (int) Math.pow(digit, index);
            n /= 10;
            index++;
        }

        return result;
    }

    private static int recursionOption(int n){
        return recursionFunc(n, 1);
    }

    private static int recursionFunc(int n, int index){
        if(n == 0){
            return 0;
        }

        int digit = n % 10;
        return (int) Math.pow(digit, index) + recursionFunc(n / 10, index + 1);
    }
}
