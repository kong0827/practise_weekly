package com.kxj;


import java.util.HashMap;
import java.util.Map;

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
    private int length;
    private ListNode<Map<Integer, String>> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new ListNode<>();
    }

    public String get(int key) {
        ListNode<Map<Integer, String>> newList = list;
        for (int i = 0; i < length; i++) {
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
        if (this.contain(list,  key)) {

        }
        map.put(key, value);
        ListNode<Map<Integer, String>> newNode = new ListNode<>(map);
        ListNode<Map<Integer, String>> newList = list;
        newNode.next = newList;
        list = newNode;
        length++;
        if (length > capacity) {
            deleteElementEnd();
        }
    }

    /**
     * 删除链表尾元素
     * 要删除尾结点，需要找到倒数第二个结点。尾结点为null,将倒数第二个结点置为null
     */
    private void deleteElementEnd() {
        ListNode<Map<Integer, String>> current = list;
        if (current == null) {
            return;
        }
        ListNode<Map<Integer, String>> next = current.next;
        if (next == null) {
            list = null;
            return;
        }
        while (next.next.next != null) {
            current = next;
            next = next.next;
        }
        current.next = null;
        length--;
    }

    public boolean contain(ListNode<Map<Integer, String>> list, int key) {
        Map<Integer, String> map = list.value;
        if (map.containsKey(key)) {
            return true;
        }
        return false;
    }

    public void del(int key) {
        if (list == null) {
            return;
        }
        if (this.length == 1 && this.contain(list, key)) {
            this.list = null;
        }
        ListNode<Map<Integer, String>> current = list;
        ListNode<Map<Integer, String>> next = current.next;
        for (int i = 0; i < length; i++) {
            boolean isContain = this.contain(next, key);
            if (isContain) {
                current.next = next.next;
                length--;
                break;
            }
            current = next;
            next = current.next;
        }
    }

    public int length(LRUCache lruCache) {
        return this.length;
    }

    public void reset(LRUCache lruCache) {
        this.list = null;
        this.length = 0;
    }


}