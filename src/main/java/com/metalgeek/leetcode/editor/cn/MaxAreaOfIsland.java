//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被
//0（代表水）包围着。
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
//
//
//
// 示例 1:
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
//
// 示例 2:
//
// [[0,0,0,0,0,0,0,0]]
//
// 对于上面这个给定的矩阵, 返回 0。
//
//
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
// Related Topics 深度优先搜索 数组
// 👍 502 👎 0


package com.metalgeek.leetcode.editor.cn;
public class MaxAreaOfIsland{
    public static void main(String[] args) {
         Solution solution = new MaxAreaOfIsland().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length -1, n = grid[0].length -1, res = 0;
        for(int i =0; i <= m; i++) {
            for(int j=0; j <= n; j++) {
                if(grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j, 0), res);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j, int size) {
        if(i<0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return size;
        }
        grid[i][j] = 2;
        size++;
        size = dfs(grid, i, j+1, size);
        size = dfs(grid, i, j-1, size);
        size = dfs(grid, i+1, j, size);
        size = dfs(grid, i-1, j, size);
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
