package Tasks;

public class Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        int sum = 0; //завжди буде метод з 1
        while (n > 1) {
            n = n - 2;
            sum++;
        }
        sum = 2 * sum + 1;
        return sum;
    }
}
