//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 395 👎 0


package com.metalgeek.leetcode.editor.cn;
public class SumOfTwoIntegers{
  public static void main(String[] args) {
       Solution solution = new SumOfTwoIntegers().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        // 二进制情况下 a ^ b 为无进位的加法(原地取值), a & b 为进位数, 进位后需要左移一位(保留符号)因此是 (a & b) << 1
        // 递归迭代都可以
        if(b == 0){
            return a;
        }else {
            return getSum(a ^ b, (a & b) <<1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
