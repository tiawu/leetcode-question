//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 379 👎 0


package com.metalgeek.leetcode.editor.cn;
public class ValidPalindrome{
    public static void main(String[] args) {
         Solution solution = new ValidPalindrome().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        int l=0, r=sb.length() -1;
        while (l < r) {
            if(sb.charAt(l++) != sb.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        char c;
        int l = s.length(), r;
        for(int i=0; i <  l; i++){
            c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        l = 0;
        r= sb.length()-1;
        while(l < r) {
            if(sb.charAt(l++) != sb.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
