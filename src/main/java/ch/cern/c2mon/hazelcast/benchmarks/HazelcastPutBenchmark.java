package ch.cern.c2mon.hazelcast.benchmarks;

import java.util.Map;

import ch.cern.c2mon.Tag;
import ch.cern.c2mon.hazelcast.AbstractHazelcastBenchmark;
import lombok.extern.slf4j.Slf4j;

import static ch.cern.c2mon.Utils.nextRandom;

/**
 * @author Szymon Halastra
 */
@Slf4j
public class HazelcastPutBenchmark extends AbstractHazelcastBenchmark {

  public HazelcastPutBenchmark(String cacheName) {
    super("tagCache");
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    long key = nextRandom(args.range());

    cache.put(key, new Tag(1L, "tag_1", "tag description"));

    log.info("Tag put into cache");

    return true;
  }
}
