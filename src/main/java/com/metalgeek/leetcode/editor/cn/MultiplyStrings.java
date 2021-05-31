//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串
// 👍 642 👎 0


package com.metalgeek.leetcode.editor.cn;
public class MultiplyStrings{
    public static void main(String[] args) {
         Solution solution = new MultiplyStrings().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.multiply("123", "456"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];

        // 竖式乘法, 外循环num1为乘数, 内循环num2为被乘数
        for(int i = len1 -1; i >=0; i--) {
            int n1 = num1.charAt(i) - '0';
            for(int j = len2 -1; j >=0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 个位数乘法最多为两位数, 加上进位余数也不会为三位数, 因此只要处理两个数字位
                // i <= len1 -1 j <= len2 -1, i + j <= len 1 + len2 -2. 最低位就是i + j + 1
                int tmp = res[i + j + 1] + n1 * n2;
                res[i +j + 1] = tmp % 10;
                // 注意这里进位要用 +=
                res[i +j] += tmp / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int digit: res) {
            if(digit == 0 && sb.length() ==0) {
                continue;
            }
            sb.append(digit);
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
