package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.internal.util.ExceptionsUtils;
import p640rx.internal.util.atomic.MpscLinkedAtomicQueue;
import p640rx.internal.util.unsafe.MpscLinkedQueue;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.j0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFlatMapSingle<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<T> f45368a;

    /* renamed from: b */
    final Func1<? super T, ? extends Single<? extends R>> f45369b;

    /* renamed from: c */
    final boolean f45370c;

    /* renamed from: d */
    final int f45371d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlatMapSingle.java */
    /* renamed from: rx.internal.operators.j0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15758a<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super R> f45372a;

        /* renamed from: b */
        final Func1<? super T, ? extends Single<? extends R>> f45373b;

        /* renamed from: c */
        final boolean f45374c;

        /* renamed from: d */
        final int f45375d;

        /* renamed from: i */
        final Queue<Object> f45380i;

        /* renamed from: k */
        volatile boolean f45382k;

        /* renamed from: l */
        volatile boolean f45383l;

        /* renamed from: e */
        final AtomicInteger f45376e = new AtomicInteger();

        /* renamed from: h */
        final AtomicReference<Throwable> f45379h = new AtomicReference<>();

        /* renamed from: j */
        final C15758a<T, R>.C15760b f45381j = new C15760b();

        /* renamed from: g */
        final CompositeSubscription f45378g = new CompositeSubscription();

        /* renamed from: f */
        final AtomicInteger f45377f = new AtomicInteger();

        /* compiled from: OnSubscribeFlatMapSingle.java */
        /* renamed from: rx.internal.operators.j0$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class C15759a extends SingleSubscriber<R> {
            C15759a() {
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(R r) {
                C15758a.this.m1202H(this, r);
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                C15758a.this.m1203G(this, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeFlatMapSingle.java */
        /* renamed from: rx.internal.operators.j0$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15760b extends AtomicLong implements Producer, Subscription {
            private static final long serialVersionUID = -887187595446742742L;

            C15760b() {
            }

            /* renamed from: a */
            void m1201a(long j) {
                BackpressureUtils.m1328i(this, j);
            }

            @Override // p640rx.Subscription
            public boolean isUnsubscribed() {
                return C15758a.this.f45383l;
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.m1335b(this, j);
                    C15758a.this.m1204F();
                }
            }

            @Override // p640rx.Subscription
            public void unsubscribe() {
                C15758a.this.f45383l = true;
                C15758a.this.unsubscribe();
                if (C15758a.this.f45376e.getAndIncrement() == 0) {
                    C15758a.this.f45380i.clear();
                }
            }
        }

        C15758a(Subscriber<? super R> subscriber, Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
            this.f45372a = subscriber;
            this.f45373b = func1;
            this.f45374c = z;
            this.f45375d = i;
            if (UnsafeAccess.m759f()) {
                this.f45380i = new MpscLinkedQueue();
            } else {
                this.f45380i = new MpscLinkedAtomicQueue();
            }
            request(i != Integer.MAX_VALUE ? i : Long.MAX_VALUE);
        }

        /* renamed from: F */
        void m1204F() {
            if (this.f45376e.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.f45372a;
            Queue<Object> queue = this.f45380i;
            boolean z = this.f45374c;
            AtomicInteger atomicInteger = this.f45377f;
            int i = 1;
            do {
                long j = this.f45381j.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.f45383l) {
                        queue.clear();
                        return;
                    }
                    boolean z2 = this.f45382k;
                    if (!z && z2 && this.f45379h.get() != null) {
                        queue.clear();
                        subscriber.onError(ExceptionsUtils.terminate(this.f45379h));
                        return;
                    }
                    Object poll = queue.poll();
                    boolean z3 = poll == null;
                    if (z2 && atomicInteger.get() == 0 && z3) {
                        if (this.f45379h.get() != null) {
                            subscriber.onError(ExceptionsUtils.terminate(this.f45379h));
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    } else if (z3) {
                        break;
                    } else {
                        subscriber.onNext((Object) NotificationLite.m1048e(poll));
                        j2++;
                    }
                }
                if (j2 == j) {
                    if (this.f45383l) {
                        queue.clear();
                        return;
                    } else if (this.f45382k) {
                        if (z) {
                            if (atomicInteger.get() == 0 && queue.isEmpty()) {
                                if (this.f45379h.get() != null) {
                                    subscriber.onError(ExceptionsUtils.terminate(this.f45379h));
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            }
                        } else if (this.f45379h.get() != null) {
                            queue.clear();
                            subscriber.onError(ExceptionsUtils.terminate(this.f45379h));
                            return;
                        } else if (atomicInteger.get() == 0 && queue.isEmpty()) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    this.f45381j.m1201a(j2);
                    if (!this.f45382k && this.f45375d != Integer.MAX_VALUE) {
                        request(j2);
                    }
                }
                i = this.f45376e.addAndGet(-i);
            } while (i != 0);
        }

        /* renamed from: G */
        void m1203G(C15758a<T, R>.C15759a c15759a, Throwable th) {
            if (this.f45374c) {
                ExceptionsUtils.addThrowable(this.f45379h, th);
                this.f45378g.m361G(c15759a);
                if (!this.f45382k && this.f45375d != Integer.MAX_VALUE) {
                    request(1L);
                }
            } else {
                this.f45378g.unsubscribe();
                unsubscribe();
                if (!this.f45379h.compareAndSet(null, th)) {
                    RxJavaHooks.m576I(th);
                    return;
                }
                this.f45382k = true;
            }
            this.f45377f.decrementAndGet();
            m1204F();
        }

        /* renamed from: H */
        void m1202H(C15758a<T, R>.C15759a c15759a, R r) {
            this.f45380i.offer(NotificationLite.m1043j(r));
            this.f45378g.m361G(c15759a);
            this.f45377f.decrementAndGet();
            m1204F();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45382k = true;
            m1204F();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45374c) {
                ExceptionsUtils.addThrowable(this.f45379h, th);
            } else {
                this.f45378g.unsubscribe();
                if (!this.f45379h.compareAndSet(null, th)) {
                    RxJavaHooks.m576I(th);
                    return;
                }
            }
            this.f45382k = true;
            m1204F();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                Single<? extends R> call = this.f45373b.call(t);
                if (call != null) {
                    C15759a c15759a = new C15759a();
                    this.f45378g.m359a(c15759a);
                    this.f45377f.incrementAndGet();
                    call.m1372i0(c15759a);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Single");
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeFlatMapSingle(Observable<T> observable, Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
        if (func1 == null) {
            throw new NullPointerException("mapper is null");
        }
        if (i > 0) {
            this.f45368a = observable;
            this.f45369b = func1;
            this.f45370c = z;
            this.f45371d = i;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i);
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        C15758a c15758a = new C15758a(subscriber, this.f45369b, this.f45370c, this.f45371d);
        subscriber.add(c15758a.f45378g);
        subscriber.add(c15758a.f45381j);
        subscriber.setProducer(c15758a.f45381j);
        this.f45368a.m1822I6(c15758a);
    }
}
