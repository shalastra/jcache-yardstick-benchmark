package org.yardstickframework.ignite.benchmarks;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.yardstickframework.common.Tag;
import org.yardstickframework.common.random.MaxRandom;
import org.yardstickframework.ignite.AbstractIgniteBenchmark;

/**
 * @author Szymon Halastra
 */
public class IgnitePutAllBenchmark extends AbstractIgniteBenchmark {

  public IgnitePutAllBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    SortedMap<Long, Tag> tags = new TreeMap<>();

    for (int i = 0; i < args.batch(); i++) {
      long key = new MaxRandom(args.range()).random();

      tags.put(key, new Tag(key, "name_" + key, "description_" + key));
    }

    cache.putAll(tags);

    return true;
  }
}
