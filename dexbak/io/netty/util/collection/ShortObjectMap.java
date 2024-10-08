package io.netty.util.collection;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ShortObjectMap<V> extends Map<Short, V> {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface PrimitiveEntry<V> {
        short key();

        void setValue(V v);

        V value();
    }

    boolean containsKey(short s);

    Iterable<PrimitiveEntry<V>> entries();

    V get(short s);

    V put(short s, V v);

    V remove(short s);
}
