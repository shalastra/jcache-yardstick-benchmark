package org.yardstickframework.ignite;

import com.beust.jcommander.Parameter;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.yardstickframework.common.NodeType;

/**
 * @author Szymon Halastra
 */
public class IgniteArguments {

  /** */
  @Parameter(names = {"-nn", "--nodeNumber"}, description = "Node number")
  private int nodes = 1;

  /** */
  @Parameter(names = {"-b", "--backups"}, description = "Backups")
  private int backups;

  /** */
  @Parameter(names = {"-cfg", "--Config"}, description = "Configuration file")
  private String cfg = "config/ignite/ignite-config.xml";

  /** */
  @Parameter(names = {"-sm", "--syncMode"}, description = "Synchronization mode")
  private CacheWriteSynchronizationMode syncMode = CacheWriteSynchronizationMode.PRIMARY_SYNC;

  @Parameter(names = {"-nt", "--nodeType"}, description = "Node type")
  private NodeType nodeType = NodeType.SERVER;

  @Parameter(names = {"-r", "--range"}, description = "Key range")
  private int range = 1_000_000;

  /** */
  @Parameter(names = {"-bs", "--batchSize"}, description = "Batch size")
  private int batch = 500;

  /** */
  @Parameter(names = {"-rd", "--restartdelay"}, description = "Restart delay in seconds")
  private int restartDelay = 20;

  /** */
  @Parameter(names = {"-rs", "--restartsleep"}, description = "Restart sleep in seconds")
  private int restartSleep = 2;

  /** */
  @Parameter(names = {"-kc", "--keysCount"}, description = "Count of keys")
  private int keysCnt = 5;

  /**
   * @return Node type.
   */
  public NodeType nodeType() {
    return nodeType;
  }

  /**
   * @return Synchronization.
   */
  public CacheWriteSynchronizationMode syncMode() {
    return syncMode;
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
   * @return Configuration file.
   */
  public String configuration() {
    return cfg;
  }

  /**
   * @return Batch size.
   */
  public int batch() {
    return batch;
  }

  /**
   * @return Delay in second which used in nodes restart algorithm.
   */
  public int restartDelay() {
    return restartDelay;
  }

  /**
   * @return Sleep in second which used in nodes restart algorithm.
   */
  public int restartSleep() {
    return restartSleep;
  }

  /**
   * @return Keys count.
   */
  public int keysCount() {
    return keysCnt;
  }

  /**
   * @return Description.
   */
  public String description() {
    return "-nn=" + nodes + "-b=" + backups + "-sb=" + syncMode + "-nt=" + nodeType.name() + "-rb=" + backups;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" +
            "nodes=" + nodes +
            ", backups=" + backups +
            ", hzConfig='" + cfg + '\'' +
            ", hzClientCfg='" + cfg + '\'' +
            ", backups=" + backups +
            ", nodeType=" + nodeType.name() +
            ", range=" + range +
            ']';
  }
}
