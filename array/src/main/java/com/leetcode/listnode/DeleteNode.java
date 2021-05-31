package com.leetcode.listnode;
/*
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 

现有一个链表 -- head = [4,5,1,9]，它可以表示为:



 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
