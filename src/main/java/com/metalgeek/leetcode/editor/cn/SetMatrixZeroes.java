//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
// 进阶：
//
//
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个仅使用常量空间的解决方案吗？
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//
//
// 示例 2：
//
//
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
// Related Topics 数组
// 👍 482 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Set;
import java.util.TreeSet;

public class SetMatrixZeroes{
  public static void main(String[] args) {
       Solution solution = new SetMatrixZeroes().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mm = new int[m], nn = new int[n];
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    mm[i] = nn[j] = 1;
                }
            }
        }

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(mm[i] ==1 ||nn[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, col0 = false;

        for(int i=0; i< m; i++) {
            if(matrix[i][0] ==0) {
                col0 = true;
                break;
            }
        }
        for(int j=0; j< n; j++) {
            if(matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        for(int i=0; i < m; i++) {
            for(int j =0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i < m; i++) {
            for(int j =1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row0){
            for(int j=0; j< n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0){
            for(int i=0; i< m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void solve1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m], col = new boolean[n];

        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[i].length; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
