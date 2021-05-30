/**
 * Bilibili.com Inc.
 * Copyright (c) 2009-2021 All Rights Reserved.
 */
package com.leetcode.listnode;

/**
 *
 * @author leping
 * @version $Id: DeleteDuplicates.java, v 0.1 2021-05-30 下午5:11 leping Exp $$
 */
public class DeleteDuplicates {
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
