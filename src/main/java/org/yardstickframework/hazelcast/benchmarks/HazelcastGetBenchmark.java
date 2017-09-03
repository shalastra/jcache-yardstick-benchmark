package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;

import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class HazelcastGetBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastGetBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    long key = nextRandom(args.range());

    cache.get(key);

    return true;
  }
}
