//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 786 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DailyTemperatures{
  public static void main(String[] args) {
       Solution solution = new DailyTemperatures().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return solve1(temperatures);
    }

    public int[] solve1(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] solve2(int[] temperatures) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];

        for(int i = len -1; i >=0; i--) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp >= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = 0;
                stack.push(temp);
                map.put(temp, i);
            }else {
                res[i] = map.get(stack.peek()) - i;
                stack.push(temp);
                map.put(temp, i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
