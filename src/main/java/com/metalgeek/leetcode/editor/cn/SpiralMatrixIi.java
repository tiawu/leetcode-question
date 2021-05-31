//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组
// 👍 425 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi{
    public static void main(String[] args) {
         Solution solution = new SpiralMatrixIi().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(Arrays.deepToString(solution.generateMatrix(3)));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        bfs(matrix, 0, 0, n-1, n-1, 1);
        return matrix;
    }
    public void bfs(int[][] matrix, int left, int top, int right, int bottom, int startIndex) {
        if(left <= right && top <= bottom) {
            int row, col;
            for(col = left; col <= right; col++) {
                matrix[top][col] = startIndex++;
            }
            for(row = top +1; row <= bottom; row++) {
                matrix[row][right] = startIndex++;
            }
            if(left < right && top < bottom) {
                for(col = right -1; col > left; col--) {
                    matrix[bottom][col] = startIndex++;
                }
                for(row = bottom; row > top; row--) {
                    matrix[row][left] = startIndex++;
                }
            }
            bfs(matrix, left +1, top +1, right -1, bottom -1, startIndex);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
