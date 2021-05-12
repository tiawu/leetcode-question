//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 384 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
         Solution solution = new FirstUniqueCharacterInAString().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.firstUniqChar("leetcode" ));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        // 用数组保存更快, 浪费了一点空间但少了每个字符 - 'a'的运算
        int[] ci = new int['z'+1];
        int len = s.length();

        char[] str = s.toCharArray();
        for(int i=0; i < len; i++) {
            ci[str[i]] += 1;
        }
        for(int i=0; i < len; i++) {
            if(ci[str[i]] == 1) {
                return i;
            }
        }

        return -1;

        // 其他解法都比较慢

        //用HashMap存储下标
//        Map<Character, Integer> map = new HashMap<>();
//        char c;
//        for(int i=0; i < s.length(); i++) {
//            c = s.charAt(i);
//            if(!map.containsKey(c)) {
//                map.put(c, i);
//            }else {
//                map.put(c, -1);
//            }
//        }

        // 遍历字符串
//        for(int i=0; i < s.length(); i++){
//            c = s.charAt(i);
//            if(map.get(c) >= 0) {
//                return map.get(c);
//            }
//        }
//        return -1;

        // 遍历HashMap
//        int tmp = Integer.MAX_VALUE;
//        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
//            int index = entry.getValue();
//            if(index >= 0 && index < tmp) {
//                tmp = index;
//            }
//        }
//        return tmp != Integer.MAX_VALUE ? tmp : -1;

        // 遍历values
//        int tmp = Integer.MAX_VALUE;
//        for(int index : map.values()) {
//            if(index >= 0 && index < tmp) {
//                tmp = index;
//            }
//        }
//        return tmp != Integer.MAX_VALUE ? tmp : -1;

        // StreamAPI
//        return map.values().stream().filter(i -> i >= 0).sorted().findFirst().orElseGet(() -> -1);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
