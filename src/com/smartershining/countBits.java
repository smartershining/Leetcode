package com.smartershining;

/**
 * Created by smartershining on 16-3-21.
 */

// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
// calculate the number of 1's in their binary representation and return them as an array.


public  class countBits {

}
    /*
    public  int[] countBits(int num){
        int[] solu = new int[num + 1];
        int count;
        int j = 0;
        for(int i = 0; i <= num; ++ i){
            j = i;
            count = 0;
            while(j != 0){
                count += (j % 2);
                j = (j >> 1);
            }
            solu[i] = count;
        }
        return solu;
    }


    /**
     *   res[i] = res[i >> 1] + (i & 1);
     * @param num
     * @return
     */
  /*
    public  int[] countBits(int num){
        int[]  res = new int[num + 1];
        for(int i = 0; i <= num; ++ i){
            res[i] = res[i >> 1] + (i & 1);
        }
            return res;
    }

}*/
