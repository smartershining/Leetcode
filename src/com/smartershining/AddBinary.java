package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Given two binary strings, return their sum (also a binary string).

 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public  static  String addBinary2(String a, String b) {
      int length = a.length() > b.length() ? a.length() : b.length();
         StringBuffer sba = new StringBuffer(a);
         StringBuffer sbb = new StringBuffer(b);
         sba.reverse();
         sbb.reverse();
         StringBuffer result= new StringBuffer("");
         int temp;
         int count = 0;
         for (int i = 0; i < length; i ++) {
            if(i >= sba.length()) {
                temp = sbb.charAt(i)- '0' + count;
                if(temp >= 2) {
                    temp -= 2;
                    count = 1;
                } else {
                    count = 0;
                }
            } else if(i >= sbb.length()) {
                temp = sba.charAt(i) - '0' + count;
                if(temp >= 2) {
                    temp -= 2;
                    count = 1;
                } else {
                    count = 0;
                }
            } else {
                temp = sba.charAt(i) - '0' + sbb.charAt(i) - '0' + count;
                if(temp >= 2) {
                    temp -= 2;
                    count = 1;
                } else {
                    count = 0;
                }
            }
             result.append((char)('0' + temp));
         }
        if(count != 0)
            result.append((char)('0' + count));
        return result.reverse().toString();
    }


    public  static  String addBinary(String a,String b) {
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carrier = 0;
        String result = "";

        while(al >= 0) {
            int sum = (a.charAt(al) - '0') + (b.charAt(bl) - '0') + carrier;
            result = String.valueOf(sum % 2) + result;
            al --;
            bl --;
            carrier = sum / 2;
        }
        while (bl >= 0) {
            int sum = (b.charAt(bl) - '0') + carrier;
            result = String.valueOf(sum % 2) + result;
            bl --;
            carrier = sum /2;
        }
        if(carrier != 0) {
            result  = "1" + result;
        }
        return  result;
    }




    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a ,b));

    }
}
