package com.leetcode.dp;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。


 */
public class MaxSubArray {
    private int smallestNum = -10 * 10 * 10 * 10 * 10;

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }

        if (size == 1) {
            return nums[0];
        }

        int max = smallestNum;
        int[] tmpResult = new int[size];
        tmpResult[0] = nums[0];
        for (int i = 1; i < size; i++) {
            tmpResult[i] = Math.max(tmpResult[i - 1] + nums[i], nums[i]);
            if (tmpResult[i] > max) {
                max = tmpResult[i];
            }
        }

        return Math.max(max, tmpResult[0]);
    }
}
