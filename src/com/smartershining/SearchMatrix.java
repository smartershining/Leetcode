package com.smartershining;

/**
 * Created by smartershining on 16-4-29.
 */

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * <p>
 * Given target = 3, return true.
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target)
            return false;

        int begin = 0;
        int end = m - 1;
        int mid = 0;
        while (begin <= end) {
            mid = ((end - begin) >> 1) + begin;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target)
                break;
            if (matrix[mid][0] > target)
                end = mid - 1;
            if (matrix[mid][n - 1] < target)
                begin = mid + 1;
        }

        if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
            begin = 0;
            end = n - 1;
            while (begin <= end) {
                int mi = ((end - begin) >> 1) + begin;
                if (matrix[mid][mi] == target)
                    return true;
                if (matrix[mid][mi] > target)
                    end = mi - 1;
                else
                    begin = mi + 1;
            }
        }
        return false;

    }

    public static boolean serachMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int begin = 0;
        int end = m * n - 1;

        while (begin <= end) {
            int mid = ((end - begin) >> 1) + begin;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }


    public static void main(String[] args) {
        int a[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        if (serachMatrix2(a, 9)) {
            System.out.println("OK");
        }

    }
}
