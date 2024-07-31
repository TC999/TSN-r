package p640rx.internal.util;

import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.functions.Action1;

/* renamed from: rx.internal.util.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ActionSubscriber<T> extends Subscriber<T> {

    /* renamed from: a */
    final Action1<? super T> f46482a;

    /* renamed from: b */
    final Action1<Throwable> f46483b;

    /* renamed from: c */
    final Action0 f46484c;

    public ActionSubscriber(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        this.f46482a = action1;
        this.f46483b = action12;
        this.f46484c = action0;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f46484c.call();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f46483b.call(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46482a.call(t);
    }
}
