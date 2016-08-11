package com.smartershining;


import java.util.Scanner;

/**
 * Created by smartershining on 16-8-3.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextInt(), scanner.nextInt()));
        scanner.close();
    }

    public static int solve(int a, int b) {
        int result = 0;
        int i = a;
        while (i <= b) {
            if (i % 30 == 0) {
                result++;
                i += 30;
            } else {
                i++;
            }
        }
        return result;
    }


}

