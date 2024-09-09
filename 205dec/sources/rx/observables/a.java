package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.annotations.Beta;
import rx.e;
import rx.functions.o;
import rx.functions.p;
import rx.functions.r;
import rx.l;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: AsyncOnSubscribe.java */
@Beta
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class a<S, T> implements e.a<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* renamed from: rx.observables.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class C1317a implements r<S, Long, rx.f<rx.e<? extends T>>, S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.d f64085a;

        C1317a(rx.functions.d dVar) {
            this.f64085a = dVar;
        }

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ Object call(Object obj, Long l4, Object obj2) {
            return call((C1317a) obj, l4, (rx.f) ((rx.f) obj2));
        }

        public S call(S s3, Long l4, rx.f<rx.e<? extends T>> fVar) {
            this.f64085a.call(s3, l4, fVar);
            return s3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class b implements r<S, Long, rx.f<rx.e<? extends T>>, S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.d f64086a;

        b(rx.functions.d dVar) {
            this.f64086a = dVar;
        }

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ Object call(Object obj, Long l4, Object obj2) {
            return call((b) obj, l4, (rx.f) ((rx.f) obj2));
        }

        public S call(S s3, Long l4, rx.f<rx.e<? extends T>> fVar) {
            this.f64086a.call(s3, l4, fVar);
            return s3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class c implements r<Void, Long, rx.f<rx.e<? extends T>>, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.c f64087a;

        c(rx.functions.c cVar) {
            this.f64087a = cVar;
        }

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ Void call(Void r12, Long l4, Object obj) {
            return call(r12, l4, (rx.f) ((rx.f) obj));
        }

        public Void call(Void r22, Long l4, rx.f<rx.e<? extends T>> fVar) {
            this.f64087a.call(l4, fVar);
            return r22;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class d implements r<Void, Long, rx.f<rx.e<? extends T>>, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.c f64088a;

        d(rx.functions.c cVar) {
            this.f64088a = cVar;
        }

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ Void call(Void r12, Long l4, Object obj) {
            return call(r12, l4, (rx.f) ((rx.f) obj));
        }

        public Void call(Void r12, Long l4, rx.f<rx.e<? extends T>> fVar) {
            this.f64088a.call(l4, fVar);
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class e implements rx.functions.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f64089a;

        e(rx.functions.a aVar) {
            this.f64089a = aVar;
        }

        @Override // rx.functions.b
        public void call(Void r12) {
            this.f64089a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class f extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f64090a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f64091b;

        f(l lVar, i iVar) {
            this.f64090a = lVar;
            this.f64091b = iVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64090a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64090a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64090a.onNext(t3);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f64091b.J(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class g implements p<rx.e<T>, rx.e<T>> {
        g() {
        }

        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((rx.e) ((rx.e) obj));
        }

        public rx.e<T> call(rx.e<T> eVar) {
            return eVar.M3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class i<S, T> implements rx.g, m, rx.f<rx.e<? extends T>> {

        /* renamed from: b  reason: collision with root package name */
        private final a<S, T> f64098b;

        /* renamed from: e  reason: collision with root package name */
        private boolean f64101e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f64102f;

        /* renamed from: g  reason: collision with root package name */
        private S f64103g;

        /* renamed from: h  reason: collision with root package name */
        private final j<rx.e<T>> f64104h;

        /* renamed from: i  reason: collision with root package name */
        boolean f64105i;

        /* renamed from: j  reason: collision with root package name */
        List<Long> f64106j;

        /* renamed from: k  reason: collision with root package name */
        rx.g f64107k;

        /* renamed from: l  reason: collision with root package name */
        long f64108l;

        /* renamed from: d  reason: collision with root package name */
        final rx.subscriptions.b f64100d = new rx.subscriptions.b();

        /* renamed from: c  reason: collision with root package name */
        private final rx.observers.f<rx.e<? extends T>> f64099c = new rx.observers.f<>(this);

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f64097a = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: AsyncOnSubscribe.java */
        /* renamed from: rx.observables.a$i$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class C1318a extends l<T> {

            /* renamed from: a  reason: collision with root package name */
            long f64109a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f64110b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ rx.internal.operators.g f64111c;

            C1318a(long j4, rx.internal.operators.g gVar) {
                this.f64110b = j4;
                this.f64111c = gVar;
                this.f64109a = j4;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f64111c.onCompleted();
                long j4 = this.f64109a;
                if (j4 > 0) {
                    i.this.I(j4);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f64111c.onError(th);
            }

            @Override // rx.f
            public void onNext(T t3) {
                this.f64109a--;
                this.f64111c.onNext(t3);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: AsyncOnSubscribe.java */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f64113a;

            b(l lVar) {
                this.f64113a = lVar;
            }

            @Override // rx.functions.a
            public void call() {
                i.this.f64100d.G(this.f64113a);
            }
        }

        public i(a<S, T> aVar, S s3, j<rx.e<T>> jVar) {
            this.f64098b = aVar;
            this.f64103g = s3;
            this.f64104h = jVar;
        }

        private void F(Throwable th) {
            if (this.f64101e) {
                rx.plugins.c.I(th);
                return;
            }
            this.f64101e = true;
            this.f64104h.onError(th);
            d();
        }

        private void K(rx.e<? extends T> eVar) {
            rx.internal.operators.g x7 = rx.internal.operators.g.x7();
            C1318a c1318a = new C1318a(this.f64108l, x7);
            this.f64100d.a(c1318a);
            eVar.O1(new b(c1318a)).q5(c1318a);
            this.f64104h.onNext(x7);
        }

        public void G(long j4) {
            this.f64103g = this.f64098b.h(this.f64103g, j4, this.f64099c);
        }

        @Override // rx.f
        /* renamed from: H */
        public void onNext(rx.e<? extends T> eVar) {
            if (!this.f64102f) {
                this.f64102f = true;
                if (this.f64101e) {
                    return;
                }
                K(eVar);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        public void I(long j4) {
            if (j4 == 0) {
                return;
            }
            if (j4 >= 0) {
                synchronized (this) {
                    if (this.f64105i) {
                        List list = this.f64106j;
                        if (list == null) {
                            list = new ArrayList();
                            this.f64106j = list;
                        }
                        list.add(Long.valueOf(j4));
                        return;
                    }
                    this.f64105i = true;
                    if (L(j4)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.f64106j;
                            if (list2 == null) {
                                this.f64105i = false;
                                return;
                            }
                            this.f64106j = null;
                            for (Long l4 : list2) {
                                if (L(l4.longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Request can't be negative! " + j4);
            }
        }

        void J(rx.g gVar) {
            if (this.f64107k == null) {
                this.f64107k = gVar;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        boolean L(long j4) {
            if (isUnsubscribed()) {
                d();
                return true;
            }
            try {
                this.f64102f = false;
                this.f64108l = j4;
                G(j4);
                if (!this.f64101e && !isUnsubscribed()) {
                    if (this.f64102f) {
                        return false;
                    }
                    F(new IllegalStateException("No events emitted!"));
                    return true;
                }
                d();
                return true;
            } catch (Throwable th) {
                F(th);
                return true;
            }
        }

        void d() {
            this.f64100d.unsubscribe();
            try {
                this.f64098b.i(this.f64103g);
            } catch (Throwable th) {
                F(th);
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f64097a.get();
        }

        @Override // rx.f
        public void onCompleted() {
            if (!this.f64101e) {
                this.f64101e = true;
                this.f64104h.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f64101e) {
                this.f64101e = true;
                this.f64104h.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.g
        public void request(long j4) {
            boolean z3;
            if (j4 == 0) {
                return;
            }
            if (j4 >= 0) {
                synchronized (this) {
                    z3 = true;
                    if (this.f64105i) {
                        List list = this.f64106j;
                        if (list == null) {
                            list = new ArrayList();
                            this.f64106j = list;
                        }
                        list.add(Long.valueOf(j4));
                    } else {
                        this.f64105i = true;
                        z3 = false;
                    }
                }
                this.f64107k.request(j4);
                if (z3 || L(j4)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.f64106j;
                        if (list2 == null) {
                            this.f64105i = false;
                            return;
                        }
                        this.f64106j = null;
                        for (Long l4 : list2) {
                            if (L(l4.longValue())) {
                                return;
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Request can't be negative! " + j4);
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f64097a.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.f64105i) {
                        ArrayList arrayList = new ArrayList();
                        this.f64106j = arrayList;
                        arrayList.add(0L);
                        return;
                    }
                    this.f64105i = true;
                    d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class j<T> extends rx.e<T> implements rx.f<T> {

        /* renamed from: b  reason: collision with root package name */
        private final C1319a<T> f64115b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: AsyncOnSubscribe.java */
        /* renamed from: rx.observables.a$j$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public static final class C1319a<T> implements e.a<T> {

            /* renamed from: a  reason: collision with root package name */
            l<? super T> f64116a;

            C1319a() {
            }

            @Override // rx.functions.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((l) ((l) obj));
            }

            public void call(l<? super T> lVar) {
                synchronized (this) {
                    if (this.f64116a == null) {
                        this.f64116a = lVar;
                    } else {
                        lVar.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }

        protected j(C1319a<T> c1319a) {
            super(c1319a);
            this.f64115b = c1319a;
        }

        public static <T> j<T> v7() {
            return new j<>(new C1319a());
        }

        @Override // rx.f
        public void onCompleted() {
            this.f64115b.f64116a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64115b.f64116a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f64115b.f64116a.onNext(t3);
        }
    }

    public static <S, T> a<S, T> a(o<? extends S> oVar, rx.functions.d<? super S, Long, ? super rx.f<rx.e<? extends T>>> dVar) {
        return new h(oVar, new C1317a(dVar));
    }

    public static <S, T> a<S, T> b(o<? extends S> oVar, rx.functions.d<? super S, Long, ? super rx.f<rx.e<? extends T>>> dVar, rx.functions.b<? super S> bVar) {
        return new h(oVar, new b(dVar), bVar);
    }

    public static <S, T> a<S, T> c(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar) {
        return new h(oVar, rVar);
    }

    public static <S, T> a<S, T> d(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar, rx.functions.b<? super S> bVar) {
        return new h(oVar, rVar, bVar);
    }

    public static <T> a<Void, T> e(rx.functions.c<Long, ? super rx.f<rx.e<? extends T>>> cVar) {
        return new h(new c(cVar));
    }

    public static <T> a<Void, T> f(rx.functions.c<Long, ? super rx.f<rx.e<? extends T>>> cVar, rx.functions.a aVar) {
        return new h(new d(cVar), new e(aVar));
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    protected abstract S g();

    protected abstract S h(S s3, long j4, rx.f<rx.e<? extends T>> fVar);

    protected void i(S s3) {
    }

    public final void call(l<? super T> lVar) {
        try {
            S g4 = g();
            j v7 = j.v7();
            i iVar = new i(this, g4, v7);
            f fVar = new f(lVar, iVar);
            v7.M3().Z0(new g()).I6(fVar);
            lVar.add(fVar);
            lVar.add(iVar);
            lVar.setProducer(iVar);
        } catch (Throwable th) {
            lVar.onError(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncOnSubscribe.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class h<S, T> extends a<S, T> {

        /* renamed from: a  reason: collision with root package name */
        private final o<? extends S> f64094a;

        /* renamed from: b  reason: collision with root package name */
        private final r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> f64095b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.functions.b<? super S> f64096c;

        h(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar, rx.functions.b<? super S> bVar) {
            this.f64094a = oVar;
            this.f64095b = rVar;
            this.f64096c = bVar;
        }

        @Override // rx.observables.a, rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((l) ((l) obj));
        }

        @Override // rx.observables.a
        protected S g() {
            o<? extends S> oVar = this.f64094a;
            if (oVar == null) {
                return null;
            }
            return oVar.call();
        }

        @Override // rx.observables.a
        protected S h(S s3, long j4, rx.f<rx.e<? extends T>> fVar) {
            return this.f64095b.call(s3, Long.valueOf(j4), fVar);
        }

        @Override // rx.observables.a
        protected void i(S s3) {
            rx.functions.b<? super S> bVar = this.f64096c;
            if (bVar != null) {
                bVar.call(s3);
            }
        }

        public h(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar) {
            this(oVar, rVar, null);
        }

        public h(r<S, Long, rx.f<rx.e<? extends T>>, S> rVar, rx.functions.b<? super S> bVar) {
            this(null, rVar, bVar);
        }

        public h(r<S, Long, rx.f<rx.e<? extends T>>, S> rVar) {
            this(null, rVar, null);
        }
    }
}
