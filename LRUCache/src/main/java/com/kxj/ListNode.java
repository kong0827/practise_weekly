package com.kxj;

/**
 * @author xiangjin.kong
 * @date 2021/4/13 13:53
 * @desc 链表
 */
public class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }
}
