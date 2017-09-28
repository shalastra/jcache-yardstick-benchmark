package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;

import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

/**
 * @author Szymon Halastra
 */
public class HazelcastGetBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastGetBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    long key = new MaxRandom(args.range()).random();

    cache.get(key);

    return true;
  }
}
