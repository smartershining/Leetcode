package com.smartershining;

/**
 * Created by smartershining on 16-5-7.
 */

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
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
