//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 数组 
// 👍 547 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray{
  public static void main(String[] args) {
       Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        return solution2(nums);
    }
    public int solution2(int[] nums) {
        int len = nums.length, end = 0, start = len -1;
        int[] tmpNums = nums.clone();
        Arrays.sort(tmpNums);

        for(int i =0; i < len; i++) {
            if(nums[i] != tmpNums[i]) {
                start = Math.min(start, i);
                end   = Math.max(end, i);
            }
        }
        return end - start > 0 ? end - start + 1 : 0;
    }

    public int solution1(int[] nums) {
        int len = nums.length, max = Integer.MIN_VALUE, maxStart = -1;
        int i =0, j = i+1;
        int start = -1, end = -1;
        for(; j < len; i++, j++) {
            if(max < nums[i]) {
                max = nums[i];
                maxStart = i;
            }
            max = Math.max(max, nums[i]);
            if(max > nums[j]) {
                if(start == -1) {
                    start = maxStart;
                }
                end = j;
            }
        }
        return start == end ? 0 : end - start + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
