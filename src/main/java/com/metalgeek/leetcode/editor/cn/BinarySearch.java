//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。
//
//
//示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
//
//
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。
//
// Related Topics 二分查找
// 👍 236 👎 0


package com.metalgeek.leetcode.editor.cn;
public class BinarySearch{
    public static void main(String[] args) {
         Solution solution = new BinarySearch().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 2));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length -1, mid;
        if(target < nums[l] || target > nums[r]) {
            return -1;
        }

        while(l <= r) {
            mid = l + (r -l) /2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                r = mid -1;
            }else if (nums[mid] < target) {
                l = mid +1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
