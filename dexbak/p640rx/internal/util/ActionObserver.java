package p640rx.internal.util;

import p640rx.Observer;
import p640rx.functions.Action0;
import p640rx.functions.Action1;

/* renamed from: rx.internal.util.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ActionObserver<T> implements Observer<T> {

    /* renamed from: a */
    final Action1<? super T> f46479a;

    /* renamed from: b */
    final Action1<? super Throwable> f46480b;

    /* renamed from: c */
    final Action0 f46481c;

    public ActionObserver(Action1<? super T> action1, Action1<? super Throwable> action12, Action0 action0) {
        this.f46479a = action1;
        this.f46480b = action12;
        this.f46481c = action0;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f46481c.call();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f46480b.call(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46479a.call(t);
    }
}
