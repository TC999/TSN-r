package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.util.pool.a;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SingleRequest.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class j<R> implements d, o, i, a.f {
    private static final String C = "Request";
    private static final String D = "Glide";
    private static final Pools.Pool<j<?>> E = com.bumptech.glide.util.pool.a.e(150, new a());
    private static final boolean F = Log.isLoggable("Request", 2);
    private int A;
    @Nullable
    private RuntimeException B;

    /* renamed from: a  reason: collision with root package name */
    private boolean f17921a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f17922b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f17923c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private g<R> f17924d;

    /* renamed from: e  reason: collision with root package name */
    private e f17925e;

    /* renamed from: f  reason: collision with root package name */
    private Context f17926f;

    /* renamed from: g  reason: collision with root package name */
    private com.bumptech.glide.f f17927g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Object f17928h;

    /* renamed from: i  reason: collision with root package name */
    private Class<R> f17929i;

    /* renamed from: j  reason: collision with root package name */
    private com.bumptech.glide.request.a<?> f17930j;

    /* renamed from: k  reason: collision with root package name */
    private int f17931k;

    /* renamed from: l  reason: collision with root package name */
    private int f17932l;

    /* renamed from: m  reason: collision with root package name */
    private Priority f17933m;

    /* renamed from: n  reason: collision with root package name */
    private p<R> f17934n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private List<g<R>> f17935o;

    /* renamed from: p  reason: collision with root package name */
    private com.bumptech.glide.load.engine.k f17936p;

    /* renamed from: q  reason: collision with root package name */
    private com.bumptech.glide.request.transition.g<? super R> f17937q;

    /* renamed from: r  reason: collision with root package name */
    private Executor f17938r;

    /* renamed from: s  reason: collision with root package name */
    private u<R> f17939s;

    /* renamed from: t  reason: collision with root package name */
    private k.d f17940t;

    /* renamed from: u  reason: collision with root package name */
    private long f17941u;
    @GuardedBy("this")

    /* renamed from: v  reason: collision with root package name */
    private b f17942v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f17943w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f17944x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f17945y;

    /* renamed from: z  reason: collision with root package name */
    private int f17946z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SingleRequest.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements a.d<j<?>> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.a.d
        /* renamed from: b */
        public j<?> a() {
            return new j<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SingleRequest.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    j() {
        this.f17922b = F ? String.valueOf(super.hashCode()) : null;
        this.f17923c = com.bumptech.glide.util.pool.c.a();
    }

    public static <R> j<R> A(Context context, com.bumptech.glide.f fVar, Object obj, Class<R> cls, com.bumptech.glide.request.a<?> aVar, int i4, int i5, Priority priority, p<R> pVar, g<R> gVar, @Nullable List<g<R>> list, e eVar, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.request.transition.g<? super R> gVar2, Executor executor) {
        j<?> acquire = E.acquire();
        if (acquire == null) {
            acquire = new j();
        }
        acquire.s(context, fVar, obj, cls, aVar, i4, i5, priority, pVar, gVar, list, eVar, kVar, gVar2, executor);
        return acquire;
    }

    private synchronized void B(GlideException glideException, int i4) {
        boolean z3;
        this.f17923c.c();
        glideException.setOrigin(this.B);
        int g4 = this.f17927g.g();
        if (g4 <= i4) {
            Log.w("Glide", "Load failed for " + this.f17928h + " with size [" + this.f17946z + "x" + this.A + "]", glideException);
            if (g4 <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.f17940t = null;
        this.f17942v = b.FAILED;
        boolean z4 = true;
        this.f17921a = true;
        List<g<R>> list = this.f17935o;
        if (list != null) {
            z3 = false;
            for (g<R> gVar : list) {
                z3 |= gVar.a(glideException, this.f17928h, this.f17934n, t());
            }
        } else {
            z3 = false;
        }
        g<R> gVar2 = this.f17924d;
        if (gVar2 == null || !gVar2.a(glideException, this.f17928h, this.f17934n, t())) {
            z4 = false;
        }
        if (!(z3 | z4)) {
            E();
        }
        this.f17921a = false;
        y();
    }

    private synchronized void C(u<R> uVar, R r3, DataSource dataSource) {
        boolean z3;
        boolean t3 = t();
        this.f17942v = b.COMPLETE;
        this.f17939s = uVar;
        if (this.f17927g.g() <= 3) {
            Log.d("Glide", "Finished loading " + r3.getClass().getSimpleName() + " from " + dataSource + " for " + this.f17928h + " with size [" + this.f17946z + "x" + this.A + "] in " + com.bumptech.glide.util.f.a(this.f17941u) + " ms");
        }
        boolean z4 = true;
        this.f17921a = true;
        List<g<R>> list = this.f17935o;
        if (list != null) {
            z3 = false;
            for (g<R> gVar : list) {
                z3 |= gVar.c(r3, this.f17928h, this.f17934n, dataSource, t3);
            }
        } else {
            z3 = false;
        }
        g<R> gVar2 = this.f17924d;
        if (gVar2 == null || !gVar2.c(r3, this.f17928h, this.f17934n, dataSource, t3)) {
            z4 = false;
        }
        if (!(z4 | z3)) {
            this.f17934n.k(r3, this.f17937q.a(dataSource, t3));
        }
        this.f17921a = false;
        z();
    }

    private void D(u<?> uVar) {
        this.f17936p.k(uVar);
        this.f17939s = null;
    }

    private synchronized void E() {
        if (m()) {
            Drawable q3 = this.f17928h == null ? q() : null;
            if (q3 == null) {
                q3 = p();
            }
            if (q3 == null) {
                q3 = r();
            }
            this.f17934n.n(q3);
        }
    }

    private void k() {
        if (this.f17921a) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean l() {
        e eVar = this.f17925e;
        return eVar == null || eVar.l(this);
    }

    private boolean m() {
        e eVar = this.f17925e;
        return eVar == null || eVar.c(this);
    }

    private boolean n() {
        e eVar = this.f17925e;
        return eVar == null || eVar.e(this);
    }

    private void o() {
        k();
        this.f17923c.c();
        this.f17934n.b(this);
        k.d dVar = this.f17940t;
        if (dVar != null) {
            dVar.a();
            this.f17940t = null;
        }
    }

    private Drawable p() {
        if (this.f17943w == null) {
            Drawable G = this.f17930j.G();
            this.f17943w = G;
            if (G == null && this.f17930j.F() > 0) {
                this.f17943w = v(this.f17930j.F());
            }
        }
        return this.f17943w;
    }

    private Drawable q() {
        if (this.f17945y == null) {
            Drawable H = this.f17930j.H();
            this.f17945y = H;
            if (H == null && this.f17930j.I() > 0) {
                this.f17945y = v(this.f17930j.I());
            }
        }
        return this.f17945y;
    }

    private Drawable r() {
        if (this.f17944x == null) {
            Drawable N = this.f17930j.N();
            this.f17944x = N;
            if (N == null && this.f17930j.O() > 0) {
                this.f17944x = v(this.f17930j.O());
            }
        }
        return this.f17944x;
    }

    private synchronized void s(Context context, com.bumptech.glide.f fVar, Object obj, Class<R> cls, com.bumptech.glide.request.a<?> aVar, int i4, int i5, Priority priority, p<R> pVar, g<R> gVar, @Nullable List<g<R>> list, e eVar, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.request.transition.g<? super R> gVar2, Executor executor) {
        this.f17926f = context;
        this.f17927g = fVar;
        this.f17928h = obj;
        this.f17929i = cls;
        this.f17930j = aVar;
        this.f17931k = i4;
        this.f17932l = i5;
        this.f17933m = priority;
        this.f17934n = pVar;
        this.f17924d = gVar;
        this.f17935o = list;
        this.f17925e = eVar;
        this.f17936p = kVar;
        this.f17937q = gVar2;
        this.f17938r = executor;
        this.f17942v = b.PENDING;
        if (this.B == null && fVar.i()) {
            this.B = new RuntimeException("Glide request origin trace");
        }
    }

    private boolean t() {
        e eVar = this.f17925e;
        return eVar == null || !eVar.b();
    }

    private synchronized boolean u(j<?> jVar) {
        boolean z3;
        synchronized (jVar) {
            List<g<R>> list = this.f17935o;
            int size = list == null ? 0 : list.size();
            List<g<?>> list2 = jVar.f17935o;
            z3 = size == (list2 == null ? 0 : list2.size());
        }
        return z3;
    }

    private Drawable v(@DrawableRes int i4) {
        return com.bumptech.glide.load.resource.drawable.a.a(this.f17927g, i4, this.f17930j.T() != null ? this.f17930j.T() : this.f17926f.getTheme());
    }

    private void w(String str) {
        Log.v("Request", str + " this: " + this.f17922b);
    }

    private static int x(int i4, float f4) {
        return i4 == Integer.MIN_VALUE ? i4 : Math.round(f4 * i4);
    }

    private void y() {
        e eVar = this.f17925e;
        if (eVar != null) {
            eVar.h(this);
        }
    }

    private void z() {
        e eVar = this.f17925e;
        if (eVar != null) {
            eVar.k(this);
        }
    }

    @Override // com.bumptech.glide.request.d
    public synchronized boolean a() {
        return this.f17942v == b.COMPLETE;
    }

    @Override // com.bumptech.glide.request.i
    public synchronized void b(GlideException glideException) {
        B(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.i
    public synchronized void c(u<?> uVar, DataSource dataSource) {
        this.f17923c.c();
        this.f17940t = null;
        if (uVar == null) {
            b(new GlideException("Expected to receive a Resource<R> with an object of " + this.f17929i + " inside, but instead got null."));
            return;
        }
        Object obj = uVar.get();
        if (obj != null && this.f17929i.isAssignableFrom(obj.getClass())) {
            if (!n()) {
                D(uVar);
                this.f17942v = b.COMPLETE;
                return;
            }
            C(uVar, obj, dataSource);
            return;
        }
        D(uVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f17929i);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(uVar);
        sb.append("}.");
        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        b(new GlideException(sb.toString()));
    }

    @Override // com.bumptech.glide.request.d
    public synchronized void clear() {
        k();
        this.f17923c.c();
        b bVar = this.f17942v;
        b bVar2 = b.CLEARED;
        if (bVar == bVar2) {
            return;
        }
        o();
        u<R> uVar = this.f17939s;
        if (uVar != null) {
            D(uVar);
        }
        if (l()) {
            this.f17934n.j(r());
        }
        this.f17942v = bVar2;
    }

    @Override // com.bumptech.glide.request.d
    public synchronized boolean d() {
        return a();
    }

    @Override // com.bumptech.glide.request.target.o
    public synchronized void e(int i4, int i5) {
        try {
            this.f17923c.c();
            boolean z3 = F;
            if (z3) {
                w("Got onSizeReady in " + com.bumptech.glide.util.f.a(this.f17941u));
            }
            if (this.f17942v != b.WAITING_FOR_SIZE) {
                return;
            }
            b bVar = b.RUNNING;
            this.f17942v = bVar;
            float S = this.f17930j.S();
            this.f17946z = x(i4, S);
            this.A = x(i5, S);
            if (z3) {
                w("finished setup for calling load in " + com.bumptech.glide.util.f.a(this.f17941u));
            }
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f17940t = this.f17936p.g(this.f17927g, this.f17928h, this.f17930j.R(), this.f17946z, this.A, this.f17930j.Q(), this.f17929i, this.f17933m, this.f17930j.E(), this.f17930j.U(), this.f17930j.h0(), this.f17930j.c0(), this.f17930j.K(), this.f17930j.a0(), this.f17930j.W(), this.f17930j.V(), this.f17930j.J(), this, this.f17938r);
                if (this.f17942v != bVar) {
                    this.f17940t = null;
                }
                if (z3) {
                    w("finished onSizeReady in " + com.bumptech.glide.util.f.a(this.f17941u));
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bumptech.glide.request.d
    public synchronized boolean f() {
        return this.f17942v == b.FAILED;
    }

    @Override // com.bumptech.glide.request.d
    public synchronized boolean g() {
        return this.f17942v == b.CLEARED;
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f17923c;
    }

    @Override // com.bumptech.glide.request.d
    public synchronized boolean i(d dVar) {
        boolean z3 = false;
        if (dVar instanceof j) {
            j<?> jVar = (j) dVar;
            synchronized (jVar) {
                if (this.f17931k == jVar.f17931k && this.f17932l == jVar.f17932l && com.bumptech.glide.util.k.c(this.f17928h, jVar.f17928h) && this.f17929i.equals(jVar.f17929i) && this.f17930j.equals(jVar.f17930j) && this.f17933m == jVar.f17933m && u(jVar)) {
                    z3 = true;
                }
            }
            return z3;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public synchronized boolean isRunning() {
        boolean z3;
        b bVar = this.f17942v;
        if (bVar != b.RUNNING) {
            z3 = bVar == b.WAITING_FOR_SIZE;
        }
        return z3;
    }

    @Override // com.bumptech.glide.request.d
    public synchronized void j() {
        k();
        this.f17923c.c();
        this.f17941u = com.bumptech.glide.util.f.b();
        if (this.f17928h == null) {
            if (com.bumptech.glide.util.k.v(this.f17931k, this.f17932l)) {
                this.f17946z = this.f17931k;
                this.A = this.f17932l;
            }
            B(new GlideException("Received null model"), q() == null ? 5 : 3);
            return;
        }
        b bVar = this.f17942v;
        b bVar2 = b.RUNNING;
        if (bVar != bVar2) {
            if (bVar == b.COMPLETE) {
                c(this.f17939s, DataSource.MEMORY_CACHE);
                return;
            }
            b bVar3 = b.WAITING_FOR_SIZE;
            this.f17942v = bVar3;
            if (com.bumptech.glide.util.k.v(this.f17931k, this.f17932l)) {
                e(this.f17931k, this.f17932l);
            } else {
                this.f17934n.q(this);
            }
            b bVar4 = this.f17942v;
            if ((bVar4 == bVar2 || bVar4 == bVar3) && m()) {
                this.f17934n.h(r());
            }
            if (F) {
                w("finished run method in " + com.bumptech.glide.util.f.a(this.f17941u));
            }
            return;
        }
        throw new IllegalArgumentException("Cannot restart a running request");
    }

    @Override // com.bumptech.glide.request.d
    public synchronized void recycle() {
        k();
        this.f17926f = null;
        this.f17927g = null;
        this.f17928h = null;
        this.f17929i = null;
        this.f17930j = null;
        this.f17931k = -1;
        this.f17932l = -1;
        this.f17934n = null;
        this.f17935o = null;
        this.f17924d = null;
        this.f17925e = null;
        this.f17937q = null;
        this.f17940t = null;
        this.f17943w = null;
        this.f17944x = null;
        this.f17945y = null;
        this.f17946z = -1;
        this.A = -1;
        this.B = null;
        E.release(this);
    }
}
