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

  /**
   * @return Configuration file.
   */
  public String configuration() {
    return cfg;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("IgniteArguments{");
    sb.append("cfg='").append(cfg).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
