//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 
// 👍 877 👎 0


package com.metalgeek.leetcode.editor.cn;
public class RotateImage{
  public static void main(String[] args) {
       Solution solution = new RotateImage().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public void swap(int[][] matrix, int i1, int j1, int i2, int j2){
          int tmp = matrix[i1][j1];
          matrix[i1][j1] = matrix[i2][j2];
          matrix[i2][j2] = tmp;
      }

    public void rotate(int[][] matrix) {
        int len = matrix.length, len2 = len/2;
        // 上下翻转
        for(int i =0; i <len2; i++) {
            int len3 = len - 1;
            for(int j=0; j < len; j++) {
                swap(matrix, i, j, len3 -i, j);
            }
        }
        //主对角线交换
        for(int i =0; i < len; i++) {
            for(int j =i; j < len; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
