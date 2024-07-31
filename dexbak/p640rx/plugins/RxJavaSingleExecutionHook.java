package p640rx.plugins;

import p640rx.Observable;
import p640rx.Single;
import p640rx.Subscription;

/* renamed from: rx.plugins.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class RxJavaSingleExecutionHook {
    @Deprecated
    /* renamed from: a */
    public <T> Single.InterfaceC15633t<T> m485a(Single.InterfaceC15633t<T> interfaceC15633t) {
        return interfaceC15633t;
    }

    @Deprecated
    /* renamed from: b */
    public <T, R> Observable.InterfaceC15568b<? extends R, ? super T> m484b(Observable.InterfaceC15568b<? extends R, ? super T> interfaceC15568b) {
        return interfaceC15568b;
    }

    @Deprecated
    /* renamed from: c */
    public <T> Throwable m483c(Throwable th) {
        return th;
    }

    @Deprecated
    /* renamed from: d */
    public <T> Subscription m482d(Subscription subscription) {
        return subscription;
    }

    @Deprecated
    /* renamed from: e */
    public <T> Observable.InterfaceC15567a<T> m481e(Single<? extends T> single, Observable.InterfaceC15567a<T> interfaceC15567a) {
        return interfaceC15567a;
    }
}
