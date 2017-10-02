package org.yardstickframework.redis;

import com.beust.jcommander.Parameter;
import org.yardstickframework.common.Arguments;

/**
 * @author Szymon Halastra
 */
public class RedisArguments extends Arguments {

  /** */
  @Parameter(names = {"-cfg", "--Config"}, description = "Configuration file")
  private String cfg = "config/redisson/redisson-config.xml";

  /**
   * @return Configuration file.
   */
  public String configuration() {
    return cfg;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("RedisArguments{");
    sb.append("cfg='").append(cfg).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
