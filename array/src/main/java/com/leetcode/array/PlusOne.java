package com.leetcode.array;
/*

给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean sign = false;
        int size = digits.length;
        digits[size-1] = digits[size-1] + 1;
        for (int i = size - 1; i >= 0; i--) {
            int tmp = digits[i];
            tmp = sign == true ? tmp + 1 : tmp;
            sign = false;
            if (tmp >= 10) {
                tmp %= 10;
                sign = true;
            }

            digits[i] = tmp;
        }

        if (digits[0] != 0) {
            return digits;
        }

        int[] result = new int[size + 1];
        result[0] = 1;
        for (int i = 1; i <= size; i++) {
            result[i] = digits[i-1];
        }

        return result;
    }
}
