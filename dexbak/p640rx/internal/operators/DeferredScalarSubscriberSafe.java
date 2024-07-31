package p640rx.internal.operators;

import p640rx.Subscriber;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.u */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class DeferredScalarSubscriberSafe<T, R> extends DeferredScalarSubscriber<T, R> {

    /* renamed from: i */
    protected boolean f45967i;

    public DeferredScalarSubscriberSafe(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    @Override // p640rx.internal.operators.DeferredScalarSubscriber, p640rx.Observer
    public void onCompleted() {
        if (this.f45967i) {
            return;
        }
        this.f45967i = true;
        super.onCompleted();
    }

    @Override // p640rx.internal.operators.DeferredScalarSubscriber, p640rx.Observer
    public void onError(Throwable th) {
        if (!this.f45967i) {
            this.f45967i = true;
            super.onError(th);
            return;
        }
        RxJavaHooks.m576I(th);
    }
}
