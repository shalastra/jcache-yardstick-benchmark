package org.yardstickframework.common;

import com.beust.jcommander.Parameter;

/**
 * @author Szymon Halastra
 */
public class Arguments {

  @Parameter(names = {"-nn", "--nodeNumber"}, description = "Node number")
  private int nodes = 1;

  @Parameter(names = {"-nt", "--nodeType"}, description = "Node type")
  private NodeType nodeType = NodeType.SERVER;

  @Parameter(names = {"-r", "--range"}, description = "Key range")
  private int range = 1_000_000;

  /** */
  @Parameter(names = {"-bs", "--batchSize"}, description = "Batch size")
  private int batch = 500;

  /**
   * @return nodes number
   */
  public int nodes() {
    return nodes;
  }

  /**
   * @return Node type.
   */
  public NodeType nodeType() {
    return nodeType;
  }

  /**
   * @return range
   */
  public int range() {
    return range;
  }


  /**
   * @return Batch size.
   */
  public int batch() {
    return batch;
  }


  public String description() {
    return "-nn=" + nodes + "-nt=" + nodeType.name() + "-bs=" + batch();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Arguments{");
    sb.append("nodes=").append(nodes);
    sb.append(", nodeType=").append(nodeType);
    sb.append(", range=").append(range);
    sb.append(", batchSize=").append(batch);
    sb.append('}');
    return sb.toString();
  }
}
