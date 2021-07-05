package com.leetcode.bit;

public class SingleNumber1 {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            once = (once ^ nums[i]) & (~twice);
            twice = (twice ^ nums[i]) & (~once);
        }

        return once;
    }
}
