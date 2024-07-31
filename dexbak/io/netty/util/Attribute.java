package io.netty.util;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Attribute<T> {
    boolean compareAndSet(T t, T t2);

    T get();

    @Deprecated
    T getAndRemove();

    T getAndSet(T t);

    AttributeKey<T> key();

    @Deprecated
    void remove();

    void set(T t);

    T setIfAbsent(T t);
}
