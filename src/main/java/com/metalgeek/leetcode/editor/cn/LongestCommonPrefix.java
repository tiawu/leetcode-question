//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1571 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LongestCommonPrefix{
    public static void main(String[] args) {
         Solution solution = new LongestCommonPrefix().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"ab","a"}));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str = strs[0];
        for(int i = 0; i < str.length(); i++) {
            boolean pass = true;
            char c = str.charAt(i);
            for(int j =1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != c) {
                    pass = false;
                    break;
                }
            }
            if(pass) {
                sb.append(c);
            }else {
                break;
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs.length ==0)
            return "";
        String s1 = strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < s1.length(); i++){
            char c = s1.charAt(i);
            boolean pass = true;
            for(int j =1; j < strs.length; j++){
                if(strs[j].length() <i+1 || strs[j].charAt(i) != c) {
                    pass = false;
                    break;
                }
            }
            if(pass){
                sb.append(c);
            }else {
                break;
            }
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
