package p640rx;

import p640rx.functions.Cancellable;

/* renamed from: rx.Emitter */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Emitter<T> extends Observer<T> {

    /* renamed from: rx.Emitter$BackpressureMode */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }

    /* renamed from: a */
    void mo1326a(Subscription subscription);

    /* renamed from: b */
    void mo1325b(Cancellable cancellable);

    long requested();
}
