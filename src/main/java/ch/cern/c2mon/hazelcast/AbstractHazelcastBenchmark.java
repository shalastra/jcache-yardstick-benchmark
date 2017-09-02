package ch.cern.c2mon.hazelcast;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.cache.Cache;

import ch.cern.c2mon.NodeType;
import ch.cern.c2mon.Tag;
import ch.cern.c2mon.hazelcast.arguments.HazelcastArguments;
import ch.cern.c2mon.hazelcast.server.HazelcastNode;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkDriverAdapter;

import static org.yardstickframework.BenchmarkUtils.jcommander;

public abstract class AbstractHazelcastBenchmark extends BenchmarkDriverAdapter {

  private String cacheName;

  protected Cache<Long, Tag> cache;

  protected HazelcastArguments args;

  private HazelcastNode node;

  public AbstractHazelcastBenchmark(String cacheName) {
    this.cacheName = cacheName;
  }

  @Override
  public void setUp(BenchmarkConfiguration cfg) throws Exception {
    super.setUp(cfg);

    jcommander(cfg.commandLineArguments(), args, "<hazelcast-driver>");

    HazelcastInstance instance = startedInstance(args.nodeType());

    cache = node.hazelcast().getCacheManager().getCache(cacheName);
  }

  private HazelcastInstance startedInstance(NodeType nodeType) {
    Collection<HazelcastInstance> collection = nodeType == NodeType.CLIENT ? HazelcastClient.getAllHazelcastClients() : Hazelcast.getAllHazelcastInstances();

    return collection == null || collection.isEmpty() ? null : collection.iterator().next();
  }

  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    return false;
  }
}
