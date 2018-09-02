package com.llx278.leetcode.easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode newNode,pc;
        ListNode p1,p2;

        if (l1.val < l2.val) {
            newNode = pc = l1;
            p1 = l1.next;
            p2 = l2;
        } else {
            newNode = pc = l2;
            p1 = l1;
            p2 = l2.next;
        }

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pc.next = p1;
                pc = p1;
                p1 = p1.next;
            } else {
                pc.next = p2;
                pc = p2;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            pc.next = p2;
        } else {
            pc.next = p1;
        }

        return newNode;
    }

    private void printNode(ListNode node) {

        System.out.println(node.val);
        ListNode p = node.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode c1 = new ListNode(1);

        MergeTwoSortedLists mt = new MergeTwoSortedLists();

        ListNode l = mt.mergeTwoLists(l1,c1);

        mt.printNode(l);
    }
}
