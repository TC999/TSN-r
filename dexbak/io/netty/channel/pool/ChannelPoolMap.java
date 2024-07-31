package io.netty.channel.pool;

import io.netty.channel.pool.ChannelPool;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ChannelPoolMap<K, P extends ChannelPool> {
    boolean contains(K k);

    P get(K k);
}
