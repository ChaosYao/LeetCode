package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。

 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size;i++) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left == null && tmpNode.right == null) {
                    return result;
                }

                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
        }

        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
    }
}
