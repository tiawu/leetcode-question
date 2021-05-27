//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 堆 二分查找 
// 👍 600 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestElementInASortedMatrix{
  public static void main(String[] args) {
       Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
      System.out.println(solution.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
      System.out.println(solution.kthSmallest(new int[][]{{-5}}, 1));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] res = new int[len * len];
        for (int i =0; i < len; i++){
            System.arraycopy(matrix[i], 0, res, i * len, len);
        }
        Arrays.sort(res);
        return res[k-1];
//        int tmp = Integer.MIN_VALUE;
//        List<Integer> list = new ArrayList<>(k);
//        len = res.length;
//        for (int j =0; j < len; j++) {
//            if(res[j] > tmp) {
//                tmp = res[j];
//                list.add(tmp);
//                if(list.size() == k) {
//                    return tmp;
//                }
//            }
//        }
//        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
