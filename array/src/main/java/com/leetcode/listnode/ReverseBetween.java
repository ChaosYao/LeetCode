package com.leetcode.listnode;
/*
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sign = new ListNode(0);
        sign.next = head;
        ListNode first = sign;
        ListNode second = sign;
        ListNode pre = sign;
        ListNode next = second.next;
        for (int i = 0; i < left; i++) {
            pre = first;
            first = first.next;
        }

        for (int i = 0; i < right; i++) {
            second = second.next;
            next = second.next;
        }
        reverse(first, next);
        pre.next = second;
        first.next = next;
        return sign.next;
    }

    private void reverse(ListNode first, ListNode end) {
        ListNode pre = first;
        ListNode cur = first.next;
        pre.next = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
