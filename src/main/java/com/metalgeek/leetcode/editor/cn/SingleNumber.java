//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1841 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber{
  public static void main(String[] args) {
       Solution solution = new SingleNumber().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>(nums.length);
//        for (int num : nums) {
//            if(!set.add(num))
//                set.remove(num);
//        }
//        return set.iterator().next().intValue();

        // 异或解法真是神来之笔
        int ret = 0;
        for(int num: nums){
            ret = ret ^ num;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
