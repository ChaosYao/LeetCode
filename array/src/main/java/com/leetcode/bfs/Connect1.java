package com.leetcode.bfs;

import com.leetcode.array.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Connect1 {
    public Node connect(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node pre = queue.poll();
            if (pre.left != null) {
                queue.offer(pre.left);
            }

            if (pre.right != null) {
                queue.offer(pre.right);
            }

            for (int i = 1; i < size;i++) {
                Node cur = queue.poll();
                pre.next = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                pre = cur;
            }
        }

        return root;
    }
}
