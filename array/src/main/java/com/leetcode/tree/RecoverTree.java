package com.leetcode.tree;

import com.leetcode.array.TreeNode;

public class RecoverTree {
    private TreeNode t1;
    private TreeNode t2;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) {
                t1 = pre;
            }
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
