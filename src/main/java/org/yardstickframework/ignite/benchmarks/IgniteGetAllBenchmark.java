package org.yardstickframework.ignite.benchmarks;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

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
      long key = new MaxRandom(args.range()).random();

      keys.add(key);
    }

    cache.getAll(keys);

    return true;
  }
}
