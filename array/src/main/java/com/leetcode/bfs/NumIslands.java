package com.leetcode.bfs;

import java.util.*;
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {
    private Queue<List<Integer>> queue = new LinkedList<>();

    private int size;

    private int length;

    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        size = grid.length;
        length = grid[0].length;
        int result = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new ArrayList<Integer>(Arrays.asList(i, j)));
                    grid[i][j] = '0';
                    while(!queue.isEmpty()) {
                        List<Integer> list = queue.poll();
                        Integer x = list.get(0);
                        Integer y = list.get(1);
                        canPush(x-1, y);
                        canPush(x+1, y);
                        canPush(x, y-1);
                        canPush(x, y+1);
                    }
                    result++;
                }
            }
        }

        return result;
    }

    private void canPush(int i, int j) {
        if (i >= 0 && i < size && j >=0 && j < length && grid[i][j] == '1') {
            queue.offer(new ArrayList<Integer>(Arrays.asList(i, j)));
            grid[i][j] = '0';
        }
    }
}
