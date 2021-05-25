//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -106 <= nums[i] <= 106 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 104 次 reset 和 shuffle 
// 
// 👍 136 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray{
  public static void main(String[] args) {
       Solution solution = new ShuffleAnArray().new Solution(new int[]{1,2,3});
       
       long t0 = System.currentTimeMillis();
       // Call solution here
      System.out.println(Arrays.deepToString(Arrays.stream(solution.shuffle()).boxed().toArray()));
      System.out.println(Arrays.deepToString(Arrays.stream(solution.shuffle()).boxed().toArray()));
      System.out.println(Arrays.deepToString(Arrays.stream(solution.shuffle()).boxed().toArray()));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] array;
    int[] rndArray;
    int len;
    Random rand= new Random();

    public Solution(int[] nums) {
        array = Arrays.copyOf(nums, nums.length);
        rndArray = Arrays.copyOf(nums, nums.length);
        len = array.length;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int r1, tmp;
        //Fisher-Yates 洗牌算法, 每次抽牌交换后拿掉一张牌
        for(int i= len -1; i > 0; i--) {
            r1 = rand.nextInt(i +1);
            tmp = rndArray[r1];
            rndArray[r1] = rndArray[i];
            rndArray[i] = tmp;

            // 全随机办法概率上有问题
//            r1= rand.nextInt(len);
//            r2= rand.nextInt(len);
//            tmp = rndArray[r1];
//            rndArray[r1] = rndArray[r2];
//            rndArray[r2] = tmp;
        }
        return rndArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
