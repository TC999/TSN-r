package io.netty.channel.pool;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.pool.ChannelPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractChannelPoolMap<K, P extends ChannelPool> implements ChannelPoolMap<K, P>, Iterable<Map.Entry<K, P>>, Closeable {
    private final ConcurrentMap<K, P> map = PlatformDependent.newConcurrentHashMap();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (K k : this.map.keySet()) {
            remove(k);
        }
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final boolean contains(K k) {
        return this.map.containsKey(ObjectUtil.checkNotNull(k, DomainCampaignEx.LOOPBACK_KEY));
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final P get(K k) {
        P p = this.map.get(ObjectUtil.checkNotNull(k, DomainCampaignEx.LOOPBACK_KEY));
        if (p == null) {
            P newPool = newPool(k);
            P putIfAbsent = this.map.putIfAbsent(k, newPool);
            if (putIfAbsent != null) {
                newPool.close();
                return putIfAbsent;
            }
            return newPool;
        }
        return p;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, P>> iterator() {
        return new ReadOnlyIterator(this.map.entrySet().iterator());
    }

    protected abstract P newPool(K k);

    public final boolean remove(K k) {
        P remove = this.map.remove(ObjectUtil.checkNotNull(k, DomainCampaignEx.LOOPBACK_KEY));
        if (remove != null) {
            remove.close();
            return true;
        }
        return false;
    }

    public final int size() {
        return this.map.size();
    }
}
