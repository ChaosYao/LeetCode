package com.leetcode.dp;
/*
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ones-and-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (String s : strs) {
            char[] chars = s.toCharArray();
            int ones = 0;
            int zeros = 0;
            for (char c : chars) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            //由于有zeros个0 ones个1 ，所以dp[x][y] = max(dp[x-zeros][y-ones] + 1) x>=zeros && y >=ones
            //之所以用倒序，是防止重复利用同一个值
            for (int i = m ; i >= zeros ; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
