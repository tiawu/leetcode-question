//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true
// ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
//
//
// 示例 2：
//
//
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组
//
// 示例 3：
//
//
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
// 👍 310 👎 0


package com.metalgeek.leetcode.editor.cn;
public class IncreasingTripletSubsequence{
    public static void main(String[] args) {
         Solution solution = new IncreasingTripletSubsequence().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, mid = small, len = nums.length;
        for(int i =0; i< len; i++) {
            int num = nums[i];
            if(num <= small) {
                small = num;
            }else if (num <= mid) {
                mid = num;
            }else {
                // num > mid, 因为最坏情况下small和mid都是Int.Max, 不存在比他大的Int数了, 所以这种情况下不会走到这里,
                // 所以mid一定小于 Int.max, 也就是有mid值, 也就是我们找到了 large, 存在该三元组的子序列
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
