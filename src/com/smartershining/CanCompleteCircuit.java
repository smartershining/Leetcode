package com.smartershining;

/**
 * Created by smartershining on 16-5-8.
 */

/**
 *
 *
 */

/**
 * 1) if the sum of gas >= the sum of cost, then the circle can be completed.
 * 2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.
 */
public class CanCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaing = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int remaing = gas[i] - cost[i];
            if (sumRemaing >= 0) {
                sumRemaing += remaing;
            } else {
                sumRemaing = remaing;
                start = i;
            }
            total += remaing;
        }

        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = {2, 4};
        int[] cost = {3, 4};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
