//根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dea
//d）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返
//回下一个状态。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// 示例 2： 
//
// 
//输入：board = [[1,1],[1,0]]
//输出：[[1,1],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] 为 0 或 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
// Related Topics 数组 
// 👍 341 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class GameOfLife{
  public static void main(String[] args) {
       Solution solution = new GameOfLife().new Solution();
       int[][] game = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

       long t0 = System.currentTimeMillis();
       // Call solution here
      solution.gameOfLife(game);
       System.out.println(Arrays.deepToString(game));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNeighbor(int[][] board, int row, int col, int i, int j) {
        int res = 0;
        for(int k = -1; k < 2; k++) {
            for(int l = -1; l < 2; l++) {
                if(k==0 && l ==0) {
                    continue;
                }
                int r = i + k, c = j + l;
                // 注意边界
                if((r >=0 && r < row) && (c >= 0 && c < col) && board[r][c] ==1) {
                    res++;
                }
            }
        }
        return res;
    }

    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int[][] newboard = new int[board.length][board[0].length];

        // 复制一份地图
        for(int i =0; i < row; i++) {
            for (int j =0; j < col; j++) {
                newboard[i][j] = board[i][j];
            }
        }

        // 查新地图, 改老地图
        for(int i =0; i < row; i++) {
            for (int j =0; j < col; j++) {
                // 求细胞状态和邻居状态, 更新老地图
                int cell = newboard[i][j];
                int neighbor = countNeighbor(newboard, row,col, i,j);
                if(cell == 1){
                    if(neighbor < 2 || neighbor > 3) {
                        board[i][j] = 0;
                    }
                }else if(neighbor ==3) {
                    board[i][j] = 1;
                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
