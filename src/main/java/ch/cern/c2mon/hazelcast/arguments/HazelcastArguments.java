package ch.cern.c2mon.hazelcast.arguments;

import com.beust.jcommander.Parameter;

/**
 * @author Szymon Halastra
 */
public class HazelcastArguments {

  @Parameter(names = {"-r", "--range"}, description = "Key range")
  private int range = 1_000_000;

  public int range() {
    return range;
  }
}
