package com.leetcode.listnode;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode sign = new ListNode(0);
        sign.next = head;
        ListNode pre = sign;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                list.add(cur);
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            ListNode first = list.get(i);
            ListNode second = list.get(i + 1);
            first.next = second;
        }

        if (list.size() > 0) {
            ListNode signNext = sign.next;
            sign.next = list.get(0);
            list.get(list.size() - 1).next = signNext;
        }

        return sign.next;
    }
}
