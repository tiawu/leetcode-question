//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
// 示例 1：
//
//
//输入：x = 121
//输出：true
//
//
// 示例 2：
//
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 示例 4：
//
//
//输入：x = -101
//输出：false
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 👍 1516 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber{
    public static void main(String[] args) {
         Solution solution = new PalindromeNumber().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        // 转字符串处理
//        String str = String.valueOf(x);
//        for(int i =0, j = str.length() -1; i <=j; i++, j--){
//            if(str.charAt(i) != str.charAt(j)) {
//                return false;
//            }
//        }

        // 整数化
        if(x == 0)
            return true;
        List<Integer> list = new ArrayList<>();
        int tmp = x;
        for(int i=0; tmp > 0; i++) {
            list.add(tmp % 10);
            tmp = tmp/10;
        }
        for(int i =0, j = list.size() -1; i <=j; i++, j--){
            if(list.get(i) != list.get(j)) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
