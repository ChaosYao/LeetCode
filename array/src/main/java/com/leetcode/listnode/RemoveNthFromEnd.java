package com.leetcode.listnode;
/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode second = head;
        boolean sign = true;
        for (int i = 0; i < n - 1; i++) {
            second = second.next;
        }

        if (second.next == null) {
            return head.next;
        }

        ListNode pre = head;
        ListNode first = head.next;
        second = second.next;
        while(second.next != null) {
            pre = first;
            first = first.next;
            second = second.next;
        }

        pre.next = first.next;
        return head;
    }
}
