package com.leetcode.dp;
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
链接：https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        int lastMax = nums[0];
        int lastMin = nums[0];
        int max = nums[0];

        for (int i = 1; i < size; i++) {
            int currentMax = Math.max(lastMax * nums[i], nums[i]);
            currentMax = Math.max(lastMin * nums[i], currentMax);

            int currentMin = Math.min(lastMax * nums[i], nums[i]);
            currentMin = Math.min(lastMin * nums[i], currentMin);
            if (max < currentMax) {
                max = currentMax;
            }

            lastMax = currentMax;
            lastMin = currentMin;
        }

        return max;
    }
}
