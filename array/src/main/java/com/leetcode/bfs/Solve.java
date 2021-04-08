package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solve {
    public void solve(char[][] board) {
        int size = board.length;
        if (size < 1) {
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        int length = board[0].length;
        for (int i = 0; i < size; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'y';
                queue.offer(new Pair(i, 0));
            }

            if (board[i][length-1] == 'O') {
                board[i][length-1] = 'y';
                queue.offer(new Pair(i, length-1));
            }
        }

        for (int i = 0; i < length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'y';
                queue.offer(new Pair(0, i));
            }

            if (board[size-1][i] == 'O') {
                board[size-1][i] = 'y';
                queue.offer(new Pair(size-1, i));
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int i = pair.first;
            int j = pair.second;
            if (board[i][j] == 'y') {
                if (i - 1 > 0  && board[i-1][j] == 'O') {
                    board[i-1][j] = 'y';
                    queue.offer(new Pair(i-1, j));
                }

                if (i + 1 < size && board[i+1][j] == 'O') {
                    board[i+1][j] = 'y';
                    queue.offer(new Pair(i+1, j));
                }

                if (j - 1 > 0 && board[i][j-1] == 'O') {
                    board[i][j-1] = 'y';
                    queue.offer(new Pair(i, j-1));
                }

                if (j + 1 < length && board[i][j+1] == 'O') {
                    board[i][j+1] = 'y';
                    queue.offer(new Pair(i, j+1));
                }
            }
        }



        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public class Pair {
        public int first;

        public int second;

        Pair() {};

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
