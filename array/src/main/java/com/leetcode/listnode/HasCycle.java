package com.leetcode.listnode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            second = second.next;
            if (second == null || second.next == null) {
                return false;
            }
            second = second.next;

            if (second == first) {
                return true;
            }

            first = first.next;
            if (second == first) {
                return true;
            }
        }

        return false;
    }
}
