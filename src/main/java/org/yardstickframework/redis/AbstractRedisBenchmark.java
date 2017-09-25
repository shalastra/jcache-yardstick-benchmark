package org.yardstickframework.redis;

import java.util.Map;

import org.yardstickframework.BenchmarkDriverAdapter;

/**
 * @author Szymon Halastra
 */
public class AbstractRedisBenchmark extends BenchmarkDriverAdapter {

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    return false;
  }
}
