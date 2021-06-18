//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 542 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString{
  public static void main(String[] args) {
       Solution solution = new FindAllAnagramsInAString().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
//      System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
      System.out.println(solution.findAnagrams("abab", "ab"));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // s比p短则不存在解
        if(s.length() < p.length()) {
            return Collections.emptyList();
        }
        List<Integer> res = new LinkedList<>();

        // 初始化计数用的数组
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for(char c : p.toCharArray()) {
            pCnt[c - 'a']++;
        }

        // 对字符串s用一个长度为p的滑动窗口来滚动检查, 只需要一趟扫描
        char[] str = s.toCharArray();
        int i = 0, j=0;
        while(i<p.length()) {
            sCnt[str[i++] - 'a']++;
        }

        // TODO : 有木有办法移除这里的检查?
        if(Arrays.equals(sCnt, pCnt)) {
            res.add(j);
        }

        i--;
        int len = s.length() -1;
        while (i < len) {
            sCnt[str[j++] -'a']--;
            sCnt[str[++i] -'a']++;
            if(Arrays.equals(sCnt, pCnt)) {
                res.add(j);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
