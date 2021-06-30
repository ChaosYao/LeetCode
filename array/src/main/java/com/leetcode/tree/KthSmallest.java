package com.leetcode.tree;

import com.leetcode.array.TreeNode;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int rootRank = getTreeSize(root.left) + 1;
        if (k == rootRank) {
            return root.val;
        }

        if (k > rootRank) {
            return kthSmallest(root.right, k - rootRank);
        } else {
            return kthSmallest(root.left, k);
        }

    }

    private int getTreeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }
}
