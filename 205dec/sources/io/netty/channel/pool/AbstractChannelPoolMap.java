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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractChannelPoolMap<K, P extends ChannelPool> implements ChannelPoolMap<K, P>, Iterable<Map.Entry<K, P>>, Closeable {
    private final ConcurrentMap<K, P> map = PlatformDependent.newConcurrentHashMap();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (K k4 : this.map.keySet()) {
            remove(k4);
        }
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final boolean contains(K k4) {
        return this.map.containsKey(ObjectUtil.checkNotNull(k4, DomainCampaignEx.LOOPBACK_KEY));
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final P get(K k4) {
        P p3 = this.map.get(ObjectUtil.checkNotNull(k4, DomainCampaignEx.LOOPBACK_KEY));
        if (p3 == null) {
            P newPool = newPool(k4);
            P putIfAbsent = this.map.putIfAbsent(k4, newPool);
            if (putIfAbsent != null) {
                newPool.close();
                return putIfAbsent;
            }
            return newPool;
        }
        return p3;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, P>> iterator() {
        return new ReadOnlyIterator(this.map.entrySet().iterator());
    }

    protected abstract P newPool(K k4);

    public final boolean remove(K k4) {
        P remove = this.map.remove(ObjectUtil.checkNotNull(k4, DomainCampaignEx.LOOPBACK_KEY));
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
