package com.leetcode.listnode;
/*
给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。


https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next;
            if (second == null) {
                break;
            }
            second = second.next;
        }

        return first;
    }
}
