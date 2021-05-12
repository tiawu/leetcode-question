//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 487 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
         Solution solution = new IntersectionOfTwoArraysIi().new Solution();

        int[] n1=new int[]{1,2,2,1},  n2=new int[]{2,2};
//        int[] n1=new int[]{4,9,5},  n2=new int[]{9,4,9,8,4};
         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.intersect(n1, n2));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return hashAns(nums1, nums2);
    }

    public int[] hashAns(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return hashAns(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] tmpArray = new int[nums1.length];
        int index = 0;
        for(int num: nums2) {
            if(map.getOrDefault(num, 0) > 0) {
                tmpArray[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        return Arrays.copyOfRange(tmpArray, 0 , index);
    }

    public int[] sortAns(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length, l2 = nums2.length, k=0;
        int[] tmpArray = new int[Math.min(l1, l2)];

        for(int i=0, j=0; i<l1 && j < l2;){
            if(nums1[i] == nums2[j]) {
                tmpArray[k++] = nums1[i];
                i++; j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }

        return Arrays.copyOfRange(tmpArray, 0 , k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
