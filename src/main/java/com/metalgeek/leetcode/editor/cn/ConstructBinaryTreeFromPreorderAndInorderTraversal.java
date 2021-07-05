//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 1038 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
         Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }
//        int rootVal = preorder[0];
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i= inorder.length -1; i >= 0  ; i--) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecurse(preorder, inorder, inorderMap, 0, preorder.length -1, 0, inorder.length -1);
    }
    public TreeNode buildTreeRecurse(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int pl, int pr, int il, int ir) {
        if(pl > pr) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pl]);
        int ioIndex = inorderMap.get(node.val);
        int lNodes = ioIndex - il;
        node.left  = buildTreeRecurse(preorder, inorder, inorderMap, pl +1, pl + lNodes, il, ioIndex -1);
        node.right = buildTreeRecurse(preorder, inorder, inorderMap, pl +lNodes +1, pr, ioIndex +1, ir);
        return node;
    }

    public TreeNode buildTreeRecurse1(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int pl, int pr, int il, int ir) {
        if(pl > pr) {
            return null;
        }

        int rootVal = preorder[pl];

        // 中序遍历中根节点下标
        int inorderIndex = inorderMap.get(rootVal);
        // 左子树节点数
        int lTreeNodes = inorderIndex - il;

//        // 右子树节点数
//        int rTreeNodes = ir - inorderIndex;
//        // 左子树参数
//        int lpl = pl +1;
//        int lpr = pl + lTreeNodes;
//        int lil = il;
//        int lir = inorderIndex - 1;
//
//        // 右子树参数
//        int rpl = pl + lTreeNodes + 1;
//        int rpr = pr;
//        int ril = inorderIndex +1;
//        int rir = ir;

        TreeNode root = new TreeNode(rootVal);
        root.left   = buildTreeRecurse(preorder, inorder, inorderMap, pl + 1, pl + lTreeNodes, il, inorderIndex -1);
        root.right = buildTreeRecurse(preorder, inorder, inorderMap,  pl + lTreeNodes + 1, pr, inorderIndex +1, ir);

        // 从右计算rpl = pr - rTreeNodes + 1 = pr -(ir - inorderIndex) + 1
//        root.right = buildTreeRecurse(preorder, inorder, inorderMap, pr - ir + inorderIndex +1  , pr, inorderIndex +1, ir);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
