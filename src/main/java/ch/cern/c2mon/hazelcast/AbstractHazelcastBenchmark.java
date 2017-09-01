package ch.cern.c2mon.hazelcast;

import org.yardstickframework.BenchmarkConfiguration;
import org.yardstickframework.BenchmarkDriverAdapter;

import java.util.Map;

import javax.cache.Cache;

public abstract class AbstractHazelcastBenchmark extends BenchmarkDriverAdapter {

    private String cacheName;

    protected Cache<Long, String> cache;

    public AbstractHazelcastBenchmark(String cacheName) {
        this.cacheName = cacheName;
    }

    @Override
    public void setUp(BenchmarkConfiguration cfg) throws Exception {
        super.setUp(cfg);
    }

    @Override
    public boolean test(Map<Object, Object> map) throws Exception {
        return false;
    }
}
