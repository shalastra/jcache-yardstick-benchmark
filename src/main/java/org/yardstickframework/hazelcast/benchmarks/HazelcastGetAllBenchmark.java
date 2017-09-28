package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

/**
 * @author Szymon Halastra
 */
public class HazelcastGetAllBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastGetAllBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    SortedSet<Long> keys = new TreeSet<>();

    for (int i = 0; i < args.batch(); i++) {
      long key = new MaxRandom(args.range()).random();

      keys.add(key);
    }

    cache.getAll(keys);

    return true;
  }
}
