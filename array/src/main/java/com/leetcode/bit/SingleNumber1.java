/**
 * Bilibili.com Inc.
 * Copyright (c) 2009-2021 All Rights Reserved.
 */
package com.leetcode.bit;

/**
 *
 * @author leping
 * @version $Id: SingleNumber1.java, v 0.1 2021-07-04 下午8:03 leping Exp $$
 */
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
