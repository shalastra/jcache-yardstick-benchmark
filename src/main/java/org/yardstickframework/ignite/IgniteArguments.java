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
  @Parameter(names = {"-cfg", "--Config"}, description = "Configuration file")
  private String cfg = "config/ignite/ignite-config.xml";

  /** */
  @Parameter(names = {"-bs", "--batchSize"}, description = "Batch size")
  private int batch = 500;

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
   * @return Description.
   */
  @Override
  public String description() {
    return super.description() + "-bs=" + batch();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("IgniteArguments{");
    sb.append("cfg='").append(cfg).append('\'');
    sb.append(", batch=").append(batch);
    sb.append('}');
    return sb.toString();
  }
}
