package com.smartershining;

/**
 * Created by smartershining on 16-8-2.
 */
public class TotalNQueens {
    private static int sum = 0;

    public int totalNQueens(int n) {
        int[] usedColumns = new int[n];
        placeQueue(usedColumns, 0);
        return sum;
    }

    public void placeQueue(int[] usedColumns, int index) {
        int n = usedColumns.length;
        if (index == n) {
            ++sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(usedColumns, index, i)) {
                usedColumns[index] = i;
                placeQueue(usedColumns, index + 1);
            }
        }
    }

    public boolean isValid(int[] usedColumns, int index, int col) {
        for (int i = 0; i < index; i++) {
            if (usedColumns[i] == col || (index - i) == Math.abs(col - usedColumns[i])) {
                return false;
            }
        }

        return true;
    }


}
