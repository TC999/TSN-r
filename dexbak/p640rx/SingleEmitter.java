package p640rx;

import p640rx.functions.Cancellable;

/* renamed from: rx.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SingleEmitter<T> {
    /* renamed from: a */
    void mo745a(Subscription subscription);

    /* renamed from: b */
    void mo744b(Cancellable cancellable);

    void onError(Throwable th);

    void onSuccess(T t);
}
