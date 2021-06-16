//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Related Topics 并查集 数组
// 👍 802 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
         Solution solution = new LongestConsecutiveSequence().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num: nums) {
            set.add(num);
        }

        int res = 0;
        for(Integer num : set) {
            // 当数组中存在当前数值 -1 的数时, 说明当前数值不是序列头, 应跳过
            if(set.contains(num -1)) {
                continue;
            }
            // 当前数值是一个序列的头, 开始遍历后续的数字找到序列长度
            int tmpLen = 1;
            for(int i = num+1; set.contains(i); i++) {
                    tmpLen++;
            }
            if(res < tmpLen) {
                res = tmpLen;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
