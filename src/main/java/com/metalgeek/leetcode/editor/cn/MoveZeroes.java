//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1058 👎 0


package com.metalgeek.leetcode.editor.cn;
public class MoveZeroes{
    public static void main(String[] args) {
         Solution solution = new MoveZeroes().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int i =0, j = 0, len = nums.length;
        while(i < len) {
            if(nums[i] !=0) {
                int tmp = nums[j];
                nums[j++] = nums[i];
                nums[i] = tmp;
            }
            i++;
        }
    }
    public void solve1(int[] nums) {
        int i = 0, j= 0, tmp;
        while(i < nums.length){
            if(nums[i] !=0){
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
            i++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
