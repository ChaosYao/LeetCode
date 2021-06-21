package com.leetcode.tree;

import com.leetcode.array.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        buildTree(root);
        return isBalanced(root.left, root.right);
    }

    private void buildTree(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            root.val = 1;
            return;
        }

        buildTree(root.left);
        buildTree(root.right);
        int rootLeft = root.left == null ? 0 : root.left.val;
        int rootRight = root.right == null ? 0 : root.right.val;

        root.val = Math.max(rootLeft, rootRight) + 1;
    }

    private boolean isBalanced(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        int valLeft = left == null ? 0 : left.val;
        int valRight = right == null ? 0 : right.val;
        if (Math.abs(valLeft - valRight) > 1) {
            return false;
        }

        boolean leftIsBalanced = left == null || isBalanced(left.left, left.right);
        boolean rightIsBalanced = right == null || isBalanced(right.left, right.right);
        return leftIsBalanced && rightIsBalanced;
    }

    private boolean isBalanced1(TreeNode root) {
        return process(root) != -1;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = process(root.left);
        if (left == -1) {
            return -1;
        }

        int right = process(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left,right);
    }
}
