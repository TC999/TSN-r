package io.netty.channel.pool;

import io.netty.channel.pool.ChannelPool;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ChannelPoolMap<K, P extends ChannelPool> {
    boolean contains(K k4);

    P get(K k4);
}
