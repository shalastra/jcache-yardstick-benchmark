package ch.cern.c2mon.terracotta.server;

import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;

/**
 * @author Szymon Halastra
 */
public class TerracottaNode implements BenchmarkServer {
  @Override
  public void start(BenchmarkConfiguration cfg) throws Exception {
    
  }

  @Override
  public void stop() throws Exception {

  }

  @Override
  public String usage() {
    return null;
  }
}
