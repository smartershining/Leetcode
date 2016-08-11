package com.smartershining;

import java.util.Scanner;
import java.util.StringJoiner;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        String str = getResult(number);
        System.out.println(str);
    }

    public static String getResult(Long number) {
        StringBuilder result = new StringBuilder("");
        int i = 2;
        while (number > 1) {

            while (number % i == 0) {
                result.append(String.valueOf(i) + " ");
                number /= i;
            }
            i++;
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}


