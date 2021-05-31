//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics 链表 双指针
// 👍 570 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

public class RotateList{
    public static void main(String[] args) {
         Solution solution = new RotateList().new Solution();


         long t0 = System.currentTimeMillis();
         // Call solution here
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2}), 1));
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2,3,4,5}), 1));
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2,3,4,5}), 2));
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2,3,4,5}), 3));
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2,3,4,5}), 4));
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2,3,4,5}), 5));
        System.out.println(solution.rotateRight(ListNode.fromArray(new int[]{1,2,3,4,5}), 6));

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k ==0) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode fast = head, slow=head;
        int len = 1;
        while(fast.next != null) {
            fast = fast.next;
            len ++;
        }
        int tail = len - (k % len);

        // 如果k被len整除, 则tail == len, 直接返回头节点
        if(tail == len) {
            return head;
        }


        // 快指针所代表的原尾节点接到头上, 当前节点为一个环
        fast.next = head;

        // 慢指针从头开始跑到tail位置, 即为旋转后的尾节点
        len = 1;
        while(len < tail) {
            slow = slow.next;
            len ++;
        }
        
        // 新的头节点为 尾节点的next, 尾节点断开
        dummyHead.next = slow.next;
        slow.next = null;

        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
