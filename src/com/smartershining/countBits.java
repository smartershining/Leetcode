package com.smartershining;

/**
 * Created by smartershining on 16-3-21.
 */
public  class countBits{
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
}