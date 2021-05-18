//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
// Related Topics 深度优先搜索 动态规划 回溯算法
// 👍 724 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args) {
         Solution solution = new PalindromePartitioning().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.partition("aab"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> list = new ArrayList<>(s.length());

        // 预处理动态规划
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        back_track(s, f, 0, list, res);
        return res;
    }

    // 回溯算法
    public void back_track(String s, boolean[][] f, int index, List<String> list, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        int len = s.length();
//        StringBuilder sb = new StringBuilder();
        for(int i = index; i < len; i++) {
            // 按次序添加字符, 检查是否为回文串. 如果是, 则将回文串加入序列, 移动指针进行递归搜索
//            sb.append(s.charAt(i));
            // 使用动态规划优化, 直接查表
            if(f[index][i]) {
                String sb = s.substring(index, i+1);
                list.add(sb.toString());
                back_track(s, f, i + 1, list , res);
                list.remove(list.size() -1);
            }
        }
    }


    public boolean isPalindrome(CharSequence s) {
        int l = 0, r= s.length()-1;
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
