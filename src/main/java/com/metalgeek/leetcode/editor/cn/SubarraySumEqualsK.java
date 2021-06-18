//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 952 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK{
  public static void main(String[] args) {
       Solution solution = new SubarraySumEqualsK().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.subarraySum(new int[]{1,1,1}, 2));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
//        return traverse(nums, k);
        return preSum(nums, k);
    }

    // 暴力遍历法, 外部从前向后, 内部从后向前
    public int traverse(int[] nums, int k) {
        int len = nums.length, res = 0;
        // 从头开始遍历, 检查每一个位置作为子数组尾部是否能满足条件
        for(int i=0; i< len; i++) {
            int sum = 0;
            // 从当前尾部向前遍历, 求和, 这样总体只要一趟
            for(int j = i; j >= 0; j--) {
                sum += nums[j];
                if(sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // 前缀和解法
    public int preSum(int[] nums, int k) {
        // 前缀和map, key为前缀和数值, value为该数值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        // 建立前缀和map, 初始化 前0个元素的和为0, 出现次数为1
        map.put(0, 1);

        int sum = 0, res = 0;
        for(int i=0; i< len; i++) {
            sum += nums[i];
            // 注意这里因为是从左向右遍历, 因此检查下标i位置的时候 sum-k 只会出现在i的左边, 因此不会把右边的值带进来, 保证了有序性
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) +1);

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
