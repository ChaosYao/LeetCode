package com.leetcode.string;

public class Convert {
    public String convert(String s, int numRows) {
        if (s.length() < 2 || numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int max = s.length() - 1;
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int firstStep = step - 2 * i;
            int secondStep = 2 * i;
            int tmp = i;

            if (i == 0) {
                result.append(String.valueOf(s.charAt(i)));
            }
            while(tmp <= max) {
                if (secondStep != 0) {
                    result.append(String.valueOf(s.charAt(tmp)));
                }
                tmp += firstStep;

                if (tmp <= max) {
                    if (firstStep != 0) {
                        result.append(String.valueOf(s.charAt(tmp)));
                    }
                    tmp += secondStep;
                }
            }
        }

        return result.toString();
    }
}
