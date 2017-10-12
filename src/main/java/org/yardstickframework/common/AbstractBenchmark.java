package org.yardstickframework.common;

import org.yardstickframework.BenchmarkDriverAdapter;

/**
 * @author Szymon Halastra
 */
public abstract class AbstractBenchmark extends BenchmarkDriverAdapter {

  protected final String cacheName;

  protected AbstractBenchmark(String cacheName) {
    this.cacheName = cacheName;
  }
}
