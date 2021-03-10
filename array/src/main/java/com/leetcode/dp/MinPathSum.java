package com.leetcode.dp;
/*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步
链接：https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int size = grid.length;
        int length = grid[0].length;

        for (int i = 1; i < size; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < length; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[size-1][length-1];
    }
}
