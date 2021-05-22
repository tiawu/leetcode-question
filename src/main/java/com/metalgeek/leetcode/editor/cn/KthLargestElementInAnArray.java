//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法
// 👍 1089 👎 0


package com.metalgeek.leetcode.editor.cn;
public class KthLargestElementInAnArray{
    public static void main(String[] args) {
         Solution solution = new KthLargestElementInAnArray().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
//        quickSort(nums, 0, nums.length -1);
        quickSelect(nums, 0, nums.length -1, nums.length -k);
        return nums[nums.length - k];

    }

    public void quickSelect(int[] nums, int l, int r, int targetIndex) {
        if(l<r){
            swap(nums, l, (l + r) >> 1);

            int i=l, j =r, tmp = nums[l];
            while (i < j) {
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
            // 通过排序元素下标确定剪枝方向
            if(i == targetIndex) {
                return;
            }else if (i > targetIndex){
                quickSort(nums, l, i-1);
            }else {
                quickSort(nums, j+1, r);
            }
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if(l<r){

            swap(nums, l, (l + r) >> 1);

            int i=l, j =r, tmp = nums[l];
            while (i < j) {
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
            quickSort(nums, l, i-1);
            quickSort(nums, j+1, r);
        }
    }
    public void swap(int[] nums, int src, int dest) {
        // 额外空间交换.
        int tmp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = tmp;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
