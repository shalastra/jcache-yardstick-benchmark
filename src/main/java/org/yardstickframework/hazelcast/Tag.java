package org.yardstickframework.hazelcast;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Szymon Halastra
 */
@Data
@AllArgsConstructor
public class Tag implements Serializable {

  private long id;

  private String name;

  private String description;
}
