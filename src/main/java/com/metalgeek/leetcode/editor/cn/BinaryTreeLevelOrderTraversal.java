//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 871 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.ListNode;
import com.metalgeek.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal{
  public static void main(String[] args) {
       Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");

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
    // BFS广度优先搜索 -> Level Order 层序遍历(记录每层的数量n后, 按n内循环一次遍历)

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = null;
        stack.add(root);
        while (!stack.isEmpty()) {
            List<Integer> level = new ArrayList<>(stack.size());
            for(int i = stack.size(); i> 0; i--) {
                node = stack.pollFirst();
                level.add(node.val);

                if(node.left != null)
                    stack.addLast(node.left);
                if(node.right != null)
                    stack.addLast(node.right);
            }
            res.add(level);
        }
        return res;
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) {
            queue.add(root);
        }

        int n;
        TreeNode curr;
        while(!queue.isEmpty()) {
            n = queue.size();
            List<Integer> list = new ArrayList<>(n);

            for(; n>0; n--) {
                curr = queue.poll();
                list.add(curr.val);

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
