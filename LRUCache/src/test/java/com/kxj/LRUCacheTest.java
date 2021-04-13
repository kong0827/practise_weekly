package com.kxj;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName LRUCacheTest
 * @Description TODO
 * @Author kongxiangjin
 * @Date 2019/11/14 14:52
 * @Version 1.0
 **/
public class LRUCacheTest {
    @Test
    public void test1() {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(1, 'a');
        lruCache.put(2, 'b');
        lruCache.put(3, 'b');
        lruCache.put(4, 'b');
        lruCache.put(5, 'b');
        lruCache.put(6, 'b');
        lruCache.put(7, 'b');
        lruCache.put(8, 'b');
        lruCache.put(9, 'b');
        lruCache.put(18, 'b');
        lruCache.put(28, 'b');

        String result = lruCache.get(1);
        Assert.assertEquals('a', result);
        result = lruCache.get(2);
        Assert.assertEquals('b', result);
        result = lruCache.get(3);
        Assert.assertEquals(null, result);
    }

    @Test
    public void test2() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 'a');
        lruCache.put(2, 'b');
        lruCache.put(3, 'c');

        String result = lruCache.get(3);
        Assert.assertEquals('c', result);

        result = lruCache.get(1);
        Assert.assertEquals(null, result);
    }

    @Test
    public void test3() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 'a');
        lruCache.put(2, 'b');

        String result = lruCache.get(1);
        Assert.assertEquals('a', result);

        lruCache.del(1);
        result = lruCache.get(1);
        Assert.assertEquals(null, result);

        int lruCacheLength = lruCache.length(lruCache);
        Assert.assertEquals(1, lruCacheLength);

        lruCache.put(3, 'c');
        result = lruCache.get(3);
        Assert.assertEquals('c', result);
        lruCacheLength = lruCache.length(lruCache);
        Assert.assertEquals(2, lruCacheLength);
    }

    @Test
    public void test4() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 'a');
        lruCache.put(2, 'b');

        String result = lruCache.get(2);
        Assert.assertEquals('b', result);

        lruCache.reset(lruCache);

        result = lruCache.get(1);
        Assert.assertEquals(null, result);
        int lruCacheLength = lruCache.length(lruCache);
        Assert.assertEquals(0, lruCacheLength);

        lruCache.put(2, 'b');
        result = lruCache.get(2);
        Assert.assertEquals('b', result);
        lruCacheLength = lruCache.length(lruCache);
        Assert.assertEquals(1, lruCacheLength);

    }

    @Test
    public void test5() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 'a');
        lruCache.put(2, 'b');
        lruCache.put(2, 'd');

        String result = lruCache.get(2);
        Assert.assertEquals('d', result);
    }

}
