//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 链表
// 👍 1730 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

import java.util.List;

public class ReverseLinkedList{
    public static void main(String[] args) {
         Solution solution = new ReverseLinkedList().new Solution();

         ListNode node = new ListNode(1);
         node.addVal(2).addVal(3).addVal(4).addVal(5);

        System.out.println(node);

        long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.reverseList(node));

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
    public ListNode reverseList(ListNode head) {
        return solve1(head);
    }

    public ListNode solve1(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode node = head;
        while(node != null){
            ListNode tmp = node.next;
            node.next = dummyHead.next;
            dummyHead.next = node;
            node = tmp;
        }
        return dummyHead.next;
    }

    public ListNode iterate(ListNode head) {
        if(head == null)
            return head;
        ListNode p = head, q = null, r = p.next;
        while(p != null) {
            q = p;
            p = r;
            if(p != null) {
                r = p.next;
                if(q == head) {
                    q.next = null;
                }
                p.next = q;
            }
        }
        return q;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
