package io.netty.util.collection;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ByteObjectMap<V> extends Map<Byte, V> {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface PrimitiveEntry<V> {
        byte key();

        void setValue(V v);

        V value();
    }

    boolean containsKey(byte b);

    Iterable<PrimitiveEntry<V>> entries();

    V get(byte b);

    V put(byte b, V v);

    V remove(byte b);
}
