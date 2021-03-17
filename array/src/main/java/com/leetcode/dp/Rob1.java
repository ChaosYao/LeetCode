package com.leetcode.dp;
/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob1 {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }

        if (size == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int tmp1 = rob1(nums, 1, size);
        int tmp2 = rob1(nums, 0 ,size-1);
        return tmp1 > tmp2 ? tmp1 : tmp2;

    }

    private int rob1(int[] nums, int start, int end) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);

        }

        return dp[end-1];
    }
}
