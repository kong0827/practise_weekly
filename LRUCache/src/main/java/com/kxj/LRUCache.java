package com.kxj;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author xiangjin.kong
 * @Date 2019/11/14 14:47
 * @Version 1.0
 **/
public class LRUCache {

    /**
     * lru的容量
     */
    private int capacity;
    private int size;
    private ListNode<Map<Integer, String>> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new ListNode<>();
    }

    public String get(int key) {
        ListNode<Map<Integer, String>> newList = list;
        for (int i = 0; i < size; i++) {
            Map<Integer, String> map = newList.value;
            String val = map.get(key);
            if (val != null) {
                return val;
            }
            newList = newList.next;
        }
        return null;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void put(int key, String value) {
        Map<Integer, String> map = new HashMap<>(10);
        map.put(key, value);
        ListNode<Map<Integer, String>> newNode = new ListNode<>(map);
        ListNode<Map<Integer, String>> newList = list;
        newNode.next = newList;
        list = newNode;
        size++;
        if (size > capacity) {
            deleteElementEnd();
        }
    }

    /**
     * 删除链表尾元素
     */
    private void deleteElementEnd() {
        ListNode<Map<Integer, String>> node = list;
        while (Objects.nonNull(node.next.next)) {
            node = node.next;
        }
        ListNode<Map<Integer, String>> end = node;
        end = null;
        size--;
    }

    public boolean del(int key) {
        return true;
    }

    public int length(LRUCache lruCache) {
        return 1;
    }

    public void reset(LRUCache lruCache) {

    }


}