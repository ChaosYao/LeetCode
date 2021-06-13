package com.leetcode.listnode;

public class ReOrderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode first = head;
        ListNode second = head;
        ListNode pre = head;
        while(second != null) {
            pre = first;
            first = first.next;
            second = second.next;
            if (second == null) {
                break;
            }
            second = second.next;
        }

        pre.next = null;
        ListNode n = reverse(first);
        combineListNode(head, n);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private void combineListNode(ListNode first, ListNode second) {
        while (first != null && second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;
            first = next1;
            second = next2;
        }
    }
}
