//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 773 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix{
  public static void main(String[] args) {
       Solution solution = new SpiralMatrix().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if(matrix ==null || matrix.length ==0 || matrix[0].length ==0) {
            return res;
        }
        spiralOrderRecurse(matrix, 0, 0, matrix[matrix.length-1].length-1, matrix.length-1, res);
        return res;
    }

    // 递归法, 每次遍历一圈, 内圈递归. 注意边界条件
    public void spiralOrderRecurse(int[][] matrix, int left, int top, int right, int bottom, List<Integer> res) {
        if(left <= right && top <= bottom) {
            int row, col;
            for (col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            for (row = top +1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if(left < right && top < bottom) {
                for (col = right -1; col > left; col--) {
                    res.add(matrix[bottom][col]);
                }
                for (row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            spiralOrderRecurse(matrix, left + 1, top + 1, right - 1, bottom - 1, res);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
