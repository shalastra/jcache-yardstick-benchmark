package ch.cern.c2mon.hazelcast.arguments;

import ch.cern.c2mon.NodeType;
import com.beust.jcommander.Parameter;

/**
 * @author Szymon Halastra
 */
public class HazelcastArguments {
  @Parameter(names = {"-nn", "--nodeNumber"}, description = "Node number")
  private int nodes = 1;

  /** */
  @Parameter(names = {"-b", "--backups"}, description = "Backups")
  private int backups;

  @Parameter(names = {"-hzcfg", "--hzConfig"}, description = "Configuration file")
  private String hzCfg = "config/hazelcast/hazelcast.xml";

  @Parameter(names = {"-hzclicfg", "--hzClientConfig"}, description = "Client configuration file")
  private String hzClientCfg = "config/hazelcast/hazelcast-client.xml";

  /** */
  @Parameter(names = {"-sb", "--syncBackups"}, description = "Synchronous backups")
  private boolean syncBackups;

  /** */
  @Parameter(names = {"-nt", "--nodeType"}, description = "Node type")
  private NodeType nodeType = NodeType.SERVER;

  /** */
  @Parameter(names = {"-r", "--range"}, description = "Key range")
  private int range = 1_000_000;

  /** */
  @Parameter(names = {"-rb", "--readBackups"}, description = "Read backups")
  private boolean readBackups = false;

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

  /** */
  @Parameter(names = {"-td", "--txDurability"}, description = "Transaction durability")
  private int txDurability = 1;

  /**
   * @return Sync backups.
   */
  public boolean syncBackups() {
    return syncBackups;
  }

  /**
   * @return Node type.
   */
  public NodeType nodeType() {
    return nodeType;
  }

  /**
   * @return Backups.
   */
  public int backups() {
    return backups;
  }

  /**
   * @return Read backups flag.
   */
  public boolean readBackups() {
    return readBackups;
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
    return hzCfg;
  }

  /**
   * @return Configuration file.
   */
  public String clientConfiguration() {
    return hzClientCfg;
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
   * @return Transaction durability.
   */
  public int txDurability() {
    return txDurability;
  }

  /**
   * @return Description.
   */
  public String description() {
    return "-nn=" + nodes + "-b=" + backups + "-sb=" + syncBackups + "-nt=" + nodeType.name() + "-rb=" + readBackups;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" +
            "nodes=" + nodes +
            ", backups=" + backups +
            ", hzConfig='" + hzCfg + '\'' +
            ", hzClientCfg='" + hzClientCfg + '\'' +
            ", syncBackups=" + syncBackups +
            ", nodeType=" + nodeType.name() +
            ", range=" + range +
            ']';
  }
}