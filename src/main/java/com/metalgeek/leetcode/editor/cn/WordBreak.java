//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 动态规划
// 👍 983 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak{
    public static void main(String[] args) {
         Solution solution = new WordBreak().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict.size());
//        char[] str = s.toCharArray();
        int min=0, max=0;
        for(String word: wordDict) {
            set.add(word);
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }

//        return dfs(s, set, 0, minLen, maxLen);
        return dp(s, set, min, max);
    }

    // 动态规划
    public boolean dp(String s, Set<String> set, int min, int max) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;

        for(int i=0; i <len; i++) {
            // 状态转移 f[j] = f[i] && set.contains(s.substring(i, j))
            if(f[i]) {
                // 从最短开始搜索, 统一边界为字符串结尾, 应该还可以优化
                for(int j = i + min; j <= len; j++) {
                    if(set.contains(s.substring(i, j))) {
                        f[j] = true;
                    }
                }
            }
        }
        return f[len];
    }

    // 深度优先搜索
    public boolean dfs(String s, Set<String> set, int index, int min, int max) {
        if(index == s.length()) {
            return true;
        }

        // 每次只搜索最短和最长之间的距离
        for(int i=max; i>=min; i--) {
            int end = index +i +1;
            if(end <= s.length() && set.contains(s.substring(index, end))) {
                if (dfs(s, set, end, min, max) ){
                    return true;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
