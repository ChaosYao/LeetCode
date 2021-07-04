package com.leetcode.tree;

import com.leetcode.array.TreeNode;

public class BuildTree1 {
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        int leftStart = 0;
        int leftEnd = i - 1;
        int rightStart = i + 1;
        int rightEnd = inorder.length - 1;
        root.left = buildSubTree(1, leftStart, leftEnd);
        root.right = buildSubTree(0 + leftEnd -leftStart  + 2, rightStart, rightEnd);

        return root;
    }

    private TreeNode buildSubTree(int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length || inStart > inEnd || inStart < 0 || inEnd > inorder.length) {
            return null;
        }

        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                break;
            }
        }

        int leftStart = inStart;
        int leftEnd = i - 1;
        int rightStart = i + 1;
        int rightEnd = inEnd;
        root.left = buildSubTree(preStart + 1, leftStart, leftEnd);
        root.right = buildSubTree(preStart + i - inStart + 1, rightStart, rightEnd);

        return root;
    }
}
