package p640rx.internal.util;

import p640rx.Observer;
import p640rx.Subscriber;

/* renamed from: rx.internal.util.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ObserverSubscriber<T> extends Subscriber<T> {

    /* renamed from: a */
    final Observer<? super T> f46499a;

    public ObserverSubscriber(Observer<? super T> observer) {
        this.f46499a = observer;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f46499a.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f46499a.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46499a.onNext(t);
    }
}
