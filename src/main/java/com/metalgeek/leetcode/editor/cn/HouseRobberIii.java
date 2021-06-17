//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
// 示例 1:
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//输出: 7
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
//
// 示例 2:
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
//
// Related Topics 树 深度优先搜索 动态规划
// 👍 877 👎 0


package com.metalgeek.leetcode.editor.cn;

import com.metalgeek.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii{
    public static void main(String[] args) {
         Solution solution = new HouseRobberIii().new Solution();

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
    public int rob(TreeNode root) {
//        return robRecurse(root);
        Map<TreeNode, Integer> map = new HashMap<>();
        return robHashmap(root, map);
//        int[] res = robInternal(root);
//        return Math.max(res[0], res[1]);
    }

    // 超时
    public int robRecurse(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int rootVal = root.val
                + (root.left == null ? 0 : robRecurse(root.left.left) + robRecurse(root.left.right))
                + (root.right == null ? 0 : robRecurse(root.right.left) + robRecurse(root.right.right));
        int childVal = robRecurse(root.left) + robRecurse(root.right);
        return rootVal > childVal ? rootVal : childVal;
    }

    public int robHashmap(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) {
            return 0;
        }
        if(map.containsKey(root)) {
            return map.get(root);
        }

        int rootVal = root.val
                + (root.left == null ? 0 : robHashmap(root.left.left, map) + robHashmap(root.left.right, map))
                + (root.right == null ? 0 : robHashmap(root.right.left, map) + robHashmap(root.right.right, map));
        int childVal = robHashmap(root.left, map) + robHashmap(root.right, map);
        int res = rootVal > childVal ? rootVal : childVal;
        map.put(root, res);
        return res;
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}
