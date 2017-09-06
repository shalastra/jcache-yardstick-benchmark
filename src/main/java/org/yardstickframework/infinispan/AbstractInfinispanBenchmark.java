package org.yardstickframework.infinispan;

import java.util.Map;

import javax.cache.Cache;

import org.yardstickframework.BenchmarkDriverAdapter;
import org.yardstickframework.common.Tag;

/**
 * @author Szymon Halastra
 */
public class AbstractInfinispanBenchmark extends BenchmarkDriverAdapter {

  private String cacheName;

  protected Cache<Long, Tag> cache;

  protected InfinispanArguments args = new InfinispanArguments();

  InfinispanNode node;

  public AbstractInfinispanBenchmark(String cacheName) {
    this.cacheName = cacheName;
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    return false;
  }
}
