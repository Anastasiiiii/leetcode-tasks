import java.util.Arrays;

public class LinearSearchAlg {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 7, 9, 11};
        System.out.println(lenearSearch(ints, 9));

        int[] ints2 = {8, 4, 88, 23, 11, 26};
        System.out.println(lenearSearch(ints2, 23));

        //SentielLinearSearch
        int[] ints3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 9;
        int index = sentialLinearSearch(ints3, key);
        if(index == -1) {
            System.out.println(key + " is not found in the array: " + Arrays.toString(ints3));
        } else {
            System.out.println(key + " is found at index " + index + " in the array: " + Arrays.toString(ints3));
        }
    }
    private static  int lenearSearch(int[] numbers, int numberToFind){
        int first = 0;
        int last = numbers.length -1;

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
    private static int sentialLinearSearch(int[] numbers, int key){
        int last = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = key;
        int i=0;
        while (numbers[i] != key) {
            i++;
        }
        numbers[numbers.length-1] = last;
        if(i < numbers.length - 1 || last == key){
            return i;
        } else {
            return -1;
        }
    }

}
