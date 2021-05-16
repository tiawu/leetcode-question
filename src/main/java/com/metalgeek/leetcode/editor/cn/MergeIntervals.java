//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 929 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class MergeIntervals{
  public static void main(String[] args) {
       Solution solution = new MergeIntervals().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // o1,o2非空. 不用o2-o1防止溢出错误
                if(o1[0] > o2[0])
                    return 1;
                else if(o1[0] == o2[0])
                    return 0;
                else
                    return -1;
            }
        });

        List<int[]> list = new ArrayList<>();

        //先迭代计算出合并后的区间, 再插入
//        int[] last = null;
//        for(int i=0; i < intervals.length; i++) {
//            if(i == 0) {
//                last = intervals[0];
//                continue;
//            }
//            // 最后的有边界大于等于新区间的左边界, 则合并区间
//            if(last[1] >= intervals[i][0]) {
//                last[1] = Math.max(last[1], intervals[i][1]);
//            }else {
//                list.add(last);
//                last = intervals[i];
//            }
//        }
//        // 最后剩一个区间直接加入(可能在没有任何区间输入的情况下错误?)
//        list.add(last);

            // 从列表里拿区间
        for(int i=0; i < intervals.length; i++) {
            if(list.size() == 0) {
                list.add(intervals[0]);
                continue;
            }
            int [] last = list.get(list.size() -1);
            // 最后的有边界大于等于新区间的左边界, 则合并区间
            if(last[1] >= intervals[i][0]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            }else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
