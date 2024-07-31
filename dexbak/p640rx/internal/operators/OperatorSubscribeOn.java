package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.g3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSubscribeOn<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Scheduler f45234a;

    /* renamed from: b */
    final Observable<T> f45235b;

    /* renamed from: c */
    final boolean f45236c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSubscribeOn.java */
    /* renamed from: rx.internal.operators.g3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15728a<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super T> f45237a;

        /* renamed from: b */
        final boolean f45238b;

        /* renamed from: c */
        final Scheduler.AbstractC15607a f45239c;

        /* renamed from: d */
        Observable<T> f45240d;

        /* renamed from: e */
        Thread f45241e;

        /* compiled from: OperatorSubscribeOn.java */
        /* renamed from: rx.internal.operators.g3$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15729a implements Producer {

            /* renamed from: a */
            final /* synthetic */ Producer f45242a;

            /* compiled from: OperatorSubscribeOn.java */
            /* renamed from: rx.internal.operators.g3$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15730a implements Action0 {

                /* renamed from: a */
                final /* synthetic */ long f45244a;

                C15730a(long j) {
                    this.f45244a = j;
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    C15729a.this.f45242a.request(this.f45244a);
                }
            }

            C15729a(Producer producer) {
                this.f45242a = producer;
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (C15728a.this.f45241e != Thread.currentThread()) {
                    C15728a c15728a = C15728a.this;
                    if (c15728a.f45238b) {
                        c15728a.f45239c.mo456d(new C15730a(j));
                        return;
                    }
                }
                this.f45242a.request(j);
            }
        }

        C15728a(Subscriber<? super T> subscriber, boolean z, Scheduler.AbstractC15607a abstractC15607a, Observable<T> observable) {
            this.f45237a = subscriber;
            this.f45238b = z;
            this.f45239c = abstractC15607a;
            this.f45240d = observable;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            Observable<T> observable = this.f45240d;
            this.f45240d = null;
            this.f45241e = Thread.currentThread();
            observable.m1822I6(this);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                this.f45237a.onCompleted();
            } finally {
                this.f45239c.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            try {
                this.f45237a.onError(th);
            } finally {
                this.f45239c.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45237a.onNext(t);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45237a.setProducer(new C15729a(producer));
        }
    }

    public OperatorSubscribeOn(Observable<T> observable, Scheduler scheduler, boolean z) {
        this.f45234a = scheduler;
        this.f45235b = observable;
        this.f45236c = z;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45234a.mo450a();
        C15728a c15728a = new C15728a(subscriber, this.f45236c, mo450a, this.f45235b);
        subscriber.add(c15728a);
        subscriber.add(mo450a);
        mo450a.mo456d(c15728a);
    }
}
