package com.leetcode.dp;

import java.util.Arrays;
/*
有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。

现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //此处dp数组的第二个维度代表的是搭乘的航班数，不代表中转数
        int[][] dp = new int[n][K+2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i <= K+1; i++) {
            dp[src][i] = 0;
        }

        for (int k = 1; k <= K+1; k++) {
            for (int[] flight : flights) {
                if (dp[flight[0]][k-1] != Integer.MAX_VALUE) {
                    dp[flight[1]][k] = Math.min(dp[flight[1]][k], dp[flight[0]][k-1] + flight[2]);
                }
            }
        }

        return dp[dst][K+1] == Integer.MAX_VALUE ? -1 : dp[dst][K+1];
    }
}

/*
dp[i][n] 代表搭乘至多n次航班到达i所花费的最少金额

 */