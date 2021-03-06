package org.yardstickframework.infinispan.benchmarks;

import java.util.Map;

import org.yardstickframework.common.Tag;
import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.infinispan.AbstractInfinispanBenchmark;

/**
 * @author Szymon Halastra
 */
public class InfinispanPutBenchmark extends AbstractInfinispanBenchmark {

  public InfinispanPutBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    long key = new MaxRandom(args.range()).random();

    cache.put(key, new Tag(1L, "tag_1", "tag description"));

    return true;
  }
}
