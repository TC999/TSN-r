package io.netty.util.collection;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface CharObjectMap<V> extends Map<Character, V> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface PrimitiveEntry<V> {
        char key();

        void setValue(V v3);

        V value();
    }

    boolean containsKey(char c4);

    Iterable<PrimitiveEntry<V>> entries();

    V get(char c4);

    V put(char c4, V v3);

    V remove(char c4);
}
