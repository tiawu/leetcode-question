//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2347 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses{
  public static void main(String[] args) {
       Solution solution = new ValidParentheses().new Solution();

       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.isValid("()[]{}"));

       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char getChar(char c) {
        switch (c) {
            case '}': return '{';
            case ']': return '[';
            case ')': return '(';
            default: return 'e';
        }
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{': stack.push(c); break;
                case ')':
                case ']':
                case '}': if(!stack.isEmpty() && stack.pop() == getChar(c)){
                                break;
                            }else{
                                return false;
                            }
                default:break;
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        for(int i =0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stack.isEmpty() && stack.pop() == getChar(c)) {
                        break;
                    }else {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.empty() && stack.pop() == getChar(c)) {
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
