//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 660 👎 0


package com.metalgeek.leetcode.editor.cn;
public class Sqrtx{
  public static void main(String[] args) {
       Solution solution = new Sqrtx().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.mySqrt(6));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        // 这样显然是不行的
//        return (int)Math.sqrt(x);

        // 自己撸一个. x非负整数
        if(x==0) return 0;
        int i = x/2;
        for(; i > 1; i = i/2) {
            if (i*i <= x)
                return i;
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
