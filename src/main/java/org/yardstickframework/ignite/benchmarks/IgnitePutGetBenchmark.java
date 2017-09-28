package org.yardstickframework.ignite.benchmarks;

import java.util.Map;

import org.yardstickframework.common.Tag;
import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

/**
 * @author Szymon Halastra
 */
public class IgnitePutGetBenchmark extends AbstractIgniteBenchmark {

  public IgnitePutGetBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    long key = new MaxRandom(args.range()).random();

    Tag tag = cache.get(key);

    cache.put(key, new Tag(key, "name_" + key, "description_" + key));

    return true;
  }
}
