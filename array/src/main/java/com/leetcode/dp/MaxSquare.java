package com.leetcode.dp;
/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

链接：https://leetcode-cn.com/problems/maximal-square/
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int size = matrix.length;
        int length = matrix[0].length;
        int[][] dp = new int[size+1][length+1];
        int max = 0;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= length; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}
