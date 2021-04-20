  //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6073 👎 0

  
  package com.metalgeek.leetcode.editor.cn;

  import com.metalgeek.leetcode.ListNode;

  public class AddTwoNumbers{
      public static void main(String[] args) {
           Solution solution = new AddTwoNumbers().new Solution();

//           ListNode l1 = new ListNode(2);
//           l1.next = new ListNode(4);
//           l1.next.next = new ListNode(3);
//
//          ListNode l2 = new ListNode(5);
//          l2.next = new ListNode(6);
//          l2.next.next = new ListNode(4);
//
          ListNode l1 = new ListNode(9);

          ListNode l2 = new ListNode(1);
          for(int i = 0; i< 9 ; i++) {
              solution.addVal(l2, 9);
          }
//          l2.next = new ListNode(9);
//          l2.next.next = new ListNode(9);


          ListNode ret = solution.addTwoNumbers(l1, l2);
          System.out.println( ret );

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
    public ListNode addVal(ListNode node, int val) {
        while(node != null && node.next != null)
            node = node.next;
        node.next = new ListNode(val);
        return node;
    }
    public long addOneList(ListNode l) {
        long sum = 0;
        int i = 0;
        while(l!=null) {
            sum += l.val * Math.pow(10, i);
            l = l.next;
            i++;
        }
        return sum;
    }
    public ListNode getList(long val) {
        ListNode rootNode = new ListNode((int)(val % 10)), node= rootNode;
        while(val / 10 > 0) {
            val = val / 10;
            ListNode node1 = new ListNode((int)(val % 10));
            node.next = node1;
            node = node1;
        }
        return rootNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long s1 = addOneList(l1), s2 = addOneList(l2);
        return getList(s1 + s2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//      解答失败:
//      测试用例:[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//              [5,6,4]
//      测试结果:[-4]
//      期望结果:[6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//      stdout:
  }