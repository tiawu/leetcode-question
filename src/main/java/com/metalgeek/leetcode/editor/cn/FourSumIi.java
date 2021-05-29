//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找 
// 👍 372 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FourSumIi{
  public static void main(String[] args) {
       Solution solution = new FourSumIi().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum, res =0;
        for(int n1: nums1) {
            for (int n2 : nums2) {
                sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) +1);
            }
        }

        for(int n3: nums3) {
            for (int n4 : nums4) {
                sum = -n3 - n4;
                if(map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
