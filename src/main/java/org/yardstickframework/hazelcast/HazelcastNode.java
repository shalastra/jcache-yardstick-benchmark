package org.yardstickframework.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;
import org.yardstickframework.BenchmarkUtils;

import static org.yardstickframework.BenchmarkUtils.jcommander;
import static org.yardstickframework.BenchmarkUtils.println;

/**
 * @author Szymon Halastra
 */
@Slf4j
public class HazelcastNode implements BenchmarkServer {

  private HazelcastInstance instance;

  private NodeType nodeType = NodeType.SERVER;

  public HazelcastNode() {

  }

  public HazelcastNode(NodeType nodeType) {
    this.nodeType = nodeType;
  }

  public HazelcastNode(NodeType nodeType, HazelcastInstance instance) {
    this.nodeType = nodeType;
    this.instance = instance;
  }

  @Override
  public void start(BenchmarkConfiguration cfg) throws Exception {
    HazelcastArguments args = new HazelcastArguments();

    jcommander(cfg.commandLineArguments(), args, "<hazelcast-node>");

    switch (nodeType) {
      case CLIENT:
        ClientConfig clientCfg = new XmlClientConfigBuilder(args.clientConfiguration()).build();

        instance = HazelcastClient.newHazelcastClient(clientCfg);

        println(cfg, "Hazelcast client started.");

        break;

      case SERVER:
      case LITE_MEMBER:
        Config instanceCfg = new XmlConfigBuilder(args.configuration()).build();

        if (nodeType == NodeType.LITE_MEMBER)
          instanceCfg.setLiteMember(true);

        println(cfg, "Starting Hazelcast with configuration: " + instanceCfg);

        instance = Hazelcast.newHazelcastInstance(instanceCfg);

        println(cfg, "Hazelcast member started.");
        println(cfg, "Hazelcast benchmark arguments: " + args);
        println(cfg, "Hazelcast benchmark config: " + cfg);

        break;
    }

    assert instance != null;
  }

  @Override
  public void stop() throws Exception {
    Hazelcast.shutdownAll();
    HazelcastClient.shutdownAll();
  }

  @Override
  public String usage() {
    return BenchmarkUtils.usage(new HazelcastArguments());
  }

  public HazelcastInstance hazelcast() {
    return instance;
  }
}
