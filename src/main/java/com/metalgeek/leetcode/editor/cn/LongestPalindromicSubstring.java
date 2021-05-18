//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3651 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
         Solution solution = new LongestPalindromicSubstring().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.longestPalindrome("babad"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() ==0) {
            return "";
        }
        // 预处理动态规划
        int n = s.length(), minI = n -1, maxLen = 1, len;
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            // 每个单字母都为回文
            f[i][i] = true;
            // from 分割回文串, 似乎有问题?
//            Arrays.fill(f[i], true);
        }

        char[] str = s.toCharArray();

        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1 ; j < n; j++) {
                // 收尾字母相同, 且: 1. 字符串长度为2以下, 或 2.内缩字符串为回文串
                if(str[i] == str[j] && (f[i+1][j-1] ||j - i <2)) {
                    f[i][j] = true;
                    len = j - i + 1;
                    if(len> maxLen) {
                        minI = i;
                        maxLen = len;
                    }
                }
                // 上面的简略写法, 便于置位但不利于计算存储最大长度字符串
//                f[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || f[i + 1][j - 1]); //j - i 代表长度减去 1

                // from 分割回文串
//                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];

            }
        }

//        for(i=0; i < n; i++) {
//            boolean[] arr = f[i];
//            System.out.println(Arrays.toString(arr));
//        }
        return s.substring(minI, minI + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
