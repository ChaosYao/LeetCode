package com.leetcode.dp;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int size = obstacleGrid.length;
        int length = obstacleGrid[0].length;
        boolean sign = false;
        for (int i = 0; i < size; i++) {
            if (sign == true) {
                obstacleGrid[i][0] = 0;
            } else if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                sign = true;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }

        sign = false;
        for (int i = 1; i < length; i++) {
            if (sign == true) {
                obstacleGrid[0][i] = 0;
            } else if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                sign = true;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[size-1][length-1];
    }
}
