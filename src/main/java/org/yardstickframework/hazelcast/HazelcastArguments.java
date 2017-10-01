package org.yardstickframework.hazelcast;

import com.beust.jcommander.Parameter;
import org.yardstickframework.common.Arguments;
import org.yardstickframework.common.NodeType;

/**
 * @author Szymon Halastra
 */
public class HazelcastArguments extends Arguments {

  @Parameter(names = {"-b", "--backups"}, description = "Backups")
  private int backups;

  @Parameter(names = {"-hzcfg", "--hzConfig"}, description = "Configuration file")
  private String hzCfg = "config/hazelcast/hazelcast.xml";

  @Parameter(names = {"-hzclicfg", "--hzClientConfig"}, description = "Client configuration file")
  private String hzClientCfg = "config/hazelcast/hazelcast-client.xml";

  @Parameter(names = {"-sb", "--syncBackups"}, description = "Synchronous backups")
  private boolean syncBackups;

  @Parameter(names = {"-rb", "--readBackups"}, description = "Read backups")
  private boolean readBackups = false;

  @Parameter(names = {"-bs", "--batchSize"}, description = "Batch size")
  private int batch = 500;

  @Parameter(names = {"-rd", "--restartdelay"}, description = "Restart delay in seconds")
  private int restartDelay = 20;

  @Parameter(names = {"-rs", "--restartsleep"}, description = "Restart sleep in seconds")
  private int restartSleep = 2;

  @Parameter(names = {"-kc", "--keysCount"}, description = "Count of keys")
  private int keysCnt = 5;

  /**
   * @return Sync backups.
   */
  public boolean syncBackups() {
    return syncBackups;
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
   * @return Description.
   */
  public String description() {
    return super.description() + "-b=" + backups + "-sb=" + syncBackups + "-rb=" + readBackups;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HazelcastArguments{");
    sb.append("backups=").append(backups);
    sb.append(", hzCfg='").append(hzCfg).append('\'');
    sb.append(", hzClientCfg='").append(hzClientCfg).append('\'');
    sb.append(", syncBackups=").append(syncBackups);
    sb.append(", readBackups=").append(readBackups);
    sb.append(", batch=").append(batch);
    sb.append(", restartDelay=").append(restartDelay);
    sb.append(", restartSleep=").append(restartSleep);
    sb.append(", keysCnt=").append(keysCnt);
    sb.append('}');
    return sb.toString();
  }
}