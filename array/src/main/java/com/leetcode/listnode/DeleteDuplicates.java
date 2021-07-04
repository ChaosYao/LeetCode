<<<<<<< HEAD
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
=======
package com.leetcode.listnode;

>>>>>>> 9cac607b7efae7ade34e9d18adb6fcb4e12388fb
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

<<<<<<< HEAD
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
=======
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
>>>>>>> 9cac607b7efae7ade34e9d18adb6fcb4e12388fb
    }
}
