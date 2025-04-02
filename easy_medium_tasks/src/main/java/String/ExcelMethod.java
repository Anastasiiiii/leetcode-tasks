package String;

import HashTable.HashTable;

import java.util.HashMap;

public class ExcelMethod {
    public static void main(String[] args) {
        System.out.println(convertToTitle(2002));
        System.out.println(27%26);
        System.out.println(1%26);
        System.out.println(titleToNumber("AB"));
    }

    private static String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            title.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = (columnNumber) / 26;
        }

        return title.reverse().toString();
    }

    private static int titleToNumber(String columnTitle) {
        int x = 0;
        int count  = 0;
        String reversedColumnTitle = new StringBuilder(columnTitle).reverse().toString();

        for (char el : reversedColumnTitle.toCharArray()){
            x += (int) (((el - 'A') + 1) * Math.pow(26, count));
            count++;
        }
        return x;
    }



}
