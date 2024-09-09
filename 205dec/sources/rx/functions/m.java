package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Actions.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final C1270m f62235a = new C1270m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T8, T9, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> implements x<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.j f62236a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62237b;

        a(rx.functions.j jVar, Object obj) {
            this.f62236a = jVar;
            this.f62237b = obj;
        }

        @Override // rx.functions.x
        public R call(T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            this.f62236a.call(t12, t22, t3, t4, t5, t6, t7, t8, t9);
            return (R) this.f62237b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.l f62238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62239b;

        b(rx.functions.l lVar, Object obj) {
            this.f62238a = lVar;
            this.f62239b = obj;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            this.f62238a.call(objArr);
            return (R) this.f62239b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c<R> implements o<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62241b;

        c(rx.functions.a aVar, Object obj) {
            this.f62240a = aVar;
            this.f62241b = obj;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public R call() {
            this.f62240a.call();
            return (R) this.f62241b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T1] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d<R, T1> implements p<T1, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62243b;

        d(rx.functions.b bVar, Object obj) {
            this.f62242a = bVar;
            this.f62243b = obj;
        }

        @Override // rx.functions.p
        public R call(T1 t12) {
            this.f62242a.call(t12);
            return (R) this.f62243b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T1, T2] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e<R, T1, T2> implements q<T1, T2, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.c f62244a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62245b;

        e(rx.functions.c cVar, Object obj) {
            this.f62244a = cVar;
            this.f62245b = obj;
        }

        @Override // rx.functions.q
        public R call(T1 t12, T2 t22) {
            this.f62244a.call(t12, t22);
            return (R) this.f62245b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f<R, T1, T2, T3> implements r<T1, T2, T3, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.d f62246a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62247b;

        f(rx.functions.d dVar, Object obj) {
            this.f62246a = dVar;
            this.f62247b = obj;
        }

        @Override // rx.functions.r
        public R call(T1 t12, T2 t22, T3 t3) {
            this.f62246a.call(t12, t22, t3);
            return (R) this.f62247b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, R, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class g<R, T1, T2, T3, T4> implements s<T1, T2, T3, T4, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.e f62248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62249b;

        g(rx.functions.e eVar, Object obj) {
            this.f62248a = eVar;
            this.f62249b = obj;
        }

        @Override // rx.functions.s
        public R call(T1 t12, T2 t22, T3 t3, T4 t4) {
            this.f62248a.call(t12, t22, t3, t4);
            return (R) this.f62249b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, R, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class h<R, T1, T2, T3, T4, T5> implements t<T1, T2, T3, T4, T5, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.f f62250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62251b;

        h(rx.functions.f fVar, Object obj) {
            this.f62250a = fVar;
            this.f62251b = obj;
        }

        @Override // rx.functions.t
        public R call(T1 t12, T2 t22, T3 t3, T4 t4, T5 t5) {
            this.f62250a.call(t12, t22, t3, t4, t5);
            return (R) this.f62251b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class i<R, T1, T2, T3, T4, T5, T6> implements u<T1, T2, T3, T4, T5, T6, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.g f62252a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62253b;

        i(rx.functions.g gVar, Object obj) {
            this.f62252a = gVar;
            this.f62253b = obj;
        }

        @Override // rx.functions.u
        public R call(T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6) {
            this.f62252a.call(t12, t22, t3, t4, t5, t6);
            return (R) this.f62253b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class j<R, T1, T2, T3, T4, T5, T6, T7> implements v<T1, T2, T3, T4, T5, T6, T7, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.h f62254a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62255b;

        j(rx.functions.h hVar, Object obj) {
            this.f62254a = hVar;
            this.f62255b = obj;
        }

        @Override // rx.functions.v
        public R call(T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
            this.f62254a.call(t12, t22, t3, t4, t5, t6, t7);
            return (R) this.f62255b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T8, T1, T2, T3] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class k<R, T1, T2, T3, T4, T5, T6, T7, T8> implements w<T1, T2, T3, T4, T5, T6, T7, T8, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.i f62256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f62257b;

        k(rx.functions.i iVar, Object obj) {
            this.f62256a = iVar;
            this.f62257b = obj;
        }

        @Override // rx.functions.w
        public R call(T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
            this.f62256a.call(t12, t22, t3, t4, t5, t6, t7, t8);
            return (R) this.f62257b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class l<T> implements rx.functions.b<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.a f62258a;

        public l(rx.functions.a aVar) {
            this.f62258a = aVar;
        }

        @Override // rx.functions.b
        public void call(T t3) {
            this.f62258a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$m  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1270m<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements rx.functions.a, rx.functions.b<T0>, rx.functions.c<T0, T1>, rx.functions.d<T0, T1, T2>, rx.functions.e<T0, T1, T2, T3>, rx.functions.f<T0, T1, T2, T3, T4>, rx.functions.g<T0, T1, T2, T3, T4, T5>, rx.functions.h<T0, T1, T2, T3, T4, T5, T6>, rx.functions.i<T0, T1, T2, T3, T4, T5, T6, T7>, rx.functions.j<T0, T1, T2, T3, T4, T5, T6, T7, T8>, rx.functions.l {
        C1270m() {
        }

        @Override // rx.functions.a
        public void call() {
        }

        @Override // rx.functions.b
        public void call(T0 t02) {
        }

        @Override // rx.functions.c
        public void call(T0 t02, T1 t12) {
        }

        @Override // rx.functions.d
        public void call(T0 t02, T1 t12, T2 t22) {
        }

        @Override // rx.functions.e
        public void call(T0 t02, T1 t12, T2 t22, T3 t3) {
        }

        @Override // rx.functions.f
        public void call(T0 t02, T1 t12, T2 t22, T3 t3, T4 t4) {
        }

        @Override // rx.functions.g
        public void call(T0 t02, T1 t12, T2 t22, T3 t3, T4 t4, T5 t5) {
        }

        @Override // rx.functions.h
        public void call(T0 t02, T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6) {
        }

        @Override // rx.functions.i
        public void call(T0 t02, T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        }

        @Override // rx.functions.j
        public void call(T0 t02, T1 t12, T2 t22, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        @Override // rx.functions.l
        public void call(Object... objArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Actions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum n implements rx.functions.b<Throwable> {
        INSTANCE;

        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    private m() {
        throw new IllegalStateException("No instances!");
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> C1270m<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return f62235a;
    }

    public static rx.functions.b<Throwable> b() {
        return n.INSTANCE;
    }

    public static <T> rx.functions.b<T> c(rx.functions.a aVar) {
        return new l(aVar);
    }

    public static o<Void> d(rx.functions.a aVar) {
        return e(aVar, null);
    }

    public static <R> o<R> e(rx.functions.a aVar, R r3) {
        return new c(aVar, r3);
    }

    public static <T1> p<T1, Void> f(rx.functions.b<T1> bVar) {
        return g(bVar, null);
    }

    public static <T1, R> p<T1, R> g(rx.functions.b<T1> bVar, R r3) {
        return new d(bVar, r3);
    }

    public static <T1, T2> q<T1, T2, Void> h(rx.functions.c<T1, T2> cVar) {
        return i(cVar, null);
    }

    public static <T1, T2, R> q<T1, T2, R> i(rx.functions.c<T1, T2> cVar, R r3) {
        return new e(cVar, r3);
    }

    public static <T1, T2, T3> r<T1, T2, T3, Void> j(rx.functions.d<T1, T2, T3> dVar) {
        return k(dVar, null);
    }

    public static <T1, T2, T3, R> r<T1, T2, T3, R> k(rx.functions.d<T1, T2, T3> dVar, R r3) {
        return new f(dVar, r3);
    }

    public static <T1, T2, T3, T4> s<T1, T2, T3, T4, Void> l(rx.functions.e<T1, T2, T3, T4> eVar) {
        return m(eVar, null);
    }

    public static <T1, T2, T3, T4, R> s<T1, T2, T3, T4, R> m(rx.functions.e<T1, T2, T3, T4> eVar, R r3) {
        return new g(eVar, r3);
    }

    public static <T1, T2, T3, T4, T5> t<T1, T2, T3, T4, T5, Void> n(rx.functions.f<T1, T2, T3, T4, T5> fVar) {
        return o(fVar, null);
    }

    public static <T1, T2, T3, T4, T5, R> t<T1, T2, T3, T4, T5, R> o(rx.functions.f<T1, T2, T3, T4, T5> fVar, R r3) {
        return new h(fVar, r3);
    }

    public static <T1, T2, T3, T4, T5, T6> u<T1, T2, T3, T4, T5, T6, Void> p(rx.functions.g<T1, T2, T3, T4, T5, T6> gVar) {
        return q(gVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, R> u<T1, T2, T3, T4, T5, T6, R> q(rx.functions.g<T1, T2, T3, T4, T5, T6> gVar, R r3) {
        return new i(gVar, r3);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> v<T1, T2, T3, T4, T5, T6, T7, Void> r(rx.functions.h<T1, T2, T3, T4, T5, T6, T7> hVar) {
        return s(hVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> v<T1, T2, T3, T4, T5, T6, T7, R> s(rx.functions.h<T1, T2, T3, T4, T5, T6, T7> hVar, R r3) {
        return new j(hVar, r3);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> w<T1, T2, T3, T4, T5, T6, T7, T8, Void> t(rx.functions.i<T1, T2, T3, T4, T5, T6, T7, T8> iVar) {
        return u(iVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> w<T1, T2, T3, T4, T5, T6, T7, T8, R> u(rx.functions.i<T1, T2, T3, T4, T5, T6, T7, T8> iVar, R r3) {
        return new k(iVar, r3);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> x<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> v(rx.functions.j<T1, T2, T3, T4, T5, T6, T7, T8, T9> jVar) {
        return w(jVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> x<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> w(rx.functions.j<T1, T2, T3, T4, T5, T6, T7, T8, T9> jVar, R r3) {
        return new a(jVar, r3);
    }

    public static y<Void> x(rx.functions.l lVar) {
        return y(lVar, null);
    }

    public static <R> y<R> y(rx.functions.l lVar, R r3) {
        return new b(lVar, r3);
    }
}
