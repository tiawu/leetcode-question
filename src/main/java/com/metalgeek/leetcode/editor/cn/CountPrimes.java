//统计所有小于非负整数 n 的质数的数量。
//
//
//
// 示例 1：
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
// 示例 2：
//
// 输入：n = 0
//输出：0
//
//
// 示例 3：
//
// 输入：n = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 5 * 106
//
// Related Topics 哈希表 数学
// 👍 677 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;

public class CountPrimes{
    public static void main(String[] args) {
         Solution solution = new CountPrimes().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.countPrimes(10));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        int sum = 0;
        boolean[] array = new boolean[n];
        Arrays.fill(array, true);

        for(int i = 2; i < n; i++) {
            if(array[i]) {
                sum++;
                for(int j = i + i; j < n; j += i){
                    array[j] = false;
                }
            }
        }
        return sum;
    }

    public boolean isPrime(int n) {
        int n2 = (int)Math.sqrt(n);
        for(int i =2; i <= n2; i++) {
            if((n % i) > 0)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
