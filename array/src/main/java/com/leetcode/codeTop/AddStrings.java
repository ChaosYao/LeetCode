package com.leetcode.codeTop;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        String x = "";
        boolean sign = false;
        int size = Math.min(num1.length(), num2.length());
        for (int i = 0; i < size; i++) {
            Integer tmp = num1.charAt(num1.length() - 1 - i) - '0' + (num2.charAt(num2.length() - 1 - i) - '0');
            if (sign) {
                tmp += 1;
                sign = false;
            }

            if (tmp >= 10) {
                sign = true;
                tmp %= 10;
            }


            x = String.valueOf(tmp) + x;
        }
        String remain = "";
        if (num1.length() != num2.length()) {
            remain = num1.length() > num2.length() ? num1.substring(0, num1.length() - size)
                    : num2.substring(0, num2.length() - size);
        }

        int i = remain.length() - 1;
        while(remain != "" && sign && i >= 0) {
            Integer tmp = remain.charAt(i) - '0';
            tmp++;
            sign = false;
            if (tmp >= 10) {
                sign = true;
                tmp %= 10;
            }

            x = tmp + x;
            i--;
        }

        if (i >= 0) {
            x = (num1.length() > num2.length() ? num1.substring(0, i+1) : num2.substring(0, i+1)) + x;
        }

        if (sign) {
            x = 1 + x;
        }

        return x;
    }

    public String addStrings1(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int size1 = num1.length() - 1;
        int size2 = num2.length() - 1;
        while(size1 >= 0 || size2 >= 0 || carry != 0) {
            if (size1 >= 0) {
                carry += num1.charAt(size1) - '0';
                size1--;
            }

            if (size2 >= 0) {
                carry += num2.charAt(size2) - '0';
                size2--;
            }

            result.append(carry % 10);
            carry /= 10;
        }

        return result.reverse().toString();
    }
}
