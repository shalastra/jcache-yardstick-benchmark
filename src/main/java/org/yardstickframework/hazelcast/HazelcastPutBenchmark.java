package org.yardstickframework.hazelcast;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import static org.yardstickframework.hazelcast.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
@Slf4j
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
