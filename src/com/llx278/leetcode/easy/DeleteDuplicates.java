package com.llx278.leetcode.easy;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;
        while (temp.next != null) {
            ListNode n = temp.next;
            if (n.val == temp.val) {
                temp.next = n.next;
            } else {
                temp = n;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
