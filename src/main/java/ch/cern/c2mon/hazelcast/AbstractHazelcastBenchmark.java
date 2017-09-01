package ch.cern.c2mon.hazelcast;

import ch.cern.c2mon.hazelcast.arguments.HazelcastArguments;
import ch.cern.c2mon.hazelcast.server.HazelcastNode;
import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkDriverAdapter;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.cache.Cache;

public abstract class AbstractHazelcastBenchmark extends BenchmarkDriverAdapter {

    private String cacheName;

    protected Cache<Long, String> cache;

    protected HazelcastArguments args;

    private HazelcastNode node;

    public AbstractHazelcastBenchmark(String cacheName) {
        this.cacheName = cacheName;
    }

    @Override
    public void setUp(BenchmarkConfiguration cfg) throws Exception {
        super.setUp(cfg);

        cache = node.hazelcast().getCacheManager().getCache(cacheName);
    }

    @Override
    public boolean test(Map<Object, Object> map) throws Exception {
        return false;
    }

    protected Long nextRandom(int max) {
        return ThreadLocalRandom.current().nextLong(max);
    }
}
