#!/usr/bin/env bash

echo "Running Ignite benchmarks..."
export IG_PROP="config/ignite/benchmark.properties"
./bin/benchmark-run-all.sh "$IG_PROP"
echo "Ignite benchmarks have finished."

echo "Running Hazelcast benchmarks..."
export HC_PROP="config/hazelcast/benchmark.properties"
./bin/benchmark-run-all.sh "$HC_PROP"
echo "hazelcast benchmarks have finished."