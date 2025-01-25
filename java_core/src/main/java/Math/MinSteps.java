package Math;

public class MinSteps {
    public static void main(String[] args) {
        System.out.println(minStepsCount(8));
        System.out.println(minSteps2(8));
    }

    /*
       Given a number, you can perform only two types of operations with it:
        1.Add 1
        2.Multiply by 2
        Write a function minSteps(int n) that takes an integer n and computes the minimum number of steps required to transform the number 0 into the number n.
     */
    private static int minStepsCount(int n) {
        int count = 0;
        while (n > 0){
            if(n % 2 != 0){
                n -= 1;
                count++;
            } else {
                n /= 2;
                count++;
            }
        }
        return count;
    }

    public static int minSteps2(int n) {
        // TODO: Implement the function here
        int[] steps = new int[n + 1];
        steps[0] = 0;

        for(int i = 1; i <= n; i++){
            steps[i] = steps[i - 1] + 1;
            if(i % 2 == 0){
                steps[i] = Math.min(steps[i], steps[i / 2] + 1);
            }
        }

        return steps[n];
    }
}
