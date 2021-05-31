package com.leetcode.listnode;
/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode tmp = head;
        ListNode pre = new ListNode(0);
        ListNode sign = pre;
        pre.next = head;
        while(tmp != null) {
            if (tmp.val == val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }

            tmp = tmp.next;
        }

        return sign.next;
    }
}
