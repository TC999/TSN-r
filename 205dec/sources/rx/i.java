package rx;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.annotations.Experimental;
import rx.e;
import rx.functions.v;
import rx.functions.w;
import rx.functions.x;
import rx.functions.y;
import rx.h;
import rx.internal.operators.a5;
import rx.internal.operators.b5;
import rx.internal.operators.c5;
import rx.internal.operators.h4;
import rx.internal.operators.i4;
import rx.internal.operators.j4;
import rx.internal.operators.k4;
import rx.internal.operators.l4;
import rx.internal.operators.m4;
import rx.internal.operators.n4;
import rx.internal.operators.o4;
import rx.internal.operators.p4;
import rx.internal.operators.q4;
import rx.internal.operators.r4;
import rx.internal.operators.s4;
import rx.internal.operators.t4;
import rx.internal.operators.u4;
import rx.internal.operators.v4;
import rx.internal.operators.w4;
import rx.internal.operators.x4;
import rx.internal.operators.y4;
import rx.internal.operators.z4;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Single.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    final t<T> f62261a;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f62262a;

        a(x xVar) {
            this.f62262a = xVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62262a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62264c;

        b(rx.functions.b bVar, rx.functions.b bVar2) {
            this.f62263b = bVar;
            this.f62264c = bVar2;
        }

        @Override // rx.k
        public final void c(T t3) {
            try {
                this.f62264c.call(t3);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.k
        public final void onError(Throwable th) {
            try {
                this.f62263b.call(th);
            } finally {
                unsubscribe();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c extends rx.k<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.f f62266b;

        c(rx.f fVar) {
            this.f62266b = fVar;
        }

        @Override // rx.k
        public void c(T t3) {
            this.f62266b.onNext(t3);
            this.f62266b.onCompleted();
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f62266b.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class d implements t<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62268a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Single.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.k f62270a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h.a f62271b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Single.java */
            /* renamed from: rx.i$d$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1271a extends rx.k<T> {
                C1271a() {
                }

                @Override // rx.k
                public void c(T t3) {
                    try {
                        a.this.f62270a.c(t3);
                    } finally {
                        a.this.f62271b.unsubscribe();
                    }
                }

                @Override // rx.k
                public void onError(Throwable th) {
                    try {
                        a.this.f62270a.onError(th);
                    } finally {
                        a.this.f62271b.unsubscribe();
                    }
                }
            }

            a(rx.k kVar, h.a aVar) {
                this.f62270a = kVar;
                this.f62271b = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                C1271a c1271a = new C1271a();
                this.f62270a.b(c1271a);
                i.this.i0(c1271a);
            }
        }

        d(rx.h hVar) {
            this.f62268a = hVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            h.a a4 = this.f62268a.a();
            kVar.b(a4);
            a4.c(new a(kVar, a4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class e implements rx.functions.o<i<T>> {
        e() {
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public i<T> call() {
            return i.x(new TimeoutException());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class f implements rx.functions.b<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62275a;

        f(rx.functions.b bVar) {
            this.f62275a = bVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f62275a.call(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class g implements rx.functions.b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62277a;

        g(rx.functions.b bVar) {
            this.f62277a = bVar;
        }

        @Override // rx.functions.b
        public void call(T t3) {
            this.f62277a.call(Notification.e(t3));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class h implements rx.functions.b<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62279a;

        h(rx.functions.b bVar) {
            this.f62279a = bVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f62279a.call(Notification.d(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* renamed from: rx.i$i  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1272i implements t<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callable f62281a;

        C1272i(Callable callable) {
            this.f62281a = callable;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            try {
                ((i) this.f62281a.call()).i0(kVar);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                kVar.onError(th);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class j implements t<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62282a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Single.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.k<T> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.k f62284b;

            a(rx.k kVar) {
                this.f62284b = kVar;
            }

            @Override // rx.k
            public void c(T t3) {
                this.f62284b.c(t3);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f62284b.onError(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Single.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.k f62286a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Single.java */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class a implements rx.functions.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ h.a f62288a;

                a(h.a aVar) {
                    this.f62288a = aVar;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        b.this.f62286a.unsubscribe();
                    } finally {
                        this.f62288a.unsubscribe();
                    }
                }
            }

            b(rx.k kVar) {
                this.f62286a = kVar;
            }

            @Override // rx.functions.a
            public void call() {
                h.a a4 = j.this.f62282a.a();
                a4.c(new a(a4));
            }
        }

        j(rx.h hVar) {
            this.f62282a = hVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            a aVar = new a(kVar);
            kVar.b(rx.subscriptions.f.a(new b(aVar)));
            i.this.i0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class k implements t<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable f62290a;

        k(Throwable th) {
            this.f62290a = th;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            kVar.onError(this.f62290a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class l implements t<T> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Single.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.k<i<? extends T>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.k f62292b;

            a(rx.k kVar) {
                this.f62292b = kVar;
            }

            @Override // rx.k
            /* renamed from: e */
            public void c(i<? extends T> iVar) {
                iVar.i0(this.f62292b);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f62292b.onError(th);
            }
        }

        l() {
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            a aVar = new a(kVar);
            kVar.b(aVar);
            i.this.i0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class m<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.q f62294a;

        m(rx.functions.q qVar) {
            this.f62294a = qVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62294a.call(objArr[0], objArr[1]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class n<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.r f62295a;

        n(rx.functions.r rVar) {
            this.f62295a = rVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62295a.call(objArr[0], objArr[1], objArr[2]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class o<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.s f62296a;

        o(rx.functions.s sVar) {
            this.f62296a = sVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62296a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class p<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.t f62297a;

        p(rx.functions.t tVar) {
            this.f62297a = tVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62297a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class q<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.u f62298a;

        q(rx.functions.u uVar) {
            this.f62298a = uVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62298a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class r<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f62299a;

        r(v vVar) {
            this.f62299a = vVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62299a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class s<R> implements y<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f62300a;

        s(w wVar) {
            this.f62300a = wVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f62300a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface t<T> extends rx.functions.b<rx.k<? super T>> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Single.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface u<T, R> extends rx.functions.p<i<T>, i<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(t<T> tVar) {
        this.f62261a = rx.plugins.c.H(tVar);
    }

    private rx.m A0(rx.l<? super T> lVar, boolean z3) {
        if (z3) {
            try {
                lVar.onStart();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                try {
                    lVar.onError(rx.plugins.c.Q(th));
                    return rx.subscriptions.f.e();
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.plugins.c.Q(runtimeException);
                    throw runtimeException;
                }
            }
        }
        rx.plugins.c.T(this, this.f62261a).call(q4.a(lVar));
        return rx.plugins.c.S(lVar);
    }

    public static <T> i<T> B(Future<? extends T> future) {
        return m(new o4(future, 0L, null));
    }

    public static <T> i<T> C(Future<? extends T> future, long j4, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return m(new o4(future, j4, timeUnit));
        }
        throw new NullPointerException("unit is null");
    }

    public static <T, Resource> i<T> C0(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends i<? extends T>> pVar, rx.functions.b<? super Resource> bVar) {
        return D0(oVar, pVar, bVar, false);
    }

    public static <T> i<T> D(Future<? extends T> future, rx.h hVar) {
        return B(future).m0(hVar);
    }

    public static <T, Resource> i<T> D0(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends i<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z3) {
        if (oVar != null) {
            if (pVar != null) {
                if (bVar != null) {
                    return m(new v4(oVar, pVar, bVar, z3));
                }
                throw new NullPointerException("disposeAction is null");
            }
            throw new NullPointerException("singleFactory is null");
        }
        throw new NullPointerException("resourceFactory is null");
    }

    public static <T> i<T> E(Callable<? extends T> callable) {
        return m(new m4(callable));
    }

    public static <R> i<R> E0(Iterable<? extends i<?>> iterable, y<? extends R> yVar) {
        return x4.a(G(iterable), yVar);
    }

    public static <T> i<T> F(rx.functions.b<rx.j<T>> bVar) {
        if (bVar != null) {
            return m(new n4(bVar));
        }
        throw new NullPointerException("producer is null");
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> i<R> F0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, i<? extends T7> iVar7, i<? extends T8> iVar8, i<? extends T9> iVar9, x<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> xVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9}, new a(xVar));
    }

    static <T> i<? extends T>[] G(Iterable<? extends i<? extends T>> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return (i[]) collection.toArray(new i[collection.size()]);
        }
        i<? extends T>[] iVarArr = new i[8];
        int i4 = 0;
        for (i<? extends T> iVar : iterable) {
            if (i4 == iVarArr.length) {
                i<? extends T>[] iVarArr2 = new i[(i4 >> 2) + i4];
                System.arraycopy(iVarArr, 0, iVarArr2, 0, i4);
                iVarArr = iVarArr2;
            }
            iVarArr[i4] = iVar;
            i4++;
        }
        if (iVarArr.length == i4) {
            return iVarArr;
        }
        i<? extends T>[] iVarArr3 = new i[i4];
        System.arraycopy(iVarArr, 0, iVarArr3, 0, i4);
        return iVarArr3;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> i<R> G0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, i<? extends T7> iVar7, i<? extends T8> iVar8, w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8}, new s(wVar));
    }

    public static <T> i<T> H(T t3) {
        return rx.internal.util.l.O0(t3);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> i<R> H0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, i<? extends T7> iVar7, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7}, new r(vVar));
    }

    public static <T1, T2, T3, T4, T5, T6, R> i<R> I0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, rx.functions.u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6}, new q(uVar));
    }

    public static <T1, T2, T3, T4, T5, R> i<R> J0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, rx.functions.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5}, new p(tVar));
    }

    public static <T> rx.e<T> K(rx.e<? extends i<? extends T>> eVar) {
        return L(eVar, Integer.MAX_VALUE);
    }

    public static <T1, T2, T3, T4, R> i<R> K0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, rx.functions.s<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3, iVar4}, new o(sVar));
    }

    public static <T> rx.e<T> L(rx.e<? extends i<? extends T>> eVar, int i4) {
        return (rx.e<T>) eVar.q2(rx.internal.util.n.c(), false, i4);
    }

    public static <T1, T2, T3, R> i<R> L0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, rx.functions.r<? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return x4.a(new i[]{iVar, iVar2, iVar3}, new n(rVar));
    }

    public static <T> rx.e<T> M(i<? extends T> iVar, i<? extends T> iVar2) {
        return rx.e.i3(a(iVar), a(iVar2));
    }

    public static <T1, T2, R> i<R> M0(i<? extends T1> iVar, i<? extends T2> iVar2, rx.functions.q<? super T1, ? super T2, ? extends R> qVar) {
        return x4.a(new i[]{iVar, iVar2}, new m(qVar));
    }

    public static <T> rx.e<T> N(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3) {
        return rx.e.j3(a(iVar), a(iVar2), a(iVar3));
    }

    public static <T> rx.e<T> O(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4) {
        return rx.e.k3(a(iVar), a(iVar2), a(iVar3), a(iVar4));
    }

    public static <T> rx.e<T> P(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5) {
        return rx.e.l3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5));
    }

    public static <T> rx.e<T> Q(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6) {
        return rx.e.m3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6));
    }

    public static <T> rx.e<T> R(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7) {
        return rx.e.n3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7));
    }

    public static <T> rx.e<T> S(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8) {
        return rx.e.o3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8));
    }

    public static <T> rx.e<T> T(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8, i<? extends T> iVar9) {
        return rx.e.p3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8), a(iVar9));
    }

    public static <T> i<T> U(i<? extends i<? extends T>> iVar) {
        if (iVar instanceof rx.internal.util.l) {
            return ((rx.internal.util.l) iVar).Q0(rx.internal.util.n.c());
        }
        return m(new l());
    }

    public static <T> rx.e<T> V(rx.e<? extends i<? extends T>> eVar) {
        return L(eVar, Integer.MAX_VALUE);
    }

    public static <T> rx.e<T> W(rx.e<? extends i<? extends T>> eVar, int i4) {
        return (rx.e<T>) eVar.q2(rx.internal.util.n.c(), true, i4);
    }

    private static <T> rx.e<T> a(i<T> iVar) {
        return rx.e.H6(new c5(iVar.f62261a));
    }

    public static <T> rx.e<T> d(i<? extends T> iVar, i<? extends T> iVar2) {
        return rx.e.v0(a(iVar), a(iVar2));
    }

    public static <T> rx.e<T> e(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3) {
        return rx.e.w0(a(iVar), a(iVar2), a(iVar3));
    }

    public static <T> rx.e<T> f(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4) {
        return rx.e.x0(a(iVar), a(iVar2), a(iVar3), a(iVar4));
    }

    public static <T> rx.e<T> g(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5) {
        return rx.e.y0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5));
    }

    public static <T> rx.e<T> h(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6) {
        return rx.e.z0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6));
    }

    public static <T> rx.e<T> i(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7) {
        return rx.e.A0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7));
    }

    public static <T> rx.e<T> j(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8) {
        return rx.e.B0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8));
    }

    public static <T> rx.e<T> k(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8, i<? extends T> iVar9) {
        return rx.e.C0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8), a(iVar9));
    }

    public static <T> i<T> m(t<T> tVar) {
        return new i<>(tVar);
    }

    public static <T> i<T> n(Callable<i<T>> callable) {
        return m(new C1272i(callable));
    }

    public static <T> i<T> x(Throwable th) {
        return m(new k(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> rx.e<R> A(rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar) {
        return rx.e.g3(a(J(pVar)));
    }

    @Experimental
    public final i<T> B0(rx.h hVar) {
        return m(new j(hVar));
    }

    public final <R> i<R> I(e.b<? extends R, ? super T> bVar) {
        return m(new q4(this.f62261a, bVar));
    }

    public final <R> i<R> J(rx.functions.p<? super T, ? extends R> pVar) {
        return m(new u4(this, pVar));
    }

    public final <T2, R> i<R> N0(i<? extends T2> iVar, rx.functions.q<? super T, ? super T2, ? extends R> qVar) {
        return M0(this, iVar, qVar);
    }

    public final rx.e<T> X(i<? extends T> iVar) {
        return M(this, iVar);
    }

    public final i<T> Y(rx.h hVar) {
        if (this instanceof rx.internal.util.l) {
            return ((rx.internal.util.l) this).R0(hVar);
        }
        if (hVar != null) {
            return m(new r4(this.f62261a, hVar));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final i<T> Z(i<? extends T> iVar) {
        return new i<>(w4.b(this, iVar));
    }

    public final i<T> a0(rx.functions.p<Throwable, ? extends i<? extends T>> pVar) {
        return new i<>(w4.a(this, pVar));
    }

    public final i<T> b() {
        return y0().e0(1).C6();
    }

    public final i<T> b0(rx.functions.p<Throwable, ? extends T> pVar) {
        return m(new s4(this.f62261a, pVar));
    }

    public <R> i<R> c(u<? super T, ? extends R> uVar) {
        return (i) uVar.call(this);
    }

    public final i<T> c0() {
        return y0().B4().C6();
    }

    public final i<T> d0(long j4) {
        return y0().C4(j4).C6();
    }

    public final i<T> e0(rx.functions.q<Integer, Throwable, Boolean> qVar) {
        return y0().D4(qVar).C6();
    }

    public final i<T> f0(rx.functions.p<rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
        return y0().E4(pVar).C6();
    }

    public final rx.m g0() {
        return l0(rx.functions.m.a(), rx.functions.m.b());
    }

    public final rx.m h0(rx.f<? super T> fVar) {
        if (fVar != null) {
            return i0(new c(fVar));
        }
        throw new NullPointerException("observer is null");
    }

    public final rx.m i0(rx.k<? super T> kVar) {
        if (kVar != null) {
            try {
                rx.plugins.c.T(this, this.f62261a).call(kVar);
                return rx.plugins.c.S(kVar);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                try {
                    kVar.onError(rx.plugins.c.Q(th));
                    return rx.subscriptions.f.b();
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.plugins.c.Q(runtimeException);
                    throw runtimeException;
                }
            }
        }
        throw new IllegalArgumentException("te is null");
    }

    public final rx.m j0(rx.l<? super T> lVar) {
        if (lVar != null) {
            lVar.onStart();
            if (!(lVar instanceof rx.observers.e)) {
                return A0(new rx.observers.e(lVar), false);
            }
            return A0(lVar, true);
        }
        throw new IllegalArgumentException("observer can not be null");
    }

    public final rx.m k0(rx.functions.b<? super T> bVar) {
        return l0(bVar, rx.functions.m.b());
    }

    public final rx.e<T> l(i<? extends T> iVar) {
        return d(this, iVar);
    }

    public final rx.m l0(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return i0(new b(bVar2, bVar));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final i<T> m0(rx.h hVar) {
        if (this instanceof rx.internal.util.l) {
            return ((rx.internal.util.l) this).R0(hVar);
        }
        return m(new d(hVar));
    }

    public final i<T> n0(rx.b bVar) {
        return m(new y4(this.f62261a, bVar));
    }

    public final i<T> o(long j4, TimeUnit timeUnit) {
        return p(j4, timeUnit, rx.schedulers.c.a());
    }

    public final <E> i<T> o0(rx.e<? extends E> eVar) {
        return m(new z4(this.f62261a, eVar));
    }

    public final i<T> p(long j4, TimeUnit timeUnit, rx.h hVar) {
        return m(new h4(this.f62261a, j4, timeUnit, hVar));
    }

    public final <E> i<T> p0(i<? extends E> iVar) {
        return m(new a5(this.f62261a, iVar));
    }

    public final i<T> q(rx.e<?> eVar) {
        eVar.getClass();
        return m(new t4(this, eVar));
    }

    public final rx.observers.a<T> q0() {
        m3.a g4 = m3.a.g(Long.MAX_VALUE);
        j0(g4);
        return g4;
    }

    public final i<T> r(rx.functions.a aVar) {
        return m(new i4(this, aVar));
    }

    public final i<T> r0(long j4, TimeUnit timeUnit) {
        return u0(j4, timeUnit, null, rx.schedulers.c.a());
    }

    public final i<T> s(rx.functions.b<Notification<? extends T>> bVar) {
        if (bVar != null) {
            return m(new j4(this, new g(bVar), new h(bVar)));
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    public final i<T> s0(long j4, TimeUnit timeUnit, rx.h hVar) {
        return u0(j4, timeUnit, null, hVar);
    }

    public final i<T> t(rx.functions.b<Throwable> bVar) {
        if (bVar != null) {
            return m(new j4(this, rx.functions.m.a(), new f(bVar)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    public final i<T> t0(long j4, TimeUnit timeUnit, i<? extends T> iVar) {
        return u0(j4, timeUnit, iVar, rx.schedulers.c.a());
    }

    public final i<T> u(rx.functions.a aVar) {
        return m(new k4(this.f62261a, aVar));
    }

    public final i<T> u0(long j4, TimeUnit timeUnit, i<? extends T> iVar, rx.h hVar) {
        if (iVar == null) {
            iVar = n(new e());
        }
        return m(new b5(this.f62261a, j4, timeUnit, hVar, iVar.f62261a));
    }

    public final i<T> v(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return m(new j4(this, bVar, rx.functions.m.a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    public final <R> R v0(rx.functions.p<? super i<T>, R> pVar) {
        return pVar.call(this);
    }

    public final i<T> w(rx.functions.a aVar) {
        return m(new l4(this.f62261a, aVar));
    }

    public final rx.singles.a<T> w0() {
        return rx.singles.a.a(this);
    }

    public final rx.b x0() {
        return rx.b.K(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> i<R> y(rx.functions.p<? super T, ? extends i<? extends R>> pVar) {
        if (this instanceof rx.internal.util.l) {
            return ((rx.internal.util.l) this).Q0(pVar);
        }
        return U(J(pVar));
    }

    public final rx.e<T> y0() {
        return a(this);
    }

    public final rx.b z(rx.functions.p<? super T, ? extends rx.b> pVar) {
        return rx.b.p(new rx.internal.operators.i(this, pVar));
    }

    public final rx.m z0(rx.l<? super T> lVar) {
        return A0(lVar, true);
    }

    @Deprecated
    protected i(e.a<T> aVar) {
        this.f62261a = rx.plugins.c.H(new p4(aVar));
    }
}
