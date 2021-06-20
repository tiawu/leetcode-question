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
      int[] test3 = new int[]{1}; // 6
      int[] test4 = new int[]{1,4};
       long t0 = System.currentTimeMillis();
       // Call solution here
//      System.out.println(Arrays.asList(solution.searchRange(test1, 8)));
//      System.out.println(Arrays.asList(solution.searchRange(test2, 6)));
//      System.out.println(Arrays.asList(solution.searchRange(test3, 1)));
      System.out.println(Arrays.asList(solution.searchRange(test4, 4)));

      long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {-1, -1};
        }
        int l=0, r = nums.length -1, mid=0;
        while(l < r) {
            mid = l + (r - l) /2;
//            if(nums[mid] == target) {
//                break;
//            }else
                if (nums[mid] >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        mid = l;
        if(nums[mid] == target) {
            l = mid; r = mid;
            while (l >= 0 && nums[l] == nums[mid]){
                l--;
            }
            while (r < nums.length && nums[r] == nums[mid]){
                r++;
            }
            return new int[] {l +1, r -1};
        }

        return new int[] {-1, -1};
    }


    public int[] solve1(int[] nums, int target) {
        if(nums.length ==0) {
            return new int[]{-1, -1};
        }

        int l = 0, r = nums.length - 1, mid;
        int left;
        while(l < r) {
            mid = l + (r - l) /2;
            if(nums[mid] >= target) {
                r = mid;
            }else {
                l = mid +1;
            }
        }
        left = l;
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        l = 0; r = nums.length - 1;
        while(l < r) {
            mid = l + (r - l +1) /2;
            if(nums[mid] <= target) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }

        return new int[]{left, r};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
