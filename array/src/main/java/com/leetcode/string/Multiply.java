package com.leetcode.string;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int size1 = num1.length();
        int size2 = num2.length();
        int[] result = new int[size1+size2];

        for (int i = size1 - 1;i >= 0; i--) {
            char tmp1 = num1.charAt(i);
            for (int j = size2 - 1; j >= 0; j--) {
                char tmp2 = num2.charAt(j);
                int tmpResult = (tmp1 - '0') * (tmp2 - '0');
                tmpResult += result[i+j+1];

                result[i+j+1] = tmpResult % 10;
                result[i+j] += tmpResult / 10;
            }
        }

        int zero = 0;
        while(zero <= result.length - 1 && result[zero] == 0) {
            zero++;
        }

        StringBuilder sb = new StringBuilder();
        for (; zero < result.length; zero++) {
            sb.append(result[zero]);
        }

        return sb.toString();
    }
}
