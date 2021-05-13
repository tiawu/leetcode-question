//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1002 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray{
  public static void main(String[] args) {
       Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

       int[] test1 = new int[]{5,7,7,8,8,10}; // 8
       int[] test2 = new int[]{5,7,7,8,8,10}; // 6
       long t0 = System.currentTimeMillis();
       // Call solution here
//      System.out.println(Arrays.asList(solution.searchRange(test1, 8)));
      System.out.println(Arrays.asList(solution.searchRange(test2, 6)));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1, mid =-1, num;
        while(i <= j) {
            mid = (i + j) >> 1;
            num = nums[mid];
            if(num > target) {
                j = mid -1;
            }else if(num < target) {
                i = mid;
            }else {
                break;
            }
        }
        i = mid;
        j = mid;
        while(nums[i] == target) {
            i--;
        }
        while(nums[j] == target) {
            j++;
        }
        return new int[]{i+1, j-1};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
