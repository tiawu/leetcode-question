//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
// 👍 977 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement{
    public static void main(String[] args) {
         Solution solution = new MajorityElement().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // 解法1, 哈希表
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int n : nums) {
//            if(map.containsKey(n)){
//                map.put(n, map.get(n) + 1);
//            }else {
//                map.put(n, 1);
//            }
//        }
//        int maxv= Integer.MIN_VALUE, maxk = nums[0];
//        for(Map.Entry<Integer, Integer>entry : map.entrySet()) {
//            if(entry.getValue() > maxv){
//                maxv = entry.getValue();
//                maxk = entry.getKey();
//            }
//        }
//        return maxk;

        // 试下Stream, 跟手写遍历差不多, 并行流更慢
//        return map.entrySet().stream()
//                .max(Comparator.comparingInt(entry -> {return entry.getValue();}))
//                .get().getKey();

        // 解法2, 排序. len/2一定是众数(题目保证一定存在)
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
