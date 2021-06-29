//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1354 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

import java.util.Stack;

public class RemoveNthNodeFromEndOfList{
  public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

       ListNode node = ListNode.fromArray(new int[]{1,2});
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.removeNthFromEnd(node, 2));

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return solve2(head, n);
    }

    public ListNode solve2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1), l = dummyHead, r = dummyHead;
        dummyHead.next = head;
        for(int i =0; i < n; i++) {
            r = r.next;
        }
        while(r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummyHead.next;
    }
    public ListNode solve1(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for(int i =1; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode twoPointer(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode fast = root, slow = root;
        for(int i=0; i < n ; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return root.next;
    }

    public ListNode stack(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;

        Stack<ListNode> stack = new Stack<>();
        ListNode node = root;
        while(node!= null) {
            stack.push(node);
            node = node.next;
        }


        for(int i =0; i < n; i++) {
            node = stack.pop();
        }
        stack.peek().next = node.next;

        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
