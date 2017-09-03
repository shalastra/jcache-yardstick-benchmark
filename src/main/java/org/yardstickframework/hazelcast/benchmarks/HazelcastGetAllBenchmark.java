package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

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

    for(int i = 0; i < args.batch(); i++) {
      long key = nextRandom(args.range());

      keys.add(key);
    }

    cache.getAll(keys);

    return true;
  }
}
