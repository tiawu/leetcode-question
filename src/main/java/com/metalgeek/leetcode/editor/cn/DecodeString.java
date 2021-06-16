//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 786 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString{
  public static void main(String[] args) {
       Solution solution = new DecodeString().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.decodeString("3[a2[c]]"));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> sbStack = new LinkedList<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9'){
                // 数字可能有多位, 需要先处理10进制数
                num = num * 10 + (c - '0');
            }else if(c == '[') {
                // 左括号 数字和字符串压栈
                sbStack.push(sb);
                numStack.push(num);
                sb = new StringBuilder();
                num = 0;
            }else if(c == ']') {
                // 右括号, 出栈
                int tmp = numStack.pop();
                StringBuilder sbTmp = sbStack.pop();
                while(tmp-- > 0) {
                    sbTmp.append(sb);
                }
                sb = sbTmp;
            }else {
                // 字母, 加入sb
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
