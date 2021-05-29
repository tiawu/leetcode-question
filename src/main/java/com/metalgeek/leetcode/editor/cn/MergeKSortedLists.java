//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1321 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

import java.util.*;

public class MergeKSortedLists{
    public static void main(String[] args) {
         Solution solution = new MergeKSortedLists().new Solution();

        ListNode l1 = ListNode.fromArray(new int[]{1,3,5});
        ListNode l2 = ListNode.fromArray(new int[]{2,4,6});

//        ListNode[] lists = new ListNode[]{l1, l2};

        ListNode[] lists = new ListNode[]{null};

        long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.mergeKLists(lists));

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
    public ListNode mergeKLists(ListNode[] lists) {
        // 归并排序的性能比堆排序要好
        return recurseMerge(lists, 0, lists.length-1);
//        return sequencialMerge(lists);
//        return queueMerge(lists);

    }

    public ListNode queueMerge(ListNode[] lists) {
        // 利用小根堆进行排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node: lists) {
            // 空节点要过滤掉
            if(node!=null) {
                queue.offer(node);
            }
        }
        ListNode head = new ListNode(-1), pre = head;
        while(!queue.isEmpty()){
            // 利用小根堆特性, 先从队列取最小的节点加入进来, 然后把节点的子节点加进来(空节点要过滤掉)
            pre.next = queue.poll();
            pre = pre.next;
            if(pre.next != null) {
                queue.offer(pre.next);
            }
        }
        return head.next;
    }

    public ListNode recurseMerge(ListNode [] list , int i, int j) {
        // 分治法进行归并排序
        if(i > j) {
            return null;
        }
        if(i == j) {
            return list[i];
        }

        int mid = (i + j) /2;
        return merge(recurseMerge(list, i, mid), recurseMerge(list, mid+1, j));
    }

    public ListNode sequencialMerge(ListNode[] lists) {
        // 顺序排序
        int len = lists.length;
        if(len == 0)
            return null;
        if(len == 1)
            return lists[0];

        for(int i =lists.length -1; i > 0; i --) {
            lists[0] = merge(lists[0], lists[i]);
        }
        return lists[0];
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
