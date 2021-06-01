package com.leetcode.listnode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sign = new ListNode(0);
        sign.next = head;
        ListNode pre = sign;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
            } else {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                if (cur.next == null) {
                    pre.next = null;
                    break;
                }

                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return sign.next;
    }
}
