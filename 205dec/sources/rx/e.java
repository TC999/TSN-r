package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Emitter;
import rx.a;
import rx.annotations.Beta;
import rx.exceptions.OnErrorFailedException;
import rx.functions.a0;
import rx.functions.o;
import rx.functions.p;
import rx.functions.q;
import rx.functions.r;
import rx.functions.s;
import rx.functions.t;
import rx.functions.u;
import rx.functions.v;
import rx.functions.x;
import rx.functions.y;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.a1;
import rx.internal.operators.a2;
import rx.internal.operators.a3;
import rx.internal.operators.a4;
import rx.internal.operators.b0;
import rx.internal.operators.b1;
import rx.internal.operators.b2;
import rx.internal.operators.b3;
import rx.internal.operators.b4;
import rx.internal.operators.c0;
import rx.internal.operators.c1;
import rx.internal.operators.c2;
import rx.internal.operators.c3;
import rx.internal.operators.c4;
import rx.internal.operators.d0;
import rx.internal.operators.d1;
import rx.internal.operators.d2;
import rx.internal.operators.d3;
import rx.internal.operators.d4;
import rx.internal.operators.e0;
import rx.internal.operators.e1;
import rx.internal.operators.e2;
import rx.internal.operators.e3;
import rx.internal.operators.e4;
import rx.internal.operators.f0;
import rx.internal.operators.f1;
import rx.internal.operators.f2;
import rx.internal.operators.f3;
import rx.internal.operators.f4;
import rx.internal.operators.g0;
import rx.internal.operators.g1;
import rx.internal.operators.g2;
import rx.internal.operators.g3;
import rx.internal.operators.g4;
import rx.internal.operators.h0;
import rx.internal.operators.h1;
import rx.internal.operators.h2;
import rx.internal.operators.h3;
import rx.internal.operators.i0;
import rx.internal.operators.i1;
import rx.internal.operators.i2;
import rx.internal.operators.i3;
import rx.internal.operators.j0;
import rx.internal.operators.j1;
import rx.internal.operators.j2;
import rx.internal.operators.j3;
import rx.internal.operators.k0;
import rx.internal.operators.k1;
import rx.internal.operators.k2;
import rx.internal.operators.k3;
import rx.internal.operators.l0;
import rx.internal.operators.l1;
import rx.internal.operators.l2;
import rx.internal.operators.l3;
import rx.internal.operators.m0;
import rx.internal.operators.m1;
import rx.internal.operators.m3;
import rx.internal.operators.n0;
import rx.internal.operators.n1;
import rx.internal.operators.n2;
import rx.internal.operators.n3;
import rx.internal.operators.o0;
import rx.internal.operators.o1;
import rx.internal.operators.o2;
import rx.internal.operators.o3;
import rx.internal.operators.p0;
import rx.internal.operators.p1;
import rx.internal.operators.p2;
import rx.internal.operators.p3;
import rx.internal.operators.q0;
import rx.internal.operators.q1;
import rx.internal.operators.q2;
import rx.internal.operators.q3;
import rx.internal.operators.r0;
import rx.internal.operators.r1;
import rx.internal.operators.r2;
import rx.internal.operators.r3;
import rx.internal.operators.s1;
import rx.internal.operators.s2;
import rx.internal.operators.t1;
import rx.internal.operators.t2;
import rx.internal.operators.t3;
import rx.internal.operators.u1;
import rx.internal.operators.u2;
import rx.internal.operators.u3;
import rx.internal.operators.v0;
import rx.internal.operators.v1;
import rx.internal.operators.v2;
import rx.internal.operators.v3;
import rx.internal.operators.w;
import rx.internal.operators.w0;
import rx.internal.operators.w1;
import rx.internal.operators.w2;
import rx.internal.operators.w3;
import rx.internal.operators.x0;
import rx.internal.operators.x1;
import rx.internal.operators.x2;
import rx.internal.operators.x3;
import rx.internal.operators.y0;
import rx.internal.operators.y1;
import rx.internal.operators.y2;
import rx.internal.operators.y3;
import rx.internal.operators.z;
import rx.internal.operators.z1;
import rx.internal.operators.z2;
import rx.internal.operators.z3;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Observable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e<T> {

    /* renamed from: a  reason: collision with root package name */
    final a<T> f62215a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Observable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a<T> extends rx.functions.b<l<? super T>> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Observable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface b<R, T> extends p<l<? super R>, l<? super T>> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Observable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface c<T, R> extends p<e<T>, e<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(a<T> aVar) {
        this.f62215a = aVar;
    }

    public static <T> e<T> A0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return u0(R2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> A3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return u3(Q2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> A5(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.Z2(h3.a(false));
    }

    public static <T> e<T> B0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return u0(S2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> B3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return u3(R2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> B5(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.Z2(h3.a(true));
    }

    public static <T> e<T> C0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return u0(T2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> C3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return u3(S2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> D0(Iterable<? extends e<? extends T>> iterable) {
        return E0(u2(iterable));
    }

    public static <T> e<T> D3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return u3(T2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> E0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.a1(n.c());
    }

    public static <T> e<T> F0(e<? extends T> eVar, e<? extends T> eVar2) {
        return E0(M2(eVar, eVar2));
    }

    public static e<Long> F2(long j4, long j5, TimeUnit timeUnit) {
        return G2(j4, j5, timeUnit, rx.schedulers.c.a());
    }

    public static <T> e<T> G0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return E0(N2(eVar, eVar2, eVar3));
    }

    public static e<Long> G2(long j4, long j5, TimeUnit timeUnit, h hVar) {
        return H6(new g1(j4, j5, timeUnit, hVar));
    }

    public static <T> e<T> G3() {
        return NeverObservableHolder.instance();
    }

    public static <T> e<T> H0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return E0(O2(eVar, eVar2, eVar3, eVar4));
    }

    public static e<Long> H2(long j4, TimeUnit timeUnit) {
        return G2(j4, j4, timeUnit, rx.schedulers.c.a());
    }

    public static <T> e<T> H6(a<T> aVar) {
        return new e<>(rx.plugins.c.G(aVar));
    }

    public static <T> e<T> I(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return H6(w.e(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> I0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return E0(P2(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static e<Long> I2(long j4, TimeUnit timeUnit, h hVar) {
        return G2(j4, j4, timeUnit, hVar);
    }

    public static <T> e<T> J(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return H6(w.f(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> J0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return E0(Q2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> K0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return E0(R2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T, Resource> e<T> K6(o<Resource> oVar, p<? super Resource, ? extends e<? extends T>> pVar, rx.functions.b<? super Resource> bVar) {
        return L6(oVar, pVar, bVar, false);
    }

    public static <T> e<T> L(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return H6(w.g(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> L0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return E0(S2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> L2(T t3) {
        return rx.internal.util.k.v7(t3);
    }

    public static <T> e<Boolean> L4(e<? extends T> eVar, e<? extends T> eVar2) {
        return M4(eVar, eVar2, InternalObservableUtils.OBJECT_EQUALS);
    }

    public static <T, Resource> e<T> L6(o<Resource> oVar, p<? super Resource, ? extends e<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z3) {
        return H6(new k1(oVar, pVar, bVar, z3));
    }

    public static <T> e<T> M(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return H6(w.h(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> M0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return E0(T2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> M2(T t3, T t4) {
        return y2(new Object[]{t3, t4});
    }

    public static <T> e<Boolean> M4(e<? extends T> eVar, e<? extends T> eVar2, q<? super T, ? super T, Boolean> qVar) {
        return y2.b(eVar, eVar2, qVar);
    }

    public static <T> e<T> N(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return H6(w.i(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> N0(Iterable<? extends e<? extends T>> iterable) {
        return u2(iterable).b1(n.c());
    }

    public static <T> e<T> N2(T t3, T t4, T t5) {
        return y2(new Object[]{t3, t4, t5});
    }

    public static <T> e<T> O0(Iterable<? extends e<? extends T>> iterable, int i4) {
        return u2(iterable).c1(n.c(), i4);
    }

    public static <T> e<T> O2(T t3, T t4, T t5, T t6) {
        return y2(new Object[]{t3, t4, t5, t6});
    }

    public static <T> e<T> P0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.b1(n.c());
    }

    public static <T> e<T> P2(T t3, T t4, T t5, T t6, T t7) {
        return y2(new Object[]{t3, t4, t5, t6, t7});
    }

    public static <T> e<T> Q0(e<? extends e<? extends T>> eVar, int i4) {
        return (e<T>) eVar.c1(n.c(), i4);
    }

    public static <T> e<T> Q2(T t3, T t4, T t5, T t6, T t7, T t8) {
        return y2(new Object[]{t3, t4, t5, t6, t7, t8});
    }

    public static <T> e<T> R0(e<? extends T> eVar, e<? extends T> eVar2) {
        return N0(Arrays.asList(eVar, eVar2));
    }

    public static <T> e<T> R2(T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return y2(new Object[]{t3, t4, t5, t6, t7, t8, t9});
    }

    public static <T> e<T> S0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return N0(Arrays.asList(eVar, eVar2, eVar3));
    }

    public static <T> e<T> S1() {
        return EmptyObservableHolder.instance();
    }

    public static <T> e<T> S2(T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return y2(new Object[]{t3, t4, t5, t6, t7, t8, t9, t10});
    }

    public static <T> e<T> T0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> T1(Throwable th) {
        return H6(new e1(th));
    }

    public static <T> e<T> T2(T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10, T t11) {
        return y2(new Object[]{t3, t4, t5, t6, t7, t8, t9, t10, t11});
    }

    public static <T> e<T> U0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> U2(T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12) {
        return y2(new Object[]{t3, t4, t5, t6, t7, t8, t9, t10, t11, t12});
    }

    public static <T> e<T> V0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> W0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> X0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> Y0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static e<Integer> a4(int i4, int i5) {
        if (i5 >= 0) {
            if (i5 == 0) {
                return S1();
            }
            if (i4 <= (Integer.MAX_VALUE - i5) + 1) {
                if (i5 == 1) {
                    return L2(Integer.valueOf(i4));
                }
                return H6(new v0(i4, (i5 - 1) + i4));
            }
            throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
        }
        throw new IllegalArgumentException("Count can not be negative");
    }

    public static e<Integer> b4(int i4, int i5, h hVar) {
        return a4(i4, i5).v5(hVar);
    }

    private <R> e<R> c3(p<? super T, ? extends R> pVar, p<? super Throwable, ? extends R> pVar2, o<? extends R> oVar) {
        return Z2(new i2(pVar, pVar2, oVar));
    }

    public static <T> e<T> e(Iterable<? extends e<? extends T>> iterable) {
        return H6(w.a(iterable));
    }

    public static <T> e<T> e3(Iterable<? extends e<? extends T>> iterable) {
        return g3(u2(iterable));
    }

    public static <T> e<T> f3(Iterable<? extends e<? extends T>> iterable, int i4) {
        return h3(u2(iterable), i4);
    }

    public static <T> e<T> g(e<? extends T> eVar, e<? extends T> eVar2) {
        return H6(w.b(eVar, eVar2));
    }

    public static <T> e<T> g3(e<? extends e<? extends T>> eVar) {
        if (eVar.getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) eVar).y7(n.c());
        }
        return (e<T>) eVar.Z2(l2.a(false));
    }

    public static <T, R> e<R> h0(Iterable<? extends e<? extends T>> iterable, y<? extends R> yVar) {
        return H6(new rx.internal.operators.y(iterable, yVar));
    }

    public static <T> e<T> h3(e<? extends e<? extends T>> eVar, int i4) {
        if (eVar.getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) eVar).y7(n.c());
        }
        return (e<T>) eVar.Z2(l2.b(false, i4));
    }

    public static <T, R> e<R> i0(List<? extends e<? extends T>> list, y<? extends R> yVar) {
        return H6(new rx.internal.operators.y(list, yVar));
    }

    public static <T> e<T> i3(e<? extends T> eVar, e<? extends T> eVar2) {
        return q3(new e[]{eVar, eVar2});
    }

    public static <R> e<R> i7(Iterable<? extends e<?>> iterable, y<? extends R> yVar) {
        ArrayList arrayList = new ArrayList();
        for (e<?> eVar : iterable) {
            arrayList.add(eVar);
        }
        return L2(arrayList.toArray(new e[arrayList.size()])).Z2(new f4(yVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> j0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, e<? extends T9> eVar9, x<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> xVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9), a0.n(xVar));
    }

    @Deprecated
    public static <T> e<T> j1(a<T> aVar) {
        return new e<>(rx.plugins.c.G(aVar));
    }

    public static <T> e<T> j3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return q3(new e[]{eVar, eVar2, eVar3});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> j7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, e<? extends T9> eVar9, x<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> xVar) {
        return L2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9}).Z2(new f4(xVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> k0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, rx.functions.w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8), a0.m(wVar));
    }

    public static <T> e<T> k1(rx.functions.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        return H6(new rx.internal.operators.a0(bVar, backpressureMode));
    }

    public static <T> e<T> k3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return q3(new e[]{eVar, eVar2, eVar3, eVar4});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> k7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, rx.functions.w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return L2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8}).Z2(new f4(wVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> e<R> l0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7), a0.l(vVar));
    }

    @Beta
    public static <S, T> e<T> l1(rx.observables.a<S, T> aVar) {
        return H6(aVar);
    }

    public static <T> e<T> l3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return q3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5});
    }

    @Deprecated
    public static e<Long> l6(long j4, long j5, TimeUnit timeUnit) {
        return G2(j4, j5, timeUnit, rx.schedulers.c.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> e<R> l7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return L2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7}).Z2(new f4(vVar));
    }

    public static <T1, T2, T3, T4, T5, T6, R> e<R> m0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6), a0.k(uVar));
    }

    public static <S, T> e<T> m1(rx.observables.e<S, T> eVar) {
        return H6(eVar);
    }

    public static <T> e<T> m3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return q3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6});
    }

    @Deprecated
    public static e<Long> m6(long j4, long j5, TimeUnit timeUnit, h hVar) {
        return G2(j4, j5, timeUnit, hVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> e<R> m7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return L2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6}).Z2(new f4(uVar));
    }

    public static <T1, T2, T3, T4, T5, R> e<R> n0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5), a0.j(tVar));
    }

    public static <T> e<T> n3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return q3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7});
    }

    public static e<Long> n6(long j4, TimeUnit timeUnit) {
        return o6(j4, timeUnit, rx.schedulers.c.a());
    }

    public static <T1, T2, T3, T4, T5, R> e<R> n7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return L2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5}).Z2(new f4(tVar));
    }

    public static <T1, T2, T3, T4, R> e<R> o0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, s<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4), a0.i(sVar));
    }

    public static <T> e<T> o3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return q3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8});
    }

    public static e<Long> o6(long j4, TimeUnit timeUnit, h hVar) {
        return H6(new f1(j4, timeUnit, hVar));
    }

    public static <T1, T2, T3, T4, R> e<R> o7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, s<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return L2(new e[]{eVar, eVar2, eVar3, eVar4}).Z2(new f4(sVar));
    }

    public static <T1, T2, T3, R> e<R> p0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, r<? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3), a0.h(rVar));
    }

    public static <T> e<T> p3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return q3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9});
    }

    public static <T1, T2, T3, R> e<R> p7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, r<? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return L2(new e[]{eVar, eVar2, eVar3}).Z2(new f4(rVar));
    }

    public static <T1, T2, R> e<R> q0(e<? extends T1> eVar, e<? extends T2> eVar2, q<? super T1, ? super T2, ? extends R> qVar) {
        return i0(Arrays.asList(eVar, eVar2), a0.g(qVar));
    }

    public static <T> e<T> q3(e<? extends T>[] eVarArr) {
        return g3(y2(eVarArr));
    }

    public static <T1, T2, R> e<R> q7(e<? extends T1> eVar, e<? extends T2> eVar2, q<? super T1, ? super T2, ? extends R> qVar) {
        return L2(new e[]{eVar, eVar2}).Z2(new f4(qVar));
    }

    public static <T, R> e<R> r0(Iterable<? extends e<? extends T>> iterable, y<? extends R> yVar) {
        return H6(new rx.internal.operators.y(null, iterable, yVar, rx.internal.util.j.f63940d, true));
    }

    public static <T> e<T> r1(o<e<T>> oVar) {
        return H6(new b0(oVar));
    }

    public static <T> e<T> r3(e<? extends T>[] eVarArr, int i4) {
        return h3(y2(eVarArr), i4);
    }

    static <T> m r5(l<? super T> lVar, e<T> eVar) {
        if (lVar != null) {
            if (eVar.f62215a != null) {
                lVar.onStart();
                if (!(lVar instanceof rx.observers.e)) {
                    lVar = new rx.observers.e(lVar);
                }
                try {
                    rx.plugins.c.O(eVar, eVar.f62215a).call(lVar);
                    return rx.plugins.c.N(lVar);
                } catch (Throwable th) {
                    rx.exceptions.a.e(th);
                    if (lVar.isUnsubscribed()) {
                        rx.plugins.c.I(rx.plugins.c.L(th));
                    } else {
                        try {
                            lVar.onError(rx.plugins.c.L(th));
                        } catch (Throwable th2) {
                            rx.exceptions.a.e(th2);
                            OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                            rx.plugins.c.L(onErrorFailedException);
                            throw onErrorFailedException;
                        }
                    }
                    return rx.subscriptions.f.e();
                }
            }
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        throw new IllegalArgumentException("subscriber can not be null");
    }

    public static <R> e<R> r7(e<? extends e<?>> eVar, y<? extends R> yVar) {
        return eVar.u6().b3(InternalObservableUtils.TO_ARRAY).Z2(new f4(yVar));
    }

    public static <T> e<T> s3(Iterable<? extends e<? extends T>> iterable) {
        return u3(u2(iterable));
    }

    public static <R> e<R> s7(e<?>[] eVarArr, y<? extends R> yVar) {
        return L2(eVarArr).Z2(new f4(yVar));
    }

    public static <T> e<T> t0(Iterable<? extends e<? extends T>> iterable) {
        return u0(u2(iterable));
    }

    public static <T> e<T> t3(Iterable<? extends e<? extends T>> iterable, int i4) {
        return v3(u2(iterable), i4);
    }

    public static <T> e<T> u0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.Z0(n.c());
    }

    public static <T> e<T> u2(Iterable<? extends T> iterable) {
        return H6(new n0(iterable));
    }

    public static <T> e<T> u3(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.Z2(l2.a(true));
    }

    public static <T> e<T> v(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return H6(w.c(eVar, eVar2, eVar3));
    }

    public static <T> e<T> v0(e<? extends T> eVar, e<? extends T> eVar2) {
        return u0(M2(eVar, eVar2));
    }

    public static <T> e<T> v2(Future<? extends T> future) {
        return H6(j1.a(future));
    }

    public static <T> e<T> v3(e<? extends e<? extends T>> eVar, int i4) {
        return (e<T>) eVar.Z2(l2.b(true, i4));
    }

    public static <T> e<T> w0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return u0(N2(eVar, eVar2, eVar3));
    }

    public static <T> e<T> w2(Future<? extends T> future, long j4, TimeUnit timeUnit) {
        return H6(j1.b(future, j4, timeUnit));
    }

    public static <T> e<T> w3(e<? extends T> eVar, e<? extends T> eVar2) {
        return u3(M2(eVar, eVar2));
    }

    public static <T> e<T> x(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return H6(w.d(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> x0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return u0(O2(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> x2(Future<? extends T> future, h hVar) {
        return H6(j1.a(future)).v5(hVar);
    }

    public static <T> e<T> x3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return u3(N2(eVar, eVar2, eVar3));
    }

    public static <T> e<T> y0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return u0(P2(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> y2(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return S1();
        }
        if (length == 1) {
            return L2(tArr[0]);
        }
        return H6(new l0(tArr));
    }

    public static <T> e<T> y3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return u3(O2(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> z0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return u0(Q2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> z2(Callable<? extends T> callable) {
        return H6(new m0(callable));
    }

    public static <T> e<T> z3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return u3(P2(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public final <T2> e<T2> A1() {
        return (e<T2>) Z2(x1.a());
    }

    public final <K> e<rx.observables.d<K, T>> A2(p<? super T, ? extends K> pVar) {
        return (e<rx.observables.d<K, T>>) Z2(new g2(pVar));
    }

    public final rx.observables.c<T> A4(h hVar) {
        return t2.H7(t4(), hVar);
    }

    public final <K, V> e<Map<K, Collection<V>>> A6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2, o<? extends Map<K, Collection<V>>> oVar) {
        return H6(new i1(this, pVar, pVar2, oVar));
    }

    public final e<T> B1() {
        return (e<T>) Z2(y1.a());
    }

    public final <K, R> e<rx.observables.d<K, R>> B2(p<? super T, ? extends K> pVar, p<? super T, ? extends R> pVar2) {
        return (e<R>) Z2(new g2(pVar, pVar2));
    }

    public final e<T> B4() {
        return w0.h(this);
    }

    public final <K, V> e<Map<K, Collection<V>>> B6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2, o<? extends Map<K, Collection<V>>> oVar, p<? super K, ? extends Collection<V>> pVar3) {
        return H6(new i1(this, pVar, pVar2, oVar, pVar3));
    }

    public final <U> e<T> C1(p<? super T, ? extends U> pVar) {
        return (e<T>) Z2(new y1(pVar));
    }

    public final <K, R> e<rx.observables.d<K, R>> C2(p<? super T, ? extends K> pVar, p<? super T, ? extends R> pVar2, p<rx.functions.b<K>, Map<K, Object>> pVar3) {
        if (pVar3 != null) {
            return (e<R>) Z2(new g2(pVar, pVar2, pVar3));
        }
        throw new NullPointerException("evictingMapFactory cannot be null");
    }

    public final e<T> C4(long j4) {
        return w0.i(this, j4);
    }

    public final e<T> C5(int i4) {
        return (e<T>) Z2(new i3(i4));
    }

    public i<T> C6() {
        return new i<>(a1.a(this));
    }

    public final e<T> D1() {
        return (e<T>) Z2(z1.a());
    }

    public final <T2, D1, D2, R> e<R> D2(e<T2> eVar, p<? super T, ? extends e<D1>> pVar, p<? super T2, ? extends e<D2>> pVar2, q<? super T, ? super e<T2>, ? extends R> qVar) {
        return H6(new o0(this, eVar, pVar, pVar2, qVar));
    }

    public final e<T> D4(q<Integer, Throwable, Boolean> qVar) {
        return (e<T>) F3().Z2(new u2(qVar));
    }

    public final e<T> D5(long j4, TimeUnit timeUnit) {
        return E5(j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<List<T>> D6() {
        return (e<List<T>>) Z2(new w3(10));
    }

    public final <U> e<T> E1(p<? super T, ? extends U> pVar) {
        return (e<T>) Z2(new z1(pVar));
    }

    public final e<T> E2() {
        return (e<T>) Z2(h2.a());
    }

    public final e<T> E3(e<? extends T> eVar) {
        return i3(this, eVar);
    }

    public final e<T> E4(p<? super e<? extends Throwable>, ? extends e<?>> pVar) {
        return w0.j(this, InternalObservableUtils.createRetryDematerializer(pVar));
    }

    public final e<T> E5(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new l3(j4, timeUnit, hVar));
    }

    public final e<List<T>> E6(int i4) {
        return (e<List<T>>) Z2(new w3(i4));
    }

    public final e<T> F1(q<? super T, ? super T, Boolean> qVar) {
        return (e<T>) Z2(new z1(qVar));
    }

    public final e<e<T>> F3() {
        return L2(this);
    }

    public final e<T> F4(p<? super e<? extends Throwable>, ? extends e<?>> pVar, h hVar) {
        return w0.k(this, InternalObservableUtils.createRetryDematerializer(pVar), hVar);
    }

    public final e<T> F5(p<? super T, Boolean> pVar) {
        return V1(pVar).C5(1);
    }

    public final e<List<T>> F6(q<? super T, ? super T, Integer> qVar) {
        return (e<List<T>>) Z2(new w3(qVar, 10));
    }

    public final e<T> G1(rx.functions.a aVar) {
        return (e<T>) Z2(new a2(aVar));
    }

    public final e<T> G4(long j4, TimeUnit timeUnit) {
        return H4(j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> G5(int i4) {
        if (i4 == 0) {
            return E2();
        }
        if (i4 == 1) {
            return H6(new d1(this));
        }
        return (e<T>) Z2(new j3(i4));
    }

    public final e<List<T>> G6(q<? super T, ? super T, Integer> qVar, int i4) {
        return (e<List<T>>) Z2(new w3(qVar, i4));
    }

    public final e<T> H1(rx.functions.a aVar) {
        return H6(new g0(this, new rx.internal.util.b(rx.functions.m.a(), rx.functions.m.a(), aVar)));
    }

    public final e<T> H3(h hVar) {
        return I3(hVar, rx.internal.util.j.f63940d);
    }

    public final e<T> H4(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new w2(j4, timeUnit, hVar));
    }

    public final e<T> H5(int i4, long j4, TimeUnit timeUnit) {
        return I5(i4, j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> I1(f<? super T> fVar) {
        return H6(new g0(this, fVar));
    }

    public final e<T> I3(h hVar, int i4) {
        return K3(hVar, false, i4);
    }

    public final <U> e<T> I4(e<U> eVar) {
        return (e<T>) Z2(new v2(eVar));
    }

    public final e<T> I5(int i4, long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new k3(i4, j4, timeUnit, hVar));
    }

    public final m I6(l<? super T> lVar) {
        try {
            lVar.onStart();
            rx.plugins.c.O(this, this.f62215a).call(lVar);
            return rx.plugins.c.N(lVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                lVar.onError(rx.plugins.c.L(th));
                return rx.subscriptions.f.e();
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.plugins.c.L(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final e<T> J1(rx.functions.b<Notification<? super T>> bVar) {
        return H6(new g0(this, new rx.internal.util.a(bVar)));
    }

    public final e<Boolean> J2() {
        return Z2(InternalObservableUtils.IS_EMPTY);
    }

    public final e<T> J3(h hVar, boolean z3) {
        return K3(hVar, z3, rx.internal.util.j.f63940d);
    }

    public final <R> e<R> J4(R r3, q<R, ? super T, R> qVar) {
        return Z2(new x2(r3, qVar));
    }

    public final e<T> J5(long j4, TimeUnit timeUnit) {
        return K5(j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> J6(h hVar) {
        return (e<T>) Z2(new x3(hVar));
    }

    public final e<T> K1(rx.functions.b<? super Throwable> bVar) {
        return H6(new g0(this, new rx.internal.util.b(rx.functions.m.a(), bVar, rx.functions.m.a())));
    }

    public final <TRight, TLeftDuration, TRightDuration, R> e<R> K2(e<TRight> eVar, p<T, e<TLeftDuration>> pVar, p<TRight, e<TRightDuration>> pVar2, q<T, TRight, R> qVar) {
        return H6(new p0(this, eVar, pVar, pVar2, qVar));
    }

    public final e<T> K3(h hVar, boolean z3, int i4) {
        if (this instanceof rx.internal.util.k) {
            return ((rx.internal.util.k) this).z7(hVar);
        }
        return (e<T>) Z2(new n2(hVar, z3, i4));
    }

    public final e<T> K4(q<T, T, T> qVar) {
        return (e<T>) Z2(new x2(qVar));
    }

    public final e<T> K5(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new k3(j4, timeUnit, hVar));
    }

    public final e<T> L1(rx.functions.b<? super T> bVar) {
        return H6(new g0(this, new rx.internal.util.b(bVar, rx.functions.m.a(), rx.functions.m.a())));
    }

    public final <R> e<R> L3(Class<R> cls) {
        return V1(InternalObservableUtils.isInstanceOf(cls)).f0(cls);
    }

    public final e<List<T>> L5(int i4) {
        return G5(i4).u6();
    }

    public final e<T> M1(rx.functions.b<? super Long> bVar) {
        return (e<T>) Z2(new b2(bVar));
    }

    public final e<T> M3() {
        return (e<T>) Z2(o2.a());
    }

    public final e<List<T>> M5(int i4, long j4, TimeUnit timeUnit) {
        return H5(i4, j4, timeUnit).u6();
    }

    public final e<e<T>> M6(int i4) {
        return N6(i4, i4);
    }

    public final e<T> N1(rx.functions.a aVar) {
        return (e<T>) Z2(new c2(aVar));
    }

    public final e<T> N3(long j4) {
        return (e<T>) Z2(new o2(j4));
    }

    public final e<T> N4() {
        return (e<T>) Z2(z2.a());
    }

    public final e<List<T>> N5(int i4, long j4, TimeUnit timeUnit, h hVar) {
        return I5(i4, j4, timeUnit, hVar).u6();
    }

    public final e<e<T>> N6(int i4, int i5) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + i4);
        } else if (i5 > 0) {
            return (e<e<T>>) Z2(new a4(i4, i5));
        } else {
            throw new IllegalArgumentException("skip > 0 required but it was " + i5);
        }
    }

    public final e<T> O(e<? extends T> eVar) {
        return g(this, eVar);
    }

    public final e<T> O1(rx.functions.a aVar) {
        return H6(new g0(this, new rx.internal.util.b(rx.functions.m.a(), rx.functions.m.c(aVar), aVar)));
    }

    public final e<T> O3(long j4, rx.functions.a aVar) {
        return (e<T>) Z2(new o2(j4, aVar));
    }

    public final e<T> O4() {
        return Z3().A7();
    }

    public final e<List<T>> O5(long j4, TimeUnit timeUnit) {
        return J5(j4, timeUnit).u6();
    }

    public final e<e<T>> O6(long j4, long j5, TimeUnit timeUnit) {
        return P6(j4, j5, timeUnit, Integer.MAX_VALUE, rx.schedulers.c.a());
    }

    public final e<T> P() {
        return (e<T>) Z2(n1.a());
    }

    public final e<T> P1(rx.functions.a aVar) {
        return (e<T>) Z2(new d2(aVar));
    }

    public final e<T> P3(long j4, rx.functions.a aVar, a.d dVar) {
        return (e<T>) Z2(new o2(j4, aVar, dVar));
    }

    public final e<T> P4() {
        return (e<T>) Z2(a3.a());
    }

    public final e<List<T>> P5(long j4, TimeUnit timeUnit, h hVar) {
        return K5(j4, timeUnit, hVar).u6();
    }

    public final e<e<T>> P6(long j4, long j5, TimeUnit timeUnit, int i4, h hVar) {
        return (e<e<T>>) Z2(new c4(j4, j5, timeUnit, i4, hVar));
    }

    public final e<List<T>> Q(int i4) {
        return R(i4, i4);
    }

    public final e<T> Q1(int i4) {
        return (e<T>) Z2(new f2(i4));
    }

    public final e<T> Q3() {
        return (e<T>) Z2(p2.a());
    }

    public final e<T> Q4(p<? super T, Boolean> pVar) {
        return V1(pVar).P4();
    }

    public final <E> e<T> Q5(e<? extends E> eVar) {
        return (e<T>) Z2(new m3(eVar));
    }

    public final e<e<T>> Q6(long j4, long j5, TimeUnit timeUnit, h hVar) {
        return P6(j4, j5, timeUnit, Integer.MAX_VALUE, hVar);
    }

    public final e<List<T>> R(int i4, int i5) {
        return (e<List<T>>) Z2(new p1(i4, i5));
    }

    public final e<T> R1(int i4, T t3) {
        return (e<T>) Z2(new f2(i4, t3));
    }

    public final e<T> R3(rx.functions.b<? super T> bVar) {
        return (e<T>) Z2(new p2(bVar));
    }

    public final e<T> R4(T t3) {
        return (e<T>) Z2(new a3(t3));
    }

    public final e<T> R5(p<? super T, Boolean> pVar) {
        return (e<T>) Z2(new n3(pVar));
    }

    public final e<e<T>> R6(long j4, TimeUnit timeUnit) {
        return Q6(j4, j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<List<T>> S(long j4, long j5, TimeUnit timeUnit) {
        return T(j4, j5, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> S3() {
        return (e<T>) Z2(q2.a());
    }

    public final e<T> S4(T t3, p<? super T, Boolean> pVar) {
        return V1(pVar).R4(t3);
    }

    public final e<T> S5(p<? super T, Boolean> pVar) {
        return (e<T>) Z2(new o3(pVar));
    }

    public final e<e<T>> S6(long j4, TimeUnit timeUnit, int i4) {
        return T6(j4, timeUnit, i4, rx.schedulers.c.a());
    }

    public final e<List<T>> T(long j4, long j5, TimeUnit timeUnit, h hVar) {
        return (e<List<T>>) Z2(new r1(j4, j5, timeUnit, Integer.MAX_VALUE, hVar));
    }

    public final e<T> T3(e<? extends T> eVar) {
        return (e<T>) Z2(r2.b(eVar));
    }

    public final e<T> T4(int i4) {
        return (e<T>) Z2(new b3(i4));
    }

    public final rx.observers.a<T> T5() {
        m3.a g4 = m3.a.g(Long.MAX_VALUE);
        p5(g4);
        return g4;
    }

    public final e<e<T>> T6(long j4, TimeUnit timeUnit, int i4, h hVar) {
        return P6(j4, j4, timeUnit, i4, hVar);
    }

    public final e<List<T>> U(long j4, TimeUnit timeUnit) {
        return W(j4, timeUnit, Integer.MAX_VALUE, rx.schedulers.c.a());
    }

    public final e<Boolean> U1(p<? super T, Boolean> pVar) {
        return Z2(new m1(pVar, false));
    }

    public final e<T> U3(p<? super Throwable, ? extends e<? extends T>> pVar) {
        return (e<T>) Z2(new r2(pVar));
    }

    public final e<T> U4(long j4, TimeUnit timeUnit) {
        return V4(j4, timeUnit, rx.schedulers.c.a());
    }

    public final rx.observers.a<T> U5(long j4) {
        m3.a g4 = m3.a.g(j4);
        p5(g4);
        return g4;
    }

    public final e<e<T>> U6(long j4, TimeUnit timeUnit, h hVar) {
        return T6(j4, timeUnit, Integer.MAX_VALUE, hVar);
    }

    public final e<List<T>> V(long j4, TimeUnit timeUnit, int i4) {
        return (e<List<T>>) Z2(new r1(j4, j4, timeUnit, i4, rx.schedulers.c.a()));
    }

    public final e<T> V1(p<? super T, Boolean> pVar) {
        return H6(new h0(this, pVar));
    }

    public final e<T> V2() {
        return G5(1).P4();
    }

    public final e<T> V3(p<? super Throwable, ? extends T> pVar) {
        return (e<T>) Z2(r2.c(pVar));
    }

    public final e<T> V4(long j4, TimeUnit timeUnit, h hVar) {
        return H6(new b1(this, j4, timeUnit, hVar));
    }

    public final e<T> V5(long j4, TimeUnit timeUnit) {
        return W5(j4, timeUnit, rx.schedulers.c.a());
    }

    public final <U> e<e<T>> V6(e<U> eVar) {
        return (e<e<T>>) Z2(new y3(eVar));
    }

    public final e<List<T>> W(long j4, TimeUnit timeUnit, int i4, h hVar) {
        return (e<List<T>>) Z2(new r1(j4, j4, timeUnit, i4, hVar));
    }

    @Deprecated
    public final e<T> W1(rx.functions.a aVar) {
        return (e<T>) Z2(new a2(aVar));
    }

    public final e<T> W2(p<? super T, Boolean> pVar) {
        return V1(pVar).G5(1).P4();
    }

    public final e<T> W3(e<? extends T> eVar) {
        return (e<T>) Z2(r2.a(eVar));
    }

    public final e<T> W4(int i4) {
        return (e<T>) Z2(new c3(i4));
    }

    public final e<T> W5(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new p3(j4, timeUnit, hVar));
    }

    public final <TOpening, TClosing> e<e<T>> W6(e<? extends TOpening> eVar, p<? super TOpening, ? extends e<? extends TClosing>> pVar) {
        return (e<e<T>>) Z2(new b4(eVar, pVar));
    }

    public final e<List<T>> X(long j4, TimeUnit timeUnit, h hVar) {
        return T(j4, j4, timeUnit, hVar);
    }

    public final e<T> X1() {
        return C5(1).P4();
    }

    public final e<T> X2(T t3) {
        return G5(1).R4(t3);
    }

    public final e<T> X3() {
        return H6(new f0(this));
    }

    public final e<T> X4(long j4, TimeUnit timeUnit) {
        return Y4(j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> X5(long j4, TimeUnit timeUnit) {
        return G4(j4, timeUnit);
    }

    public final <TClosing> e<e<T>> X6(o<? extends e<? extends TClosing>> oVar) {
        return (e<e<T>>) Z2(new z3(oVar));
    }

    public final <B> e<List<T>> Y(e<B> eVar) {
        return Z(eVar, 16);
    }

    public final e<T> Y1(p<? super T, Boolean> pVar) {
        return F5(pVar).P4();
    }

    public final e<T> Y2(T t3, p<? super T, Boolean> pVar) {
        return V1(pVar).G5(1).R4(t3);
    }

    public final <R> e<R> Y3(p<? super e<T>, ? extends e<R>> pVar) {
        return s2.B7(this, pVar);
    }

    public final e<T> Y4(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new d3(j4, timeUnit, hVar));
    }

    public final e<T> Y5(long j4, TimeUnit timeUnit, h hVar) {
        return H4(j4, timeUnit, hVar);
    }

    public final <R> e<R> Y6(Iterable<e<?>> iterable, y<R> yVar) {
        return H6(new e4(this, null, iterable, yVar));
    }

    public final <B> e<List<T>> Z(e<B> eVar, int i4) {
        return (e<List<T>>) Z2(new o1(eVar, i4));
    }

    public final <R> e<R> Z0(p<? super T, ? extends e<? extends R>> pVar) {
        if (this instanceof rx.internal.util.k) {
            return ((rx.internal.util.k) this).y7(pVar);
        }
        return H6(new z(this, pVar, 2, 0));
    }

    public final e<T> Z1(T t3) {
        return C5(1).R4(t3);
    }

    public final <R> e<R> Z2(b<? extends R, ? super T> bVar) {
        return H6(new q0(this.f62215a, bVar));
    }

    public final rx.observables.c<T> Z3() {
        return s2.D7(this);
    }

    public final <U> e<T> Z4(e<U> eVar) {
        return (e<T>) Z2(new e3(eVar));
    }

    public final e<T> Z5(long j4, TimeUnit timeUnit) {
        return n1(j4, timeUnit);
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> Z6(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, e<T6> eVar6, e<T7> eVar7, e<T8> eVar8, x<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> xVar) {
        return H6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8}, null, a0.n(xVar)));
    }

    public final <TOpening, TClosing> e<List<T>> a0(e<? extends TOpening> eVar, p<? super TOpening, ? extends e<? extends TClosing>> pVar) {
        return (e<List<T>>) Z2(new q1(eVar, pVar));
    }

    public final <R> e<R> a1(p<? super T, ? extends e<? extends R>> pVar) {
        if (this instanceof rx.internal.util.k) {
            return ((rx.internal.util.k) this).y7(pVar);
        }
        return H6(new z(this, pVar, 2, 2));
    }

    public final e<T> a2(T t3, p<? super T, Boolean> pVar) {
        return F5(pVar).R4(t3);
    }

    public final e<T> a3(int i4) {
        return C5(i4);
    }

    public final e<T> a5(p<? super T, Boolean> pVar) {
        return (e<T>) Z2(new f3(f3.a(pVar)));
    }

    public final e<T> a6(long j4, TimeUnit timeUnit, h hVar) {
        return o1(j4, timeUnit, hVar);
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> e<R> a7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, e<T6> eVar6, e<T7> eVar7, rx.functions.w<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> wVar) {
        return H6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7}, null, a0.m(wVar)));
    }

    public final <TClosing> e<List<T>> b0(o<? extends e<? extends TClosing>> oVar) {
        return (e<List<T>>) Z2(new o1(oVar, 16));
    }

    public final <R> e<R> b1(p<? super T, ? extends e<? extends R>> pVar) {
        return c1(pVar, rx.internal.util.j.f63940d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> b2(p<? super T, ? extends e<? extends R>> pVar) {
        if (getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) this).y7(pVar);
        }
        return g3(b3(pVar));
    }

    public final <R> e<R> b3(p<? super T, ? extends R> pVar) {
        return H6(new r0(this, pVar));
    }

    public final e<T> b5() {
        return (e<T>) D6().k2(n.c());
    }

    public final e<rx.schedulers.e<T>> b6() {
        return c6(rx.schedulers.c.a());
    }

    public final <T1, T2, T3, T4, T5, T6, R> e<R> b7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, e<T6> eVar6, v<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> vVar) {
        return H6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6}, null, a0.l(vVar)));
    }

    public final e<Boolean> c(p<? super T, Boolean> pVar) {
        return Z2(new l1(pVar));
    }

    public final e<T> c0() {
        return rx.internal.operators.h.v7(this);
    }

    public final <R> e<R> c1(p<? super T, ? extends e<? extends R>> pVar, int i4) {
        if (i4 >= 1) {
            return Z2(new e2(pVar, i4, Integer.MAX_VALUE));
        }
        throw new IllegalArgumentException("capacityHint > 0 required but it was " + i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> c2(p<? super T, ? extends e<? extends R>> pVar, int i4) {
        if (getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) this).y7(pVar);
        }
        return h3(b3(pVar), i4);
    }

    public final e<T> c4(int i4) {
        if (i4 > 0) {
            return (e<T>) Z2(n2.a(i4));
        }
        throw new IllegalArgumentException("n > 0 required but it was " + i4);
    }

    public final e<T> c5(q<? super T, ? super T, Integer> qVar) {
        return (e<T>) F6(qVar).k2(n.c());
    }

    public final e<rx.schedulers.e<T>> c6(h hVar) {
        return (e<rx.schedulers.e<T>>) Z2(new q3(hVar));
    }

    public final <T1, T2, T3, T4, T5, R> e<R> c7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, u<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> uVar) {
        return H6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5}, null, a0.k(uVar)));
    }

    @Deprecated
    public final e<T> d0(int i4) {
        return e0(i4);
    }

    public final <R> e<R> d1(p<? super T, ? extends e<? extends R>> pVar, int i4, int i5) {
        if (i4 < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i4);
        } else if (i5 >= 1) {
            return Z2(new e2(pVar, i4, i5));
        } else {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> d2(p<? super T, ? extends e<? extends R>> pVar, p<? super Throwable, ? extends e<? extends R>> pVar2, o<? extends e<? extends R>> oVar) {
        return g3(c3(pVar, pVar2, oVar));
    }

    public final e<Notification<T>> d3() {
        return (e<Notification<T>>) Z2(k2.a());
    }

    public final <R> e<R> d4(R r3, q<R, ? super T, R> qVar) {
        return H6(new y0(this, r3, qVar));
    }

    public final e<T> d5(Iterable<T> iterable) {
        return v0(u2(iterable), this);
    }

    public final e<T> d6(long j4, TimeUnit timeUnit) {
        return f6(j4, timeUnit, null, rx.schedulers.c.a());
    }

    public final <T1, T2, T3, T4, R> e<R> d7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, t<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> tVar) {
        return H6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4}, null, a0.j(tVar)));
    }

    public final e<T> e0(int i4) {
        return rx.internal.operators.h.w7(this, i4);
    }

    public final <R> e<R> e1(p<? super T, ? extends Iterable<? extends R>> pVar) {
        return k0.a(this, pVar, rx.internal.util.j.f63940d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> e2(p<? super T, ? extends e<? extends R>> pVar, p<? super Throwable, ? extends e<? extends R>> pVar2, o<? extends e<? extends R>> oVar, int i4) {
        return h3(c3(pVar, pVar2, oVar), i4);
    }

    public final e<T> e4(q<T, T, T> qVar) {
        return H6(new x0(this, qVar));
    }

    public final e<T> e5(T t3) {
        return v0(L2(t3), this);
    }

    public final e<T> e6(long j4, TimeUnit timeUnit, e<? extends T> eVar) {
        return f6(j4, timeUnit, eVar, rx.schedulers.c.a());
    }

    public final <T1, T2, T3, R> e<R> e7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, s<? super T, ? super T1, ? super T2, ? super T3, R> sVar) {
        return H6(new e4(this, new e[]{eVar, eVar2, eVar3}, null, a0.i(sVar)));
    }

    public final <R> e<R> f0(Class<R> cls) {
        return Z2(new s1(cls));
    }

    public final e<T> f1(e<? extends T> eVar) {
        return v0(this, eVar);
    }

    public final <U, R> e<R> f2(p<? super T, ? extends e<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar) {
        return g3(Z2(new j2(pVar, qVar)));
    }

    public final e<T> f4() {
        return w0.b(this);
    }

    public final e<T> f5(T t3, T t4) {
        return v0(M2(t3, t4), this);
    }

    public final e<T> f6(long j4, TimeUnit timeUnit, e<? extends T> eVar, h hVar) {
        return (e<T>) Z2(new r3(j4, timeUnit, eVar, hVar));
    }

    public final <T1, T2, R> e<R> f7(e<T1> eVar, e<T2> eVar2, r<? super T, ? super T1, ? super T2, R> rVar) {
        return H6(new e4(this, new e[]{eVar, eVar2}, null, a0.h(rVar)));
    }

    public final <R> e<R> g0(o<R> oVar, rx.functions.c<R, ? super T> cVar) {
        return H6(new rx.internal.operators.x(this, oVar, cVar));
    }

    public final e<Boolean> g1(Object obj) {
        return U1(InternalObservableUtils.equalsWith(obj));
    }

    public final <U, R> e<R> g2(p<? super T, ? extends e<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar, int i4) {
        return h3(Z2(new j2(pVar, qVar)), i4);
    }

    public final e<T> g4(long j4) {
        return w0.c(this, j4);
    }

    public final e<T> g5(T t3, T t4, T t5) {
        return v0(N2(t3, t4, t5), this);
    }

    public final e<T> g6(long j4, TimeUnit timeUnit, h hVar) {
        return f6(j4, timeUnit, null, hVar);
    }

    public final <U, R> e<R> g7(e<? extends U> eVar, q<? super T, ? super U, ? extends R> qVar) {
        return Z2(new d4(eVar, qVar));
    }

    public final e<Integer> h1() {
        return d4(0, InternalObservableUtils.COUNTER);
    }

    public final e<T> h2(p<? super T, ? extends rx.b> pVar) {
        return j2(pVar, false, Integer.MAX_VALUE);
    }

    public final e<T> h4(long j4, h hVar) {
        return w0.d(this, j4, hVar);
    }

    public final e<T> h5(T t3, T t4, T t5, T t6) {
        return v0(O2(t3, t4, t5, t6), this);
    }

    public final <U, V> e<T> h6(o<? extends e<U>> oVar, p<? super T, ? extends e<V>> pVar) {
        return i6(oVar, pVar, null);
    }

    public final <R> e<R> h7(e<?>[] eVarArr, y<R> yVar) {
        return H6(new e4(this, eVarArr, null, yVar));
    }

    public final e<Long> i1() {
        return d4(0L, InternalObservableUtils.LONG_COUNTER);
    }

    public final e<T> i2(p<? super T, ? extends rx.b> pVar, boolean z3) {
        return j2(pVar, z3, Integer.MAX_VALUE);
    }

    public final e<T> i4(h hVar) {
        return w0.e(this, hVar);
    }

    public final e<T> i5(T t3, T t4, T t5, T t6, T t7) {
        return v0(P2(t3, t4, t5, t6, t7), this);
    }

    public final <U, V> e<T> i6(o<? extends e<U>> oVar, p<? super T, ? extends e<V>> pVar, e<? extends T> eVar) {
        if (pVar != null) {
            return (e<T>) Z2(new t3(oVar, pVar, eVar));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    public final e<T> j2(p<? super T, ? extends rx.b> pVar, boolean z3, int i4) {
        return H6(new i0(this, pVar, z3, i4));
    }

    public final e<T> j4(p<? super e<? extends Void>, ? extends e<?>> pVar) {
        return w0.f(this, InternalObservableUtils.createRepeatDematerializer(pVar));
    }

    public final e<T> j5(T t3, T t4, T t5, T t6, T t7, T t8) {
        return v0(Q2(t3, t4, t5, t6, t7, t8), this);
    }

    public final <V> e<T> j6(p<? super T, ? extends e<V>> pVar) {
        return i6(null, pVar, null);
    }

    public final <R> e<R> k2(p<? super T, ? extends Iterable<? extends R>> pVar) {
        return l2(pVar, rx.internal.util.j.f63940d);
    }

    public final e<T> k4(p<? super e<? extends Void>, ? extends e<?>> pVar, h hVar) {
        return w0.g(this, InternalObservableUtils.createRepeatDematerializer(pVar), hVar);
    }

    public final e<T> k5(T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return v0(R2(t3, t4, t5, t6, t7, t8, t9), this);
    }

    public final <V> e<T> k6(p<? super T, ? extends e<V>> pVar, e<? extends T> eVar) {
        return i6(null, pVar, eVar);
    }

    public final <R> e<R> l2(p<? super T, ? extends Iterable<? extends R>> pVar, int i4) {
        return k0.a(this, pVar, i4);
    }

    public final <R> e<R> l4(p<? super e<T>, ? extends e<R>> pVar) {
        return t2.G7(InternalObservableUtils.createReplaySupplier(this), pVar);
    }

    public final e<T> l5(T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return v0(S2(t3, t4, t5, t6, t7, t8, t9, t10), this);
    }

    public final <U, R> e<R> m2(p<? super T, ? extends Iterable<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar) {
        return f2(j2.a(pVar), qVar);
    }

    public final <R> e<R> m4(p<? super e<T>, ? extends e<R>> pVar, int i4) {
        return t2.G7(InternalObservableUtils.createReplaySupplier(this, i4), pVar);
    }

    public final e<T> m5(T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10, T t11) {
        return v0(T2(t3, t4, t5, t6, t7, t8, t9, t10, t11), this);
    }

    public final e<T> n1(long j4, TimeUnit timeUnit) {
        return o1(j4, timeUnit, rx.schedulers.c.a());
    }

    public final <U, R> e<R> n2(p<? super T, ? extends Iterable<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar, int i4) {
        return g2(j2.a(pVar), qVar, i4);
    }

    public final <R> e<R> n4(p<? super e<T>, ? extends e<R>> pVar, int i4, long j4, TimeUnit timeUnit) {
        return o4(pVar, i4, j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> n5(e<T> eVar) {
        return v0(eVar, this);
    }

    public final e<T> o1(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new u1(j4, timeUnit, hVar));
    }

    public final <R> e<R> o2(p<? super T, ? extends i<? extends R>> pVar) {
        return q2(pVar, false, Integer.MAX_VALUE);
    }

    public final <R> e<R> o4(p<? super e<T>, ? extends e<R>> pVar, int i4, long j4, TimeUnit timeUnit, h hVar) {
        if (i4 >= 0) {
            return t2.G7(InternalObservableUtils.createReplaySupplier(this, i4, j4, timeUnit, hVar), pVar);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final m o5() {
        return q5(new rx.internal.util.c(rx.functions.m.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, rx.functions.m.a()));
    }

    public final <U> e<T> p1(p<? super T, ? extends e<U>> pVar) {
        return (e<T>) Z2(new t1(pVar));
    }

    public final <R> e<R> p2(p<? super T, ? extends i<? extends R>> pVar, boolean z3) {
        return q2(pVar, z3, Integer.MAX_VALUE);
    }

    public final <R> e<R> p4(p<? super e<T>, ? extends e<R>> pVar, int i4, h hVar) {
        return t2.G7(InternalObservableUtils.createReplaySupplier(this, i4), InternalObservableUtils.createReplaySelectorAndObserveOn(pVar, hVar));
    }

    public final m p5(f<? super T> fVar) {
        if (fVar instanceof l) {
            return q5((l) fVar);
        }
        if (fVar != null) {
            return q5(new rx.internal.util.g(fVar));
        }
        throw new NullPointerException("observer is null");
    }

    public final e<rx.schedulers.f<T>> p6() {
        return q6(rx.schedulers.c.a());
    }

    public final e<T> q1(T t3) {
        return x5(L2(t3));
    }

    public final <R> e<R> q2(p<? super T, ? extends i<? extends R>> pVar, boolean z3, int i4) {
        return H6(new j0(this, pVar, z3, i4));
    }

    public final <R> e<R> q4(p<? super e<T>, ? extends e<R>> pVar, long j4, TimeUnit timeUnit) {
        return r4(pVar, j4, timeUnit, rx.schedulers.c.a());
    }

    public final m q5(l<? super T> lVar) {
        return r5(lVar, this);
    }

    public final e<rx.schedulers.f<T>> q6(h hVar) {
        return (e<rx.schedulers.f<T>>) Z2(new u3(hVar));
    }

    public final void r2(rx.functions.b<? super T> bVar) {
        s5(bVar);
    }

    public final <R> e<R> r4(p<? super e<T>, ? extends e<R>> pVar, long j4, TimeUnit timeUnit, h hVar) {
        return t2.G7(InternalObservableUtils.createReplaySupplier(this, j4, timeUnit, hVar), pVar);
    }

    public final <R> R r6(p<? super e<T>, R> pVar) {
        return pVar.call(this);
    }

    public <R> e<R> s0(c<? super T, ? extends R> cVar) {
        return (e) cVar.call(this);
    }

    public final e<T> s1(long j4, TimeUnit timeUnit) {
        return t1(j4, timeUnit, rx.schedulers.c.a());
    }

    public final void s2(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        t5(bVar, bVar2);
    }

    public final <R> e<R> s4(p<? super e<T>, ? extends e<R>> pVar, h hVar) {
        return t2.G7(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(pVar, hVar));
    }

    public final m s5(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return q5(new rx.internal.util.c(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, rx.functions.m.a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final rx.observables.b<T> s6() {
        return rx.observables.b.g(this);
    }

    public final e<T> t1(long j4, TimeUnit timeUnit, h hVar) {
        return (e<T>) Z2(new v1(j4, timeUnit, hVar));
    }

    public final void t2(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        u5(bVar, bVar2, aVar);
    }

    public final rx.observables.c<T> t4() {
        return t2.B7(this);
    }

    public final m t5(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return q5(new rx.internal.util.c(bVar, bVar2, rx.functions.m.a()));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public rx.b t6() {
        return rx.b.J(this);
    }

    public final <T2, R> e<R> t7(Iterable<? extends T2> iterable, q<? super T, ? super T2, ? extends R> qVar) {
        return Z2(new g4(iterable, qVar));
    }

    public final <U, V> e<T> u1(o<? extends e<U>> oVar, p<? super T, ? extends e<V>> pVar) {
        return (e<T>) z1(oVar).Z2(new w1(this, pVar));
    }

    public final rx.observables.c<T> u4(int i4) {
        return t2.C7(this, i4);
    }

    public final m u5(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        if (bVar != null) {
            if (bVar2 != null) {
                if (aVar != null) {
                    return q5(new rx.internal.util.c(bVar, bVar2, aVar));
                }
                throw new IllegalArgumentException("onComplete can not be null");
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final e<List<T>> u6() {
        return (e<List<T>>) Z2(v3.a());
    }

    public final <T2, R> e<R> u7(e<? extends T2> eVar, q<? super T, ? super T2, ? extends R> qVar) {
        return q7(this, eVar, qVar);
    }

    public final <U> e<T> v1(p<? super T, ? extends e<U>> pVar) {
        return (e<T>) Z2(new w1(this, pVar));
    }

    public final rx.observables.c<T> v4(int i4, long j4, TimeUnit timeUnit) {
        return w4(i4, j4, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> v5(h hVar) {
        return w5(hVar, !(this.f62215a instanceof rx.internal.operators.a0));
    }

    public final <K> e<Map<K, T>> v6(p<? super T, ? extends K> pVar) {
        return H6(new h1(this, pVar, n.c()));
    }

    public final e<T> w1(long j4, TimeUnit timeUnit) {
        return x1(j4, timeUnit, rx.schedulers.c.a());
    }

    public final rx.observables.c<T> w4(int i4, long j4, TimeUnit timeUnit, h hVar) {
        if (i4 >= 0) {
            return t2.E7(this, j4, timeUnit, hVar, i4);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final e<T> w5(h hVar, boolean z3) {
        if (this instanceof rx.internal.util.k) {
            return ((rx.internal.util.k) this).z7(hVar);
        }
        return H6(new g3(this, hVar, z3));
    }

    public final <K, V> e<Map<K, V>> w6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2) {
        return H6(new h1(this, pVar, pVar2));
    }

    public final e<T> x1(long j4, TimeUnit timeUnit, h hVar) {
        return H6(new c0(this, j4, timeUnit, hVar));
    }

    public final rx.observables.c<T> x4(int i4, h hVar) {
        return t2.H7(u4(i4), hVar);
    }

    public final e<T> x5(e<? extends T> eVar) {
        if (eVar != null) {
            return H6(new c1(this, eVar));
        }
        throw new NullPointerException("alternate is null");
    }

    public final <K, V> e<Map<K, V>> x6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2, o<? extends Map<K, V>> oVar) {
        return H6(new h1(this, pVar, pVar2, oVar));
    }

    public final <U> e<T> y1(e<U> eVar) {
        eVar.getClass();
        return H6(new d0(this, eVar));
    }

    public final rx.observables.c<T> y4(long j4, TimeUnit timeUnit) {
        return z4(j4, timeUnit, rx.schedulers.c.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> y5(p<? super T, ? extends e<? extends R>> pVar) {
        return A5(b3(pVar));
    }

    public final <K> e<Map<K, Collection<T>>> y6(p<? super T, ? extends K> pVar) {
        return H6(new i1(this, pVar, n.c()));
    }

    public final <U> e<T> z1(o<? extends e<U>> oVar) {
        return H6(new e0(this, oVar));
    }

    public final rx.observables.c<T> z4(long j4, TimeUnit timeUnit, h hVar) {
        return t2.D7(this, j4, timeUnit, hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> z5(p<? super T, ? extends e<? extends R>> pVar) {
        return B5(b3(pVar));
    }

    public final <K, V> e<Map<K, Collection<V>>> z6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2) {
        return H6(new i1(this, pVar, pVar2));
    }
}
