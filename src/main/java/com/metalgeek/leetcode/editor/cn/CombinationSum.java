//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1373 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class CombinationSum{
  public static void main(String[] args) {
       Solution solution = new CombinationSum().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
//      System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
      System.out.println(solution.combinationSum(new int[]{2,7,6,3,5,1}, 9));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 背包问题, 可以用backtrack解, 也可以用背包解法来解
    List<List<Integer>> res= new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();

        // 排序用于配合剪枝
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, list);

        return new ArrayList<>(res);
    }

    public void pack(int[] candidates, int target) {
        // 完全背包组合问题
    }

    public void backtrack(int[] candidates, int target, int index, Deque<Integer> list) {
        if(target == 0) {
            // 注意要拷贝构造
//            List<Integer> ans = new ArrayList<>(list);
//            ans.sort(Comparator.naturalOrder());
            res.add(new ArrayList<>(list));
            return;
        }
        // 下面做了剪枝以后就不需要这个判断了
//        else if(target < 0) {
//            return;
//        }

        // 最暴力的普通解法  依赖使用Set<List<Integer>>去重   大概600ms
//        for(int num : candidates) {
//            list.add(num);
//            backtrack(candidates, target - num, 0, list, res);
//            list.remove(list.size() -1);
//        }

        // 普通解法中增加过滤, 前提是数组已排序, 还是没有对结果直接去重, 大概50ms
//        for(int num : candidates) {
//            int result = target - num;
//            if(result >= 0) {
//                list.add(num);
//                backtrack(candidates, result, 0, list, res);
//                list.remove(list.size() - 1);
//            }else {
//                break;
//            }
//        }

        // 通过记忆index值来过滤重复答案, 即每轮次不会用到之前轮次的数字, 3ms
        for(int i = index; i < candidates.length; i++) {
            int result = target - candidates[i];
            // 基于数组有序且不含有重复值的前提, 如果result小于0的话, 后续的数字更大, 则都可以直接略过
            if(result >= 0) {
                list.add( candidates[i]);
                // 本深度轮次搜索仍然可以用i, 下轮次起禁用
                backtrack(candidates, result, i, list);
                list.removeLast();
            }else {
                break;
            }
        }


    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
