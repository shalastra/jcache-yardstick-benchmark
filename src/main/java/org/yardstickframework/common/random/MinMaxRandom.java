package org.yardstickframework.common.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Szymon Halastra
 */
public class MinMaxRandom implements Random {

  private final long min;
  private final long max;

  public MinMaxRandom(long min, long max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public long random() {
    return ThreadLocalRandom.current().nextLong(max - min) + min;
  }
}
