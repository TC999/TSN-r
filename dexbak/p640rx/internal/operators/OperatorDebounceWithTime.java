package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.observers.SerializedSubscriber;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.u1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDebounceWithTime<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f45973a;

    /* renamed from: b */
    final TimeUnit f45974b;

    /* renamed from: c */
    final Scheduler f45975c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDebounceWithTime.java */
    /* renamed from: rx.internal.operators.u1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15909a extends Subscriber<T> {

        /* renamed from: a */
        final C15911b<T> f45976a;

        /* renamed from: b */
        final Subscriber<?> f45977b;

        /* renamed from: c */
        final /* synthetic */ SerialSubscription f45978c;

        /* renamed from: d */
        final /* synthetic */ Scheduler.AbstractC15607a f45979d;

        /* renamed from: e */
        final /* synthetic */ SerializedSubscriber f45980e;

        /* compiled from: OperatorDebounceWithTime.java */
        /* renamed from: rx.internal.operators.u1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15910a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ int f45982a;

            C15910a(int i) {
                this.f45982a = i;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15909a c15909a = C15909a.this;
                c15909a.f45976a.m1056b(this.f45982a, c15909a.f45980e, c15909a.f45977b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15909a(Subscriber subscriber, SerialSubscription serialSubscription, Scheduler.AbstractC15607a abstractC15607a, SerializedSubscriber serializedSubscriber) {
            super(subscriber);
            this.f45978c = serialSubscription;
            this.f45979d = abstractC15607a;
            this.f45980e = serializedSubscriber;
            this.f45976a = new C15911b<>();
            this.f45977b = this;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45976a.m1055c(this.f45980e, this);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45980e.onError(th);
            unsubscribe();
            this.f45976a.m1057a();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int m1054d = this.f45976a.m1054d(t);
            SerialSubscription serialSubscription = this.f45978c;
            Scheduler.AbstractC15607a abstractC15607a = this.f45979d;
            C15910a c15910a = new C15910a(m1054d);
            OperatorDebounceWithTime operatorDebounceWithTime = OperatorDebounceWithTime.this;
            serialSubscription.m347b(abstractC15607a.mo460F(c15910a, operatorDebounceWithTime.f45973a, operatorDebounceWithTime.f45974b));
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDebounceWithTime.java */
    /* renamed from: rx.internal.operators.u1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15911b<T> {

        /* renamed from: a */
        int f45984a;

        /* renamed from: b */
        T f45985b;

        /* renamed from: c */
        boolean f45986c;

        /* renamed from: d */
        boolean f45987d;

        /* renamed from: e */
        boolean f45988e;

        /* renamed from: a */
        public synchronized void m1057a() {
            this.f45984a++;
            this.f45985b = null;
            this.f45986c = false;
        }

        /* renamed from: b */
        public void m1056b(int i, Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (!this.f45988e && this.f45986c && i == this.f45984a) {
                    T t = this.f45985b;
                    this.f45985b = null;
                    this.f45986c = false;
                    this.f45988e = true;
                    try {
                        subscriber.onNext(t);
                        synchronized (this) {
                            if (!this.f45987d) {
                                this.f45988e = false;
                            } else {
                                subscriber.onCompleted();
                            }
                        }
                    } catch (Throwable th) {
                        C15575a.m1472g(th, subscriber2, t);
                    }
                }
            }
        }

        /* renamed from: c */
        public void m1055c(Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (this.f45988e) {
                    this.f45987d = true;
                    return;
                }
                T t = this.f45985b;
                boolean z = this.f45986c;
                this.f45985b = null;
                this.f45986c = false;
                this.f45988e = true;
                if (z) {
                    try {
                        subscriber.onNext(t);
                    } catch (Throwable th) {
                        C15575a.m1472g(th, subscriber2, t);
                        return;
                    }
                }
                subscriber.onCompleted();
            }
        }

        /* renamed from: d */
        public synchronized int m1054d(T t) {
            int i;
            this.f45985b = t;
            this.f45986c = true;
            i = this.f45984a + 1;
            this.f45984a = i;
            return i;
        }
    }

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45973a = j;
        this.f45974b = timeUnit;
        this.f45975c = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45975c.mo450a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(mo450a);
        serializedSubscriber.add(serialSubscription);
        return new C15909a(subscriber, serialSubscription, mo450a, serializedSubscriber);
    }
}
