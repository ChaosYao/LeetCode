package com.leetcode.dfs;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> storeList = new ArrayList<>();
        while(head != null) {
            storeList.add(head.val);
            head = head.next;
        }


        return buildTreeNode(storeList);
    }

    private TreeNode buildTreeNode(List<Integer> storeList) {
        int size = storeList.size();
        int central = size % 2 == 1 ? (size - 1) / 2 : size / 2;
        TreeNode root = new TreeNode(storeList.get(central));
        if (central != 0) {
            root.left = buildTreeNode(storeList.subList(0, central));
        }
        if (central + 1 < size) {
            root.right = buildTreeNode(storeList.subList(central+1, size));
        }

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
