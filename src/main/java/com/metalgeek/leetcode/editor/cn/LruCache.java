//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// 最多调用 3 * 104 次 get 和 put
//
// Related Topics 设计
// 👍 1390 👎 0


package com.metalgeek.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache{
    public static void main(String[] args) {
        LRUCache solution = new LRUCache(2);
        solution.put(2, 1);
        solution.put(2, 2);
        solution.get(2);
        solution.put(1,1);
        solution.put(4,1);
        solution.get(2);

         long t0 = System.currentTimeMillis();
         // Call solution here
         System.out.println("");

         long t1 = System.currentTimeMillis();
         System.out.println("time used " + (t1-t0));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    class BiDirectNode {
        int key;
        int value;
        BiDirectNode prev;
        BiDirectNode next;

        public BiDirectNode() {
        }

        public BiDirectNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, BiDirectNode> keyMap;
    BiDirectNode head, tail;

    public LRUCache(int capacity) {
        // 初始化容器
        this.capacity = capacity;
        keyMap = new HashMap<>(capacity);

        // 初始化双向链表
        head = new BiDirectNode();
        tail = new BiDirectNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        BiDirectNode node = keyMap.get(key);
        if(node == null) {
            return -1;
        }
        modeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        BiDirectNode node;
        if(keyMap.containsKey(key)) {
            node = keyMap.get(key);
            node.value = value;
            modeToHead(node);
        }else {
            if(keyMap.size() == capacity) {
                node = removeTail();
                keyMap.remove(node.key);

                node.key = key;
                node.value = value;

                addToHead(node);
                keyMap.put(key, node);

            }else {
                node = new BiDirectNode(key, value);
                addToHead(node);
                keyMap.put(key, node);
            }
        }
    }

    public void addToHead(BiDirectNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(BiDirectNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void modeToHead(BiDirectNode node) {
        removeNode(node);
        addToHead(node);
    }

    public BiDirectNode removeTail() {
        // 加个保护? 按题解不需要, 除非capacity == 0
        if(tail.prev != head) {
            BiDirectNode node = tail .prev;
            removeNode(node);
            return node;
        }
        return null;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
