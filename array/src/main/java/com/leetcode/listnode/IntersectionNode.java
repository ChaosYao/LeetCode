package com.leetcode.listnode;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int size1 = 0;
        int size2 = 0;
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;

        while (tmp1 != null || tmp2 != null) {
            if (tmp1 != null) {
                tmp1 = tmp1.next;
                size1++;
            }

            if (tmp2 != null) {
                tmp2 = tmp2.next;
                size2++;
            }
        }

        int diff = Math.abs(size1 - size2);
        boolean aBigger = size1 >= size2;

        if (aBigger) {
            for(int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        while(headA != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
