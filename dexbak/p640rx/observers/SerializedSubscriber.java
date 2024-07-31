package p640rx.observers;

import p640rx.Observer;
import p640rx.Subscriber;

/* renamed from: rx.observers.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SerializedSubscriber<T> extends Subscriber<T> {

    /* renamed from: a */
    private final Observer<T> f46913a;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, true);
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f46913a.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f46913a.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f46913a.onNext(t);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        super(subscriber, z);
        this.f46913a = new SerializedObserver(subscriber);
    }
}
