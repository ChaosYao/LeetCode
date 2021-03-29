package com.leetcode.dp;
/*
编写一个程序，找出第 n 个丑数。

丑数就是质因数只包含 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] idx = new int[3];
        for (int i = 0; i < 3;i++) {
            idx[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int tmp = Math.min(dp[idx[0]] * 2, Math.min(dp[idx[1]] * 3, dp[idx[2]] * 5));
            if (tmp == dp[idx[0]] * 2) {
                ++idx[0];
            }

            if (tmp == dp[idx[1]] * 3) {
                ++idx[1];
            } if (tmp == dp[idx[2]] * 5) {
                ++idx[2];
            }

            dp[i] = tmp;

        }

        return dp[n-1];
    }

}
/*
三指针
 */