package com.leetcode.tree;

import com.leetcode.array.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderTraversal {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
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
        travel(root.right);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque();
        TreeNode r = null;
        while(!queue.isEmpty() || root != null) {
            if (root != null) {
                queue.push(root);
                root = root.left;
            } else {
                root = queue.peek();
                if (root.right == null || root.right == r) {
                    result.add(root.val);
                    r = root;
                    queue.pop();
                    root = null;
                } else {
                    root = root.right;
                }
            }
        }

        return result;
    }
}
