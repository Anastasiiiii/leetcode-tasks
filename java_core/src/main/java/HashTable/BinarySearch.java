package HashTable;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 7, 9, 11};
        System.out.println(binarySearch(ints, 9));

        System.out.println(metaBinarySearch(ints, 3));
       // System.out.println(Arrays.binarySearch(ints, 3));
    }

    private static int binarySearch(int[] numbers, int numberToFind){
        int low = 0;
        int high = numbers.length - 1;

        while(low <= high){
            int middlePosition = (low + high) / 2;
            int middleNumber = numbers[middlePosition];
            if(numberToFind == middleNumber) {
                return middlePosition;
            }
            if(numberToFind < middleNumber) {
                high = middlePosition - 1;
            } else {
                low = middlePosition + 1;
            }
        }
        return -1;
    }

    private static int metaBinarySearch(int[] numbers, int target){
        int n = numbers.length;
        int intervalSize = n;

        while (intervalSize > 0) {
            int mid = intervalSize / 2;

            if (numbers[mid] == target){
                return mid;
            } else if (numbers[mid] < target) {
                intervalSize = (n - mid) / 2;
            } else {
                intervalSize = mid / 2;
            }
        }

        return -1;
    }
}
