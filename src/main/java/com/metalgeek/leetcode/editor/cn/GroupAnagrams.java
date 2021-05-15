//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 735 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GroupAnagrams{
  public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
       
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return sortAns(strs);
    }
    
    public List<List<String>> streamAns(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        })).values());
    }

    public List<List<String>> sortAns(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();
      for(String str : strs) {
          char [] chars = str.toCharArray();
          Arrays.sort(chars);
          String key = String.valueOf(chars);
          List<String> list = map.getOrDefault(key, new LinkedList<>());
          list.add(str);
          map.put(key, list);
      }
      return map.values().stream().collect(Collectors.toList());
    }

    public List<List<String>> countAns(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();
      for(String str : strs) {
          int[] chars = new int[26];
          int len = str.length(), i;
          for(i =0; i < len; i++) {
              chars[str.charAt(i) - 'a'] ++;
          }
          StringBuilder sb = new StringBuilder();
          for(i =0; i < 26; i++) {
              if(chars[i] > 0) {
                  sb.append((char)('a' + i)).append(chars[i]);
              }
          }
          String key = sb.toString();
          List<String> list = map.getOrDefault(key, new LinkedList<>());
          list.add(str);
          map.put(key, list);
      }
      return map.values().stream().collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
