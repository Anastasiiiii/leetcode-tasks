package Tasks;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }

    /*
    In this task, your goal is to find the number of distinct ways you can make change for a target amount, given an array of available coin denominations.
    Specifically, you need to write a Java method coinChange(int[] coins, int amount
     */

    private static int coinChange(int[] coins, int amount){
        int[] ways = new int[amount + 1];
        ways[0] = 1;

        for(int coin : coins){
            for (int i = coin; i <= amount; i++) {
                ways[i] += ways[i - coin];
            }
        }
        return ways[amount];
    }
}
