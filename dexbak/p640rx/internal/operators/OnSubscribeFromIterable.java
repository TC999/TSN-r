package p640rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.operators.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFromIterable<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Iterable<? extends T> f45561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFromIterable.java */
    /* renamed from: rx.internal.operators.n0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15798a<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;

        /* renamed from: a */
        private final Subscriber<? super T> f45562a;

        /* renamed from: b */
        private final Iterator<? extends T> f45563b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C15798a(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.f45562a = subscriber;
            this.f45563b = it;
        }

        /* renamed from: a */
        void m1150a() {
            Subscriber<? super T> subscriber = this.f45562a;
            Iterator<? extends T> it = this.f45563b;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext((T) it.next());
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        C15575a.m1473f(th, subscriber);
                        return;
                    }
                } catch (Throwable th2) {
                    C15575a.m1473f(th2, subscriber);
                    return;
                }
            }
        }

        /* renamed from: b */
        void m1149b(long j) {
            Subscriber<? super T> subscriber = this.f45562a;
            Iterator<? extends T> it = this.f45563b;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        try {
                            subscriber.onNext((T) it.next());
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (subscriber.isUnsubscribed()) {
                                        return;
                                    }
                                    subscriber.onCompleted();
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                C15575a.m1473f(th, subscriber);
                                return;
                            }
                        } catch (Throwable th2) {
                            C15575a.m1473f(th2, subscriber);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = BackpressureUtils.m1328i(this, j2);
                        }
                    }
                }
            } while (j != 0);
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                m1150a();
            } else if (j <= 0 || BackpressureUtils.m1335b(this, j) != 0) {
            } else {
                m1149b(j);
            }
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f45561a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it = this.f45561a.iterator();
            boolean hasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new C15798a(subscriber, it));
            }
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
        }
    }
}
