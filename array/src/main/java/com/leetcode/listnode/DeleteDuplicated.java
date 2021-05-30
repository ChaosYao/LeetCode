package com.leetcode.listnode;

public class DeleteDuplicated {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head.next;
        ListNode pre = head;
        while (tmp != null) {
            if (tmp.val == pre.val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }

            tmp = tmp.next;
        }

        return head;
    }
}
