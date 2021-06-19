//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 
// 👍 759 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray{
  public static void main(String[] args) {
       Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        return solve1(nums);
        return solve2(nums);
    }

    public List<Integer> solve1(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int n = nums.length;
        int[] tmp = new int[n+1];
        for(int num: nums) {
            tmp[num]++;
        }
        for(int i =1; i < tmp.length; i++) {
            if(tmp[i] ==0) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> solve2(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int len = nums.length;
        for(int n: nums) {
            // 就地修改, 将已出现数字的数值修改为负数, 避免溢出
            int num = Math.abs(n)-1;
            if(nums[num] > 0) {
                nums[num] = - nums[num];
            }
        }
        for(int i=0; i < len; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
