package com.leetcode.codeTop;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import com.leetcode.listnode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sign = head;
        ListNode start = head;
        ListNode end = head;
        ListNode pre = null;
        ListNode result = head;
        for (int i = 0; i < k-1; i++) {
            result = result.next;
        }

        int count = 1;
        boolean sw = false;
        while(sign != null) {
            if (count % k != 0) {
                end = end.next;
                sw = true;
                count++;
                sign = sign.next;
            } else {
                ListNode next = end.next;
                sign = next;
                end.next = null;
                reverse(start);
                if (pre != null) {
                    pre.next = end;
                }

                pre = start;
                start = next;
                end = next;
                count = 1;
                sw = false;
            }
        }

        if (sw) {
            pre.next = start;
        }

        return result;
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
}
