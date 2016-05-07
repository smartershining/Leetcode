package com.smartershining;

/**
 * Created by smartershining on 16-5-7.
 */
public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            int x = matrix[i][j];
            if (target == x) {
                return true;
            } else if (target < x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
