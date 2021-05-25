//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 堆 哈希表 
// 👍 755 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements{
  public static void main(String[] args) {
       Solution solution = new TopKFrequentElements().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

//        return sortByStream(nums, k, map);
        return sortByHeap(nums, k, map);
    }

    public int[] sortByHeap(int[] nums, int k, Map<Integer, Integer> map) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 默认为小根堆, 直接o1 - o2. 大根堆o2 - o1
                return o1.getValue() - o2.getValue();
            }
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(queue.size()== k) {
                if(queue.peek().getValue() < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }else {
                queue.offer(entry);
            }
        }

        int resLen = Math.min(queue.size(), k);
        int[] res = new int[resLen];
        for(int i =0; i < resLen; i++) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }

    public int[] sortByStream(int[] nums, int k, Map<Integer, Integer> map) {
        int[] tmp =map.entrySet().stream().sorted((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        }).mapToInt(Map.Entry::getKey).toArray();

        int resLen = Math.min(tmp.length, k);
        int[] res = new int[resLen];
        System.arraycopy(tmp, 0, res, 0 ,Math.min(tmp.length, resLen));

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
