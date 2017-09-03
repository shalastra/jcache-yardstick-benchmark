package org.yardstickframework.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;
import org.yardstickframework.BenchmarkUtils;
import org.yardstickframework.common.NodeType;

import static org.yardstickframework.BenchmarkUtils.jcommander;

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
        break;
      case SERVER:
      case LITE_MEMBER:
        break;
    }
  }

  @Override
  public void stop() throws Exception {
    Ignition.stopAll(true);
  }

  @Override
  public String usage() {
    return BenchmarkUtils.usage(new IgniteArguments());
  }
}
