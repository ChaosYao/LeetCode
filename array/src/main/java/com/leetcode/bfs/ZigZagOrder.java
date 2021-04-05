package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpResult = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                tmpResult.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }

            }

            index++;
            result.add(index % 2 == 1 ? reverse(tmpResult) : tmpResult);
        }

        return result;
    }

    private List<Integer> reverse(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
