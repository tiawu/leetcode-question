//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1143 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SortList{
  public static void main(String[] args) {
       Solution solution = new SortList().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.sortList(ListNode.fromArray(new int[]{4,2,1,3})));
       
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
    public ListNode sortList(ListNode head) {
//        return recurseSort(head, null);
        return seperateAndMerge(head);
    }

    // 迭代法自底向上归并排序
    public ListNode seperateAndMerge(ListNode head) {
        if(head == null) {
            return head;
        }
        int len = 0;
        ListNode dummy = new ListNode(-1);
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        dummy.next = head;

        for(int mergeNodes = 1; mergeNodes < len; mergeNodes = 2*mergeNodes) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                // 从头取2^i 长度的第一个链表
                ListNode list1 = curr;
                for (int i = 1; i < mergeNodes && curr.next !=null; i++) {
                    curr = curr.next;
                }
                // 截断链表1的尾
                ListNode list2 = curr.next;
                curr.next = null;

                // 从链表1结尾后取2^i长度的一个链表
                curr = list2;
                for (int i = 1; i < mergeNodes && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 截断链表2的尾
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                // 合并链表, 接到上一段的尾巴. 移动上一段到末尾
                prev.next = mergeTwoLists(list1, list2);
                while (prev.next !=null) {
                    prev = prev.next;
                }
                // 从下一段开始处理
                curr = next;
            }
        }
        return dummy.next;
    }

    //递归解法从上向下归并排序
    public ListNode recurseSort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode n1 = head, n2 = head;
        // 快慢指针找中点
        while (n2 != tail) {
            n1 = n1.next;
            n2 = n2.next;
            if(n2 != tail){
                n2 = n2.next;
            }
        }

        // n1 为中点, 拆成两个不连续的链表
        // 递归排序, 得到两个有序的子链表, 再进行排序合并
        return mergeTwoLists(recurseSort(head, n1), recurseSort(n1, tail));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root= new ListNode(1), curr = root, temp;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val >= l2.val) {
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                }else {
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                }
            }else if (l1 == null) {
                curr.next = l2;
                break;
            }else {
                curr.next = l1;
                break;
            }
        }
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
