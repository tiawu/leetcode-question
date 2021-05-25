//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
//
//
// 示例 2：
//
//
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 104
// 0 <= nums[i] <= 5000
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
//
//
//
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
// Related Topics 排序
// 👍 254 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class WiggleSortIi{
    public static void main(String[] args) {
         Solution solution = new WiggleSortIi().new Solution();

        int[] test = new int[]{1,4,3,4,1,2,1,3,1,3,2,3,3};
//        int[] test = new int[]{1,5,1,1,6,4};
//        {1,5,1,1,6,4}  len = 6, len /2 =  3 , (len -1)/2 = 2
//        {1,5,1,1,6}    len = 5, len /2 =  2 , (len -1)/2 = 2

         long t0 = System.currentTimeMillis();
         // Call solution here
        System.out.println(Arrays.deepToString(Arrays.stream(test).boxed().toArray()));
        Arrays.sort(test);
        System.out.println(Arrays.deepToString(Arrays.stream(test).boxed().toArray()));
        solution.wiggleSort(test);
         System.out.println(Arrays.deepToString(Arrays.stream(test).boxed().toArray()));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len];
        System.arraycopy(nums, 0, tmp, 0, len);

        Arrays.sort(tmp);
        int mid = (len-1) /2;
        int l = mid, r = len -1, i =0;
        while (l >= 0 && r >= mid) {
            if(i < len) {
                nums[i++] = tmp[l--];
            }
            if(i < len) {
                nums[i++] = tmp[r--];
            }
        }
        if(l==0 && r < mid) {
            nums[i++] = tmp[0];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
