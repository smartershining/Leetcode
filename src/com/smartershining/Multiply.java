package com.smartershining;

/**
 * Created by smartershining on 16-4-29.
 */
public class Multiply {
    public static String multiply(String num1, String num2) {

        String result = new String("0");
        if (num1.equals("0") || num2.equals("0"))
            return result;

        for (int i = 0; i < num1.length(); i++) {
            String temp = helper(num2, num1.charAt(i));

            result = Add(result, temp);
        }
        result = result.replaceAll("^0+(?!$)", "");
        StringBuilder sb = new StringBuilder();


        return result.toString();
    }

    public static String Add(String a, String b) {
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        sa.append(0);
        sa.reverse();
        sb.reverse();

        StringBuilder result = new StringBuilder();
        int count = 0;
        int length = Math.min(sa.length(), sb.length());
        int i;
        for (i = 0; i < length; i++) {
            int temp = sa.charAt(i) - '0' + sb.charAt(i) - '0' + count;
            count = temp / 10;
            result.insert(0, temp % 10);
        }
        while (i < sa.length()) {
            int temp = sa.charAt(i++) - '0' + count;
            count = temp / 10;
            result.insert(0, temp % 10);
        }
        while (i < sb.length()) {
            int temp = sb.charAt(i++) - '0' + count;
            count = temp / 10;
            result.insert(0, temp % 10);
        }
        if (count != 0)
            result.insert(0, count);

        return result.toString();

    }

    public static String helper(String num, char a) {
        //  int c = Integer.parseInt(a);
        int c = a - '0';
        StringBuilder result = new StringBuilder();

        int count = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int b = (num.charAt(i) - '0') * c + count;
            result.insert(0, b % 10);
            count = b / 10;
        }
        if (count != 0) {
            result.insert(0, count);
        }
        return result.toString();
    }

    public static String multiply2(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] result = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                result[i + j] += a * b;
            }
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            int digit = (result[i] + carry) % 10;
            carry = (result[i] + carry) / 10;
            sb.insert(0, digit);
        }

        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String a = "3534";
        String b = "6457";

        System.out.println(multiply2(a, b));
    }
}
