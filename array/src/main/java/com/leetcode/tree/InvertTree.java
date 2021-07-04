package com.leetcode.tree;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverse(root.left);
        reverse(root.right);
    }
}
