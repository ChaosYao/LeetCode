package com.leetcode.tree;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }

        travel(root);
        return result;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        travel(root.left);
        travel(root.right);
    }
}
