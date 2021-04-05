package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */

public class LevelOrder1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode != null) {
                    tmpResult.add(tmpNode.val);
                    queue.offer(tmpNode.left);
                    queue.offer(tmpNode.right);
                }
            }

            if (!tmpResult.isEmpty()) {
                result.add(tmpResult);
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
