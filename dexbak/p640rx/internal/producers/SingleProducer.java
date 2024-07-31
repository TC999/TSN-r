package p640rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.producers.SingleProducer */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    final Subscriber<? super T> child;
    final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t) {
        this.child = subscriber;
        this.value = t;
    }

    @Override // p640rx.Producer
    public void request(long j) {
        if (j >= 0) {
            if (j != 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.child;
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    subscriber.onNext(obj);
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                } catch (Throwable th) {
                    C15575a.m1472g(th, subscriber, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
