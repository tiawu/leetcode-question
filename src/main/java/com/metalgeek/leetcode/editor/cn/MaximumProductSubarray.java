//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1106 👎 0


package com.metalgeek.leetcode.editor.cn;
public class MaximumProductSubarray{
  public static void main(String[] args) {
       Solution solution = new MaximumProductSubarray().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.maxProduct(new int[]{3, -1, 4}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        // DP 
        int len = nums.length, max = Integer.MIN_VALUE;
        int[] fMax = new int[len+1], fMin = new int[len+1];

        fMax[0] = 1;
        fMin[0] = 1;

        for(int i =0; i < len; i++) {
            fMax[i+1] = Math.max(fMax[i] * nums[i], Math.max(fMin[i] * nums[i], nums[i]));
            fMin[i+1] = Math.min(fMax[i] * nums[i], Math.min(fMin[i] * nums[i], nums[i]));
            max = Math.max(max, fMax[i+1]);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
