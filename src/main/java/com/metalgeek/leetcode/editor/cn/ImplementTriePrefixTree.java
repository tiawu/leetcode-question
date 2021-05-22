//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次 
// 
// Related Topics 设计 字典树 
// 👍 772 👎 0


package com.metalgeek.leetcode.editor.cn;


public class ImplementTriePrefixTree{
  public static void main(String[] args) {
      Trie solution = new ImplementTriePrefixTree().new Trie();
      solution.insert("apple");
      solution.search("apple");
       long t0 = System.currentTimeMillis();
       // Call solution here
       System.out.println("");
       
       long t1 = System.currentTimeMillis();
       System.out.println("time used " + (t1-t0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    boolean isLeaf;
    Trie[] childs;

    /** Initialize your data structure here. */
    public Trie() {
        isLeaf = false;
        childs = new Trie[26];

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.childs[index] == null) {
                node.childs[index] = new Trie();
            }else {
                if(node.isLeaf) {
                    node.isLeaf = false;
                }
            }
            node = node.childs[index];
        }
        node.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchNode(word);
        return node!= null && node.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

      public Trie searchNode(String prefix) {
          Trie node = this;
          int i = 0;
          for(; i < prefix.length(); i++) {
              int index = prefix.charAt(i) - 'a';
              if (node.childs[index] != null) {
                  node = node.childs[index];
              }else {
                  return null;
              }
          }
          return i == prefix.length() ? node : null;
      }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
