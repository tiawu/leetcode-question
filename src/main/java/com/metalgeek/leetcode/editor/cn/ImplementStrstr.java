//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 874 👎 0


package com.metalgeek.leetcode.editor.cn;
public class ImplementStrstr{
  public static void main(String[] args) {
       Solution solution = new ImplementStrstr().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        char[] hs = haystack.toCharArray(), ns = needle.toCharArray();
        char nss = ns[0];
        int start = 0;
        while(start < hs.length) {
            if(hs[start] != nss) {
                start++;
                continue;
            }
            if(hs.length - start < ns.length) {
                return -1;
            }

            boolean pass = true;
            for(int i = 0; i < ns.length; i++) {
                if(hs[start + i] != ns[i]) {
                    pass = false;
                    break;
                }
            }
            if(pass) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        // 用API是最快的...
//        return  haystack.indexOf(needle);

        // 自己撸一个简单的
        int hl = haystack.length(), nl = needle.length();
        char[] hcs = haystack.toCharArray(), ncs = needle.toCharArray();
        if(nl==0)
            return 0;
        char first = ncs[0];
        for(int i=0; i< hl; i++){
            if(hcs[i] != first)
                continue;
            if(hl - i < nl){
                return -1;
            }

            int j= 0;
            for(; j < nl ;j++) {
                if(hcs[i+j] != ncs[j])
                    break;
            }
            if(j==nl)
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
