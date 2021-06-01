//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 885 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class SortColors{
  public static void main(String[] args) {
       Solution solution = new SortColors().new Solution();
       int[] test1 = new int[]{2,0,2,1,1,0};
       long t0 = System.currentTimeMillis();
       // Call solution here
      solution.sortColors(test1);
       System.out.println(Arrays.asList(test1));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        // API直接用
//        Arrays.sort(nums);
        // 手写一个快排
//        quickSort(nums, 0, nums.length -1);
        qs(nums, 0, nums.length -1);
    }

    // 交换辅助函数
    public void swap(int[] nums, int src, int dest) {
        // 额外空间交换.
        int tmp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = tmp;

        //也可以用异或算法, 不过效率不见得高
//      nums[src] = nums[src] ^ nums[dest];
//      nums[dest] = nums[dest] ^ nums[src];
//      nums[src] = nums[src] ^ nums[dest];
    }

    public void qs(int[] nums, int l, int r) {
        if(l < r) {
            // 交换首位和中间位置
            swap(nums, l, (l + r) >> 1);

            int tmp = nums[l], i = l, j = r;
            while(i < j) {
                while(i < j && nums[j] >= tmp) {
                    j--;
                }
                if(i < j) {
                    nums[i++] = nums[j];
                }

                while(i < j && nums[i] <= tmp) {
                    i++;
                }
                if(i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = tmp;
            qs(nums, l, i-1);
            qs(nums, j+1, r);
        }
    }

    // 快速排序, 参数左右边界
    public void quickSort(int[] nums, int l, int r) {
        if(l < r) {
            // 从头部取个数出来. 也可以取中间位置的数, 做一下 l <-> (l + r) >>1的交换然后从头取就可以
            swap(nums, l, (l + r) >> 1);
            int i=l, j=r, tmp = nums[l];
            while(i < j) {
                // 从右向左扫描j, 找到第一个小于tmp的数, 放到nums[i]里, i右移
                while(i < j && nums[j] >= tmp) {
                    j--;
                }
                if(i < j) {
                    nums[i++] = nums[j];
                }

                // 从左向右扫描i, 找到第一个大于tmp的数, 放到nums[j]里, j左移
                while(i < j && nums[i] <= tmp) {
                    i++;
                }
                if(i < j) {
                    nums[j--] = nums[i];
                }
            }
            // 循环结束时 i == j, 两指针相遇, 相遇处放原始取出来的tmp;
            nums[i] = tmp;

            // 分治处理i == j的左右两边子区间
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
