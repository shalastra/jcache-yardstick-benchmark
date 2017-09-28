package org.yardstickframework.common.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Szymon Halastra
 */
public class MaxRandom implements Random {

  private final long max;

  public MaxRandom(long max) {
    this.max = max;
  }

  @Override
  public long random() {
    return ThreadLocalRandom.current().nextLong(max);
  }
}
