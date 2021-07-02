//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1636 👎 0


package com.metalgeek.leetcode.editor.cn;
public class ClimbingStairs{
    public static void main(String[] args) {
         Solution solution = new ClimbingStairs().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.climbStairs(100));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int f0 = 1, f1 = 1;
        for(int i =2; i <= n; i++) {
            int tmp = f0 + f1;
            f0 = f1;
            f1 = tmp;
        }
        return f1;
    }
    public int climbStairs1(int n) {
        int[] stairs = new int[n+1];
        stairs[0]=1;
        stairs[1]=1;

        for(int i =2; i <= n; i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }
        return stairs[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
