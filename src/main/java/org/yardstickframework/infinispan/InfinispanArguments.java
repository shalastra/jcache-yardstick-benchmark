package org.yardstickframework.infinispan;

import com.beust.jcommander.Parameter;

/**
 * @author Szymon Halastra
 */
public class InfinispanArguments {

  @Parameter(names = {"-r", "--range"}, description = "Key range")
  private int range = 1_000_000;

  /**
   * @return Key range, from {@code 0} to this number.
   */
  public int range() {
    return range;
  }
}
