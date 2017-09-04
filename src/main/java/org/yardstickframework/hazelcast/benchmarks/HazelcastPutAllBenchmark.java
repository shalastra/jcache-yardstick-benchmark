package org.yardstickframework.hazelcast.benchmarks;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.yardstickframework.common.Tag;
import org.yardstickframework.hazelcast.AbstractHazelcastBenchmark;

import static org.yardstickframework.common.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
public class HazelcastPutAllBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastPutAllBenchmark() {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> ctx) throws Exception {
    SortedMap<Long, Tag> tags = new TreeMap<>();

    for (int i = 0; i < args.batch(); i++) {
      long key = nextRandom(args.range());

      tags.put(key, new Tag(key, "name_" + key, "description_" + key));
    }

    cache.putAll(tags);

    return true;
  }
}