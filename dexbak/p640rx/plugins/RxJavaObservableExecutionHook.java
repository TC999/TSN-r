package p640rx.plugins;

import p640rx.Observable;
import p640rx.Subscription;

/* renamed from: rx.plugins.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class RxJavaObservableExecutionHook {
    @Deprecated
    /* renamed from: a */
    public <T> Observable.InterfaceC15567a<T> m515a(Observable.InterfaceC15567a<T> interfaceC15567a) {
        return interfaceC15567a;
    }

    @Deprecated
    /* renamed from: b */
    public <T, R> Observable.InterfaceC15568b<? extends R, ? super T> m514b(Observable.InterfaceC15568b<? extends R, ? super T> interfaceC15568b) {
        return interfaceC15568b;
    }

    @Deprecated
    /* renamed from: c */
    public <T> Throwable m513c(Throwable th) {
        return th;
    }

    @Deprecated
    /* renamed from: d */
    public <T> Subscription m512d(Subscription subscription) {
        return subscription;
    }

    @Deprecated
    /* renamed from: e */
    public <T> Observable.InterfaceC15567a<T> m511e(Observable<? extends T> observable, Observable.InterfaceC15567a<T> interfaceC15567a) {
        return interfaceC15567a;
    }
}
