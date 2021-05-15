//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1188 👎 0


package com.metalgeek.leetcode.editor.cn;
public class JumpGame{
  public static void main(String[] args) {
       Solution solution = new JumpGame().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
      System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
      System.out.println(solution.canJump(new int[]{0}));
      System.out.println(solution.canJump(new int[]{2,0,0}));
      System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        return greedyJump(nums);
    }

    // 贪心, 维护右边界
    public boolean greedyJump(int[] nums) {
        int rMost = 0, index = 0, target = nums.length -1;
        while(index <= rMost && index < nums.length) {
            rMost = Math.max(nums[index] + index, rMost);

            if(rMost >= target) {
                return true;
            }
            index++;
        }
        return false;
    }

    // 递归不太对
    public boolean recurseJump(int[] nums, int index) {
        if(index == nums.length -1) {
            return true;
        }
        int maxStep = nums[index];
        while(maxStep >= 0) {
            if((index + maxStep) > nums.length) {
                maxStep --;
            }else if (recurseJump(nums, index + maxStep--)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
