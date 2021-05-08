package com.leetcode.array;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int size = nums.length;
        int sum = nums[0];
        for (int i = 1; i < size; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}
