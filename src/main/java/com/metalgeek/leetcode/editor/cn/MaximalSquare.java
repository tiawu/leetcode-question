//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 动态规划
// 👍 790 👎 0


package com.metalgeek.leetcode.editor.cn;
public class MaximalSquare{
    public static void main(String[] args) {
         Solution solution = new MaximalSquare().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxLen;
        }

        int row = matrix.length, col = matrix[0].length;
        // 初始化DP矩阵, 默认全为0, 矩阵值为当前位置为右下角的最大正方形边长
        int[][] dp = new int[row][col];

        // DP dp(i, j) = min(dp(i-1, j) , dp(i, j-1), dp(i-1, j-1)) +1  when (maxtrix(i,j) ==1)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 注意当前节点必须是'1', 否则就跳过, 另外处理一下左侧和顶上两条边的情况
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) +1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
