package org.yardstickframework.ignite;

import com.beust.jcommander.Parameter;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.yardstickframework.common.Arguments;
import org.yardstickframework.common.NodeType;

/**
 * @author Szymon Halastra
 */
public class IgniteArguments extends Arguments {

  /** */
  @Parameter(names = {"-b", "--backups"}, description = "Backups")
  private int backups;

  /** */
  @Parameter(names = {"-cfg", "--Config"}, description = "Configuration file")
  private String cfg = "config/ignite/ignite-config.xml";

  /** */
  @Parameter(names = {"-sm", "--syncMode"}, description = "Synchronization mode")
  private CacheWriteSynchronizationMode syncMode = CacheWriteSynchronizationMode.PRIMARY_SYNC;

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
  @Override
  public String description() {
    return super.description() + "-b=" + backups + "-sb=" + syncMode + "-nt=" + "-rb=" + backups;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("IgniteArguments{");
    sb.append("backups=").append(backups);
    sb.append(", cfg='").append(cfg).append('\'');
    sb.append(", syncMode=").append(syncMode);
    sb.append(", batch=").append(batch);
    sb.append(", restartDelay=").append(restartDelay);
    sb.append(", restartSleep=").append(restartSleep);
    sb.append(", keysCnt=").append(keysCnt);
    sb.append('}');
    return sb.toString();
  }
}
