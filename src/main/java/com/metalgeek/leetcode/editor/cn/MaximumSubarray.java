//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治算法 动态规划
// 👍 3153 👎 0


package com.metalgeek.leetcode.editor.cn;
public class MaximumSubarray{
  public static void main(String[] args) {
       Solution solution = new MaximumSubarray().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], max = res;
        for(int i=1; i<nums.length; i++) {
            res = Math.max(res + nums[i], nums[i]);
            if(res > max) max = res;
        }
        return max;
    }
    public int maxSubArray1(int[] nums) {
        // 核心公式 sum(i) = max(sum(i-1) + num[i], num[i])
        int ret = nums[0], len = nums.length, max = ret;

        for(int i = 1; i < len; i++) {
            ret = Math.max(nums[i], ret + nums[i]);
            if(ret > max) max = ret;
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
