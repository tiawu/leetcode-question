//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划
// 👍 990 👎 0


package com.metalgeek.leetcode.editor.cn;
public class UniquePaths{
  public static void main(String[] args) {
       Solution solution = new UniquePaths().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
//        return dp(m, n);
        return math(m,n);
    }
    // 动态规划 func[i][j]为走到i,j节点的路径数
    // func[i][j] = func[i-1][j] + func[i][j-1] 即每个节点能走到的路径数等于上方节点和左方节点路径数的和
    // 同时首行和首列的路径数初始化为1(因为只能沿一个方向走)
    public int dp(int m, int n) {
        int[][] func = new int[m][n];
        for(int i =0; i < m; i++) {
            func[i][0] = 1;
        }
        for(int j =0; j < n; j++) {
            func[0][j] = 1;
        }
        for(int i =1; i < m; i++) {
            for(int j =1; j < n; j++) {
                func[i][j] = func[i-1][j] + func[i][j-1];
            }
        }
        return func[m-1][n-1];
    }

    // 数学, 求C(m-1, (m-1)+(n-1)) = C(m-1, m+n-2) , 其中m可以求为m和n中的较小数
    public int math(int m, int n) {
        int min = m > n ? n : m;
        int max = m == min ? n : m;
        long res = 1;
        for(int i= max, j = 1; j < min; i++, j++) {
            res = res * i / j;
        }

        return (int)res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
