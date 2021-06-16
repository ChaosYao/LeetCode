package com.leetcode.string;

public class MyAtoi {
    public int myAtoi(String s) {
        int length = s.length();
        if (length < 1) {
            return 0;
        }

        return atoi(s);
    }


    private int atoi(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }

        int length = s.length();
        int i = 0;
        long result = 0;
        boolean sign = false;

        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            i++;
            sign = true;
        }

        for (;i < length;i++) {
            char tmp = s.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                result = result * 10 + (tmp - '0');
            } else {
                return sign ? -1 * (int) result : (int) result;
            }

            if (result > Integer.MAX_VALUE) {
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

        }

        return sign ? -1 * (int) result : (int) result;
    }
}
