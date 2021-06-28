//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2447 👎 0


package com.metalgeek.leetcode.editor.cn;
public class ContainerWithMostWater{
    public static void main(String[] args) {
         Solution solution = new ContainerWithMostWater().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxArea(int[] height) {
        int res = 0;
        for(int i =0, j = height.length -1; i < j;) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if(height[i] > height[j]) {
                j--;
            }else {
                i++;
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int res = 0;

        for(int i =0, j = height.length -1; i < j;) {
            int square = (j-i) * Math.min(height[i], height[j]);
            res = Math.max(res, square);
            if(height[i] > height[j]) {
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
    public int maxArea1(int[] height) {
        // 下标为x轴坐标啊, 值为y轴坐标
        // 求min(height[i], height[j]) * (j-i)最大值

        // 双循环 超时, O(n^2)
//        int len = height.length, res = 0;
//        for(int i =0; i < len; i++ ) {
//            for(int j = i +1; j < len; j++) {
//                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
//            }
//        }

        // 双指针法, 初始指针在两端, 将所指数值小的指针向中心移动
        // 证明: x = min(x, y), 则 x >= min(x, y - n), 而下标差减少, 因此面积减少.
        int res = 0;
        for(int i=0, j = height.length -1; i < j;) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
