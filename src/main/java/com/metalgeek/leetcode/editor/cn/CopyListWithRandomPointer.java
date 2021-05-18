//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
//
// 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
//
// 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
//--> y 。
//
// 返回复制链表的头节点。
//
// 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
//
//
// val：一个表示 Node.val 的整数。
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
//
//
// 你的代码 只 接受原链表的头节点 head 作为传入参数。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// 示例 2：
//
//
//
//
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//
// 示例 3：
//
//
//
//
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//
// 示例 4：
//
//
//输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
//
//
//
//
// 提示：
//
//
// 0 <= n <= 1000
// -10000 <= Node.val <= 10000
// Node.random 为空（null）或指向链表中的节点。
//
// Related Topics 哈希表 链表
// 👍 567 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer{
    public static void main(String[] args) {
         Solution solution = new CopyListWithRandomPointer().new Solution();

         Node n1 = Node.fromArray(new int[]{2,1,3,4,5});
         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.copyRandomList(n1));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        @Override
        public String toString() {
            Node node = this;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
        public Node addVal(int val) {
            Node temp = this;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
            return temp.next;
        }
        static public Node fromArray(int[] arr) {
            Node head = new Node(0);
            Node node = head;
            for(int num : arr) {
                node = node.addVal(num);
            }
            return head.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        return copyRandomListRecurse(head, map);
    }
    public Node copyRandomListRecurse(Node head, HashMap<Node, Node> map) {
        if(head == null) {
            return null;
        }
        if(map.containsKey(head)) {
            return map.get(head);
        }

        Node newNode = new Node(head.val);
        map.put(head, newNode);

        newNode.next = copyRandomListRecurse(head.next, map);
        newNode.random = copyRandomListRecurse(head.random, map);

        return newNode;
    }
//    public Node copyRandomList(Node head) {
//        // 遇事不觉先加个dummy head
//        Node root = new Node(-1);
//        root.next = head;
//
//        Map<Node, Integer> map1 = new HashMap<>();
//        Node node = head;
//        int i = 0;
//        while(head != null) {
//            map1.put(node, i++);
//            head = head.next;
//        }
//
//        Map<Integer, Node> map2 = new HashMap<>();
//        Node newRoot = new Node(-1), res = newRoot;
//        int j = 0;
//        while (root.next != null) {
//            Node next = root.next;
//            Node newNext = new Node(next.val);
//            newRoot.next = newNext;
//
//            map2.put(j++, newNext);
//
//            root = root.next;
//            newRoot = newRoot.next;
//        }
//
//        newRoot = res.next;
//        while (head != null) {
//            int index = map1.get(head.random);
//            newRoot.random = map2.get(index);
//
//            head = head.next;
//            newRoot = newRoot.next;
//        }
//        return res.next;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
