//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 943 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray{
  public static void main(String[] args) {
       Solution solution = new MergeSortedArray().new Solution();

      int[] n1 = new int[]{2,0};
      int[] n2 = new int[]{1};

       long t0 = System.currentTimeMillis();
       // Call solution here
      solution.merge(n1, 1, n2, 1);

       long t1 = System.currentTimeMillis();
      System.out.println(Arrays.toString(n1));
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, mn = m+n-1;
        while (mn >= 0) {
            if(j==-1) {
                nums1[mn--] = nums1[i--];
            }else if(i==-1){
                nums1[mn--] = nums2[j--];
            }else {
                nums1[mn--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, mn= m+n -1;
        while(i >=0 || j >= 0) {
            if(i == -1) {
                nums1[mn--] = nums2[j--];
            }else if(j == -1){
                nums1[mn--] = nums1[i--];
            }else {
                nums1[mn--] = nums1[i] >= nums2[j] ? nums1[i--]: nums2[j--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
