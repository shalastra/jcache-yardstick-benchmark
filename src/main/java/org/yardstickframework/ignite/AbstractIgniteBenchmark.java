package org.yardstickframework.ignite;

import java.util.concurrent.CountDownLatch;

import javax.cache.Cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteState;
import org.apache.ignite.Ignition;
import org.apache.ignite.events.Event;
import org.apache.ignite.lang.IgnitePredicate;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkDriverAdapter;
import org.yardstickframework.BenchmarkUtils;
import org.yardstickframework.common.Tag;

import static org.apache.ignite.events.EventType.EVT_NODE_JOINED;
import static org.yardstickframework.BenchmarkUtils.jcommander;
import static org.yardstickframework.BenchmarkUtils.println;

/**
 * @author Szymon Halastra
 */
public abstract class AbstractIgniteBenchmark extends BenchmarkDriverAdapter {

  private String cacheName;

  protected IgniteArguments args = new IgniteArguments();

  protected Cache<Long, Tag> cache;

  IgniteNode node;

  public AbstractIgniteBenchmark(String cacheName) {
    this.cacheName = cacheName;
  }

  @Override
  public void setUp(BenchmarkConfiguration cfg) throws Exception {
    super.setUp(cfg);

    jcommander(cfg.commandLineArguments(), args, "<ignite-driver>");

    if(Ignition.state() != IgniteState.STARTED) {
      node = new IgniteNode(args.nodeType());

      node.start(cfg);
    } else {
      node = new IgniteNode(args.nodeType(), Ignition.ignite());
    }

    waitForNodes();

    cache = node.ignite().getOrCreateCache("tagCache");

    assert cache != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void tearDown() throws Exception {
    if (node != null)
      node.stop();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String description() {
    String desc = BenchmarkUtils.description(cfg, this);

    return desc.isEmpty() ?
            getClass().getSimpleName() + args.description() + cfg.defaultDescription() : desc;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String usage() {
    return BenchmarkUtils.usage(args);
  }

  /**
   * @return Grid.
   */
  protected Ignite ignite() {
    return node.ignite();
  }

  private void waitForNodes() throws Exception {
    final CountDownLatch nodesStartedLatch = new CountDownLatch(1);

    ignite().events().localListen(new IgnitePredicate<Event>() {
      @Override
      public boolean apply(Event gridEvt) {
        if (nodesStarted())
          nodesStartedLatch.countDown();

        return true;
      }
    }, EVT_NODE_JOINED);

    if (!nodesStarted()) {
      println(cfg, "Waiting for " + (args.nodes() - 1) + " nodes to start...");

      nodesStartedLatch.await();
    }
  }

  private boolean nodesStarted() {
    return ignite().cluster().nodes().size() >= args.nodes();
  }

}
