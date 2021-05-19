//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 966 👎 0


package com.metalgeek.leetcode.editor.cn;
public class RotateArray{
  public static void main(String[] args) {
       Solution solution = new RotateArray().new Solution();
       
       long t0 = System.currentTimeMillis();
      solution.rotate(new int[]{-1,-100,3,99}, 2);
       // Call solution here
       System.out.println("");

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        // 方案1, 每次右循环1个, 循环k次(代码略...)
        int len = nums.length;

        // 方案2, 建一个新数组, 从(i + k) %len位置开始遍历老数组, 向新数组的i(0...n-1)位置写入
//        int[] res = new int[len];
//        for(int i=0; i<len; i++) {
//            res[(i + k) % len] = nums[i];
//        }
//
//        System.arraycopy(res, 0, nums, 0, len);

        // 方案3, 两次数组翻转. 先翻转 (0, len-1), 然后翻转(0, k%len -1) (k %len, len-1)
        // 此方案空间只用O(1), 也是遍历两遍
        revert(nums, 0, len -1);
        revert(nums, 0, k % len -1);
        revert(nums, k %len, len-1);


    }
    public void revert(int[] nums, int l, int r) {
        int tmp;
        while(l < r) {
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
