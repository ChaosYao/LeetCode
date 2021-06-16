package com.leetcode.string;

public class AddBinary {
    public String addBinary(String a, String b) {
        int size1 = a.length() - 1;
        int size2 = b.length() - 1;

        String result = "";
        int sign = 0;
        while (size1 >= 0 || size2 >= 0) {
            if (size1 >= 0) {
                sign += a.charAt(size1--) - '0';
            }

            if (size2 >= 0) {
                sign += b.charAt(size2--) - '0';
            }

            result = String.valueOf(sign % 2) + result;
            sign >>= 1;
        }

        return  sign > 0 ? "1" + result : result;
    }
}
