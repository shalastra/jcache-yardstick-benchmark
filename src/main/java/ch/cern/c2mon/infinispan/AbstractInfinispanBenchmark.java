package ch.cern.c2mon.infinispan;

import java.util.Map;

import org.yardstickframework.BenchmarkDriverAdapter;

/**
 * @author Szymon Halastra
 */
public class AbstractInfinispanBenchmark extends BenchmarkDriverAdapter {
  @Override
  public boolean test(Map<Object, Object> map) throws Exception {
    return false;
  }
}
