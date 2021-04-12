package com.leetcode.dp;
/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSquares {
    public int numSquares(int n) {
        if (n < 3) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int tmp = new Double(Math.sqrt(i)).intValue();
            if (tmp * tmp == i) {
                dp[i] = 1;
                continue;
            }

            int min = 10 * 10 * 10 * 10 * 10;
            for (int j = tmp; j > 0; j--) {
                int count = dp[i - j * j] + 1;
                if (min > count) {
                    min = count;
                }
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
