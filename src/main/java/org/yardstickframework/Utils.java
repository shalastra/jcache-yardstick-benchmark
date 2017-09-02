package org.yardstickframework;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Szymon Halastra
 */
public class Utils {

  public static long nextRandom(long max) {
    return ThreadLocalRandom.current().nextLong(max);
  }

  public static long nextRandom(int min, int max) {
    return ThreadLocalRandom.current().nextLong(max - min) + min;
  }
}
