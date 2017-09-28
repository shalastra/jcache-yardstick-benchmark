package org.yardstickframework.ignite.benchmarks;

import java.util.Map;

import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

/**
 * @author Szymon Halastra
 */
public class IgniteGetBenchmark extends AbstractIgniteBenchmark {

  public IgniteGetBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    long key = new MaxRandom(args.range()).random();

    cache.get(key);

    return true;
  }
}
