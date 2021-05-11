//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 👍 380 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class ValidAnagram{
    public static void main(String[] args) {
         Solution solution = new ValidAnagram().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        // int[] 初始值为全0
        int[] sa = new int[26];

        int i=0, len = s.length();
        for(; i < len; i++) {
            sa[s.charAt(i) - 97]++;
        }

        len = t.length();
        for(i=0; i < len; i++) {
            sa[t.charAt(i) - 97]--;
        }

        for(i=0; i < 26; i++){
            if(sa[i] != 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
