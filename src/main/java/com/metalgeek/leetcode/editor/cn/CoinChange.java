//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1282 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange{
  public static void main(String[] args) {
       Solution solution = new CoinChange().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 完全最值背包问题, target = amount, nums = coins 为完全背包可以重复取, 题目求最小值

//        首先是背包分类的模板：
//        1、0/1背包：外循环nums,内循环target,target倒序且target>=nums[i];
//        2、完全背包：外循环nums,内循环target,target正序且target>=nums[i];
//        3、组合背包：外循环target,内循环nums,target倒序且target>=nums[i];
//        4、分组背包：这个比较特殊，需要三重循环：外循环背包bags,内部两层循环根据题目的要求转化为1,2,3三种背包类型的模板
//
//        然后是问题分类的模板：
//        1、最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i], dp[i-num]+nums);
//        2、存在问题(bool)：dp[i]=dp[i]||dp[i-num];
//        3、组合问题：dp[i]+=dp[i-num];

        long[] dp = new long[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int coinLen = coins.length;
        for(int i=0; i < coinLen; i ++) {
            for(int target = 1; target <= amount; target++) {
                if(coins[i] <= target) {
                    // 此处有+1, 可能溢出Integer, 所以要用long来存dp
                    dp[target] = Math.min(dp[target], dp[target - coins[i]] +1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int)dp[amount];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
