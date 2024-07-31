package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Notification;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.observers.Subscribers;
import p640rx.schedulers.Schedulers;
import p640rx.subjects.BehaviorSubject;
import p640rx.subjects.SerializedSubject;
import p640rx.subjects.Subject;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.w0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeRedo<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: f */
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> f46061f = new C15934a();

    /* renamed from: a */
    final Observable<T> f46062a;

    /* renamed from: b */
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> f46063b;

    /* renamed from: c */
    final boolean f46064c;

    /* renamed from: d */
    final boolean f46065d;

    /* renamed from: e */
    private final Scheduler f46066e;

    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15934a implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15935a implements Func1<Notification<?>, Notification<?>> {
            C15935a() {
            }

            @Override // p640rx.functions.Func1
            public Notification<?> call(Notification<?> notification) {
                return Notification.m2002e(null);
            }
        }

        C15934a() {
        }

        @Override // p640rx.functions.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.m1674b3(new C15935a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15936b implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46068a;

        /* renamed from: b */
        final /* synthetic */ Subject f46069b;

        /* renamed from: c */
        final /* synthetic */ ProducerArbiter f46070c;

        /* renamed from: d */
        final /* synthetic */ AtomicLong f46071d;

        /* renamed from: e */
        final /* synthetic */ SerialSubscription f46072e;

        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15937a extends Subscriber<T> {

            /* renamed from: a */
            boolean f46074a;

            C15937a() {
            }

            /* renamed from: F */
            private void m1012F() {
                long j;
                do {
                    j = C15936b.this.f46071d.get();
                    if (j == Long.MAX_VALUE) {
                        return;
                    }
                } while (!C15936b.this.f46071d.compareAndSet(j, j - 1));
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                if (this.f46074a) {
                    return;
                }
                this.f46074a = true;
                unsubscribe();
                C15936b.this.f46069b.onNext(Notification.m2005b());
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                if (this.f46074a) {
                    return;
                }
                this.f46074a = true;
                unsubscribe();
                C15936b.this.f46069b.onNext(Notification.m2003d(th));
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                if (this.f46074a) {
                    return;
                }
                C15936b.this.f46068a.onNext(t);
                m1012F();
                C15936b.this.f46070c.m961b(1L);
            }

            @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                C15936b.this.f46070c.m960c(producer);
            }
        }

        C15936b(Subscriber subscriber, Subject subject, ProducerArbiter producerArbiter, AtomicLong atomicLong, SerialSubscription serialSubscription) {
            this.f46068a = subscriber;
            this.f46069b = subject;
            this.f46070c = producerArbiter;
            this.f46071d = atomicLong;
            this.f46072e = serialSubscription;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f46068a.isUnsubscribed()) {
                return;
            }
            C15937a c15937a = new C15937a();
            this.f46072e.m347b(c15937a);
            OnSubscribeRedo.this.f46062a.m1822I6(c15937a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15938c implements Observable.InterfaceC15568b<Notification<?>, Notification<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15939a extends Subscriber<Notification<?>> {

            /* renamed from: a */
            final /* synthetic */ Subscriber f46077a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C15939a(Subscriber subscriber, Subscriber subscriber2) {
                super(subscriber);
                this.f46077a = subscriber2;
            }

            @Override // p640rx.Observer
            /* renamed from: F */
            public void onNext(Notification<?> notification) {
                if (notification.m1996k() && OnSubscribeRedo.this.f46064c) {
                    this.f46077a.onCompleted();
                } else if (notification.m1995l() && OnSubscribeRedo.this.f46065d) {
                    this.f46077a.onError(notification.m2000g());
                } else {
                    this.f46077a.onNext(notification);
                }
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f46077a.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f46077a.onError(th);
            }

            @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                producer.request(Long.MAX_VALUE);
            }
        }

        C15938c() {
        }

        @Override // p640rx.functions.Func1
        public Subscriber<? super Notification<?>> call(Subscriber<? super Notification<?>> subscriber) {
            return new C15939a(subscriber, subscriber);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15940d implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Observable f46079a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f46080b;

        /* renamed from: c */
        final /* synthetic */ AtomicLong f46081c;

        /* renamed from: d */
        final /* synthetic */ Scheduler.AbstractC15607a f46082d;

        /* renamed from: e */
        final /* synthetic */ Action0 f46083e;

        /* renamed from: f */
        final /* synthetic */ AtomicBoolean f46084f;

        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15941a extends Subscriber<Object> {
            C15941a(Subscriber subscriber) {
                super(subscriber);
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C15940d.this.f46080b.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15940d.this.f46080b.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(Object obj) {
                if (C15940d.this.f46080b.isUnsubscribed()) {
                    return;
                }
                if (C15940d.this.f46081c.get() > 0) {
                    C15940d c15940d = C15940d.this;
                    c15940d.f46082d.mo456d(c15940d.f46083e);
                    return;
                }
                C15940d.this.f46084f.compareAndSet(false, true);
            }

            @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                producer.request(Long.MAX_VALUE);
            }
        }

        C15940d(Observable observable, Subscriber subscriber, AtomicLong atomicLong, Scheduler.AbstractC15607a abstractC15607a, Action0 action0, AtomicBoolean atomicBoolean) {
            this.f46079a = observable;
            this.f46080b = subscriber;
            this.f46081c = atomicLong;
            this.f46082d = abstractC15607a;
            this.f46083e = action0;
            this.f46084f = atomicBoolean;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            this.f46079a.m1822I6(new C15941a(this.f46080b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15942e implements Producer {

        /* renamed from: a */
        final /* synthetic */ AtomicLong f46087a;

        /* renamed from: b */
        final /* synthetic */ ProducerArbiter f46088b;

        /* renamed from: c */
        final /* synthetic */ AtomicBoolean f46089c;

        /* renamed from: d */
        final /* synthetic */ Scheduler.AbstractC15607a f46090d;

        /* renamed from: e */
        final /* synthetic */ Action0 f46091e;

        C15942e(AtomicLong atomicLong, ProducerArbiter producerArbiter, AtomicBoolean atomicBoolean, Scheduler.AbstractC15607a abstractC15607a, Action0 action0) {
            this.f46087a = atomicLong;
            this.f46088b = producerArbiter;
            this.f46089c = atomicBoolean;
            this.f46090d = abstractC15607a;
            this.f46091e = action0;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j > 0) {
                BackpressureUtils.m1335b(this.f46087a, j);
                this.f46088b.request(j);
                if (this.f46089c.compareAndSet(true, false)) {
                    this.f46090d.mo456d(this.f46091e);
                }
            }
        }
    }

    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15943f implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* renamed from: a */
        final long f46093a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$f$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15944a implements Func1<Notification<?>, Notification<?>> {

            /* renamed from: a */
            int f46094a;

            C15944a() {
            }

            @Override // p640rx.functions.Func1
            public Notification<?> call(Notification<?> notification) {
                long j = C15943f.this.f46093a;
                if (j == 0) {
                    return notification;
                }
                int i = this.f46094a + 1;
                this.f46094a = i;
                return ((long) i) <= j ? Notification.m2002e(Integer.valueOf(i)) : notification;
            }
        }

        public C15943f(long j) {
            this.f46093a = j;
        }

        @Override // p640rx.functions.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.m1674b3(new C15944a()).m1887A1();
        }
    }

    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: rx.internal.operators.w0$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15945g implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>> {

        /* renamed from: a */
        final Func2<Integer, Throwable, Boolean> f46096a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$g$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15946a implements Func2<Notification<Integer>, Notification<?>, Notification<Integer>> {
            C15946a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p640rx.functions.Func2
            public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                int intValue = notification.m1999h().intValue();
                return C15945g.this.f46096a.call(Integer.valueOf(intValue), notification2.m2000g()).booleanValue() ? Notification.m2002e(Integer.valueOf(intValue + 1)) : notification2;
            }
        }

        public C15945g(Func2<Integer, Throwable, Boolean> func2) {
            this.f46096a = func2;
        }

        @Override // p640rx.functions.Func1
        public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> observable) {
            return observable.m1816J4(Notification.m2002e(0), new C15946a());
        }
    }

    private OnSubscribeRedo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z, boolean z2, Scheduler scheduler) {
        this.f46062a = observable;
        this.f46063b = func1;
        this.f46064c = z;
        this.f46065d = z2;
        this.f46066e = scheduler;
    }

    /* renamed from: a */
    public static <T> Observable<T> m1023a(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return Observable.m1830H6(new OnSubscribeRedo(observable, func1, false, false, scheduler));
    }

    /* renamed from: b */
    public static <T> Observable<T> m1022b(Observable<T> observable) {
        return m1019e(observable, Schedulers.m467m());
    }

    /* renamed from: c */
    public static <T> Observable<T> m1021c(Observable<T> observable, long j) {
        return m1020d(observable, j, Schedulers.m467m());
    }

    /* renamed from: d */
    public static <T> Observable<T> m1020d(Observable<T> observable, long j, Scheduler scheduler) {
        if (j == 0) {
            return Observable.m1747S1();
        }
        if (j >= 0) {
            return m1017g(observable, new C15943f(j - 1), scheduler);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    /* renamed from: e */
    public static <T> Observable<T> m1019e(Observable<T> observable, Scheduler scheduler) {
        return m1017g(observable, f46061f, scheduler);
    }

    /* renamed from: f */
    public static <T> Observable<T> m1018f(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.m1830H6(new OnSubscribeRedo(observable, func1, false, true, Schedulers.m467m()));
    }

    /* renamed from: g */
    public static <T> Observable<T> m1017g(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return Observable.m1830H6(new OnSubscribeRedo(observable, func1, false, true, scheduler));
    }

    /* renamed from: h */
    public static <T> Observable<T> m1016h(Observable<T> observable) {
        return m1014j(observable, f46061f);
    }

    /* renamed from: i */
    public static <T> Observable<T> m1015i(Observable<T> observable, long j) {
        if (j >= 0) {
            return j == 0 ? observable : m1014j(observable, new C15943f(j));
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    /* renamed from: j */
    public static <T> Observable<T> m1014j(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.m1830H6(new OnSubscribeRedo(observable, func1, true, false, Schedulers.m467m()));
    }

    /* renamed from: k */
    public static <T> Observable<T> m1013k(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return Observable.m1830H6(new OnSubscribeRedo(observable, func1, true, false, scheduler));
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        Scheduler.AbstractC15607a mo450a = this.f46066e.mo450a();
        subscriber.add(mo450a);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject<T, T> m398w7 = BehaviorSubject.m431x7().m398w7();
        m398w7.m1551q5(Subscribers.m633d());
        ProducerArbiter producerArbiter = new ProducerArbiter();
        C15936b c15936b = new C15936b(subscriber, m398w7, producerArbiter, atomicLong, serialSubscription);
        mo450a.mo456d(new C15940d(this.f46063b.call(m398w7.m1690Z2(new C15938c())), subscriber, atomicLong, mo450a, c15936b, atomicBoolean));
        subscriber.setProducer(new C15942e(atomicLong, producerArbiter, atomicBoolean, mo450a, c15936b));
    }
}
