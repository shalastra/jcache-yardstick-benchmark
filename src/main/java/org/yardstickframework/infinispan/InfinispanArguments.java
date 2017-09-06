package org.yardstickframework.infinispan;

import com.beust.jcommander.Parameter;
import org.infinispan.transaction.LockingMode;
import org.infinispan.util.concurrent.IsolationLevel;
import org.yardstickframework.common.NodeType;

/**
 * @author Szymon Halastra
 */
public class InfinispanArguments {

  /** */
  @Parameter(names = {"-nn", "--nodeNumber"}, description = "Node number")
  private int nodes = 1;

  /** */
  @Parameter(names = {"-b", "--backups"}, description = "Backups")
  private int backups;

  /** */
  @Parameter(names = {"-iscfg", "--isConfig"}, description = "Configuration file")
  private String isCfg = "config/infinispan-config.xml";

  /** */
  @Parameter(names = {"-as", "--async"}, description = "Asynchronous communication")
  private boolean async;

  /** */
  @Parameter(names = {"-cm", "--clientMode"}, description = "Client mode")
  private boolean clientMode;

  /** */
  @Parameter(names = {"-r", "--range"}, description = "Key range")
  private int range = 1_000_000;

  /** */
  @Parameter(names = {"-bs", "--batchSize"}, description = "Batch size")
  private int batch = 500;

  @Parameter(names = {"-nt", "--nodeType"}, description = "Node type")
  private NodeType nodeType = NodeType.SERVER;

  /**
   * @return {@code True} whether communication is asynchronous or not.
   */
  public boolean async() {
    return async;
  }

  /**
   * @return Client mode.
   */
  public boolean clientMode() {
    return clientMode;
  }

  /**
   * @return Backups.
   */
  public int backups() {
    return backups;
  }

  /**
   * @return Nodes.
   */
  public int nodes() {
    return nodes;
  }

  /**
   * @return Key range, from {@code 0} to this number.
   */
  public int range() {
    return range;
  }

  /**
   * @return Batch size.
   */
  public int batch() {
    return batch;
  }

  /**
   * @return Configuration file.
   */
  public String configuration() {
    return isCfg;
  }

  /**
   * @return Description.
   */
  public String description() {
    return "-nn=" + nodes + "-b=" + backups + "-as=" + async + "-cm=" + clientMode;
  }

  /** {@inheritDoc} */
  @Override public String toString() {
    return getClass().getSimpleName() + " [" +
            "nodes=" + nodes +
            ", backups=" + backups +
            ", isConfig='" + isCfg + '\'' +
            ", async=" + async +
            ", clientMode=" + clientMode +
            ", range=" + range +
            ']';
  }
}
