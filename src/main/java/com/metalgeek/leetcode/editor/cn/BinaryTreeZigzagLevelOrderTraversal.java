//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 442 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
         Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        r.left = new TreeNode(15);
        r.right = new TreeNode(7);

        root.right = r;

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.zigzagLevelOrder(root));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrderResultDeque(root);
//        return zigzagLevelOrderDeque(root);
    }

    // 按锯齿形方式控制节点访问顺序, 按访问顺序直接插入结果
    public List<List<Integer>> zigzagLevelOrderDeque(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if(root != null)
            queue.add(root);
        // 插入方向控制
        boolean leftToRight = true;

        TreeNode curr;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>(len);
            if(leftToRight){
                // 奇数层从头部取本层节点, 然后子节点按层序自左向右插入到队列尾部,
                for(int i=0; i< len; i++) {
                    curr = queue.pollFirst();
                    list.add(curr.val);
                    if(curr.left != null) {
                        queue.addLast(curr.left);
                    }
                    if(curr.right != null) {
                        queue.addLast(curr.right);
                    }
                }
            }else {
                // 偶数层从尾部取节点(逆层序访问), 然后子节点按层序先右后左插入到队列头部,
                for(int i=0; i< len; i++) {
                    curr = queue.pollLast();
                    list.add(curr.val);
                    // 奇数层的节点要先压栈右节点, 再压左节点
                    if(curr.right != null) {
                        queue.addFirst(curr.right);
                    }
                    if(curr.left != null) {
                        queue.addFirst(curr.left);
                    }
                }
            }

            // 保存本层结果, 进入下一层时反转顺序
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }

    // 按层序正常遍历, 插入结果时控制方向并用链表插入头/尾
    public List<List<Integer>> zigzagLevelOrderResultDeque(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null)
            queue.add(root);
        // 插入方向控制
        boolean leftToRight = true;

        TreeNode curr;
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
                for(int i=0; i< len; i++) {
                    curr = queue.poll();
                    if(leftToRight){
                        // 奇数层从按访问顺序插入队列尾部即为正序
                        list.addLast(curr.val);
                    }else {
                        // 偶数层从按访问顺序插入队列头部即为逆序
                        list.addFirst(curr.val);
                    }
                    if(curr.left != null) {
                        queue.add(curr.left);
                    }
                    if(curr.right != null) {
                        queue.add(curr.right);
                    }
            }

            // 保存本层结果, 进入下一层时反转顺序
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
