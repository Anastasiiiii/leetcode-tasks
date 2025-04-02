package Math;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(countPerfectSquares(13));
    }

    private static int countPerfectSquares(int n){
        int[] nums = new int[n + 1];
        nums[0] = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i ; j++) {
                int square = j * j;
                nums[i] = Math.min(nums[i], nums[i - square] + 1);
            }
        }

        return nums[n];
     }
}
