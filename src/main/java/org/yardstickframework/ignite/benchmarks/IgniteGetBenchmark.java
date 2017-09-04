package org.yardstickframework.ignite.benchmarks;

import java.util.Map;

import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class IgniteGetBenchmark extends AbstractIgniteBenchmark {

  public IgniteGetBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    long key = nextRandom(args.range());

    cache.get(key);

    return true;
  }
}
