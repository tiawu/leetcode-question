//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 1060 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree{
  public static void main(String[] args) {
       Solution solution = new ValidateBinarySearchTree().new Solution();

       TreeNode root = new TreeNode(5);
       root.left = new TreeNode(1);
       TreeNode r = new TreeNode(4);
       r.left = new TreeNode(3);
       r.right = new TreeNode(6);

       root.right = r;

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.isValidBST(root));

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
    private long pre;

    public boolean isValidBST(TreeNode root) {
        // 用Integer.MIX_VALUE 会导致中序遍历的第一个节点等于{Integer.MIX_VALUE}这样的Case失效, 所以要取比它更小的来测
        // 也就是用Long, 可以取LONG.MIN_VALUE
        pre = Long.MIN_VALUE;
//        return isValidBSTRecurse(root);
        return isValidBSTIterate(root);
    }

    public boolean isValidBSTIterate(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int pre = Integer.MIN_VALUE;
        while(node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(node.val < pre) {
                return false;
            }
            node = node.right;
        }
        return true;
    }

    // 采用中序遍历, 将前一步遍历到的节点数值存下来, 与下一个节点进行比较即可
    public boolean isValidBSTRecurse(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isValidBSTRecurse(root.left)){
            return false;
        }

        if(pre >= root.val)
            return false;
        pre = root.val;

        // 形式等价于 左子树递归, 非法返false, 遍历完毕返true
        return isValidBSTRecurse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
