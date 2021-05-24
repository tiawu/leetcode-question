//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1628 👎 0


package com.metalgeek.leetcode.editor.cn;
public class LongestIncreasingSubsequence{
  public static void main(String[] args) {
       Solution solution = new LongestIncreasingSubsequence().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        // DP, 状态转移方程 dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
        int len = nums.length, res = 1;

        // 初始设置每个单独的数字都为长度1的子序列
        int[] f = new int[len];
        for(int i =0; i < len; i++) {
            f[i] = 1;
        }

        for(int i=0; i < len; i++) {
            for(int j=0; j < i; j++) {
                // j从0遍历到i-1, 若nums[i] > nums[j] 则可以将其加入子序列, 求最大子序列长度
                if(nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] +1);
                }
            }
            // 更新全局最长子序列长度
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
