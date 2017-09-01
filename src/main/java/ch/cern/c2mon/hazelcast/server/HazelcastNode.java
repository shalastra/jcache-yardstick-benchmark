package ch.cern.c2mon.hazelcast.server;

import ch.cern.c2mon.NodeType;
import ch.cern.c2mon.hazelcast.arguments.HazelcastArguments;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkServer;

/**
 * @author Szymon Halastra
 */
@Slf4j
public class HazelcastNode implements BenchmarkServer {

    private HazelcastInstance instance;

    private NodeType nodeType;

    public HazelcastNode() {

    }

    public HazelcastNode(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public HazelcastNode(HazelcastInstance instance, NodeType nodeType) {
        this.instance = instance;
        this.nodeType = nodeType;
    }

    @Override
    public void start(BenchmarkConfiguration cfg) throws Exception {
        HazelcastArguments arguments = new HazelcastArguments();
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public String usage() {
        return null;
    }

    public HazelcastInstance hazelcast() {
        return instance;
    }
}
