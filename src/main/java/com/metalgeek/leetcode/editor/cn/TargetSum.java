//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 809 👎 0


package com.metalgeek.leetcode.editor.cn;
public class TargetSum{
  public static void main(String[] args) {
       Solution solution = new TargetSum().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 分割子集的背包问题, x y子集, x + y = sum(nums), x-y = target; x = (sum + target) /2;
    public int findTargetSumWays(int[] nums, int target) {
        // 0/1背包组合问题
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int dpTarget = (sum + target);

        // 数组和小于目标值, 或sum + target 为奇数, 则条件无法满足
        if(dpTarget %2 == 1 || sum < target) {
            return 0;
        }

        // 设置目标值为(sum + target) /2, 初始化dp数组, dp[0] = 1 即什么都不选, 因此只有一种
        dpTarget = dpTarget >>1;
        int[] dp = new int[dpTarget+1];
        dp[0] = 1;

        for(int num : nums) {
            for(int i=dpTarget; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[dpTarget];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
