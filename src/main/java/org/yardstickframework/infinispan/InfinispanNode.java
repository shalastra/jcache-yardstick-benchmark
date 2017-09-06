package org.yardstickframework.infinispan;

import javax.cache.CacheManager;

import org.infinispan.manager.DefaultCacheManager;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;
import org.yardstickframework.BenchmarkUtils;
import org.yardstickframework.common.NodeType;

import static org.yardstickframework.BenchmarkUtils.jcommander;
import static org.yardstickframework.BenchmarkUtils.println;

/**
 * @author Szymon Halastra
 */
public class InfinispanNode implements BenchmarkServer {

  private NodeType nodeType = NodeType.SERVER;

  private CacheManager cacheManager;

  public InfinispanNode() {
  }

  public InfinispanNode(NodeType nodeType) {
    this.nodeType = nodeType;
  }

  public InfinispanNode(NodeType nodeType, CacheManager cacheManager) {
    this.nodeType = nodeType;
    this.cacheManager = cacheManager;
  }

  @Override
  public void start(BenchmarkConfiguration cfg) throws Exception {
    InfinispanArguments args = new InfinispanArguments();

    jcommander(cfg.commandLineArguments(), args, "<infinispan-node>");

    switch (nodeType) {
      case CLIENT:

        println(cfg, "Infinispan client started.");

        break;
      case SERVER:

        println(cfg, "Infinispan member started.");
        println(cfg, "Infinispan benchmark arguments: " + args);
        println(cfg, "Infinispan benchmark config: " + cfg);
        break;
    }

    assert cacheManager != null;
  }

  @Override
  public void stop() throws Exception {
    ((DefaultCacheManager) cacheManager).stop();
  }

  @Override
  public String usage() {
    return BenchmarkUtils.usage(new InfinispanArguments());
  }

  public CacheManager cacheManager() {
    return cacheManager;
  }
}
