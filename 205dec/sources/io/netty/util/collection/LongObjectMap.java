package io.netty.util.collection;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface LongObjectMap<V> extends Map<Long, V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface PrimitiveEntry<V> {
        long key();

        void setValue(V v3);

        V value();
    }

    boolean containsKey(long j4);

    Iterable<PrimitiveEntry<V>> entries();

    V get(long j4);

    V put(long j4, V v3);

    V remove(long j4);
}
