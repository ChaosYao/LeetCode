package com.leetcode.listnode;
/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 0;
        ListNode tmp = head;
        while(tmp != null) {
            size++;
            tmp = tmp.next;
        }

        k %= size;
        if (k == 0) {
            return head;
        }

        ListNode second = head;
        ListNode first = head;
        for (int i = 0; i < k - 1; i++) {
            second = second.next;
        }

        ListNode pre = first;
        while(second.next != null) {
            pre = first;
            first = first.next;
            second = second.next;
        }

        pre.next = null;
        second.next = head;
        return first;
    }
}
