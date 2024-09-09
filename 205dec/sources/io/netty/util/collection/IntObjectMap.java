package io.netty.util.collection;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface IntObjectMap<V> extends Map<Integer, V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface PrimitiveEntry<V> {
        int key();

        void setValue(V v3);

        V value();
    }

    boolean containsKey(int i4);

    Iterable<PrimitiveEntry<V>> entries();

    V get(int i4);

    V put(int i4, V v3);

    V remove(int i4);
}
