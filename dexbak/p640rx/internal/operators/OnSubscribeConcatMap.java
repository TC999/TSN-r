package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.functions.Func1;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.internal.util.ExceptionsUtils;
import p640rx.internal.util.ScalarSynchronousObservable;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.observers.SerializedSubscriber;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeConcatMap<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: e */
    public static final int f46226e = 0;

    /* renamed from: f */
    public static final int f46227f = 1;

    /* renamed from: g */
    public static final int f46228g = 2;

    /* renamed from: a */
    final Observable<? extends T> f46229a;

    /* renamed from: b */
    final Func1<? super T, ? extends Observable<? extends R>> f46230b;

    /* renamed from: c */
    final int f46231c;

    /* renamed from: d */
    final int f46232d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: rx.internal.operators.z$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15979a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15982d f46233a;

        C15979a(C15982d c15982d) {
            this.f46233a = c15982d;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f46233a.m977L(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: rx.internal.operators.z$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15980b<T, R> implements Producer {

        /* renamed from: a */
        final R f46235a;

        /* renamed from: b */
        final C15982d<T, R> f46236b;

        /* renamed from: c */
        boolean f46237c;

        public C15980b(R r, C15982d<T, R> c15982d) {
            this.f46235a = r;
            this.f46236b = c15982d;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (this.f46237c || j <= 0) {
                return;
            }
            this.f46237c = true;
            C15982d<T, R> c15982d = this.f46236b;
            c15982d.m979J(this.f46235a);
            c15982d.m981H(1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: rx.internal.operators.z$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15981c<T, R> extends Subscriber<R> {

        /* renamed from: a */
        final C15982d<T, R> f46238a;

        /* renamed from: b */
        long f46239b;

        public C15981c(C15982d<T, R> c15982d) {
            this.f46238a = c15982d;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46238a.m981H(this.f46239b);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46238a.m980I(th, this.f46239b);
        }

        @Override // p640rx.Observer
        public void onNext(R r) {
            this.f46239b++;
            this.f46238a.m979J(r);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f46238a.f46243d.m960c(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* renamed from: rx.internal.operators.z$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15982d<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super R> f46240a;

        /* renamed from: b */
        final Func1<? super T, ? extends Observable<? extends R>> f46241b;

        /* renamed from: c */
        final int f46242c;

        /* renamed from: e */
        final Queue<Object> f46244e;

        /* renamed from: h */
        final SerialSubscription f46247h;

        /* renamed from: i */
        volatile boolean f46248i;

        /* renamed from: j */
        volatile boolean f46249j;

        /* renamed from: d */
        final ProducerArbiter f46243d = new ProducerArbiter();

        /* renamed from: f */
        final AtomicInteger f46245f = new AtomicInteger();

        /* renamed from: g */
        final AtomicReference<Throwable> f46246g = new AtomicReference<>();

        public C15982d(Subscriber<? super R> subscriber, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
            Queue<Object> spscAtomicArrayQueue;
            this.f46240a = subscriber;
            this.f46241b = func1;
            this.f46242c = i2;
            if (UnsafeAccess.m759f()) {
                spscAtomicArrayQueue = new C16092z<>(i);
            } else {
                spscAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
            }
            this.f46244e = spscAtomicArrayQueue;
            this.f46247h = new SerialSubscription();
            request(i);
        }

        /* renamed from: F */
        void m983F() {
            if (this.f46245f.getAndIncrement() != 0) {
                return;
            }
            int i = this.f46242c;
            while (!this.f46240a.isUnsubscribed()) {
                if (!this.f46249j) {
                    if (i == 1 && this.f46246g.get() != null) {
                        Throwable terminate = ExceptionsUtils.terminate(this.f46246g);
                        if (ExceptionsUtils.isTerminated(terminate)) {
                            return;
                        }
                        this.f46240a.onError(terminate);
                        return;
                    }
                    boolean z = this.f46248i;
                    Object poll = this.f46244e.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = ExceptionsUtils.terminate(this.f46246g);
                        if (terminate2 == null) {
                            this.f46240a.onCompleted();
                            return;
                        } else if (ExceptionsUtils.isTerminated(terminate2)) {
                            return;
                        } else {
                            this.f46240a.onError(terminate2);
                            return;
                        }
                    } else if (!z2) {
                        try {
                            Observable<? extends R> call = this.f46241b.call((Object) NotificationLite.m1048e(poll));
                            if (call == null) {
                                m982G(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            } else if (call != Observable.m1747S1()) {
                                if (call instanceof ScalarSynchronousObservable) {
                                    this.f46249j = true;
                                    this.f46243d.m960c(new C15980b(((ScalarSynchronousObservable) call).m817x7(), this));
                                } else {
                                    C15981c c15981c = new C15981c(this);
                                    this.f46247h.m347b(c15981c);
                                    if (c15981c.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f46249j = true;
                                    call.m1822I6(c15981c);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            C15575a.m1474e(th);
                            m982G(th);
                            return;
                        }
                    }
                }
                if (this.f46245f.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* renamed from: G */
        void m982G(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.f46246g, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.f46246g);
                if (ExceptionsUtils.isTerminated(terminate)) {
                    return;
                }
                this.f46240a.onError(terminate);
                return;
            }
            m978K(th);
        }

        /* renamed from: H */
        void m981H(long j) {
            if (j != 0) {
                this.f46243d.m961b(j);
            }
            this.f46249j = false;
            m983F();
        }

        /* renamed from: I */
        void m980I(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.f46246g, th)) {
                m978K(th);
            } else if (this.f46242c == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.f46246g);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f46240a.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.f46243d.m961b(j);
                }
                this.f46249j = false;
                m983F();
            }
        }

        /* renamed from: J */
        void m979J(R r) {
            this.f46240a.onNext(r);
        }

        /* renamed from: K */
        void m978K(Throwable th) {
            RxJavaHooks.m576I(th);
        }

        /* renamed from: L */
        void m977L(long j) {
            if (j > 0) {
                this.f46243d.request(j);
            } else if (j >= 0) {
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46248i = true;
            m983F();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.f46246g, th)) {
                this.f46248i = true;
                if (this.f46242c == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.f46246g);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.f46240a.onError(terminate);
                    }
                    this.f46247h.unsubscribe();
                    return;
                }
                m983F();
                return;
            }
            m978K(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (!this.f46244e.offer(NotificationLite.m1043j(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            m983F();
        }
    }

    public OnSubscribeConcatMap(Observable<? extends T> observable, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.f46229a = observable;
        this.f46230b = func1;
        this.f46231c = i;
        this.f46232d = i2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        C15982d c15982d = new C15982d(this.f46232d == 0 ? new SerializedSubscriber<>(subscriber) : subscriber, this.f46230b, this.f46231c, this.f46232d);
        subscriber.add(c15982d);
        subscriber.add(c15982d.f46247h);
        subscriber.setProducer(new C15979a(c15982d));
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.f46229a.m1822I6(c15982d);
    }
}
