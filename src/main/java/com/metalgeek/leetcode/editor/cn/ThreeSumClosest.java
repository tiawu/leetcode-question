//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 787 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest{
  public static void main(String[] args) {
       Solution solution = new ThreeSumClosest().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
      System.out.println(solution.threeSumClosest(new int[]{1,1,-1}, 1));
      System.out.println(solution.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len1 = nums.length -1, len2 = nums.length -2;
        int i, j, k;
        int tmp = 100000, sum;
        Arrays.sort(nums);

        for(i=0; i < len2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            j = i+1;
            k = len1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }

                if(Math.abs(tmp - target) > Math.abs((sum - target))) {
                    tmp = sum;
                }

                if(sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }

        }
        return tmp;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
