package p640rx;

/* renamed from: rx.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Observer<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
