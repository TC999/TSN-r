package org.reactivestreams;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Subscription subscription);
}
