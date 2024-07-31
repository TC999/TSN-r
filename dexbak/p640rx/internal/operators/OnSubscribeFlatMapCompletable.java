package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.internal.util.ExceptionsUtils;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.i0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFlatMapCompletable<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<T> f45316a;

    /* renamed from: b */
    final Func1<? super T, ? extends Completable> f45317b;

    /* renamed from: c */
    final boolean f45318c;

    /* renamed from: d */
    final int f45319d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlatMapCompletable.java */
    /* renamed from: rx.internal.operators.i0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15748a<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super T> f45320a;

        /* renamed from: b */
        final Func1<? super T, ? extends Completable> f45321b;

        /* renamed from: c */
        final boolean f45322c;

        /* renamed from: d */
        final int f45323d;

        /* renamed from: e */
        final AtomicInteger f45324e = new AtomicInteger(1);

        /* renamed from: g */
        final AtomicReference<Throwable> f45326g = new AtomicReference<>();

        /* renamed from: f */
        final CompositeSubscription f45325f = new CompositeSubscription();

        /* compiled from: OnSubscribeFlatMapCompletable.java */
        /* renamed from: rx.internal.operators.i0$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class C15749a extends AtomicReference<Subscription> implements CompletableSubscriber, Subscription {
            private static final long serialVersionUID = -8588259593722659900L;

            C15749a() {
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                if (compareAndSet(null, subscription)) {
                    return;
                }
                subscription.unsubscribe();
                if (get() != this) {
                    RxJavaHooks.m576I(new IllegalStateException("Subscription already set!"));
                }
            }

            @Override // p640rx.Subscription
            public boolean isUnsubscribed() {
                return get() == this;
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                C15748a.this.m1213G(this);
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                C15748a.this.m1212H(this, th);
            }

            @Override // p640rx.Subscription
            public void unsubscribe() {
                Subscription andSet = getAndSet(this);
                if (andSet == null || andSet == this) {
                    return;
                }
                andSet.unsubscribe();
            }
        }

        C15748a(Subscriber<? super T> subscriber, Func1<? super T, ? extends Completable> func1, boolean z, int i) {
            this.f45320a = subscriber;
            this.f45321b = func1;
            this.f45322c = z;
            this.f45323d = i;
            request(i != Integer.MAX_VALUE ? i : Long.MAX_VALUE);
        }

        /* renamed from: F */
        boolean m1214F() {
            if (this.f45324e.decrementAndGet() == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.f45326g);
                if (terminate != null) {
                    this.f45320a.onError(terminate);
                    return true;
                }
                this.f45320a.onCompleted();
                return true;
            }
            return false;
        }

        /* renamed from: G */
        public void m1213G(C15748a<T>.C15749a c15749a) {
            this.f45325f.m361G(c15749a);
            if (m1214F() || this.f45323d == Integer.MAX_VALUE) {
                return;
            }
            request(1L);
        }

        /* renamed from: H */
        public void m1212H(C15748a<T>.C15749a c15749a, Throwable th) {
            this.f45325f.m361G(c15749a);
            if (this.f45322c) {
                ExceptionsUtils.addThrowable(this.f45326g, th);
                if (m1214F() || this.f45323d == Integer.MAX_VALUE) {
                    return;
                }
                request(1L);
                return;
            }
            this.f45325f.unsubscribe();
            unsubscribe();
            if (this.f45326g.compareAndSet(null, th)) {
                this.f45320a.onError(ExceptionsUtils.terminate(this.f45326g));
            } else {
                RxJavaHooks.m576I(th);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            m1214F();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45322c) {
                ExceptionsUtils.addThrowable(this.f45326g, th);
                onCompleted();
                return;
            }
            this.f45325f.unsubscribe();
            if (this.f45326g.compareAndSet(null, th)) {
                this.f45320a.onError(ExceptionsUtils.terminate(this.f45326g));
            } else {
                RxJavaHooks.m576I(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                Completable call = this.f45321b.call(t);
                if (call != null) {
                    C15749a c15749a = new C15749a();
                    this.f45325f.m359a(c15749a);
                    this.f45324e.getAndIncrement();
                    call.m1967G0(c15749a);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Completable");
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeFlatMapCompletable(Observable<T> observable, Func1<? super T, ? extends Completable> func1, boolean z, int i) {
        if (func1 == null) {
            throw new NullPointerException("mapper is null");
        }
        if (i > 0) {
            this.f45316a = observable;
            this.f45317b = func1;
            this.f45318c = z;
            this.f45319d = i;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i);
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        C15748a c15748a = new C15748a(subscriber, this.f45317b, this.f45318c, this.f45319d);
        subscriber.add(c15748a);
        subscriber.add(c15748a.f45325f);
        this.f45316a.m1822I6(c15748a);
    }
}
