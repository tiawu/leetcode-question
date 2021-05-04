//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 489 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle{
  public static void main(String[] args) {
       Solution solution = new PascalsTriangle().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.generate(7));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Collections.singletonList(1));
        List<Integer> tmp;
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            tmp = ret.get(i-1);
            for(int j = 1; j < i; j++) {
                row.add(tmp.get(j-1) + tmp.get(j));
            }
            row.add(1);
            ret.add(row);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
