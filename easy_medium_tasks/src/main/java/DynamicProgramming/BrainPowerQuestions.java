package DynamicProgramming;

public class BrainPowerQuestions {
    public static void main(String[] args){
        int[][] questions = {{3, 2},{4, 3},{4, 4},{2, 5}};

        System.out.println(mostPoints(questions));
    }

    private static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for(int i = n - 1; i >= 0; i--){
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower + 1;

            long solve = points;
            if(nextIndex < n){
                solve += dp[nextIndex];
            }

            long skip = dp[i + 1];
            dp[i] = Math.max(solve, skip);
        }

        return dp[0];
    }
}
