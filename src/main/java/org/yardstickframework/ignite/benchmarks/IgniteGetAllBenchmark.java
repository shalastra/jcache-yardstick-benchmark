package org.yardstickframework.ignite.benchmarks;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class IgniteGetAllBenchmark extends AbstractIgniteBenchmark {

  public IgniteGetAllBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    SortedSet<Long> keys = new TreeSet<>();

    for(int i = 0; i < args.batch(); i++) {
      long key = nextRandom(args.range());

      keys.add(key);
    }

    cache.getAll(keys);

    return true;
  }
}
