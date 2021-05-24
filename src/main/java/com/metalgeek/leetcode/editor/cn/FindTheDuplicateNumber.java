//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 3 * 104 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以在不修改数组 nums 的情况下解决这个问题吗？ 
// 你可以只用常量级 O(1) 的额外空间解决这个问题吗？ 
// 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？ 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 1227 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class FindTheDuplicateNumber{
  public static void main(String[] args) {
       Solution solution = new FindTheDuplicateNumber().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
      System.out.println(solution.findDuplicate(new int[]{1,3,4,2,2}));
      System.out.println(solution.findDuplicate(new int[]{3,1,3,4,2}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        return quickSort(nums);
//        return binarySearch(nums);
//        return twoIndies(nums);
    }
    public int quickSort(int[] nums) {
        // 快排加一趟扫描 O(nLogn) 但改变了原始数据
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] - i - 1 < 0) {
                return nums[i];
            }
        }
        return -1;
    }

    // 辅助函数
    public int numCount(int[] nums, int n) {
        int count = 0;
        for(int i =0; i < nums.length; i++) {
            if(nums[i] <= n) {
                count ++;
            }
        }
        return count;
    }
    public int binarySearch(int[] nums) {
        // 注意性质, 由于x出现至少2次, 那么数组里小于x的数出现次数应该小于等于x-1(正好是下标), 大于x的数出现次数应该大于x. 据此正好可以二分处理

        // 注意这里二分起手式, 由于我们是对1...n的整数区间做二分, 而不是对数组下标做二分. r=nums.length -1 因为n+1个数的数组, -1=n
        int l=1, r = nums.length -1, mid = -1, ans = -1;
        while (l<=r) {
            mid = (l+r) /2;
            int cnt = numCount(nums, mid);
            if(cnt <= mid) {
                l = mid +1;
            }else {
                r = mid -1;
                // 这里要保留一下结果, 下次二分后mid可能就小于他了
                ans = mid;
            }
        }
        return ans;
    }

    public int twoIndies(int[] nums) {
        int l=0, r=0;
        do {
            // 将num[i]作为指针进行链表操作, 由于有重复元素的存在, 导致一定有环
            l = nums[l];
            r = nums[nums[r]];
        }while(nums[l] != nums[r]);
        l = 0;
        while (l != r) {
            l = nums[l];
            r = nums[r];
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
