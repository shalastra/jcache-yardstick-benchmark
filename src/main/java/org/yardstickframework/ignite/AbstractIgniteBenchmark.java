package org.yardstickframework.ignite;

import java.util.Map;

import javax.cache.Cache;

import org.yardstickframework.BenchmarkDriverAdapter;
import org.yardstickframework.common.Tag;

/**
 * @author Szymon Halastra
 */
public class AbstractIgniteBenchmark extends BenchmarkDriverAdapter {

  private String cacheName;

  protected IgniteArguments args = new IgniteArguments();

  protected Cache<Long, Tag> cache;

  public AbstractIgniteBenchmark(String cacheName) {
    this.cacheName = cacheName;
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    return false;
  }
}
