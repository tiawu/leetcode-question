//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 595 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal{
  public static void main(String[] args) {
       Solution solution = new BinaryTreePostorderTraversal().new Solution();
       
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

//        recurse(root, res);
        iterate(root, res);

        return res;
    }

    public void recurse(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        recurse(root.left, res);
        recurse(root.right, res);
        res.add(root.val);
    }

    public void iterate(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            res.add(0, tmp.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
