package org.yardstickframework.ignite.benchmarks;

import java.util.Map;

import org.yardstickframework.common.Tag;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class IgnitePutGetBenchmark extends AbstractIgniteBenchmark {

  public IgnitePutGetBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    long key = nextRandom(args.range());

    Tag tag = cache.get(key);

    if(tag != null) {
      key = nextRandom(args.range());
    }

    cache.put(key, new Tag(key, "name_" + key, "description_" + key));

    return true;
  }
}
