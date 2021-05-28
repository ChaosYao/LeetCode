package com.leetcode.listnode;
/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode tmp = result;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }

            tmp = tmp.next;
            if (l2 == null && l1 != null) {
                tmp.next = l1;
                break;
            } else if (l2 != null && l1 == null) {
                tmp.next = l2;
                break;
            }
        }

        return result.next;
    }
}
