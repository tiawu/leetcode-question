//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//
//
// 提示：
//
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
//
//
//
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
// Related Topics 树 二分查找
// 👍 390 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementInABst{
    public static void main(String[] args) {
         Solution solution = new KthSmallestElementInABst().new Solution();

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
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        recurse(root, k);
        return res;
//        return iterate(root, k);
    }


    public int iterate(TreeNode root, int k) {
//        int[] inOrder = new int[k];
        Deque<TreeNode> stack = new LinkedList<>();

        while(true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(0 == --k) {
                return root.val;
            }
            root = root.right;
        }
    }

    public void recurse(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        recurse(root.left, k);
        if(++count == k) {
            res = root.val;
        }else {
            recurse(root.right, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
