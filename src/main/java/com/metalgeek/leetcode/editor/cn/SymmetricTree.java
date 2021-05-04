//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1367 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.Stack;

public class SymmetricTree{
  public static void main(String[] args) {
       Solution solution = new SymmetricTree().new Solution();
       
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
    public boolean isSymmetric(TreeNode root) {
        return checkNodeRecurse(root, root);
//        return checkNodeIterate(root, root);
    }
    public boolean checkNodeRecurse(TreeNode ln, TreeNode rn) {
        if(ln == null && rn == null)
            return true;
        if(ln == null || rn == null){
            return false;
        }
        return ln.val == rn.val && checkNodeRecurse(ln.left, rn.right) && checkNodeRecurse(ln.right, rn.left);
    }
    public boolean checkNodeIterate(TreeNode ln, TreeNode rn){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(ln);
        stack.push(rn);
        while(!stack.empty()){
            rn = stack.pop();
            ln = stack.pop();
            if(ln == null && rn == null) {
                continue;
            }else if ((ln == null || rn == null) || ln.val != rn.val) {
                return false;
            }

            stack.push(ln.left);
            stack.push(rn.right);

            stack.push(rn.left);
            stack.push(ln.right);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
