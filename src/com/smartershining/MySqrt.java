package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Implement int sqrt(int x).

 * Compute and return the square root of x.
 */

public class MySqrt {
    public  static  int mySqrt(int x) {
        if(x <= 1)
             return x;
      int i = 0;
      int j = x / 2 + 1;
      while (i <= j)
       {
        int mid = i + (j - i)/ 2;
        if(x / mid == mid) return mid;
        else if (x / mid < mid ) j = mid - 1;
        else i = mid + 1;
    }
    return j;
}

    public  static  void main(String[] args) {

        System.out.println(mySqrt(100));
    }
}
