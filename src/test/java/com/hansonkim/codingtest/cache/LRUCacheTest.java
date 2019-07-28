package com.hansonkim.codingtest.cache;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {
  // Cache Hit Delay: 1
  // Cache Miss Delay: 5

  // Cache Size: 3
  // Data Strings: ["donut", "juice", "apple", "banana"]
  // Output Value: 20

  // Cache Size: 3
  // Data Strings: ["donut", "juice", "apple", "donut"]
  // Output Value: 16

  // Cache Size: 0
  // Data Strings: ["donut", "juice", "apple", "donut"]
  // Output Value: 20

  // Cache Size: 5
  // Data Strings: ["donut", "juice", "apple", "donut", "apple", "coffee"]
  // Output Value: 22

  // Cache Size: 2
  // Data Strings: ["donut", "juice", "juice", "apple", "donut"]
  // Output Value: 21

  @Test
  public void test1() {
    LRUCache lruCache = new LRUCache(1, 5);
    int delay = lruCache.GetDelaySum(3, Arrays.asList("donut", "juice", "apple", "banana"));
    Assert.assertTrue(delay == 20);
  }

  @Test
  public void test2() {
    LRUCache lruCache = new LRUCache(1, 5);
    int delay = lruCache.GetDelaySum(3, Arrays.asList("donut", "juice", "apple", "donut"));
    Assert.assertTrue(delay == 16);
  }

  @Test
  public void test3() {
    LRUCache lruCache = new LRUCache(1, 5);
    int delay = lruCache.GetDelaySum(3, Arrays.asList("donut", "juice", "apple", "donut"));
    Assert.assertTrue(delay == 16);
  }

  @Test
  public void test4() {
    LRUCache lruCache = new LRUCache(1, 5);
    int delay = lruCache.GetDelaySum(5, Arrays.asList("donut", "juice", "apple", "donut", "apple", "coffee"));
    Assert.assertTrue(delay == 22);
  }

  @Test
  public void test5() {
    LRUCache lruCache = new LRUCache(1, 5);
    int delay = lruCache.GetDelaySum(2, Arrays.asList("donut", "juice", "juice", "apple", "donut"));
    Assert.assertTrue(delay == 21);
  }

}
