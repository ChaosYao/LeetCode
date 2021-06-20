package com.leetcode.tree;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
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

        travel(root.left);
        result.add(root.val);
        travel(root.right);
    }
}
