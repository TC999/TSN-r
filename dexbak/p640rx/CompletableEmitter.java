package p640rx;

import p640rx.functions.Cancellable;

/* renamed from: rx.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface CompletableEmitter {
    /* renamed from: a */
    void mo1206a(Subscription subscription);

    /* renamed from: b */
    void mo1205b(Cancellable cancellable);

    void onCompleted();

    void onError(Throwable th);
}
