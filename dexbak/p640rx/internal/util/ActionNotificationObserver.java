package p640rx.internal.util;

import p640rx.Notification;
import p640rx.Observer;
import p640rx.functions.Action1;

/* renamed from: rx.internal.util.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ActionNotificationObserver<T> implements Observer<T> {

    /* renamed from: a */
    final Action1<Notification<? super T>> f46449a;

    public ActionNotificationObserver(Action1<Notification<? super T>> action1) {
        this.f46449a = action1;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f46449a.call(Notification.m2005b());
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f46449a.call(Notification.m2003d(th));
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46449a.call(Notification.m2002e(t));
    }
}
