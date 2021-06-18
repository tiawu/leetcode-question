//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 886 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii{
  public static void main(String[] args) {
       Solution solution = new PathSumIii().new Solution();
       
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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和初始化, 为0的路径只有一条即空的
        map.put(0, 1);
        return dfs(root, targetSum, map, 0);
    }


    public int dfs(TreeNode root, int targetSum, Map<Integer, Integer> map, int sum) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        sum = root.val + sum;

        // 取前缀和减去目标路径和的点, 也就是找是否存在前置节点其前缀和等于 sum - targetSum
        res += map.getOrDefault(sum - targetSum, 0);

        // 记录当前节点的前缀和
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        res += dfs(root.left, targetSum, map, sum);
        res += dfs(root.right, targetSum, map, sum);

        // 回溯本节点的前缀和, 保证后续递归时不使用当前节点为跟的子树里的前缀和
        map.put(sum, map.get(sum) - 1);

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
