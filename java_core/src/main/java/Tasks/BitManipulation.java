package Tasks;

import java.math.BigInteger;

public class BitManipulation {
    public static void main(String[] args) {
       String a = "1010";
       String b = "1011";

       String m = "10110";
       String n = "10011";

       String k = "110";
       String l = "101";
       System.out.println(addBinaryInt(a, b));
       System.out.println(addBinary(a, b));
       System.out.println(addBinaryManually(a, b));
       System.out.println(subtractionBinary(m, n));
       System.out.println(multiplicationBinary(m, n));
       System.out.println(multiplicationBinary(k, l));
    }

    public static String addBinaryInt(String a, String b) {
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        String result = Integer.toBinaryString(sum);
        return result;
    }

    public static String addBinary(String a, String b) {
        BigInteger bigA = new BigInteger(a, 2);
        BigInteger bigB = new BigInteger(b, 2);

        BigInteger sum = bigA.add(bigB);
        String result = sum.toString(2);

        return result;
    }

    public static String addBinaryManually(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int ost = 0; //перенос при додаванні

        //Поки є цифри в обох рядках або є перенос
        while(i >= 0 || j >= 0 || ost == 1){
            int sum = ost;

            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);

            ost = sum / 2;
        }

        return result.reverse().toString();
    }

    public static String subtractionBinary(String a, String b){
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int borrow = 0; //позика

        while (i >= 0 || j >= 0) {
            int bitA = (i >=0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int difference = bitA - bitB - borrow;

            if(difference < 0) {
                difference += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append(difference);

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static String multiplicationBinary(String a, String b) {
        StringBuilder result = new StringBuilder("0");

        int bLength = b.length();

        for (int j = bLength - 1; j >= 0; j--) {
            int bitB = b.charAt(j) - '0'; // отримуємо біт з b
            if (bitB == 1) {
                // Додаємо a з відповідною кількістю нулів
                StringBuilder temp = new StringBuilder(a);
                for (int k = 0; k < bLength - 1 - j; k++) {
                    temp.append('0'); // додаємо нулі
                }
                // Додаємо до результату
                result = new StringBuilder(addBinaryManually(result.toString(), temp.toString()));
            }
        }

        return result.toString();
    }

}
