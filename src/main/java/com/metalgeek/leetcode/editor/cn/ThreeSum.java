//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3331 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class ThreeSum{
    public static void main(String[] args) {
         Solution solution = new ThreeSum().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        int len = nums.length, leni = len - 2, lenj = len -1;
        int numi = 0, numj, numk;

        for(int i=0; i < leni; i++){
            if(i >0 && nums[i] == numi) {
                continue;
            }

            numi = nums[i];
            int k = ;


            for(int j= i + 1; j < lenj; j++) {
                numj = nums[j];
                numk = 0 - numi - numj;
                if(map.containsKey(numk)) {
                    Set<Integer> kIndices = map.get(numk);
                    for(int index : kIndices) {
                        if(index > j) {
                            res.add(Arrays.asList(numi, numj, numk));
                        }
                    }
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
