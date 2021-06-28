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
        System.out.println(solution.longestPalindrome("bb"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() ==0) {
            return "";
        }
        // 动态规划 91ms, 空间复杂度O(n2)
//        return dp(s);
        // 中心扩展 11ms, 空间复杂度O(1)
//        return center(s);
//        return center2(s);
//        return expCenter(s);
        return expendCenter(s);
    }

    public int expendStr(char[] str, int len, int l, int r) {
        while (l >= 0 && r < len && str[l] == str [r]) {
            l--;r++;
        }
        // 已经多扩展了一轮, 所以要-1而不是+1
        return r - l -1;
    }

    public String expendCenter(String s) {
        char[] str = s.toCharArray();
        int len = s.length(), maxLen = 0, start = len -1;
        for(int i =0; i < len; i++) {
            int len1 = expendStr(str, len, i, i);
            len1 = Math.max(expendStr(str, len, i, i+1), len1);
            if(maxLen < len1) {
                maxLen = len1;
                start = i - (maxLen - 1)/2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public int expStr(char[] str, int len, int l, int r) {
        while (l >=0 && r < len && str[l] == str[r]) {
            l--; r++;
        }
        // 注意长度要-1而不是+1, 因为已经多扩展了一组出去
        return r - l - 1;
    }
    public String expCenter(String s) {
        char[] str = s.toCharArray();
        int len = str.length, maxLen = 0, l = len -1;
        for(int i=0; i < len; i++) {
            // 以单字符为中心扩展
            int tmp = expStr(str, len, i, i);
            // 以双字符为中心扩展
            tmp = Math.max(expStr(str, len, i, i+1), tmp);
            if(tmp > maxLen) {
                maxLen = tmp;
                // 求起始点, i = (l + r) /2 , maxLen = (r -l) +1,  (maxLen -1) /2 = (r -l) /2.
                // 则 i - (maxLen -1) /2 = (l + r) /2 - (r -l) /2 = (l + r - r + l) /2 = l
                l = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(l, l + maxLen);
    }

    public String center2(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length(), l, r, minI = strLen -1, maxLen = 1;
        char[] str = s.toCharArray();
        for(l = 0; l < strLen; l++) {
            int len = expandString(str, l, l);
            len = Math.max(len, expandString(str, l, l +1));
            if(len > maxLen) {
                maxLen = len;
                minI = l - (len -1) /2;
            }
        }
        return s.substring(minI, minI + maxLen);
    }

    // 中心扩展辅助函数, 返回最长扩展的子串长度
    public int expandString(char[] str, int l, int r) {
        int len = str.length;
        while(l >= 0 && r < len && str[l] == str[r]) {
            l--; r++;
        }
        // 循环跳出时已经多扩展了2个, 因此回文长度为 r-l+1 -2 = r-l-1;
        return r - l -1;
    }

    public String center(String s) {
        int strLen = s.length(), minI = strLen -1, maxLen = 1, l, r;
        char[] str = s.toCharArray();
        for(l=0; l < strLen; l++) {
            int i = l -1, j = l +1;
            while(i>=0 && j < strLen) {
                if(str[i] == str[j]) {
                    int len = j-i+1;
                    if(len > maxLen) {
                        maxLen = len;
                        minI = i;
                    }
                    i--;j++;
                    continue;
                }
                break;
            }
        }
        for(l=0, r =1; r < strLen; l++, r++) {
            int i = l, j = r;
            while(i>=0 && j < strLen) {
                if(str[i] == str[j]) {
                    int len = j-i+1;
                    if(len > maxLen) {
                        maxLen = len;
                        minI = i;
                    }
                    i--;j++;
                    continue;
                }
                break;
            }
        }
        return s.substring(minI, minI + maxLen);
    }

    public String dp(String s) {
        // 预处理动态规划
        int n = s.length(), minI = n -1, maxLen = 1, len;
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            // 每个单字母都为回文
            f[i][i] = true;
        }

        char[] str = s.toCharArray();

        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1 ; j < n; j++) {
                // 首尾字母相同, 且: 1. 字符串长度为2以下, 或 2.内缩字符串为回文串
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

        return s.substring(minI, minI + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
