package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.i2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorMapNotification<T, R> implements Observable.InterfaceC15568b<R, T> {

    /* renamed from: a */
    final Func1<? super T, ? extends R> f45337a;

    /* renamed from: b */
    final Func1<? super Throwable, ? extends R> f45338b;

    /* renamed from: c */
    final Func0<? extends R> f45339c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMapNotification.java */
    /* renamed from: rx.internal.operators.i2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15752a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15753b f45340a;

        C15752a(C15753b c15753b) {
            this.f45340a = c15753b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45340a.m1209G(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMapNotification.java */
    /* renamed from: rx.internal.operators.i2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15753b<T, R> extends Subscriber<T> {

        /* renamed from: j */
        static final long f45342j = Long.MIN_VALUE;

        /* renamed from: k */
        static final long f45343k = Long.MAX_VALUE;

        /* renamed from: a */
        final Subscriber<? super R> f45344a;

        /* renamed from: b */
        final Func1<? super T, ? extends R> f45345b;

        /* renamed from: c */
        final Func1<? super Throwable, ? extends R> f45346c;

        /* renamed from: d */
        final Func0<? extends R> f45347d;

        /* renamed from: e */
        final AtomicLong f45348e = new AtomicLong();

        /* renamed from: f */
        final AtomicLong f45349f = new AtomicLong();

        /* renamed from: g */
        final AtomicReference<Producer> f45350g = new AtomicReference<>();

        /* renamed from: h */
        long f45351h;

        /* renamed from: i */
        R f45352i;

        public C15753b(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
            this.f45344a = subscriber;
            this.f45345b = func1;
            this.f45346c = func12;
            this.f45347d = func0;
        }

        /* renamed from: F */
        void m1210F() {
            long j = this.f45351h;
            if (j == 0 || this.f45350g.get() == null) {
                return;
            }
            BackpressureUtils.m1328i(this.f45348e, j);
        }

        /* renamed from: G */
        void m1209G(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (j == 0) {
            } else {
                while (true) {
                    long j2 = this.f45348e.get();
                    if ((j2 & Long.MIN_VALUE) != 0) {
                        long j3 = Long.MAX_VALUE & j2;
                        if (this.f45348e.compareAndSet(j2, Long.MIN_VALUE | BackpressureUtils.m1336a(j3, j))) {
                            if (j3 == 0) {
                                if (!this.f45344a.isUnsubscribed()) {
                                    this.f45344a.onNext((R) this.f45352i);
                                }
                                if (this.f45344a.isUnsubscribed()) {
                                    return;
                                }
                                this.f45344a.onCompleted();
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.f45348e.compareAndSet(j2, BackpressureUtils.m1336a(j2, j))) {
                            AtomicReference<Producer> atomicReference = this.f45350g;
                            Producer producer = atomicReference.get();
                            if (producer != null) {
                                producer.request(j);
                                return;
                            }
                            BackpressureUtils.m1335b(this.f45349f, j);
                            Producer producer2 = atomicReference.get();
                            if (producer2 != null) {
                                long andSet = this.f45349f.getAndSet(0L);
                                if (andSet != 0) {
                                    producer2.request(andSet);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }

        /* renamed from: H */
        void m1208H() {
            long j;
            do {
                j = this.f45348e.get();
                if ((j & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.f45348e.compareAndSet(j, Long.MIN_VALUE | j));
            if (j != 0 || this.f45350g.get() == null) {
                if (!this.f45344a.isUnsubscribed()) {
                    this.f45344a.onNext((R) this.f45352i);
                }
                if (this.f45344a.isUnsubscribed()) {
                    return;
                }
                this.f45344a.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            m1210F();
            try {
                this.f45352i = this.f45347d.call();
            } catch (Throwable th) {
                C15575a.m1473f(th, this.f45344a);
            }
            m1208H();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            m1210F();
            try {
                this.f45352i = this.f45346c.call(th);
            } catch (Throwable th2) {
                C15575a.m1472g(th2, this.f45344a, th);
            }
            m1208H();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                this.f45351h++;
                this.f45344a.onNext((R) this.f45345b.call(t));
            } catch (Throwable th) {
                C15575a.m1472g(th, this.f45344a, t);
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            if (this.f45350g.compareAndSet(null, producer)) {
                long andSet = this.f45349f.getAndSet(0L);
                if (andSet != 0) {
                    producer.request(andSet);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }
    }

    public OperatorMapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        this.f45337a = func1;
        this.f45338b = func12;
        this.f45339c = func0;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        C15753b c15753b = new C15753b(subscriber, this.f45337a, this.f45338b, this.f45339c);
        subscriber.add(c15753b);
        subscriber.setProducer(new C15752a(c15753b));
        return c15753b;
    }
}
