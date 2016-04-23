package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  There are N children standing in a line. Each child is assigned a rating value.

 *  You are giving candies to these children subjected to the following requirements:

 *  Each child must have at least one candy.
 *  Children with a higher rating get more candies than their neighbors.

 *  What is the minimum candies you must give?
 */
public class Candy {
    public static int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) {
            num[i] = 1;
        }
        for(int i = 0; i < ratings.length - 1; i++) {
            if(ratings[i + 1] > ratings[i])
                num[i + 1] = num[i] + 1;
        }
        int total = num[ratings.length - 1];
        for(int i = ratings.length - 1; i > 0; i --) {
            int cur = 1;
            if(ratings[i - 1] > ratings[i]) {
                cur = num[i] + 1;
            }
            num[i - 1] = Math.max(cur,num[i - 1]);
            total += num[i - 1];
        }
        return total;
    }
    public  static  void main(String[] args) {
        int[] a = {1,2,4,4,3};
        System.out.println(candy(a));

    }

}
