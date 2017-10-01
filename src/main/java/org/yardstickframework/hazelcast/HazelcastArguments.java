package org.yardstickframework.hazelcast;

import com.beust.jcommander.Parameter;
import org.yardstickframework.common.Arguments;
import org.yardstickframework.common.NodeType;

/**
 * @author Szymon Halastra
 */
public class HazelcastArguments extends Arguments {

  @Parameter(names = {"-hzcfg", "--hzConfig"}, description = "Configuration file")
  private String hzCfg = "config/hazelcast/hazelcast.xml";

  @Parameter(names = {"-hzclicfg", "--hzClientConfig"}, description = "Client configuration file")
  private String hzClientCfg = "config/hazelcast/hazelcast-client.xml";

  @Parameter(names = {"-bs", "--batchSize"}, description = "Batch size")
  private int batch = 500;

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
   * @return Description.
   */
  public String description() {
    return super.description() + "-bs=" + batch();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HazelcastArguments{");
    sb.append("hzCfg='").append(hzCfg).append('\'');
    sb.append(", hzClientCfg='").append(hzClientCfg).append('\'');
    sb.append(", batch=").append(batch);
    sb.append('}');
    return sb.toString();
  }
}