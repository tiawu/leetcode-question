//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
//
// 格雷编码序列必须以 0 开头。
//
//
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,3,2]
//解释:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//对于给定的 n，其格雷编码序列并不唯一。
//例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1
//
// 示例 2:
//
// 输入: 0
//输出: [0]
//解释: 我们定义格雷编码序列必须以 0 开头。
//     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
//     因此，当 n = 0 时，其格雷编码序列为 [0]。
//
// Related Topics 回溯算法
// 👍 297 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode{
    public static void main(String[] args) {
         Solution solution = new GrayCode().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        // 预先开好2^n的空间, 节省扩容开销
        List<Integer> res = new ArrayList<>((int)Math.pow(2, n));
        res.add(0);
        int sig = 1;

        for (int i=0; i<n; i++) {
            // 注意这里内循环, 类似于层序遍历, 先取当前列表尾节点, 然后逆向遍历即可
            for(int j= res.size() -1; j >=0; j--) {
                res.add(sig ^ res.get(j));
            }
            // 左移2进制进位
            sig = sig << 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
