package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.c1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeSwitchIfEmpty<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<? extends T> f44999a;

    /* renamed from: b */
    final Observable<? extends T> f45000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSwitchIfEmpty.java */
    /* renamed from: rx.internal.operators.c1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15673a<T> extends Subscriber<T> {

        /* renamed from: a */
        private final ProducerArbiter f45001a;

        /* renamed from: b */
        private final Subscriber<? super T> f45002b;

        C15673a(Subscriber<? super T> subscriber, ProducerArbiter producerArbiter) {
            this.f45002b = subscriber;
            this.f45001a = producerArbiter;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45002b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45002b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45002b.onNext(t);
            this.f45001a.m961b(1L);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45001a.m960c(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSwitchIfEmpty.java */
    /* renamed from: rx.internal.operators.c1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15674b<T> extends Subscriber<T> {

        /* renamed from: b */
        private final Subscriber<? super T> f45004b;

        /* renamed from: c */
        private final SerialSubscription f45005c;

        /* renamed from: d */
        private final ProducerArbiter f45006d;

        /* renamed from: e */
        private final Observable<? extends T> f45007e;

        /* renamed from: g */
        volatile boolean f45009g;

        /* renamed from: a */
        private boolean f45003a = true;

        /* renamed from: f */
        final AtomicInteger f45008f = new AtomicInteger();

        C15674b(Subscriber<? super T> subscriber, SerialSubscription serialSubscription, ProducerArbiter producerArbiter, Observable<? extends T> observable) {
            this.f45004b = subscriber;
            this.f45005c = serialSubscription;
            this.f45006d = producerArbiter;
            this.f45007e = observable;
        }

        /* renamed from: F */
        void m1297F(Observable<? extends T> observable) {
            if (this.f45008f.getAndIncrement() == 0) {
                while (!this.f45004b.isUnsubscribed()) {
                    if (!this.f45009g) {
                        if (observable == null) {
                            C15673a c15673a = new C15673a(this.f45004b, this.f45006d);
                            this.f45005c.m347b(c15673a);
                            this.f45009g = true;
                            this.f45007e.m1822I6(c15673a);
                        } else {
                            this.f45009g = true;
                            observable.m1822I6(this);
                            observable = null;
                        }
                    }
                    if (this.f45008f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (!this.f45003a) {
                this.f45004b.onCompleted();
            } else if (this.f45004b.isUnsubscribed()) {
            } else {
                this.f45009g = false;
                m1297F(null);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45004b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45003a = false;
            this.f45004b.onNext(t);
            this.f45006d.m961b(1L);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45006d.m960c(producer);
        }
    }

    public OnSubscribeSwitchIfEmpty(Observable<? extends T> observable, Observable<? extends T> observable2) {
        this.f44999a = observable;
        this.f45000b = observable2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        SerialSubscription serialSubscription = new SerialSubscription();
        ProducerArbiter producerArbiter = new ProducerArbiter();
        C15674b c15674b = new C15674b(subscriber, serialSubscription, producerArbiter, this.f45000b);
        serialSubscription.m347b(c15674b);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        c15674b.m1297F(this.f44999a);
    }
}
