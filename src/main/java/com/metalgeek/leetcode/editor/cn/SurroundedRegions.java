//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
//
//
//
// 示例 1：
//
//
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [["X"]]
//输出：[["X"]]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 539 👎 0


package com.metalgeek.leetcode.editor.cn;
public class SurroundedRegions{
    public static void main(String[] args) {
         Solution solution = new SurroundedRegions().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        // 以下按边缘进行搜索, 比直接双循环 m * n 变为 2(m + n), 降低搜索起点的数量
        for(int i =0; i < m; i++) {
            // 限定从边缘处的O进行搜索 - 首列和末列
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for(int j =0; j < n; j++) {
            // 限定从边缘处的O进行搜索 - 首行和末行
            if(board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if(board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for(int i =0; i < m; i++) {
            for(int j =0; j < n; j++) {
                switch (board[i][j]) {
                    case 'O' : board[i][j] = 'X'; break;
                    case 'M' : board[i][j] = 'O'; break;
                    default: break;
                }
            }
        }

    }
    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            // 搜索出界, 或当前点位不为O(为X或当前点位为已标记过的位置), 则终止搜索
            return;
        }
        // 置标志位, 上下左右递归进行深度搜索
        board[i][j] = 'M';
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        dfs(board, i+1, j);
        dfs(board, i-1, j);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
