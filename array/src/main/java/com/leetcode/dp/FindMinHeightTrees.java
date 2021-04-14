package com.leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。

给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。

可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。

请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。

树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-height-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinHeightTrees {
    private Queue<Integer> queue = new LinkedList<>();
    private int[] e;
    private boolean[][] graph;
    private boolean[] visited;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        e = new int[n];
        graph = new boolean[n][n];
        visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = true;
            graph[edges[i][1]][edges[i][0]] = true;
            e[edges[i][0]]++;
            e[edges[i][1]]++;
        }
        while(n > 2) {
            findOuter();
            while(!queue.isEmpty()) {
                Integer num = queue.poll();
                e[num]--;
                n--;
                visited[num] = true;
                for (int i = 0; i < graph[num].length; i++) {
                    if (graph[num][i]) {
                        e[i]--;
                        graph[num][i] = false;
                        graph[i][num] = false;
                    }
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                result.add(i);
            }
        }

        return result;
    }

    private void findOuter() {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == 1) {
                queue.offer(i);
            }
        }
    }

    /*
    关键思路，不断剔除最外层节点，即入度为一的节点。最终的节点数目不可能超过两个，因为如果为三个节点，必有一个为根节点
     */
}
