package io.reactivex.internal.util;

import io.reactivex.Observer;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> observer, T t);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i);
}
