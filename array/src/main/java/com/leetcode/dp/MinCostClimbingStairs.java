package com.leetcode.dp;
/*
数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。

每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。

请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        if (size == 0) {
            return 0;
        }

        if (size == 1) {
            return cost[1];
        }

        int[] result = new int[size];
        result[0] = cost[0];
        result[1] = cost[1];

        for (int i = 2;i < size; i++) {
            result[i] = Math.min(result[i-1], result[i-2]) + cost[i];
        }

        return Math.min(result[size-1], result[size-2]);
    }
}
/*
dp[n] = min(dp[n-1], dp[n-2]) + x[n]
 */
