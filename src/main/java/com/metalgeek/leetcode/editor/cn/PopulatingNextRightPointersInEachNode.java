//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
// 提示：
//
//
// 树中节点的数量少于 4096
// -1000 <= node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 461 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode{
    public static void main(String[] args) {
         Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(Node.toString(solution.connect(root)));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        return connectRecurse(root);
    }

    public Node connectRecurse(Node node) {
        // 递归, 每层处理自己的左右子节点连接, 利用本节点next来处理右子节点的next
        if(node == null)
            return node;
        
        // 子节点处理
        if(node.left != null) {
            node.left.next = node.right;
            node.right.next = node.next == null ? null : node.next.left;
        }

        // 递归处理后面层次
        connectRecurse(node.left);
        connectRecurse(node.right);
        return node;
    }

    public Node connectIterate(Node root) {
        // 循环解法, 保留一个每层最左边节点, 利用本层的next指针即可
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }

    public Node connectLevelOrder(Node root) {
        // 层序遍历, 每层最后一个节点的next置空.
        // 注意层序遍历使用了队列, 空间复杂度为O(n), 不符合题目要求, 而且确实也慢
        Queue<Node> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        // 层序遍历
        int len;
        while (!queue.isEmpty()) {
            Node curr = null, prev = null;
            len = queue.size();
            for(int i =0; i < len; i++) {
                prev = curr;
                curr = queue.poll();
                if(prev != null) {
                    prev.next = curr;
                }
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            curr.next = null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static String toString(Node node) {
        StringBuilder sb= new StringBuilder();
        while(node != null) {
            Node node1 = node;
            while (node1 != null) {
                sb.append(String.valueOf(node1.val) + ",");
                node1 = node1.next;
            }
            sb.append("#,");
            node = node.left;
        }
        return sb.toString();
    }
};
}
