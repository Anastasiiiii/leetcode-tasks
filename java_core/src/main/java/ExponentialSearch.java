import java.util.Arrays;

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 30};
        int x = 10;
        int result = exponentialSearchAlg(arr, arr.length, x);
        System.out.println((result < 0) ? "Element is not present in array" : "element is present at index: " + result);
    }
    public static int exponentialSearchAlg(int[] arr, int n, int x){
        if(arr[0] == x){
            return 0;
        }

        int i = 1;
        while(i < n && arr[i] <= x){
            i = i * 2;
        }
        return Arrays.binarySearch(arr, i/2, Math.min(i, n-1), x);
    }
}
