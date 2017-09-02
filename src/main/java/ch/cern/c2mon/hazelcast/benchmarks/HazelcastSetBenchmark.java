package ch.cern.c2mon.hazelcast.benchmarks;

import java.util.Map;

import ch.cern.c2mon.hazelcast.AbstractHazelcastBenchmark;

/**
 * @author Szymon Halastra
 */
public class HazelcastSetBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastSetBenchmark(String cacheName) {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    long key = nextRandom(args.range());

    cache.get(key);

    return true;
  }
}
