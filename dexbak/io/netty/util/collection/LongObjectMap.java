package io.netty.util.collection;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface LongObjectMap<V> extends Map<Long, V> {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface PrimitiveEntry<V> {
        long key();

        void setValue(V v);

        V value();
    }

    boolean containsKey(long j);

    Iterable<PrimitiveEntry<V>> entries();

    V get(long j);

    V put(long j, V v);

    V remove(long j);
}
