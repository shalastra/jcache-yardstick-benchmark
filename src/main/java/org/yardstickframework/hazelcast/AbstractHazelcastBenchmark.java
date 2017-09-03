package org.yardstickframework.hazelcast;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import javax.cache.Cache;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.*;
import lombok.extern.slf4j.Slf4j;
import org.yardstickframework.*;

import static org.yardstickframework.BenchmarkUtils.jcommander;
import static org.yardstickframework.BenchmarkUtils.println;

@Slf4j
public abstract class AbstractHazelcastBenchmark extends BenchmarkDriverAdapter {

  private String cacheName;

  protected Cache<Long, Tag> cache;

  protected HazelcastArguments args = new HazelcastArguments();

  private HazelcastNode node;

  public AbstractHazelcastBenchmark(String cacheName) {
    this.cacheName = cacheName;
  }

  @Override
  public void setUp(BenchmarkConfiguration cfg) throws Exception {
    super.setUp(cfg);

    jcommander(cfg.commandLineArguments(), args, "<hazelcast-driver>");

    HazelcastInstance instance = startedInstance(args.nodeType());

    if (instance == null) {
      node = new HazelcastNode(args.nodeType());

      node.start(cfg);
    }
    else {
      node = new HazelcastNode(args.nodeType(), instance);
    }

    waitForNodes();

    cache = node.hazelcast().getCacheManager().getCache(cacheName);

    assert cache != null;
  }


  /** {@inheritDoc} */
  @Override public void tearDown() throws Exception {
    cache.clear();

    if (node != null)
      node.stop();
  }

  /** {@inheritDoc} */
  @Override public String description() {
    String desc = BenchmarkUtils.description(cfg, this);

    return desc.isEmpty() ?
            getClass().getSimpleName() + args.description() + cfg.defaultDescription() : desc;
  }

  /** {@inheritDoc} */
  @Override public String usage() {
    return BenchmarkUtils.usage(args);
  }

  private void waitForNodes() throws Exception {
    final CountDownLatch nodesStartedLatch = new CountDownLatch(1);

    hazelcast().getCluster().addMembershipListener(new MembershipListener() {
      @Override
      public void memberAdded(MembershipEvent membershipEvent) {
        if (nodesStarted()) {
          nodesStartedLatch.countDown();
        }
      }

      @Override
      public void memberRemoved(MembershipEvent membershipEvent) {

      }

      @Override
      public void memberAttributeChanged(MemberAttributeEvent memberAttributeEvent) {

      }
    });

    if (!nodesStarted()) {
      println(cfg, "Waiting for " + args.nodes() + " nodes to start...");


      nodesStartedLatch.await();
    }
  }

  private HazelcastInstance hazelcast() {
    return node.hazelcast();
  }

  private static HazelcastInstance startedInstance(NodeType nodeType) {
    Collection<HazelcastInstance> collection = nodeType == NodeType.CLIENT ? HazelcastClient.getAllHazelcastClients() : Hazelcast.getAllHazelcastInstances();

    return collection == null || collection.isEmpty() ? null : collection.iterator().next();
  }

  private boolean nodesStarted() {
    return numFullNodes() >= args.nodes();
  }

  private int numFullNodes() {
    int n = 0;

    for (Member node : hazelcast().getCluster().getMembers()) {
      if (!node.isLiteMember())
        n++;
    }

    return n;
  }
}
