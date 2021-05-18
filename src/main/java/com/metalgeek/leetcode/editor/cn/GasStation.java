//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
// 说明:
//
//
// 如果题目有解，该答案即为唯一答案。
// 输入数组均为非空数组，且长度相同。
// 输入数组中的元素均为非负数。
//
//
// 示例 1:
//
// 输入:
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//
// 示例 2:
//
// 输入:
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。
// Related Topics 贪心算法
// 👍 642 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class GasStation{
    public static void main(String[] args) {
         Solution solution = new GasStation().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 先来个暴力穷举
//        return force(gas, cost);
//        return descentByGasCostDiff(gas,cost);
        return oneIterate(gas, cost);
    }

    public int oneIterate(int[] gas, int[] cost) {
        int len = gas.length, total = 0, tank = 0, position = 0;
        for(int i=0; i<len; i++) {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(tank < 0) {
                position = i +1;
                tank = 0;
            }
        }
        // 总油量不足
        if(total < 0) {
            return -1;
        }
        return tank>=0 ? position : -1;
    }

    class Node {
        public int diff;
        public int index;

        public Node(int diff, int index) {
            this.diff = diff;
            this.index = index;
        }
    }

    public int descentByGasCostDiff(int[] gas, int[] cost) {
        // 从diff最大的点出发
        int len = gas.length, sumDiff=0, diff;
        Node[] nodes = new Node[len];

        for(int i=0; i < len; i++) {
            diff= gas[i] - cost[i];
            sumDiff += diff;
            Node node = new Node(diff, i);
            nodes[i] = node;
        }
        if(sumDiff < 0) {
            return -1;
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.diff - o1.diff;
            }
        });
        for(int i=0; i < len; i++) {
            if(validateCircuit(gas, cost, nodes[i].index)) {
                return nodes[i].index;
            }
        }

        return -1;
    }

    public int force(int[] gas, int[] cost) {
        // 先来个暴力穷举
        int len = gas.length;
        for(int i =0; i<len; i++ ) {
            if(validateCircuit(gas, cost, i)) {
                return i;
            }
        }

        return -1;
    }

    public boolean validateCircuit(int[] gas, int[] cost, int start) {
        int len = gas.length, tank = 0;
        for(int i =0; i < len; i++) {
            tank += gas[(start + i) % len];
            tank -= cost[(start + i) % len];
            if(tank < 0) {
                return false;
            }
        }
        return tank >= 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
