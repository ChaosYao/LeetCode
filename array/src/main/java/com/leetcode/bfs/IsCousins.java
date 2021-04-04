package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsCousins {
    private Queue<TreeNode> queue = new LinkedList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode parentX = null;
            TreeNode parentY = null;
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                    int val = tmpNode.left.val;
                    if (val == x) {
                        parentX = tmpNode;
                    }

                    if (val == y) {
                        parentY = tmpNode;
                    }
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                    int val = tmpNode.right.val;
                    if (val == x) {
                        parentX = tmpNode;
                    }

                    if (val == y) {
                        parentY = tmpNode;
                    }
                }
            }

            if (parentX != null && parentY != null) {
                return parentX.val != parentY.val;
            }
        }

        return false;
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
