package io.netty.buffer;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface PoolChunkListMetric extends Iterable<PoolChunkMetric> {
    int maxUsage();

    int minUsage();
}
