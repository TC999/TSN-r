package io.netty.util.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface LongCounter {
    void add(long j4);

    void decrement();

    void increment();

    long value();
}
