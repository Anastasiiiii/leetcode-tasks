package Math;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(reverse(n));

        int n1 = -321;
        System.out.println(reverse(n1));
    }

    private static int reverse(int x) {
        int num = 0;
        while (x != 0) {
            int digit = x % 10;
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            num = num * 10 + digit;
            x /= 10;
        }
        return num;
    }

}
