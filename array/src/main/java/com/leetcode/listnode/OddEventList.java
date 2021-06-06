package com.leetcode.listnode;

public class OddEventList {
    public ListNode oddEventList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode tmp = second;
        ListNode pre = first;
        while(first != null && first.next != null) {
            pre = first;
            first.next = first.next.next;
            first = first.next;

            if (second.next != null) {
                second.next = second.next.next;
                second = second.next;
            }
        }

        if (first == null) {
            pre.next = tmp;
        } else {
            first.next = tmp;
        }

        return head;
    }
}
