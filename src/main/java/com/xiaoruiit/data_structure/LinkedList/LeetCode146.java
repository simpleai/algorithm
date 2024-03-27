package com.xiaoruiit.data_structure.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 中等 146. LRU 缓存
 * @author hanxiaorui
 * @date 2023/2/20
 */
public class LeetCode146 {

    class Node {
        int key = -1, value = -1;
        Node pre,next;
    }

    private static Map<Integer, Node> map = new HashMap<>();

    private Node head,tail;
    int size;
    int capacity;

    public LeetCode146(int capacity) {
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.pre = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        // 不存在，返回-1
        Node temp = map.get(key);
        if (temp == null){
            return -1;
        } else {
            // 存在，node删除节点，插入到头部
            // 从map获取已存在的节点
            // 删除
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;

            // 头插
            head.next.pre = temp;
            temp.next = head.next;
            head.next = temp;
            temp.pre = head;

            return temp.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){// 存在，更新
            // 从map获取已存在的节点
            Node temp = map.get(key);
            temp.value = value;
            // 删除
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;

            // 头插
            head.next.pre = temp;
            temp.next = head.next;
            head.next = temp;
            temp.pre = head;

            // map更新
            map.put(key, temp);

        } else {// 不存在
            if(size < capacity){// node头部插入新节点,map插入
                insertNodeAndMap(key, value);

                size++;
            } else {// node删除尾部节点，头部插入新节点;map删除旧key,插入新key
                // map 删除旧key
                map.remove(tail.pre.key);
                // node 删除尾部节点
                tail.pre.next = null;
                tail = tail.pre;

                // node头部插入，map插入
                insertNodeAndMap(key, value);
            }
        }
    }

    private void insertNodeAndMap(int key, int value) {
        // node 头部插入
        Node temp = new Node();
        temp.key = key;
        temp.value = value;

        head.next.pre = temp;
        temp.next = head.next;
        head.next = temp;
        temp.pre = head;

        // map 插入
        map.put(key, temp);
    }

    public static void main(String[] args) {
        LeetCode146 cache = new LeetCode146(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
