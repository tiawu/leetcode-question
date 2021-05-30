//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 858 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum{
  public static void main(String[] args) {
       Solution solution = new FourSum().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.fourSum(new int[]{2,2,2,2,2}, 8));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length, len3 = nums.length -3, len2 = nums.length -2;
        Arrays.sort(nums);

        for(int i =0; i<len3; i++) {
//            while(i>0 && i < len3 &&nums[i] == nums[i-1]) {
//                i++;
//            }
            if(i >0 && nums[i] == nums[i-1])
                continue;
            for(int j =i+1; j<len2; j++) {
//                while(j>i+1 && j < len2 && nums[j] == nums[j-1]) {
//                    j++;
//                }
                if (j>i+1 && nums[j] == nums[j-1])
                    continue;
                int sum1 = nums[i] + nums[j];

                // 用双指针减少一重循环, 约20ms
                int k = j+1, l = len -1;
                while(k < l) {
                    int sum = sum1+ nums[k] + nums[l];
                    if(sum > target) {
                        while (k < l && nums[l] == nums[--l]);
                    }else if(sum < target){
                        while (k < l && nums[k] == nums[++k]);
                    }else {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                        if(!res.contains(list)) {
                            res.add(list);
//                        }
                        k++;
                    }
                }

                // 使用三四重循环, 约400多ms
//                for(int k =j+1; k<len; k++) {
//                    while(k>j+1 && k < len-1 && nums[k] == nums[k-1]) {
//                        k++;
//                    }
//                    for(int l =k+1; l<len; l++) {
//                        if((sum1+ nums[k] + nums[l]) == target) {
//                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                            if(!res.contains(list)) {
//                                res.add(list);
//                            }
//                        }
//                    }
//                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
