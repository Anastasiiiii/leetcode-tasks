package HashTable;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortAlg {
    public static void main(String[] args){
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000);
        }

        System.out.println("Before: ");
        System.out.println(Arrays.toString(numbers));

        //Sorting algorithm
        boolean swappedSmTH = true;
        while (swappedSmTH) {
            swappedSmTH = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swappedSmTH = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter: ");
        System.out.println(Arrays.toString(numbers));
    }
}
