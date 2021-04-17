package com.kxj;


/**
 * @author xiangjin.kong
 * @date 2021/4/15 17:33
 * @desc lru 数组实现
 */
public class LruCacheArray {

    /**
     * lru的容量
     */
    private int capacity;
    /**
     * 链表真实长度
     */
    private int length;
    /**
     * 缓存数组
     */
    private int[] cacheArray;

    public LruCacheArray(int capacity) {
        this.capacity = capacity;
        cacheArray = new int[capacity];
        length = 0;
    }

    /**
     * 根据指定索引获取元素
     *
     * @param index
     * @return
     */
    public Integer get(int index) {
        if (index > length || index < 0) {
            return null;
        }
        // 将访问的元素至于数组最前面 其他后移
        int value = cacheArray[index];
        while (index > 0) {
            cacheArray[index] = cacheArray[--index];
        }
        cacheArray[0] = value;
        return value;
    }

    /**
     * 添加元素 头插法
     *
     * @param value
     * @param value
     */
    public void put(int value) {
        if (length == 0) {
            cacheArray[length] = value;
            length++;
            return;
        }
        if (capacity == 1) {
            cacheArray[0] = value;
            return;
        }
        // 当前数组后移
        if (length < capacity) {
            length++;
        }
        for (int i = 1; i < length; i++) {
            cacheArray[length - i] = cacheArray[length - i - 1];
        }
        cacheArray[0] = value;
    }

    public static void main(String[] args) {
        LruCacheArray cacheArray = new LruCacheArray(3);
        cacheArray.put(2);
        cacheArray.put(1);
        cacheArray.put(3);
        cacheArray.display();
        cacheArray.get(2);
        cacheArray.display();
//        cacheArray.del(2);
//        cacheArray.display();
//        cacheArray.del(3);
//        cacheArray.display();
//        cacheArray.put(4);
        cacheArray.display();
    }


    /**
     * 删除某一个元素
     *
     * @param value
     */
    public void del(int value) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (cacheArray[i] == value) {
                index = i;
                length--;
                break;
            }
        }
        if (index > -1) {
            if (index == length) {
                cacheArray[index] = 0;
                return;
            }
            for (int i = index; i <= length; i++) {
                cacheArray[index] = cacheArray[++index];
            }
        }
    }

    public int length(LRUCache lruCache) {
        return this.length;
    }

    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.println(cacheArray[i]);
        }
        System.out.println("----------------------");
    }

}
