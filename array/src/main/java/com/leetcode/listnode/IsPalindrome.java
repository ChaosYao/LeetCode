package com.leetcode.listnode;

import java.util.ArrayList;
import java.util.List;
/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public boolean isPalindrome1(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode tmp = head;
        List<ListNode> list = new ArrayList<>();
        while(tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (head.val != list.get(i).val) {
                return false;
            }

            head = head.next;
        }


        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head.next == null) {
            return true;
        }

        int size = 0;
        ListNode tmp = head;
        while(tmp != null) {
            size++;
            tmp = tmp.next;
        }

        int count = size % 2 == 0 ? size / 2 : size / 2 + 1;
        ListNode tmp1 = head;
        for (int i = 0; i < count; i++) {
            tmp1 = tmp1.next;
        }

        tmp1 = reverse(tmp1);
        for (int i = 0; i < size / 2; i++) {
            if (head.val != tmp1.val) {
                return false;
            }
            head = head.next;
            tmp1 = tmp1.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
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
