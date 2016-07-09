package com.smartershining;

import java.sql.Connection;

/**
 * Created by smartershining on 16-7-3.
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int interval = (numRows - 1) << 1;
        for (int i = 0; i < length; i += interval) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int inter = 2 * i;
            for (int j = i; j < length; j += inter) {
                sb.append(s.charAt(j));
                inter = interval - inter;
            }
        }
        for (int i = numRows - 1; i < length; i += interval) {
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }
}
