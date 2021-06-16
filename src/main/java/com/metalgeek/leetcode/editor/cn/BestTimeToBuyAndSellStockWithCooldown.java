//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 797 👎 0


package com.metalgeek.leetcode.editor.cn;
public class BestTimeToBuyAndSellStockWithCooldown{
  public static void main(String[] args) {
       Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        return dpImprove(prices);
    }

    public int dpImprove(int[] prices) {
        int len = prices.length;

        // 使用滚动变量
        int dp0, dp1, dp2;

        dp0 = 0;
        dp1 = -prices[0];
        dp2 = 0;

        for(int i =1; i < len; i++) {
            int fdp0 = Math.max(dp0, dp2);
            int fdp1 = Math.max(dp1, dp0 - prices[i]);
            int fdp2 = dp1 + prices[i];
            dp0 = fdp0;
            dp1 = fdp1;
            dp2 = fdp2;
        }
        return Math.max(dp0, dp2);
    }
    
    public int dp(int[] prices) {
//        0.不持股且当天没卖出,定义其最大收益dp[i][0];
//        1.持股,定义其最大收益dp[i][1]；
//        2.不持股且当天卖出了，定义其最大收益dp[i][2]；
        int len = prices.length;
        int[][] dp = new int[len][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for(int i =1; i < prices.length; i++) {
            int j = i-1;
            dp[i][0] = Math.max(dp[j][0], dp[j][2]);
            dp[i][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
            dp[i][2] = dp[j][1] + prices[i];
        }
        return Math.max(dp[len-1][0], dp[len-1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
