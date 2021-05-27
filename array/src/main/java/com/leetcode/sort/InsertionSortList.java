package com.leetcode.sort;
/*
插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insertion-sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode sign = head;
        while(cur != null) {
            if (cur.val >= sign.val) {
                sign = cur;
                cur = cur.next;
                continue;
            }

            ListNode tmp = pre;
            while(tmp.next.val <= cur.val) {
                tmp = tmp.next;
            }

            ListNode tmpNext = tmp.next;
            ListNode curNext = cur.next;
            tmp.next = cur;
            cur.next = tmpNext;
            sign.next = curNext;
            cur = curNext;
        }

        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
