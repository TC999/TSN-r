package org.reactivestreams;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
