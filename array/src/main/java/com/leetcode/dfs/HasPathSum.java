package com.leetcode.dfs;

import com.leetcode.array.TreeNode;
/*

 */
public class HasPathSum {
    private int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        this.targetSum = targetSum;
        return checkSum(root.val, root.left) || checkSum(root.val, root.right);
    }

    private boolean checkSum(int count, TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return count + root.val == targetSum;
        }
        String x = "123";
        x.substring(1,2);
        return checkSum(count + root.val, root.left) || checkSum(count + root.val, root.right);
    }
}
