package Array;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(canCompleteCircuit2(gas, cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        if(sumArray(gas) < sumArray(cost)){
            return -1;
        }

        int start = 0;
        int n = gas.length;
        while (start < n){
            int tank = 0;
            int i = 0;
            for (; i < n; i++) {
                int index = (i + start) % n;
                tank += gas[index] - cost[index];
                if(tank < 0){
                    break;
                }
            }
            if(i == n){
                return start;
            }
            start++;
        }
        return -1;
    }

    private static int sumArray(int[] arr){
        int sum = 0;
        for(int a : arr){
            sum += a;
        }
        return sum;
    }

    private static int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int start = 0;

        for(int i= 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            currentTank += diff;
            totalTank += diff;

            if(currentTank < 0){
                start = i+1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }
}
