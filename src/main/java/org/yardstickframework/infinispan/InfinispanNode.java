package org.yardstickframework.infinispan;

import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;
import org.yardstickframework.common.NodeType;

import static org.yardstickframework.BenchmarkUtils.jcommander;

/**
 * @author Szymon Halastra
 */
public class InfinispanNode implements BenchmarkServer {

  private NodeType nodeType = NodeType.SERVER;

  public InfinispanNode() {
  }

  public InfinispanNode(NodeType nodeType) {
    this.nodeType = nodeType;
  }

  @Override
  public void start(BenchmarkConfiguration cfg) throws Exception {
    InfinispanArguments args = new InfinispanArguments();

    jcommander(cfg.commandLineArguments(), args, "<infinispan-node>");
  }

  @Override
  public void stop() throws Exception {

  }

  @Override
  public String usage() {
    return null;
  }
}
