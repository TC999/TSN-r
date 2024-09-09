package io.reactivex.internal.util;

import io.reactivex.Observer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> observer, T t3);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i4);
}
