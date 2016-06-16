package com.smartershining;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-4-28.
 */

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return lists;
        }

        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(pre.get(j - 1) + pre.get(j));
            }
            if (i != 0)
                list.add(1);
            pre = list;
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }
}
