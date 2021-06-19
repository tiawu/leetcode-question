//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 754 👎 0


package com.metalgeek.leetcode.editor.cn;
public class CountingBits{
  public static void main(String[] args) {
       Solution solution = new CountingBits().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;

        for(int i=0; i<=n; i++) {
            // 最低有效位.  当i为偶数时 等于res[i/2](因为2进制*2等于左移一位, 1的数量不变). 当i为奇数时, 最低位为1, 则等于res[i/2] +1,
            res[i] = res[i>>1] + (i & 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
