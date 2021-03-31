package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

https://leetcode-cn.com/problems/symmetric-tree/
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode tmpNode1 = queue.poll();
            TreeNode tmpNode2 = queue.poll();
            if (tmpNode1 == null && tmpNode2 == null) {
                continue;
            }

            if (tmpNode1== null || tmpNode2 == null || tmpNode1.val != tmpNode2.val) {
                return false;
            }
            queue.offer(tmpNode1.left);
            queue.offer(tmpNode2.right);
            queue.offer(tmpNode1.right);
            queue.offer(tmpNode2.left);
        }

        return true;
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
