package com.leetcode.dfs;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePath {
    private List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        buildString(String.valueOf(root.val), root.left);
        buildString(String.valueOf(root.val), root.right);
        return result;
    }

    private void buildString(String val, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(val + "->" + root.val);
        }

        val += "->" + root.val;
        buildString(val, root.left);
        buildString(val, root.right);
    }
}
