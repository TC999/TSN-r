package rx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Observer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface f<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t3);
}
