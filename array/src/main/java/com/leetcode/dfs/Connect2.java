package com.leetcode.dfs;

import com.leetcode.array.Node;
/*
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Connect2 {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        if (root.right == null && root.left != null) {
            root.left.next = getNext(root.next);
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node getNext(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null && root.next != null) {
            return getNext(root.next);
        }

        return root.left == null ? root.right : root.left;
    }
}
