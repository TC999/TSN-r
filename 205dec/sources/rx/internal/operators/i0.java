package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.internal.util.ExceptionsUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFlatMapCompletable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62747a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.b> f62748b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f62749c;

    /* renamed from: d  reason: collision with root package name */
    final int f62750d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFlatMapCompletable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62751a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.b> f62752b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f62753c;

        /* renamed from: d  reason: collision with root package name */
        final int f62754d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f62755e = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Throwable> f62757g = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final rx.subscriptions.b f62756f = new rx.subscriptions.b();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeFlatMapCompletable.java */
        /* renamed from: rx.internal.operators.i0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class C1282a extends AtomicReference<rx.m> implements rx.d, rx.m {
            private static final long serialVersionUID = -8588259593722659900L;

            C1282a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                if (compareAndSet(null, mVar)) {
                    return;
                }
                mVar.unsubscribe();
                if (get() != this) {
                    rx.plugins.c.I(new IllegalStateException("Subscription already set!"));
                }
            }

            @Override // rx.m
            public boolean isUnsubscribed() {
                return get() == this;
            }

            @Override // rx.d
            public void onCompleted() {
                a.this.v(this);
            }

            @Override // rx.d
            public void onError(Throwable th) {
                a.this.x(this, th);
            }

            @Override // rx.m
            public void unsubscribe() {
                rx.m andSet = getAndSet(this);
                if (andSet == null || andSet == this) {
                    return;
                }
                andSet.unsubscribe();
            }
        }

        a(rx.l<? super T> lVar, rx.functions.p<? super T, ? extends rx.b> pVar, boolean z3, int i4) {
            this.f62751a = lVar;
            this.f62752b = pVar;
            this.f62753c = z3;
            this.f62754d = i4;
            request(i4 != Integer.MAX_VALUE ? i4 : Long.MAX_VALUE);
        }

        boolean g() {
            if (this.f62755e.decrementAndGet() == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.f62757g);
                if (terminate != null) {
                    this.f62751a.onError(terminate);
                    return true;
                }
                this.f62751a.onCompleted();
                return true;
            }
            return false;
        }

        @Override // rx.f
        public void onCompleted() {
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62753c) {
                ExceptionsUtils.addThrowable(this.f62757g, th);
                onCompleted();
                return;
            }
            this.f62756f.unsubscribe();
            if (this.f62757g.compareAndSet(null, th)) {
                this.f62751a.onError(ExceptionsUtils.terminate(this.f62757g));
            } else {
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                rx.b call = this.f62752b.call(t3);
                if (call != null) {
                    C1282a c1282a = new C1282a();
                    this.f62756f.a(c1282a);
                    this.f62755e.getAndIncrement();
                    call.G0(c1282a);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Completable");
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        public void v(a<T>.C1282a c1282a) {
            this.f62756f.g(c1282a);
            if (g() || this.f62754d == Integer.MAX_VALUE) {
                return;
            }
            request(1L);
        }

        public void x(a<T>.C1282a c1282a, Throwable th) {
            this.f62756f.g(c1282a);
            if (this.f62753c) {
                ExceptionsUtils.addThrowable(this.f62757g, th);
                if (g() || this.f62754d == Integer.MAX_VALUE) {
                    return;
                }
                request(1L);
                return;
            }
            this.f62756f.unsubscribe();
            unsubscribe();
            if (this.f62757g.compareAndSet(null, th)) {
                this.f62751a.onError(ExceptionsUtils.terminate(this.f62757g));
            } else {
                rx.plugins.c.I(th);
            }
        }
    }

    public i0(rx.e<T> eVar, rx.functions.p<? super T, ? extends rx.b> pVar, boolean z3, int i4) {
        if (pVar == null) {
            throw new NullPointerException("mapper is null");
        }
        if (i4 > 0) {
            this.f62747a = eVar;
            this.f62748b = pVar;
            this.f62749c = z3;
            this.f62750d = i4;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i4);
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f62748b, this.f62749c, this.f62750d);
        lVar.add(aVar);
        lVar.add(aVar.f62756f);
        this.f62747a.I6(aVar);
    }
}
