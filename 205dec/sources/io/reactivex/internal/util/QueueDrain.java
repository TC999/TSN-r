package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> subscriber, T t3);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i4);

    long produced(long j4);

    long requested();
}
