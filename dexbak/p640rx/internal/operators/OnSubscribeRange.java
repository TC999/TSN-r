package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.v0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeRange implements Observable.InterfaceC15567a<Integer> {

    /* renamed from: a */
    private final int f46012a;

    /* renamed from: b */
    private final int f46013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRange.java */
    /* renamed from: rx.internal.operators.v0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15920a extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;

        /* renamed from: a */
        private final Subscriber<? super Integer> f46014a;

        /* renamed from: b */
        private final int f46015b;

        /* renamed from: c */
        private long f46016c;

        C15920a(Subscriber<? super Integer> subscriber, int i, int i2) {
            this.f46014a = subscriber;
            this.f46016c = i;
            this.f46015b = i2;
        }

        /* renamed from: a */
        void m1042a() {
            long j = this.f46015b + 1;
            Subscriber<? super Integer> subscriber = this.f46014a;
            for (long j2 = this.f46016c; j2 != j; j2++) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(Integer.valueOf((int) j2));
            }
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        }

        /* renamed from: b */
        void m1041b(long j) {
            long j2 = this.f46015b + 1;
            long j3 = this.f46016c;
            Subscriber<? super Integer> subscriber = this.f46014a;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 != j && j3 != j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(Integer.valueOf((int) j3));
                        j3++;
                        j4++;
                    } else if (subscriber.isUnsubscribed()) {
                        return;
                    } else {
                        if (j3 == j2) {
                            subscriber.onCompleted();
                            return;
                        }
                        j = get();
                        if (j == j4) {
                            this.f46016c = j3;
                            j = addAndGet(-j4);
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
                m1042a();
            } else if (j <= 0 || BackpressureUtils.m1335b(this, j) != 0) {
            } else {
                m1041b(j);
            }
        }
    }

    public OnSubscribeRange(int i, int i2) {
        this.f46012a = i;
        this.f46013b = i2;
    }

    @Override // p640rx.functions.Action1
    public void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new C15920a(subscriber, this.f46012a, this.f46013b));
    }
}
