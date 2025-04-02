package Matrix;

import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };

        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    /*Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
    To flip an image horizontally means that each row of the image is reversed.*/

    private static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][m - 1 - j];
                image[i][m - 1 - j] = temp;
            }
        }

        return image;
    }
}
