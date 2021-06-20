//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1780 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses{
  public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.generateParenthesis(2));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        back_track(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    public void dfs(StringBuilder sb, int numLeft, int numRight, int num, List<String> res) {
        if(sb.length() == num << 1) {
            res.add(sb.toString());
        }
        if(numLeft < num) {
            sb.append('(');
            dfs(sb, numLeft +1, numRight, num, res);
            sb.deleteCharAt(sb.length() -1);
        }
        if(numRight < numLeft) {
            sb.append(')');
            dfs(sb, numLeft, numRight +1, num, res);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    // 回溯法, 合法的尝试先插入(, 再插)
    public void back_track(StringBuilder sb, int numLeft, int numRight, int num, List<String> res) {
        if(sb.length() == num * 2) {
            res.add(sb.toString());
        }
        if(numLeft < num) {
            sb.append('(');
            back_track(sb, numLeft +1, numRight, num, res);
            sb.deleteCharAt(sb.length() -1);
        }
        if(numLeft > numRight) {
            sb.append(')');
            back_track(sb, numLeft, numRight +1, num, res);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
