package com.leetcode.dp;
/*
爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divisor-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }

        if (N == 2) {
            return true;
        }

        int[] list = new int[N+1];
        list[1] = 0;
        list[2] = 1;
        for (int i = 3; i < N+1; i++) {
            for(int j = 1; j < i; j++) {
                if (i % j == 0 && list[i-j]== 0) {
                    list[i] = 1;
                    break;
                }
            }
        }

        return list[N] == 1;
    }
}
