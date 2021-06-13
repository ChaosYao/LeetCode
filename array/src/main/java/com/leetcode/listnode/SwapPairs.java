package com.leetcode.listnode;
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sign = new ListNode(0);
        sign.next = head;

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode prePre = sign;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre.next = next;
            prePre.next = cur;

            prePre = pre;
            pre = next;
            if (next == null) {
                break;
            }

            cur = next.next;
        }

        return sign.next;
    }
}
