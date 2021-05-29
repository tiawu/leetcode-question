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

import java.util.*;

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
//        return arraySort(matrix, k);
        // 每次重新构建数组的开始其实不小的, 所以效率可能还不如全加起来以后进行下标到k-1的快速排序, 甚至不如全排序
        return mergeSort(matrix, k);
    }

    public int mergeSort(int[][] matrix, int k) {
        // 使用小根堆进行归并排序, 只要排出第k小的数字即可
        int len = matrix.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 两个数组比较, 数组的头一个元素是原数组中某一行中的一个节点的值
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < len; i++) {
            // 构造一个新数组, 也可以用对象如Tuple或者坐标组合例如Point.x/y代替, 为方便比较还是用包含元素的值和二维下标的三元组
            queue.offer(new int[] {matrix[i][0], i, 0});
        }

        for(int i=0; i < k-1; i++) {
            // 堆排序里重点是如何在取出最小元素以后将剩余元素加回堆里, 借助之前的三元组元素往后找,
            // 注意单个数组不要越界, 如果越界了说明这一行已经跑完了, 就不要再加回队列里了
            int[] arr = queue.poll();
            if(arr[2] < len -1) {
                // 还没有跑到行尾, 将该行的下标向后移动一格
                queue.offer(new int[]{ matrix[arr[1]][arr[2]+1], arr[1], arr[2] +1 });
            }
        }

        // 完成扫描后队首就是第k小的元素
        return queue.poll()[0];
    }

    public int arraySort(int[][] matrix, int k) {
        int len = matrix.length;
        int[] res = new int[len * len];
        for (int i =0; i < len; i++){
            System.arraycopy(matrix[i], 0, res, i * len, len);
        }
        Arrays.sort(res);
        return res[k-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
