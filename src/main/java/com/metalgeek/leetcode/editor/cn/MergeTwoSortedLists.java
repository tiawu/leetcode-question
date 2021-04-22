//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1677 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

public class MergeTwoSortedLists{
  public static void main(String[] args) {
       Solution solution = new MergeTwoSortedLists().new Solution();

      ListNode l1 = new ListNode(1);

      ListNode l2 = new ListNode(1);

//      l1.addVal(2).addVal(4);
//      l2.addVal(3).addVal(4);
      for(int i = 0; i< 9 ; i++) {
          l1.addVal(i+2);
          l2.addVal(i+1);
      }

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.mergeTwoLists(l1, l2));

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
