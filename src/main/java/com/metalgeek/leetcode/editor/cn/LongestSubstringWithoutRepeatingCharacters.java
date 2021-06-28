//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5443 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
         Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return solve3(s);
    }
    public int solve3(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, len = s.length(), res = 0;
        for(int j =0; j < len;) {
            char c = s.charAt(j);
            if(set.add(c)) {
                res = Math.max(res, j - i +1);
                j++;
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public int solve2(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0, len = s.length();
        int l =0, r =0;
        while(r < len) {
            char c = s.charAt(r);
            if(set.add(c)) {
                res = Math.max(res, r -l +1);
                r++;
            }else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
    public int solve1(String s) {
        Set<Character> set = new HashSet<>();

        int i=0, j= -1, len = s.length(), ans = 0;
        char[] str = s.toCharArray();

        for(; i < len; i++) {
            if(i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while(j +1 < len && !set.contains(s.charAt(j+1))) {
                j++;
                set.add(s.charAt(j));
            }
            ans = Math.max(ans, j-i +1);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
