//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 回溯算法
// 👍 1350 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations{
  public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.permute(new int[]{1,2,3}));

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        back_track(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0, res);

        res = new ArrayList<>(nums.length * (nums.length-1));
        bt(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0);
        return res;
    }
    public void bt(List<Integer> nums, int index) {
        if(index == nums.size()) {
            res.add(new ArrayList<>(nums));
        }
        int len = nums.size();
        for(int i = index; i< len; i++) {
            Collections.swap(nums, index, i);
            bt(nums, index + 1);
            Collections.swap(nums, index, i);
        }
    }

    public void back_track(List<Integer> nums, int index, List<List<Integer>> res) {
        if(nums.size() == index) {
            res.add(new ArrayList(nums));
            return;
        }

        for(int i = index; i < nums.size(); i++ ) {
            Collections.swap(nums, index, i);
            back_track(nums, index + 1, res);
            Collections.swap(nums, index, i);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
