package Bitwise;

public class BitwiseCalculations {
    public static void main(String[] args) {
        int maximumBit = 2;
        System.out.println("Setting All Bits to 1 up to maximumBit: " + setUpToMax(maximumBit)); //3, 11 in binary
        System.out.println("**********************************************");
        int n = 8;
        int n1 = 12;
        System.out.println("Is " + n + " power of two? " + isPowerOfTwo(n)); //true
        System.out.println("Is " + n1 + " power of two? " + isPowerOfTwo(n1)); //false
        System.out.println("**********************************************");
        System.out.println("The lowest set bit is: " + extractLowestSetBit(n1)); //4, 100 in binary
        System.out.println("**********************************************");
        int n2 = 5;
        int range = 3;
        System.out.println("The result of Flipping all bits within certain range: " + flipAllBitsWithinRange(n2, range)); //2, 0010 in binary
        System.out.println("**********************************************");
        int n3 = 6; //110 in binary
        System.out.println("The result after clearing the lowest set bit: " + clearLowestSetBit(n3)); //4, 100 in binary
        System.out.println("**********************************************");
        System.out.println("XOR calculation`s result: " + calculateXOR(n3));
    }

    //Setting All Bits to 1 up to maximumBit
    private static int setUpToMax(int maximumBit) {
        return (1 << maximumBit) - 1;
    }

    //Checking if a Number is a Power of Two
    //If n is a power of two by confirming there is only one bit set in n.
    private static boolean isPowerOfTwo(int n){
        return (n & (n - 1)) == 0 && n != 0;
    }

    //Extracting the Lowest Set Bit
    private static int extractLowestSetBit(int n){
        return n & -n;
    }

    //Flipping All Bits within a Certain Range
    private static int flipAllBitsWithinRange(int n, int bitRange){
        return n ^ ((1<<bitRange) - 1);
    }

    //Clearing the Lowest Set Bit
    private static int clearLowestSetBit(int n) {
        return n & (n - 1);
    }

    //Calculating the XOR from 0 to n
    private static int calculateXOR(int n){
        return n % 4 == 0 ? n : n % 4 == 1 ? 1 : n % 4 == 2 ? n + 1 : 0;
    }
}
