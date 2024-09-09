package rx.functions;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Functions.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f62221a;

        a(x xVar) {
            this.f62221a = xVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 9) {
                return (R) this.f62221a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Func9 expecting 9 arguments.");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class b implements y<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62222a;

        b(rx.functions.a aVar) {
            this.f62222a = aVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length == 0) {
                this.f62222a.call();
                return null;
            }
            throw new IllegalArgumentException("Action0 expecting 0 arguments.");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class c implements y<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62223a;

        c(rx.functions.b bVar) {
            this.f62223a = bVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length == 1) {
                this.f62223a.call(objArr[0]);
                return null;
            }
            throw new IllegalArgumentException("Action1 expecting 1 argument.");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class d implements y<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.c f62224a;

        d(rx.functions.c cVar) {
            this.f62224a = cVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length == 2) {
                this.f62224a.call(objArr[0], objArr[1]);
                return null;
            }
            throw new IllegalArgumentException("Action3 expecting 2 arguments.");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class e implements y<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.d f62225a;

        e(rx.functions.d dVar) {
            this.f62225a = dVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length == 3) {
                this.f62225a.call(objArr[0], objArr[1], objArr[2]);
                return null;
            }
            throw new IllegalArgumentException("Action3 expecting 3 arguments.");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class f<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f62226a;

        f(o oVar) {
            this.f62226a = oVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 0) {
                return (R) this.f62226a.call();
            }
            throw new IllegalArgumentException("Func0 expecting 0 arguments.");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class g<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f62227a;

        g(p pVar) {
            this.f62227a = pVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 1) {
                return (R) this.f62227a.call(objArr[0]);
            }
            throw new IllegalArgumentException("Func1 expecting 1 argument.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class h<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f62228a;

        h(q qVar) {
            this.f62228a = qVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 2) {
                return (R) this.f62228a.call(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Func2 expecting 2 arguments.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class i<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f62229a;

        i(r rVar) {
            this.f62229a = rVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 3) {
                return (R) this.f62229a.call(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Func3 expecting 3 arguments.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class j<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f62230a;

        j(s sVar) {
            this.f62230a = sVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 4) {
                return (R) this.f62230a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Func4 expecting 4 arguments.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class k<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f62231a;

        k(t tVar) {
            this.f62231a = tVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 5) {
                return (R) this.f62231a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Func5 expecting 5 arguments.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class l<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f62232a;

        l(u uVar) {
            this.f62232a = uVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 6) {
                return (R) this.f62232a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Func6 expecting 6 arguments.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class m<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f62233a;

        m(v vVar) {
            this.f62233a = vVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 7) {
                return (R) this.f62233a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Func7 expecting 7 arguments.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class n<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f62234a;

        n(w wVar) {
            this.f62234a = wVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 8) {
                return (R) this.f62234a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Func8 expecting 8 arguments.");
        }
    }

    private a0() {
        throw new IllegalStateException("No instances!");
    }

    public static y<Void> a(rx.functions.a aVar) {
        return new b(aVar);
    }

    public static <T0> y<Void> b(rx.functions.b<? super T0> bVar) {
        return new c(bVar);
    }

    public static <T0, T1> y<Void> c(rx.functions.c<? super T0, ? super T1> cVar) {
        return new d(cVar);
    }

    public static <T0, T1, T2> y<Void> d(rx.functions.d<? super T0, ? super T1, ? super T2> dVar) {
        return new e(dVar);
    }

    public static <R> y<R> e(o<? extends R> oVar) {
        return new f(oVar);
    }

    public static <T0, R> y<R> f(p<? super T0, ? extends R> pVar) {
        return new g(pVar);
    }

    public static <T0, T1, R> y<R> g(q<? super T0, ? super T1, ? extends R> qVar) {
        return new h(qVar);
    }

    public static <T0, T1, T2, R> y<R> h(r<? super T0, ? super T1, ? super T2, ? extends R> rVar) {
        return new i(rVar);
    }

    public static <T0, T1, T2, T3, R> y<R> i(s<? super T0, ? super T1, ? super T2, ? super T3, ? extends R> sVar) {
        return new j(sVar);
    }

    public static <T0, T1, T2, T3, T4, R> y<R> j(t<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> tVar) {
        return new k(tVar);
    }

    public static <T0, T1, T2, T3, T4, T5, R> y<R> k(u<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> uVar) {
        return new l(uVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, R> y<R> l(v<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> vVar) {
        return new m(vVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, R> y<R> m(w<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> wVar) {
        return new n(wVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> y<R> n(x<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> xVar) {
        return new a(xVar);
    }
}
