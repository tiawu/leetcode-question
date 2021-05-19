//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 710 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumber{
  public static void main(String[] args) {
       Solution solution = new LargestNumber().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
//      System.out.println(solution.largestNumber(new int[]{10,2}));
      System.out.println(solution.largestNumber(new int[]{0,9,8,7,6,5,4,3,2,1}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int digits(int n) {
        int pow = 10;
        while(pow <= n){
            pow *= 10;
        }
        return pow;
    }
    public String largestNumber(int[] nums) {
        String res = Arrays.stream(nums).boxed().sorted(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int d1 = digits(o1), d2 = digits(o2);
                int n1 = o1 * d2 + o2, n2 = o2 * d1 + o1;
                return n2 - n1;
            }
        }).map(x -> {
            return x.toString();
        }).reduce((x,y) -> {
            return x.concat(y);
        }).get();

        if(res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
