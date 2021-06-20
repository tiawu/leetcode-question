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

         int [] test1 = new int[]{-1,0,1,2,-1,-4};
        int [] test2 = new int[]{0,0,0};
        int [] test3 = new int[]{1,2,-2,-1};
        int [] test4 = new int[]{0,0,0,0};

         long t0 = System.currentTimeMillis();
         // Call solution here
        System.out.println(solution.threeSum(test1));
        System.out.println(solution.threeSum(test2));
        System.out.println(solution.threeSum(test3));
        System.out.println(solution.threeSum(test4));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        // 先排序, 选中一个数, 再从后面挑两个数(双指针), 数字相同的跳过.
        for(int i=0; i< nums.length -1; i++) {
            // 目标和为0, 因此选择第一个数要求为负数
            if(nums[i] > 0) {
                continue;
            }else if (i > 0 && nums[i] == nums[i-1]) {
                // 跳过相同的数字
                continue;
            }

            // 转化为两数相加问题, 目标和为-nums[i]
            int target = - nums[i];

            for(int j = i +1, k = nums.length - 1; j < nums.length; j++) {
                // 跳过相同数字
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int numk = target - nums[j];
                while (k > j && nums[k] > numk) {
                    k--;
                }

                if(k != j && nums[k] == numk) {
                    // 找到一条答案
                    res.add(Arrays.asList(nums[i], nums[j], numk));
                }
            }
        }
        return res;

    }

    public List<List<Integer>> solve1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        int len = nums.length, len1 = len -1, k, numk, tmp;

        for(int i=0; i < len1; i++){
            if(nums[i] > 0) {
                continue;
            }else if(i >0 && nums[i] == nums[i-1]) {
                continue;
            }

            k = len1;
            tmp = -nums[i];

            for(int j= i + 1; j < len1; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                numk = tmp - nums[j];
                while( k > j && nums[k] > numk) {
                    k--;
                }
                if(k != j && nums[k] == numk) {
                    res.add(Arrays.asList(nums[i], nums[j], numk));
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
