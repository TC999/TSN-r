package p640rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.producers.SingleDelayedProducer */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final Subscriber<? super T> child;
    T value;

    public SingleDelayedProducer(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void emit(Subscriber<? super T> subscriber, T t) {
        if (subscriber.isUnsubscribed()) {
            return;
        }
        try {
            subscriber.onNext(t);
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        } catch (Throwable th) {
            C15575a.m1472g(th, subscriber, t);
        }
    }

    @Override // p640rx.Producer
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j == 0) {
            return;
        }
        do {
            int i = get();
            if (i != 0) {
                if (i == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(T t) {
        do {
            int i = get();
            if (i == 0) {
                this.value = t;
            } else if (i == 2 && compareAndSet(2, 3)) {
                emit(this.child, t);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
