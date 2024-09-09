package rx.plugins;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.e;
import rx.i;
import rx.internal.operators.c5;
import rx.internal.operators.p4;
import rx.internal.operators.s0;
import rx.internal.operators.t0;
import rx.internal.operators.u0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: RxJavaHooks.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile boolean f64205a;

    /* renamed from: b  reason: collision with root package name */
    static volatile rx.functions.b<Throwable> f64206b;

    /* renamed from: c  reason: collision with root package name */
    static volatile rx.functions.p<e.a, e.a> f64207c;

    /* renamed from: d  reason: collision with root package name */
    static volatile rx.functions.p<i.t, i.t> f64208d;

    /* renamed from: e  reason: collision with root package name */
    static volatile rx.functions.p<b.j0, b.j0> f64209e;

    /* renamed from: f  reason: collision with root package name */
    static volatile rx.functions.q<rx.e, e.a, e.a> f64210f;

    /* renamed from: g  reason: collision with root package name */
    static volatile rx.functions.q<rx.i, i.t, i.t> f64211g;

    /* renamed from: h  reason: collision with root package name */
    static volatile rx.functions.q<rx.b, b.j0, b.j0> f64212h;

    /* renamed from: i  reason: collision with root package name */
    static volatile rx.functions.p<rx.h, rx.h> f64213i;

    /* renamed from: j  reason: collision with root package name */
    static volatile rx.functions.p<rx.h, rx.h> f64214j;

    /* renamed from: k  reason: collision with root package name */
    static volatile rx.functions.p<rx.h, rx.h> f64215k;

    /* renamed from: l  reason: collision with root package name */
    static volatile rx.functions.p<rx.functions.a, rx.functions.a> f64216l;

    /* renamed from: m  reason: collision with root package name */
    static volatile rx.functions.p<rx.m, rx.m> f64217m;

    /* renamed from: n  reason: collision with root package name */
    static volatile rx.functions.p<rx.m, rx.m> f64218n;

    /* renamed from: o  reason: collision with root package name */
    static volatile rx.functions.o<? extends ScheduledExecutorService> f64219o;

    /* renamed from: p  reason: collision with root package name */
    static volatile rx.functions.p<Throwable, Throwable> f64220p;

    /* renamed from: q  reason: collision with root package name */
    static volatile rx.functions.p<Throwable, Throwable> f64221q;

    /* renamed from: r  reason: collision with root package name */
    static volatile rx.functions.p<Throwable, Throwable> f64222r;

    /* renamed from: s  reason: collision with root package name */
    static volatile rx.functions.p<e.b, e.b> f64223s;

    /* renamed from: t  reason: collision with root package name */
    static volatile rx.functions.p<e.b, e.b> f64224t;

    /* renamed from: u  reason: collision with root package name */
    static volatile rx.functions.p<b.k0, b.k0> f64225u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class a implements rx.functions.p<Throwable, Throwable> {
        a() {
        }

        @Override // rx.functions.p
        public Throwable call(Throwable th) {
            return rx.plugins.f.c().g().c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class b implements rx.functions.p<e.b, e.b> {
        b() {
        }

        @Override // rx.functions.p
        public e.b call(e.b bVar) {
            return rx.plugins.f.c().g().b(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class C1323c implements rx.functions.p<Throwable, Throwable> {
        C1323c() {
        }

        @Override // rx.functions.p
        public Throwable call(Throwable th) {
            return rx.plugins.f.c().a().c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class d implements rx.functions.p<b.k0, b.k0> {
        d() {
        }

        @Override // rx.functions.p
        public b.k0 call(b.k0 k0Var) {
            return rx.plugins.f.c().a().b(k0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class e implements rx.functions.p<e.a, e.a> {
        e() {
        }

        @Override // rx.functions.p
        public e.a call(e.a aVar) {
            return rx.plugins.f.c().d().a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class f implements rx.functions.p<i.t, i.t> {
        f() {
        }

        @Override // rx.functions.p
        public i.t call(i.t tVar) {
            return rx.plugins.f.c().g().a(tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class g implements rx.functions.p<b.j0, b.j0> {
        g() {
        }

        @Override // rx.functions.p
        public b.j0 call(b.j0 j0Var) {
            return rx.plugins.f.c().a().a(j0Var);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class h implements rx.functions.p<e.a, e.a> {
        h() {
        }

        @Override // rx.functions.p
        public e.a call(e.a aVar) {
            return new s0(aVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class i implements rx.functions.p<i.t, i.t> {
        i() {
        }

        @Override // rx.functions.p
        public i.t call(i.t tVar) {
            return new u0(tVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class j implements rx.functions.p<b.j0, b.j0> {
        j() {
        }

        @Override // rx.functions.p
        public b.j0 call(b.j0 j0Var) {
            return new t0(j0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class k implements rx.functions.b<Throwable> {
        k() {
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            rx.plugins.f.c().b().a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class l implements rx.functions.q<rx.e, e.a, e.a> {
        l() {
        }

        @Override // rx.functions.q
        public e.a call(rx.e eVar, e.a aVar) {
            return rx.plugins.f.c().d().e(eVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class m implements rx.functions.p<rx.m, rx.m> {
        m() {
        }

        @Override // rx.functions.p
        public rx.m call(rx.m mVar) {
            return rx.plugins.f.c().d().d(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class n implements rx.functions.q<rx.i, i.t, i.t> {
        n() {
        }

        @Override // rx.functions.q
        public i.t call(rx.i iVar, i.t tVar) {
            rx.plugins.h g4 = rx.plugins.f.c().g();
            return g4 == rx.plugins.i.f() ? tVar : new p4(g4.e(iVar, new c5(tVar)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class o implements rx.functions.p<rx.m, rx.m> {
        o() {
        }

        @Override // rx.functions.p
        public rx.m call(rx.m mVar) {
            return rx.plugins.f.c().g().d(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class p implements rx.functions.q<rx.b, b.j0, b.j0> {
        p() {
        }

        @Override // rx.functions.q
        public b.j0 call(rx.b bVar, b.j0 j0Var) {
            return rx.plugins.f.c().a().d(bVar, j0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class q implements rx.functions.p<rx.functions.a, rx.functions.a> {
        q() {
        }

        @Override // rx.functions.p
        public rx.functions.a call(rx.functions.a aVar) {
            return rx.plugins.f.c().f().k(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class r implements rx.functions.p<Throwable, Throwable> {
        r() {
        }

        @Override // rx.functions.p
        public Throwable call(Throwable th) {
            return rx.plugins.f.c().d().c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: RxJavaHooks.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class s implements rx.functions.p<e.b, e.b> {
        s() {
        }

        @Override // rx.functions.p
        public e.b call(e.b bVar) {
            return rx.plugins.f.c().d().b(bVar);
        }
    }

    static {
        x();
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }

    public static void A() {
        f64205a = true;
    }

    public static Throwable B(Throwable th) {
        rx.functions.p<Throwable, Throwable> pVar = f64222r;
        return pVar != null ? pVar.call(th) : th;
    }

    public static <T, R> b.k0 C(b.k0 k0Var) {
        rx.functions.p<b.k0, b.k0> pVar = f64225u;
        return pVar != null ? pVar.call(k0Var) : k0Var;
    }

    public static <T> b.j0 D(rx.b bVar, b.j0 j0Var) {
        rx.functions.q<rx.b, b.j0, b.j0> qVar = f64212h;
        return qVar != null ? qVar.call(bVar, j0Var) : j0Var;
    }

    public static rx.h E(rx.h hVar) {
        rx.functions.p<rx.h, rx.h> pVar = f64213i;
        return pVar != null ? pVar.call(hVar) : hVar;
    }

    public static b.j0 F(b.j0 j0Var) {
        rx.functions.p<b.j0, b.j0> pVar = f64209e;
        return pVar != null ? pVar.call(j0Var) : j0Var;
    }

    public static <T> e.a<T> G(e.a<T> aVar) {
        rx.functions.p<e.a, e.a> pVar = f64207c;
        return pVar != null ? pVar.call(aVar) : aVar;
    }

    public static <T> i.t<T> H(i.t<T> tVar) {
        rx.functions.p<i.t, i.t> pVar = f64208d;
        return pVar != null ? pVar.call(tVar) : tVar;
    }

    public static void I(Throwable th) {
        rx.functions.b<Throwable> bVar = f64206b;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                q0(th2);
            }
        }
        q0(th);
    }

    public static rx.h J(rx.h hVar) {
        rx.functions.p<rx.h, rx.h> pVar = f64214j;
        return pVar != null ? pVar.call(hVar) : hVar;
    }

    public static rx.h K(rx.h hVar) {
        rx.functions.p<rx.h, rx.h> pVar = f64215k;
        return pVar != null ? pVar.call(hVar) : hVar;
    }

    public static Throwable L(Throwable th) {
        rx.functions.p<Throwable, Throwable> pVar = f64220p;
        return pVar != null ? pVar.call(th) : th;
    }

    public static <T, R> e.b<R, T> M(e.b<R, T> bVar) {
        rx.functions.p<e.b, e.b> pVar = f64223s;
        return pVar != null ? pVar.call(bVar) : bVar;
    }

    public static rx.m N(rx.m mVar) {
        rx.functions.p<rx.m, rx.m> pVar = f64217m;
        return pVar != null ? pVar.call(mVar) : mVar;
    }

    public static <T> e.a<T> O(rx.e<T> eVar, e.a<T> aVar) {
        rx.functions.q<rx.e, e.a, e.a> qVar = f64210f;
        return qVar != null ? qVar.call(eVar, aVar) : aVar;
    }

    public static rx.functions.a P(rx.functions.a aVar) {
        rx.functions.p<rx.functions.a, rx.functions.a> pVar = f64216l;
        return pVar != null ? pVar.call(aVar) : aVar;
    }

    public static Throwable Q(Throwable th) {
        rx.functions.p<Throwable, Throwable> pVar = f64221q;
        return pVar != null ? pVar.call(th) : th;
    }

    public static <T, R> e.b<R, T> R(e.b<R, T> bVar) {
        rx.functions.p<e.b, e.b> pVar = f64224t;
        return pVar != null ? pVar.call(bVar) : bVar;
    }

    public static rx.m S(rx.m mVar) {
        rx.functions.p<rx.m, rx.m> pVar = f64218n;
        return pVar != null ? pVar.call(mVar) : mVar;
    }

    public static <T> i.t<T> T(rx.i<T> iVar, i.t<T> tVar) {
        rx.functions.q<rx.i, i.t, i.t> qVar = f64211g;
        return qVar != null ? qVar.call(iVar, tVar) : tVar;
    }

    public static void U() {
        if (f64205a) {
            return;
        }
        x();
        f64213i = null;
        f64214j = null;
        f64215k = null;
        f64219o = null;
    }

    public static void V() {
        if (f64205a) {
            return;
        }
        y();
    }

    public static void W(rx.functions.p<b.j0, b.j0> pVar) {
        if (f64205a) {
            return;
        }
        f64209e = pVar;
    }

    public static void X(rx.functions.p<b.k0, b.k0> pVar) {
        if (f64205a) {
            return;
        }
        f64225u = pVar;
    }

    public static void Y(rx.functions.q<rx.b, b.j0, b.j0> qVar) {
        if (f64205a) {
            return;
        }
        f64212h = qVar;
    }

    public static void Z(rx.functions.p<Throwable, Throwable> pVar) {
        if (f64205a) {
            return;
        }
        f64222r = pVar;
    }

    public static void a() {
        if (f64205a) {
            return;
        }
        f64206b = null;
        f64207c = null;
        f64210f = null;
        f64217m = null;
        f64220p = null;
        f64223s = null;
        f64208d = null;
        f64211g = null;
        f64218n = null;
        f64221q = null;
        f64224t = null;
        f64209e = null;
        f64212h = null;
        f64222r = null;
        f64225u = null;
        f64213i = null;
        f64214j = null;
        f64215k = null;
        f64216l = null;
        f64219o = null;
    }

    public static void a0(rx.functions.p<rx.h, rx.h> pVar) {
        if (f64205a) {
            return;
        }
        f64213i = pVar;
    }

    public static void b() {
        if (f64205a) {
            return;
        }
        f64207c = null;
        f64208d = null;
        f64209e = null;
    }

    public static void b0(rx.functions.b<Throwable> bVar) {
        if (f64205a) {
            return;
        }
        f64206b = bVar;
    }

    public static void c() {
        if (f64205a) {
            return;
        }
        f64207c = new h();
        f64208d = new i();
        f64209e = new j();
    }

    public static void c0(rx.functions.o<? extends ScheduledExecutorService> oVar) {
        if (f64205a) {
            return;
        }
        f64219o = oVar;
    }

    public static rx.functions.p<b.j0, b.j0> d() {
        return f64209e;
    }

    public static void d0(rx.functions.p<rx.h, rx.h> pVar) {
        if (f64205a) {
            return;
        }
        f64214j = pVar;
    }

    public static rx.functions.p<b.k0, b.k0> e() {
        return f64225u;
    }

    public static void e0(rx.functions.p<rx.h, rx.h> pVar) {
        if (f64205a) {
            return;
        }
        f64215k = pVar;
    }

    public static rx.functions.q<rx.b, b.j0, b.j0> f() {
        return f64212h;
    }

    public static void f0(rx.functions.p<e.a, e.a> pVar) {
        if (f64205a) {
            return;
        }
        f64207c = pVar;
    }

    public static rx.functions.p<Throwable, Throwable> g() {
        return f64222r;
    }

    public static void g0(rx.functions.p<e.b, e.b> pVar) {
        if (f64205a) {
            return;
        }
        f64223s = pVar;
    }

    public static rx.functions.p<rx.h, rx.h> h() {
        return f64213i;
    }

    public static void h0(rx.functions.p<rx.m, rx.m> pVar) {
        if (f64205a) {
            return;
        }
        f64217m = pVar;
    }

    public static rx.functions.b<Throwable> i() {
        return f64206b;
    }

    public static void i0(rx.functions.q<rx.e, e.a, e.a> qVar) {
        if (f64205a) {
            return;
        }
        f64210f = qVar;
    }

    public static rx.functions.o<? extends ScheduledExecutorService> j() {
        return f64219o;
    }

    public static void j0(rx.functions.p<Throwable, Throwable> pVar) {
        if (f64205a) {
            return;
        }
        f64220p = pVar;
    }

    public static rx.functions.p<rx.h, rx.h> k() {
        return f64214j;
    }

    public static void k0(rx.functions.p<rx.functions.a, rx.functions.a> pVar) {
        if (f64205a) {
            return;
        }
        f64216l = pVar;
    }

    public static rx.functions.p<rx.h, rx.h> l() {
        return f64215k;
    }

    public static void l0(rx.functions.p<i.t, i.t> pVar) {
        if (f64205a) {
            return;
        }
        f64208d = pVar;
    }

    public static rx.functions.p<e.a, e.a> m() {
        return f64207c;
    }

    public static void m0(rx.functions.p<e.b, e.b> pVar) {
        if (f64205a) {
            return;
        }
        f64224t = pVar;
    }

    public static rx.functions.p<e.b, e.b> n() {
        return f64223s;
    }

    public static void n0(rx.functions.p<rx.m, rx.m> pVar) {
        if (f64205a) {
            return;
        }
        f64218n = pVar;
    }

    public static rx.functions.p<rx.m, rx.m> o() {
        return f64217m;
    }

    public static void o0(rx.functions.q<rx.i, i.t, i.t> qVar) {
        if (f64205a) {
            return;
        }
        f64211g = qVar;
    }

    public static rx.functions.q<rx.e, e.a, e.a> p() {
        return f64210f;
    }

    public static void p0(rx.functions.p<Throwable, Throwable> pVar) {
        if (f64205a) {
            return;
        }
        f64221q = pVar;
    }

    public static rx.functions.p<Throwable, Throwable> q() {
        return f64220p;
    }

    static void q0(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static rx.functions.p<rx.functions.a, rx.functions.a> r() {
        return f64216l;
    }

    public static rx.functions.p<i.t, i.t> s() {
        return f64208d;
    }

    public static rx.functions.p<e.b, e.b> t() {
        return f64224t;
    }

    public static rx.functions.p<rx.m, rx.m> u() {
        return f64218n;
    }

    public static rx.functions.q<rx.i, i.t, i.t> v() {
        return f64211g;
    }

    public static rx.functions.p<Throwable, Throwable> w() {
        return f64221q;
    }

    static void x() {
        f64206b = new k();
        f64210f = new l();
        f64217m = new m();
        f64211g = new n();
        f64218n = new o();
        f64212h = new p();
        f64216l = new q();
        f64220p = new r();
        f64223s = new s();
        f64221q = new a();
        f64224t = new b();
        f64222r = new C1323c();
        f64225u = new d();
        y();
    }

    static void y() {
        f64207c = new e();
        f64208d = new f();
        f64209e = new g();
    }

    public static boolean z() {
        return f64205a;
    }
}
