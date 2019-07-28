package com.hansonkim.codingtest.cache;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCache {
  private LinkedList<String> cache;
  private int hitDelay;
  private int missDelay;
  private int cacheSize;

  public LRUCache(int hitDelay, int missDelay) {
    this.hitDelay = hitDelay;
    this.missDelay = missDelay;
  }

  public int GetDelaySum(int cacheSize, List<String> args) {
    this.cacheSize = cacheSize;
    cache = new LinkedList();
    AtomicInteger sum = new AtomicInteger();
    // 돌면서 hit 되나 확인하고
    args.stream().forEach(key -> {
      boolean isHit = isHit(key);
      //결과 값에 따라 delay 점수 더해서
      if(isHit) {
        sum.addAndGet(this.hitDelay);
      } else {
        sum.addAndGet(this.missDelay);
      }
    });
    // 반환
    return sum.get();
  }

  private boolean isHit(String key) {
    boolean isHit = cache.contains(key);
    insertToCache(key);
    return isHit;
  }

  private void insertToCache(String key) {
    if(cache.size() < this.cacheSize) {
      // cache size check 하고 캐시 사이즈 보다 작으면 삽입
      this.cache.addFirst(key);
    } else {
      // 캐시가 꽉찼으면 마지막거 제거하고 앞에다 삽입
      this.cache.removeLast();
      this.cache.addFirst(key);
    }
  }
}
