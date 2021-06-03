//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1148 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation{
  public static void main(String[] args) {
       Solution solution = new NextPermutation().new Solution();
       int[] test = new int[]{1,2,3};

       long t0 = System.currentTimeMillis();
       // Call solution here
      solution.nextPermutation(test);
       System.out.println(Arrays.deepToString(Arrays.stream(test).boxed().toArray()));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length -1;
        // 寻找最大的k, 使nums[k} < nums[k+1]
        int k = -1;
        for(int i = len; i >0; i--) {
            if(nums[i] > nums[i-1]) {
                k = i-1;
                break;
            }
        }
        // 找不到k, 说明数组已经完全降序排列, 需要反转后直接返回
        if(k == -1) {
            revertArray(nums, 0, len);
            return;
        }

        // 找比nums[k] 大的最大的下标l
        int l;
        for(l = len; l >=0; l--) {
            if(nums[l] > nums[k]) {
                break;
            }
        }
        // 交换k与l的值, 然后翻转 k +1 至len的数字, 使其变成递增的
        int tmp;
        tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;

        revertArray(nums, k+1, len);
    }

    public void revertArray(int[] nums, int l, int r) {
        if(l >= r || l < 0 || r >= nums.length) {
            return;
        }

        int tmp;
        while (l < r) {
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
