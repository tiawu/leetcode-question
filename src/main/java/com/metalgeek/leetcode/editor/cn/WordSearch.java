//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
//
//
// 示例 3：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
// Related Topics 数组 回溯算法
// 👍 901 👎 0


package com.metalgeek.leetcode.editor.cn;
public class WordSearch{
  public static void main(String[] args) {
       Solution solution = new WordSearch().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.exist(new char[][]{{'a'}}, "a"));
       System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] str = word.toCharArray();
        for(int i =0; i < m; i++) {
            for(int j =0; j < n; j++) {
                if(board[i][j] == str[0]) {
                    if( bt(board, i, j, 0, str, visited))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean bt(char[][] board, int i, int j, int index, char[] word, boolean[][] visited) {
        if(board[i][j] != word[index]) {
            return false;
        }
        if(index == word.length -1) {
            return true;
        }
        visited[i][j] = true;
        if(i > 0 && !visited[i-1][j] && bt(board, i-1, j, index +1, word, visited)) {
            return true;
        }
        if(j > 0 && !visited[i][j-1] && bt(board, i, j-1, index +1, word, visited)) {
            return true;
        }

        if(i < board.length-1 && !visited[i+1][j] && bt(board, i+1, j, index +1, word, visited)) {
            return true;
        }
        if(j < board[0].length-1 && !visited[i][j+1] && bt(board, i, j+1, index +1, word, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist1(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                // dfs 深度优先搜索, 发现合法解后返回
                if(dfs(board, word, visited, i, j, 0)) {
                    return true;
                }

            }
        }
        // 搜索不到解
        return false;
    }
    public boolean dfs(char[][] board, String word, boolean[][] visited,  int i , int j, int index) {
        // 当前节点不满足条件, 直接返回
        if(word.charAt(index) != board[i][j]) {
            return false;
        }
        // 满足条件, 且深度已满足, 找到了解
        if(index == word.length() -1){
            return true;
        }

        // 标志置位, 然后按上下左右寻找未访问过的节点进行搜索, 注意边界条件
        visited[i][j] = true;

        if(i < board.length -1 && !visited[i +1][j]) {
            if(dfs(board, word, visited, i +1, j, index +1))
                return true;
        }
        if(j < board[0].length -1 && !visited[i][j+1]) {
            if(dfs(board, word, visited, i, j +1, index +1))
                return true;
        }
        if(i > 0 && !visited[i -1][j]) {
            if(dfs(board, word, visited, i -1, j, index +1))
                return true;
        }
        if(j > 0 && !visited[i][j -1]) {
            if(dfs(board, word, visited, i, j -1, index +1))
                return true;
        }

        // 前述搜索没找到解, 回溯状态
        visited[i][j] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
