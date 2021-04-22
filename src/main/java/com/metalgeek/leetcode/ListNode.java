package com.metalgeek.leetcode;

/**

 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(val);
        if (next != null) {
            sb.append("->").append(next);
        }
        return sb.toString();
    }

    public ListNode addVal(int val) {
        ListNode temp = this;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return temp.next;
    }
}
