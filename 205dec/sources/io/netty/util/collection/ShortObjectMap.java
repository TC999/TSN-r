package io.netty.util.collection;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ShortObjectMap<V> extends Map<Short, V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface PrimitiveEntry<V> {
        short key();

        void setValue(V v3);

        V value();
    }

    boolean containsKey(short s3);

    Iterable<PrimitiveEntry<V>> entries();

    V get(short s3);

    V put(short s3, V v3);

    V remove(short s3);
}
