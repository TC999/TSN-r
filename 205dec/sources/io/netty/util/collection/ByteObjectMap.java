package io.netty.util.collection;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ByteObjectMap<V> extends Map<Byte, V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface PrimitiveEntry<V> {
        byte key();

        void setValue(V v3);

        V value();
    }

    boolean containsKey(byte b4);

    Iterable<PrimitiveEntry<V>> entries();

    V get(byte b4);

    V put(byte b4, V v3);

    V remove(byte b4);
}
