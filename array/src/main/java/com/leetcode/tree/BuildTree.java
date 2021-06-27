package com.leetcode.tree;

import com.leetcode.array.TreeNode;

public class BuildTree {
    private int[] inorder;
    private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        this.inorder = inorder;
        this.postorder = postorder;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }

        int lefStart = 0;
        int leftEnd = i - 1;
        int rightStart = i + 1;
        int rightEnd = inorder.length - 1;
        root.left = buildSubTree(postorder.length - 1 - rightEnd + rightStart - 1 - 1, lefStart, leftEnd);
        root.right = buildSubTree(postorder.length - 2, rightStart, rightEnd);

        return root;
    }

    private TreeNode buildSubTree(int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd || inStart < 0 || inEnd >= inorder.length) {
            return null;
        }

        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }

        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                break;
            }
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int leftStart = inStart;
        int leftEnd = i - 1;
        int rightStart =  i + 1;
        int rightEnd = inEnd;
        root.left = buildSubTree(postEnd - rightEnd + rightStart - 1 - 1, leftStart, leftEnd );
        root.right = buildSubTree(postEnd - 1, rightStart, rightEnd);

        return root;
    }
}
