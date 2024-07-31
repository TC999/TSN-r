package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;

/* renamed from: rx.internal.operators.q2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorOnBackpressureLatest<T> implements Observable.InterfaceC15568b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* renamed from: rx.internal.operators.q2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15842a {

        /* renamed from: a */
        static final OperatorOnBackpressureLatest<Object> f45738a = new OperatorOnBackpressureLatest<>();

        C15842a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* renamed from: rx.internal.operators.q2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15843b<T> extends AtomicLong implements Producer, Subscription, Observer<T> {

        /* renamed from: h */
        static final Object f45739h = new Object();

        /* renamed from: i */
        static final long f45740i = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;

        /* renamed from: a */
        final Subscriber<? super T> f45741a;

        /* renamed from: b */
        C15844c<? super T> f45742b;

        /* renamed from: c */
        final AtomicReference<Object> f45743c = new AtomicReference<>(f45739h);

        /* renamed from: d */
        Throwable f45744d;

        /* renamed from: e */
        volatile boolean f45745e;

        /* renamed from: f */
        boolean f45746f;

        /* renamed from: g */
        boolean f45747g;

        public C15843b(Subscriber<? super T> subscriber) {
            this.f45741a = subscriber;
            lazySet(f45740i);
        }

        /* renamed from: F */
        long m1115F(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        /* renamed from: d */
        void m1114d() {
            boolean z;
            Object obj;
            synchronized (this) {
                boolean z2 = true;
                if (this.f45746f) {
                    this.f45747g = true;
                    return;
                }
                this.f45746f = true;
                this.f45747g = false;
                while (true) {
                    try {
                        long j = get();
                        if (j == Long.MIN_VALUE) {
                            return;
                        }
                        Object obj2 = this.f45743c.get();
                        if (j > 0 && obj2 != (obj = f45739h)) {
                            this.f45741a.onNext(obj2);
                            this.f45743c.compareAndSet(obj2, obj);
                            m1115F(1L);
                            obj2 = obj;
                        }
                        if (obj2 == f45739h && this.f45745e) {
                            Throwable th = this.f45744d;
                            if (th != null) {
                                this.f45741a.onError(th);
                            } else {
                                this.f45741a.onCompleted();
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.f45747g) {
                                        this.f45746f = false;
                                        return;
                                    }
                                    this.f45747g = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            z = z2;
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.f45746f = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z = false;
                    }
                }
            }
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45745e = true;
            m1114d();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45744d = th;
            this.f45745e = true;
            m1114d();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45743c.lazySet(t);
            m1114d();
        }

        @Override // p640rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j2 == f45740i) {
                        j3 = j;
                    } else {
                        j3 = j2 + j;
                        if (j3 < 0) {
                            j3 = Long.MAX_VALUE;
                        }
                    }
                } while (!compareAndSet(j2, j3));
                if (j2 == f45740i) {
                    this.f45742b.m1113F(Long.MAX_VALUE);
                }
                m1114d();
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* renamed from: rx.internal.operators.q2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15844c<T> extends Subscriber<T> {

        /* renamed from: a */
        private final C15843b<T> f45748a;

        C15844c(C15843b<T> c15843b) {
            this.f45748a = c15843b;
        }

        /* renamed from: F */
        void m1113F(long j) {
            request(j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45748a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45748a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45748a.onNext(t);
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(0L);
        }
    }

    /* renamed from: a */
    public static <T> OperatorOnBackpressureLatest<T> m1116a() {
        return (OperatorOnBackpressureLatest<T>) C15842a.f45738a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15843b c15843b = new C15843b(subscriber);
        C15844c<? super T> c15844c = new C15844c<>(c15843b);
        c15843b.f45742b = c15844c;
        subscriber.add(c15844c);
        subscriber.add(c15843b);
        subscriber.setProducer(c15843b);
        return c15844c;
    }
}
