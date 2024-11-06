package Search;

public class JumpSearchAlg {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(jumpSearch(numbers, 4));

        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(jumpSearch(array, 5));
    }

    private static int jumpSearch(int[] numbers, int target) {
        int n = numbers.length;
        int m = (int) Math.sqrt(n);

        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int currentValue = numbers[low];
            if (currentValue == target) {
                return low;
            } else if (currentValue < target) {
                low += m;
            } else {
                int first = numbers[low - m];
                return lenearSearch(numbers, target, first, high);
            }
        }
        return -1;
    }
    private static  int lenearSearch(int[] numbers, int numberToFind, int first, int last){

        while(first <= last) {
            int currentNumber = numbers[first];
            if (currentNumber == numberToFind) {
                return first;
            } else {
                first += 1;
            }
        }
        return -1;
    }

}

