package com.leetcode.array;

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmpNode = head;
        boolean sign = false;

        while(true) {
            int tmpValue = 0;
            if (sign == true) {
                tmpValue++;
                sign = false;
            }

            tmpValue += l1.val + l2.val;
            if (tmpValue >= 10) {
                sign = true;
                tmpValue = tmpValue % 10;
            }

            tmpNode.next = new ListNode(tmpValue);
            tmpNode = tmpNode.next;

            if (l1.next == null || l2.next == null) {
                break;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1.next == null && l2.next != null) {
            conbineListNode(tmpNode, l2.next, sign);
        } else if (l2.next == null && l1.next != null) {
            conbineListNode(tmpNode, l1.next, sign);
        } else {
            if (sign) {
                tmpNode.next = new ListNode(1);
            }
        }

        return head.next;
    }

    private void conbineListNode(ListNode origin, ListNode target, boolean sign) {
        if (sign) {
            target = addTwoNumbers(target, new ListNode(1));
        }

        origin.next = target;
    }

    private static class ListNode {
        int val;

        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }

        ListNode( int val, ListNode next){
        this.val = val;
        this.next = next;
        }
    }
}
/*
corner case
1.节点增加
2.进位
3.两条节点 节点个数不同

condition：
1.是否进位增加一个标志位
2.next为空 并且标识为为正 新增节点
3.两条链表其中一个next为空  另一条链表的其余部分直接链到前一条的后面，如果标志位为正先+1，+1的情况下可能导致另一条链表新增节点
 */
