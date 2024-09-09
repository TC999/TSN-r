package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface Attribute<T> {
    boolean compareAndSet(T t3, T t4);

    T get();

    @Deprecated
    T getAndRemove();

    T getAndSet(T t3);

    AttributeKey<T> key();

    @Deprecated
    void remove();

    void set(T t3);

    T setIfAbsent(T t3);
}
