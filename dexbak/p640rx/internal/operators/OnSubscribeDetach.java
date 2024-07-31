package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.f0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeDetach<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<T> f45135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDetach.java */
    /* renamed from: rx.internal.operators.f0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15704a<T> implements Producer, Subscription {

        /* renamed from: a */
        final C15705b<T> f45136a;

        public C15704a(C15705b<T> c15705b) {
            this.f45136a = c15705b;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f45136a.isUnsubscribed();
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45136a.m1263F(j);
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f45136a.m1262G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDetach.java */
    /* renamed from: rx.internal.operators.f0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15705b<T> extends Subscriber<T> {

        /* renamed from: a */
        final AtomicReference<Subscriber<? super T>> f45137a;

        /* renamed from: b */
        final AtomicReference<Producer> f45138b = new AtomicReference<>();

        /* renamed from: c */
        final AtomicLong f45139c = new AtomicLong();

        public C15705b(Subscriber<? super T> subscriber) {
            this.f45137a = new AtomicReference<>(subscriber);
        }

        /* renamed from: F */
        void m1263F(long j) {
            if (j >= 0) {
                Producer producer = this.f45138b.get();
                if (producer != null) {
                    producer.request(j);
                    return;
                }
                BackpressureUtils.m1335b(this.f45139c, j);
                Producer producer2 = this.f45138b.get();
                if (producer2 == null || producer2 == EnumC15706c.INSTANCE) {
                    return;
                }
                producer2.request(this.f45139c.getAndSet(0L));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }

        /* renamed from: G */
        void m1262G() {
            this.f45138b.lazySet(EnumC15706c.INSTANCE);
            this.f45137a.lazySet(null);
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45138b.lazySet(EnumC15706c.INSTANCE);
            Subscriber<? super T> andSet = this.f45137a.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45138b.lazySet(EnumC15706c.INSTANCE);
            Subscriber<? super T> andSet = this.f45137a.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th);
            } else {
                RxJavaHooks.m576I(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            Subscriber<? super T> subscriber = this.f45137a.get();
            if (subscriber != null) {
                subscriber.onNext(t);
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            if (this.f45138b.compareAndSet(null, producer)) {
                producer.request(this.f45139c.getAndSet(0L));
            } else if (this.f45138b.get() != EnumC15706c.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDetach.java */
    /* renamed from: rx.internal.operators.f0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum EnumC15706c implements Producer {
        INSTANCE;

        @Override // p640rx.Producer
        public void request(long j) {
        }
    }

    public OnSubscribeDetach(Observable<T> observable) {
        this.f45135a = observable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        C15705b c15705b = new C15705b(subscriber);
        C15704a c15704a = new C15704a(c15705b);
        subscriber.add(c15704a);
        subscriber.setProducer(c15704a);
        this.f45135a.m1822I6(c15705b);
    }
}
