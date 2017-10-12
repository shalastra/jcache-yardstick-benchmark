package org.yardstickframework.redis;

import java.io.File;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;

import static org.yardstickframework.BenchmarkUtils.jcommander;

/**
 * @author Szymon Halastra
 */
@Slf4j
public class RedisNode implements BenchmarkServer {

  @Override
  public void start(BenchmarkConfiguration cfg) throws Exception {
    RedisArguments args = new RedisArguments();

    jcommander(cfg.commandLineArguments(), args, "<redis-node>");

    Config config = Config.fromYAML(new File(args.configuration()));
    RedissonClient client = Redisson.create(config);
  }

  @Override
  public void stop() throws Exception {

  }

  @Override
  public String usage() {
    return null;
  }
}
