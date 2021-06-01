//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
//
//
//
// 示例 1:
//
//
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
//
// 示例 2:
//
//
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length <= nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 104
// nums1和nums2中所有整数 互不相同
// nums1 中的所有整数同样出现在 nums2 中
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
// Related Topics 栈
// 👍 429 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElementI{
    public static void main(String[] args) {
         Solution solution = new NextGreaterElementI().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = nextGreaterElementMap(nums2);
        Map<Integer, Integer> map = nextGreaterElementMapOrder(nums2);

        int len = nums1.length;
        int[] res = new int[len];
        for(int i=0; i < len; i++ ) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public int[] nextGreaterElementArray(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();

        for(int i = nums.length -1; i >=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // 用数组方式返回
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            // 这里放入下一个更大元素, 也可以放下标方便下标相关的计算
            stack.push(nums[i]);
        }
        return res;
    }

    public Map<Integer, Integer> nextGreaterElementMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        // 这里用逆序遍历方式建立单调递减栈
        for(int i = nums.length -1; i >=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                // 这里是将当前游标元素与栈顶的元素比较后, 将小于当前元素的栈内元素弹出, 因为是从后向前扫描, 找到的第一个大于等于当前元素的即为第一个
                stack.pop();
            }

            // 这里用map方式返回结果, 方便查询
            if(!stack.isEmpty()) {
                map.put(nums[i], stack.peek());
            }
            // 这里放入下一个更大元素, 也可以放下标方便下标相关的计算
            stack.push(nums[i]);
        }
        return map;
    }

        public Map<Integer, Integer> nextGreaterElementMapOrder(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Deque<Integer> stack = new LinkedList<>();
            int len = nums.length;

            // 这里用正序序遍历方式建立单调递减栈
            for(int i = 0; i < len; i++) {
                while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                    // 这里是取栈里的元素与当前游标元素比较后, 将栈里元素取出后加入map
                    map.put(stack.pop(), nums[i]);
                }

                // 这里放入下一个更大元素, 也可以放下标方便下标相关的计算
                stack.push(nums[i]);
            }
            return map;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
