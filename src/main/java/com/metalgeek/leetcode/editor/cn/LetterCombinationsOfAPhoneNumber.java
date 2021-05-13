//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1308 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
         Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println(solution.letterCombinations("23"));

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, List<String>> map;
    public Solution() {
        map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
    }

    public List<String> letterCombinations(String digits) {
        return recurse(digits.toCharArray(), 0, new ArrayList<>());
    }

    // 递归
    public List<String> recurse(char[] digits, int index, List<String> list) {
        if(digits.length == index) {
            return list;
        }
        if(list.isEmpty()) {
            list.add("");
        }

        char digit = digits[index];
        List<String> charList = map.get(digit);
        List<String> newList = new ArrayList<>(list.size() * charList.size());
        for(String str : list) {
            for(String ch: charList) {
                newList.add(str.concat(ch));
            }
        }
        return recurse(digits, index + 1, newList);
    }

    // 回溯算法backtrack
}
//leetcode submit region end(Prohibit modification and deletion)

}
