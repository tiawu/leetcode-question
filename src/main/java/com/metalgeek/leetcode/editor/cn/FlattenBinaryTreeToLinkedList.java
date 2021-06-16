//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 树 深度优先搜索
// 👍 825 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
         Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();

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
    public void flatten(TreeNode root) {
//        flattenDfs(root);
        flattenPredecessor(root);
    }

    // 前驱节点
    public void flattenPredecessor(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null) {
            // 仅当左子树不为空时, 寻找右子树的前驱节点(左子树的最右侧节点)
            if(curr.left != null) {
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 找到前驱节点后, 将右子树挂到前驱节点的右边
                pre.right = curr.right;
                // 当前节点已经没有右子树了, 将左子树转到右边
                curr.right = curr.left;
                curr.left = null;
            }
            // 已将左子树搬到右边, 遍历右子树
            curr = curr.right;
        }

    }

    public void flattenDfs(TreeNode root) {
        if (root != null) {
            List<TreeNode> list = new LinkedList<>();
            dfs(root, list);
            TreeNode prev = list.get(0);
            list.remove(0);
            for (TreeNode node : list) {
                prev.left = null;
                prev.right = node;
                prev = node;
            }
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
