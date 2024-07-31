package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.functions.Func2;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.schedulers.Schedulers;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.u2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorRetryWithPredicate<T> implements Observable.InterfaceC15568b<T, Observable<T>> {

    /* renamed from: a */
    final Func2<Integer, Throwable, Boolean> f45989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorRetryWithPredicate.java */
    /* renamed from: rx.internal.operators.u2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15912a<T> extends Subscriber<Observable<T>> {

        /* renamed from: a */
        final Subscriber<? super T> f45990a;

        /* renamed from: b */
        final Func2<Integer, Throwable, Boolean> f45991b;

        /* renamed from: c */
        final Scheduler.AbstractC15607a f45992c;

        /* renamed from: d */
        final SerialSubscription f45993d;

        /* renamed from: e */
        final ProducerArbiter f45994e;

        /* renamed from: f */
        final AtomicInteger f45995f = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorRetryWithPredicate.java */
        /* renamed from: rx.internal.operators.u2$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15913a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Observable f45996a;

            /* compiled from: OperatorRetryWithPredicate.java */
            /* renamed from: rx.internal.operators.u2$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15914a extends Subscriber<T> {

                /* renamed from: a */
                boolean f45998a;

                /* renamed from: b */
                final /* synthetic */ Action0 f45999b;

                C15914a(Action0 action0) {
                    this.f45999b = action0;
                }

                @Override // p640rx.Observer
                public void onCompleted() {
                    if (this.f45998a) {
                        return;
                    }
                    this.f45998a = true;
                    C15912a.this.f45990a.onCompleted();
                }

                @Override // p640rx.Observer
                public void onError(Throwable th) {
                    if (this.f45998a) {
                        return;
                    }
                    this.f45998a = true;
                    C15912a c15912a = C15912a.this;
                    if (c15912a.f45991b.call(Integer.valueOf(c15912a.f45995f.get()), th).booleanValue() && !C15912a.this.f45992c.isUnsubscribed()) {
                        C15912a.this.f45992c.mo456d(this.f45999b);
                    } else {
                        C15912a.this.f45990a.onError(th);
                    }
                }

                @Override // p640rx.Observer
                public void onNext(T t) {
                    if (this.f45998a) {
                        return;
                    }
                    C15912a.this.f45990a.onNext(t);
                    C15912a.this.f45994e.m961b(1L);
                }

                @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
                public void setProducer(Producer producer) {
                    C15912a.this.f45994e.m960c(producer);
                }
            }

            C15913a(Observable observable) {
                this.f45996a = observable;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15912a.this.f45995f.incrementAndGet();
                C15914a c15914a = new C15914a(this);
                C15912a.this.f45993d.m347b(c15914a);
                this.f45996a.m1822I6(c15914a);
            }
        }

        public C15912a(Subscriber<? super T> subscriber, Func2<Integer, Throwable, Boolean> func2, Scheduler.AbstractC15607a abstractC15607a, SerialSubscription serialSubscription, ProducerArbiter producerArbiter) {
            this.f45990a = subscriber;
            this.f45991b = func2;
            this.f45992c = abstractC15607a;
            this.f45993d = serialSubscription;
            this.f45994e = producerArbiter;
        }

        @Override // p640rx.Observer
        /* renamed from: F */
        public void onNext(Observable<T> observable) {
            this.f45992c.mo456d(new C15913a(observable));
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45990a.onError(th);
        }
    }

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
        this.f45989a = func2;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super Observable<T>> call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = Schedulers.m467m().mo450a();
        subscriber.add(mo450a);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        ProducerArbiter producerArbiter = new ProducerArbiter();
        subscriber.setProducer(producerArbiter);
        return new C15912a(subscriber, this.f45989a, mo450a, serialSubscription, producerArbiter);
    }
}
