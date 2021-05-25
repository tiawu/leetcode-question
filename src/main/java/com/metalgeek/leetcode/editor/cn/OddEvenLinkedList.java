//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
//
//
// 示例 2:
//
// 输入: 2->1->3->5->6->4->7->NULL
//输出: 2->3->6->7->1->5->4->NULL
//
// 说明:
//
//
// 应当保持奇数节点和偶数节点的相对顺序。
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
//
// Related Topics 链表
// 👍 424 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

public class OddEvenLinkedList{
    public static void main(String[] args) {
         Solution solution = new OddEvenLinkedList().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

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
    public ListNode oddEvenList(ListNode head) {
        return sort2(head);
    }
    public ListNode sort2(ListNode head) {
        if(head == null) {
            return head;
        }

        // 记录偶节点的头, 然后分别记录奇节点和偶节点的当前指针
        ListNode p1 = head, p2 = head.next, ph2 = p2;
        // 因为奇节点一定存在, 所以判断偶节点和偶节点的下一个节点(也是奇节点)
        while (p2 != null && p2.next !=null) {
            // 奇数节点next指向偶节点的next, 奇数节点后移, 检查条件保证了偶数节点next必不为空, 即新的奇数节点不为空
            p1.next = p2.next;
            p1 = p1.next;

            // 偶数节点next指向上一步奇数节点的next, 偶数节点后移, 上一步已经保证了奇数节点不为空
            p2.next = p1.next;
            p2=p2.next;
        }
        p1.next = ph2;

        return head;
    }
    public ListNode sort1(ListNode head) {
        // 设置两个dummy head, 分别用来挂基数节点和偶数节点
        ListNode ph1= new ListNode(-1), ph2 = new ListNode(-1), curr = head;
        int i = 0;
        // 从两个dummy head开始往后遍历挂载对应节点, 两个指针与curr指针同步往后
        ListNode p1 = ph1, p2 = ph2;
        while (curr != null) {
            if(i % 2 ==0) {
                p1.next = curr;
                p1 = p1.next;
            }else {
                p2.next = curr;
                p2 = p2.next;
            }
            curr = curr.next;
            i++;
        }
        //挂完以后因为一定是基数节点在前, 偶数节点在后, 所以最后一个奇数节点的下个节点就是偶数节点的开始(注意dummy head), 最后一个偶数节点一定截断
        p1.next = ph2.next;
        p2.next = null;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
