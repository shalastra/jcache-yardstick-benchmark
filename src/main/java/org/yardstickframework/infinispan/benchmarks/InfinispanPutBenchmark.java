package org.yardstickframework.infinispan.benchmarks;

import java.util.Map;

import org.yardstickframework.common.Tag;
import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;
import org.yardstickframework.infinispan.AbstractInfinispanBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class InfinispanPutBenchmark extends AbstractInfinispanBenchmark {

  public InfinispanPutBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    long key = nextRandom(args.range());

    cache.put(key, new Tag(1L, "tag_1", "tag description"));

    return true;
  }
}
