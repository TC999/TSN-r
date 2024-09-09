package org.reactivestreams;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t3);

    void onSubscribe(Subscription subscription);
}
