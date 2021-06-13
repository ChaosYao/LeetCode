package com.leetcode.listnode;

public class DeleteCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        while (second != null) {
            first = first.next;
            second = second.next;
            if (second == null) {
                break;
            }

            second = second.next;
            if (second == first) {
                break;
            }
        }

        if (second == null) {
            return null;
        }

        while(second != head) {
            second = second.next;
            head = head.next;
        }

        return head;
    }
}
