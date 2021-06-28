package com.leetcode.tree;

import com.leetcode.array.TreeNode;

public class Flatten {
    public void flatten(TreeNode root) {
        buildList(root);
        return;
    }

    private Pair buildList(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return new Pair(root, root);
        }

        Pair left = buildList(root.left);
        Pair right = buildList(root.right);
        root.left = null;

        if (left != null) {
            root.right = left.first;
            if (right != null) {
                left.second.right = right.first;
            }
        }

        return new Pair(root, right == null ? left.second: right.second);
    }

    class Pair{
        public TreeNode first;
        public TreeNode second;

        Pair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }

        Pair() {}
    }
}
