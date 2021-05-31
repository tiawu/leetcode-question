//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 293 👎 0


package com.metalgeek.leetcode.editor.cn;
public class ReverseWordsInAStringIii{
  public static void main(String[] args) {
       Solution solution = new ReverseWordsInAStringIii().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String str : s.split(" ")){
            for(int i =str.length()-1; i>=0 ; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
