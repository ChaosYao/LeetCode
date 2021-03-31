package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null) {
            return 0;
        }

        int result = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            result++;
            int tmpSize = queue.size();
            for (int i = 0; i < tmpSize; i++){
                Node tmp = queue.poll();
                queue.addAll(tmp.getChildren());
            }
        }

        return result;
    }

    public static class Node {
        private Integer val;

        private List<Node> children;

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
