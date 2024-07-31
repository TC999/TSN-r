package p640rx.internal.operators;

import java.util.concurrent.TimeoutException;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.functions.Func3;
import p640rx.functions.Func4;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.observers.SerializedSubscriber;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.s3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class OperatorTimeoutBase<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final InterfaceC15875a<T> f45859a;

    /* renamed from: b */
    final InterfaceC15876b<T> f45860b;

    /* renamed from: c */
    final Observable<? extends T> f45861c;

    /* renamed from: d */
    final Scheduler f45862d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTimeoutBase.java */
    /* renamed from: rx.internal.operators.s3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15875a<T> extends Func3<C15877c<T>, Long, Scheduler.AbstractC15607a, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTimeoutBase.java */
    /* renamed from: rx.internal.operators.s3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15876b<T> extends Func4<C15877c<T>, Long, T, Scheduler.AbstractC15607a, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTimeoutBase.java */
    /* renamed from: rx.internal.operators.s3$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15877c<T> extends Subscriber<T> {

        /* renamed from: a */
        final SerialSubscription f45863a;

        /* renamed from: b */
        final SerializedSubscriber<T> f45864b;

        /* renamed from: c */
        final InterfaceC15876b<T> f45865c;

        /* renamed from: d */
        final Observable<? extends T> f45866d;

        /* renamed from: e */
        final Scheduler.AbstractC15607a f45867e;

        /* renamed from: f */
        final ProducerArbiter f45868f = new ProducerArbiter();

        /* renamed from: g */
        boolean f45869g;

        /* renamed from: h */
        long f45870h;

        /* compiled from: OperatorTimeoutBase.java */
        /* renamed from: rx.internal.operators.s3$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15878a extends Subscriber<T> {
            C15878a() {
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C15877c.this.f45864b.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15877c.this.f45864b.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                C15877c.this.f45864b.onNext(t);
            }

            @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                C15877c.this.f45868f.m960c(producer);
            }
        }

        C15877c(SerializedSubscriber<T> serializedSubscriber, InterfaceC15876b<T> interfaceC15876b, SerialSubscription serialSubscription, Observable<? extends T> observable, Scheduler.AbstractC15607a abstractC15607a) {
            this.f45864b = serializedSubscriber;
            this.f45865c = interfaceC15876b;
            this.f45863a = serialSubscription;
            this.f45866d = observable;
            this.f45867e = abstractC15607a;
        }

        /* renamed from: F */
        public void m1093F(long j) {
            boolean z;
            synchronized (this) {
                z = true;
                if (j != this.f45870h || this.f45869g) {
                    z = false;
                } else {
                    this.f45869g = true;
                }
            }
            if (z) {
                if (this.f45866d == null) {
                    this.f45864b.onError(new TimeoutException());
                    return;
                }
                C15878a c15878a = new C15878a();
                this.f45866d.m1822I6(c15878a);
                this.f45863a.m347b(c15878a);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.f45869g) {
                    z = false;
                } else {
                    this.f45869g = true;
                }
            }
            if (z) {
                this.f45863a.unsubscribe();
                this.f45864b.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.f45869g) {
                    z = false;
                } else {
                    this.f45869g = true;
                }
            }
            if (z) {
                this.f45863a.unsubscribe();
                this.f45864b.onError(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long j;
            boolean z;
            synchronized (this) {
                if (!this.f45869g) {
                    j = this.f45870h + 1;
                    this.f45870h = j;
                    z = true;
                } else {
                    j = this.f45870h;
                    z = false;
                }
            }
            if (z) {
                this.f45864b.onNext(t);
                this.f45863a.m347b(this.f45865c.call(this, Long.valueOf(j), t, this.f45867e));
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45868f.m960c(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OperatorTimeoutBase(InterfaceC15875a<T> interfaceC15875a, InterfaceC15876b<T> interfaceC15876b, Observable<? extends T> observable, Scheduler scheduler) {
        this.f45859a = interfaceC15875a;
        this.f45860b = interfaceC15876b;
        this.f45861c = observable;
        this.f45862d = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45862d.mo450a();
        subscriber.add(mo450a);
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(serialSubscription);
        C15877c c15877c = new C15877c(serializedSubscriber, this.f45860b, serialSubscription, this.f45861c, mo450a);
        serializedSubscriber.add(c15877c);
        serializedSubscriber.setProducer(c15877c.f45868f);
        serialSubscription.m347b(this.f45859a.call(c15877c, 0L, mo450a));
        return c15877c;
    }
}
