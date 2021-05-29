//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 491 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters{
  public static void main(String[] args) {
       Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
        System.out.println(solution.longestSubstring("aaabb", 3));
      System.out.println(solution.longestSubstring("ababbc", 2));
        System.out.println(solution.longestSubstring("aaabbb", 3));
      System.out.println(solution.longestSubstring("weitong", 2));
      System.out.println(solution.longestSubstring("ababacb", 3));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() < k) {
                int res = 0;
                for(String shortStr :s.split(entry.getKey().toString())) {
                    res = Math.max(res, longestSubstring(shortStr, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
