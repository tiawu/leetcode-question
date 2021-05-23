//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 398 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorIi{
  public static void main(String[] args) {
       Solution solution = new BasicCalculatorIi().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
      System.out.println(solution.calculate("3+2*2"));
      System.out.println(solution.calculate("3/2"));
      System.out.println(solution.calculate("3+5/2"));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int len = s.length(), res = 0, num = 0;
        char preOp = '+';
        for(int i =0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                // 取数字字符
                num = num * 10 + c-'0';
            }
            if((!Character.isDigit(c) && c != ' ')|| i == (len -1)){
                switch (preOp) {
                    case '*':
                    case '/': num = op(stack.pop(), num, preOp); break;
                    case '-': num = -num;break;
                    default:
                }
                stack.push(num);
                preOp = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }
    public int op(int l, int r, char op) {
        switch(op) {
          case '+': return l + r;
          case '-': return l - r;
          case '*': return l * r;
          case '/': return l / r;
          default: return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
