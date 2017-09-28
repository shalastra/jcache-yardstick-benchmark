package org.yardstickframework.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;
import org.yardstickframework.BenchmarkUtils;
import org.yardstickframework.common.NodeType;
import org.yardstickframework.common.Tag;

import static org.yardstickframework.BenchmarkUtils.jcommander;
import static org.yardstickframework.BenchmarkUtils.println;

/**
 * @author Szymon Halastra
 */
public class IgniteNode implements BenchmarkServer {

  private Ignite ignite;

  private NodeType nodeType = NodeType.SERVER;

  public IgniteNode() {
  }

  public IgniteNode(NodeType nodeType) {
    this.nodeType = nodeType;
  }

  public IgniteNode(NodeType nodeType, Ignite ignite) {
    this.nodeType = nodeType;
    this.ignite = ignite;
  }

  @Override
  public void start(BenchmarkConfiguration cfg) throws Exception {
    IgniteArguments args = new IgniteArguments();

    jcommander(cfg.commandLineArguments(), args, "<ignite-node>");

    switch (nodeType) {
      case CLIENT:
        IgniteConfiguration clientConfig = new IgniteConfiguration();
        clientConfig.setClientMode(true);

        ignite = Ignition.start(clientConfig);

        println(cfg, "Ignite client started");

        break;
      case SERVER:
        IgniteConfiguration serverConfig = new IgniteConfiguration();

        CacheConfiguration cacheConfiguration = new CacheConfiguration();

        cacheConfiguration.setName("tagCache");
        cacheConfiguration.setTypes(Long.class, Tag.class);

        serverConfig.setCacheConfiguration(cacheConfiguration);

        ignite = Ignition.start(serverConfig);

        println(cfg, "Ignite member started");
        println(cfg, "Ignite benchmark arguments: " + args);
        println(cfg, "Ignite benchmark config: " + cfg);

        break;
    }

    assert ignite != null;
  }

  @Override
  public void stop() throws Exception {
    Ignition.stopAll(true);
  }

  @Override
  public String usage() {
    return BenchmarkUtils.usage(new IgniteArguments());
  }

  public Ignite ignite() {
    return ignite;
  }
}
