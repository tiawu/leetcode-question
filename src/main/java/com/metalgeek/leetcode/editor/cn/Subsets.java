//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 1174 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets{
  public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.subsets(new int[]{1,2,3}));

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
//        back_track(nums, 0, new ArrayList<>(), res);

        bt(nums, 0, new ArrayList<>(), res);
        return res;
    }
    public void bt(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        bt(nums, index+1, list, res);
        list.add(nums[index]);
        bt(nums, index+1, list, res);
        list.remove(list.size()-1);
    }

    public void back_track(int[] nums, int depth, List<Integer> list,  List<List<Integer>> res) {
        if(depth == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        back_track(nums, depth +1, list, res);
        list.add(nums[depth]);
        back_track(nums, depth +1, list, res);
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
