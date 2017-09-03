package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.yardstickframework.common.Tag;
import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class HazelcastPutBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastPutBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    long key = nextRandom(args.range());

    cache.put(key, new Tag(1L, "tag_1", "tag description"));

    return true;
  }
}
