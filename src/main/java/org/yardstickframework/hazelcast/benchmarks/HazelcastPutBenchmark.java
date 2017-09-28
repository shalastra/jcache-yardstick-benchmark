package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;

import org.yardstickframework.common.Tag;
import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

/**
 * @author Szymon Halastra
 */
public class HazelcastPutBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastPutBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    long key = new MaxRandom(args.range()).random();

    cache.put(key, new Tag(1L, "tag_1", "tag description"));

    return true;
  }
}
