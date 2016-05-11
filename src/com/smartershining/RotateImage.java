package com.smartershining;

/**
 * Created by smartershining on 16-5-11.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] data = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                data[j][len - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            System.arraycopy(data[i], 0, matrix[i], 0, len);

        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int m = n / 2 == 1 ? n / 2 + 1 : n / 2;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}

