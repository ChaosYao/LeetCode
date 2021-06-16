package com.leetcode.listnode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head;
        ListNode pre = head;
        while(q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        pre.next = null;
        ListNode first = mergeSort(head);
        ListNode second = mergeSort(p);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        ListNode pre = new ListNode(0);
        ListNode tmp = pre;
        while(first != null && second != null) {
            if (first.val <= second.val) {
                tmp.next = first;
                first = first.next;
            } else {
                tmp.next = second;
                second = second.next;
            }

            tmp = tmp.next;
            if (first == null) {
                tmp.next = second;
                break;
            } else if (second == null) {
                tmp.next = first;
                break;
            }
        }

        return pre.next;
    }
}
