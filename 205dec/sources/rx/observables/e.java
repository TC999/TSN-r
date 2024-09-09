package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.functions.o;
import rx.functions.q;
import rx.l;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SyncOnSubscribe.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class e<S, T> implements e.a<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements q<S, rx.f<? super T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.c f64149a;

        a(rx.functions.c cVar) {
            this.f64149a = cVar;
        }

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((a) obj, (rx.f) ((rx.f) obj2));
        }

        public S call(S s3, rx.f<? super T> fVar) {
            this.f64149a.call(s3, fVar);
            return s3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class b implements q<S, rx.f<? super T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.c f64150a;

        b(rx.functions.c cVar) {
            this.f64150a = cVar;
        }

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((b) obj, (rx.f) ((rx.f) obj2));
        }

        public S call(S s3, rx.f<? super T> fVar) {
            this.f64150a.call(s3, fVar);
            return s3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class c implements q<Void, rx.f<? super T>, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64151a;

        c(rx.functions.b bVar) {
            this.f64151a = bVar;
        }

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Void call(Void r12, Object obj) {
            return call(r12, (rx.f) ((rx.f) obj));
        }

        public Void call(Void r22, rx.f<? super T> fVar) {
            this.f64151a.call(fVar);
            return r22;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class d implements q<Void, rx.f<? super T>, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f64152a;

        d(rx.functions.b bVar) {
            this.f64152a = bVar;
        }

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Void call(Void r12, Object obj) {
            return call(r12, (rx.f) ((rx.f) obj));
        }

        public Void call(Void r12, rx.f<? super T> fVar) {
            this.f64152a.call(fVar);
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class C1321e implements rx.functions.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f64153a;

        C1321e(rx.functions.a aVar) {
            this.f64153a = aVar;
        }

        @Override // rx.functions.b
        public void call(Void r12) {
            this.f64153a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f<S, T> extends AtomicLong implements rx.g, m, rx.f<T> {
        private static final long serialVersionUID = -3736864024352728072L;

        /* renamed from: a  reason: collision with root package name */
        private final l<? super T> f64154a;

        /* renamed from: b  reason: collision with root package name */
        private final e<S, T> f64155b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f64156c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f64157d;

        /* renamed from: e  reason: collision with root package name */
        private S f64158e;

        f(l<? super T> lVar, e<S, T> eVar, S s3) {
            this.f64154a = lVar;
            this.f64155b = eVar;
            this.f64158e = s3;
        }

        private void F() {
            e<S, T> eVar = this.f64155b;
            l<? super T> lVar = this.f64154a;
            do {
                try {
                    this.f64156c = false;
                    H(eVar);
                } catch (Throwable th) {
                    G(lVar, th);
                    return;
                }
            } while (!J());
        }

        private void G(l<? super T> lVar, Throwable th) {
            if (this.f64157d) {
                rx.plugins.c.I(th);
                return;
            }
            this.f64157d = true;
            lVar.onError(th);
            unsubscribe();
        }

        private void H(e<S, T> eVar) {
            this.f64158e = eVar.h(this.f64158e, this);
        }

        private void I(long j4) {
            e<S, T> eVar = this.f64155b;
            l<? super T> lVar = this.f64154a;
            do {
                long j5 = j4;
                do {
                    try {
                        this.f64156c = false;
                        H(eVar);
                        if (J()) {
                            return;
                        }
                        if (this.f64156c) {
                            j5--;
                        }
                    } catch (Throwable th) {
                        G(lVar, th);
                        return;
                    }
                } while (j5 != 0);
                j4 = addAndGet(-j4);
            } while (j4 > 0);
            J();
        }

        private boolean J() {
            if (this.f64157d || get() < -1) {
                set(-1L);
                d();
                return true;
            }
            return false;
        }

        private void d() {
            try {
                this.f64155b.i(this.f64158e);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.f
        public void onCompleted() {
            if (!this.f64157d) {
                this.f64157d = true;
                if (this.f64154a.isUnsubscribed()) {
                    return;
                }
                this.f64154a.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f64157d) {
                this.f64157d = true;
                if (this.f64154a.isUnsubscribed()) {
                    return;
                }
                this.f64154a.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (!this.f64156c) {
                this.f64156c = true;
                this.f64154a.onNext(t3);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 <= 0 || rx.internal.operators.a.b(this, j4) != 0) {
                return;
            }
            if (j4 == Long.MAX_VALUE) {
                F();
            } else {
                I(j4);
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            long j4;
            do {
                j4 = get();
                if (compareAndSet(0L, -1L)) {
                    d();
                    return;
                }
            } while (!compareAndSet(j4, -2L));
        }
    }

    public static <S, T> e<S, T> a(o<? extends S> oVar, rx.functions.c<? super S, ? super rx.f<? super T>> cVar) {
        return new g(oVar, new a(cVar));
    }

    public static <S, T> e<S, T> b(o<? extends S> oVar, rx.functions.c<? super S, ? super rx.f<? super T>> cVar, rx.functions.b<? super S> bVar) {
        return new g(oVar, new b(cVar), bVar);
    }

    public static <S, T> e<S, T> c(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar) {
        return new g(oVar, qVar);
    }

    public static <S, T> e<S, T> d(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar, rx.functions.b<? super S> bVar) {
        return new g(oVar, qVar, bVar);
    }

    public static <T> e<Void, T> e(rx.functions.b<? super rx.f<? super T>> bVar) {
        return new g(new c(bVar));
    }

    public static <T> e<Void, T> f(rx.functions.b<? super rx.f<? super T>> bVar, rx.functions.a aVar) {
        return new g(new d(bVar), new C1321e(aVar));
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    protected abstract S g();

    protected abstract S h(S s3, rx.f<? super T> fVar);

    protected void i(S s3) {
    }

    public final void call(l<? super T> lVar) {
        try {
            f fVar = new f(lVar, this, g());
            lVar.add(fVar);
            lVar.setProducer(fVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class g<S, T> extends e<S, T> {

        /* renamed from: a  reason: collision with root package name */
        private final o<? extends S> f64159a;

        /* renamed from: b  reason: collision with root package name */
        private final q<? super S, ? super rx.f<? super T>, ? extends S> f64160b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.functions.b<? super S> f64161c;

        g(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar, rx.functions.b<? super S> bVar) {
            this.f64159a = oVar;
            this.f64160b = qVar;
            this.f64161c = bVar;
        }

        @Override // rx.observables.e, rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((l) ((l) obj));
        }

        @Override // rx.observables.e
        protected S g() {
            o<? extends S> oVar = this.f64159a;
            if (oVar == null) {
                return null;
            }
            return oVar.call();
        }

        @Override // rx.observables.e
        protected S h(S s3, rx.f<? super T> fVar) {
            return this.f64160b.call(s3, fVar);
        }

        @Override // rx.observables.e
        protected void i(S s3) {
            rx.functions.b<? super S> bVar = this.f64161c;
            if (bVar != null) {
                bVar.call(s3);
            }
        }

        public g(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar) {
            this(oVar, qVar, null);
        }

        public g(q<S, rx.f<? super T>, S> qVar, rx.functions.b<? super S> bVar) {
            this(null, qVar, bVar);
        }

        public g(q<S, rx.f<? super T>, S> qVar) {
            this(null, qVar, null);
        }
    }
}
