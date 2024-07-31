package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {

    /* renamed from: e */
    static final int f45876e = 0;

    /* renamed from: f */
    static final int f45877f = 1;

    /* renamed from: g */
    static final int f45878g = 2;

    /* renamed from: h */
    static final int f45879h = 3;

    /* renamed from: a */
    protected final Subscriber<? super R> f45880a;

    /* renamed from: b */
    protected boolean f45881b;

    /* renamed from: c */
    protected R f45882c;

    /* renamed from: d */
    final AtomicInteger f45883d = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeferredScalarSubscriber.java */
    /* renamed from: rx.internal.operators.t$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15880a implements Producer {

        /* renamed from: a */
        final DeferredScalarSubscriber<?, ?> f45884a;

        public C15880a(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.f45884a = deferredScalarSubscriber;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45884a.m1090H(j);
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.f45880a = subscriber;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F */
    public final void m1092F() {
        this.f45880a.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G */
    public final void m1091G(R r) {
        Subscriber<? super R> subscriber = this.f45880a;
        do {
            int i = this.f45883d.get();
            if (i == 2 || i == 3 || subscriber.isUnsubscribed()) {
                return;
            }
            if (i == 1) {
                subscriber.onNext(r);
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
                this.f45883d.lazySet(3);
                return;
            }
            this.f45882c = r;
        } while (!this.f45883d.compareAndSet(0, 2));
    }

    /* renamed from: H */
    final void m1090H(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        } else if (j != 0) {
            Subscriber<? super R> subscriber = this.f45880a;
            do {
                int i = this.f45883d.get();
                if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                    return;
                }
                if (i == 2) {
                    if (this.f45883d.compareAndSet(2, 3)) {
                        subscriber.onNext((R) this.f45882c);
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    return;
                }
            } while (!this.f45883d.compareAndSet(0, 1));
        }
    }

    /* renamed from: I */
    final void m1089I() {
        Subscriber<? super R> subscriber = this.f45880a;
        subscriber.add(this);
        subscriber.setProducer(new C15880a(this));
    }

    /* renamed from: J */
    public final void m1088J(Observable<? extends T> observable) {
        m1089I();
        observable.m1822I6(this);
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        if (this.f45881b) {
            m1091G(this.f45882c);
        } else {
            m1092F();
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f45882c = null;
        this.f45880a.onError(th);
    }

    @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
    public final void setProducer(Producer producer) {
        producer.request(Long.MAX_VALUE);
    }
}
