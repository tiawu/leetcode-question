//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 836 👎 0


package com.metalgeek.leetcode.editor.cn;
public class PartitionEqualSubsetSum{
  public static void main(String[] args) {
       Solution solution = new PartitionEqualSubsetSum().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 分割子集的存在背包问题, x y子集, x + y = sum(nums), x-y = 0; x = (sum + 0) /2 = sum /2;
    public boolean canPartition(int[] nums) {
        // 0/1背包存在问题, 是494题目标和的一个特例
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        // 背包和为奇数, 则无法分为两个等和子集
        if(sum % 2 ==1) {
            return false;
        }

        // 取x = sum/2, 初始化dp数组
        sum = sum >> 1;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for(int num : nums) {
            for(int i=sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }

        return dp[sum];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
