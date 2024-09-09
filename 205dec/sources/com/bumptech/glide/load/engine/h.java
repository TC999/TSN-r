package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.util.pool.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DecodeJob.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private static final String F = "DecodeJob";
    private DataSource A;
    private com.bumptech.glide.load.data.d<?> B;
    private volatile com.bumptech.glide.load.engine.f C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: d  reason: collision with root package name */
    private final e f17052d;

    /* renamed from: e  reason: collision with root package name */
    private final Pools.Pool<h<?>> f17053e;

    /* renamed from: h  reason: collision with root package name */
    private com.bumptech.glide.f f17056h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.load.c f17057i;

    /* renamed from: j  reason: collision with root package name */
    private Priority f17058j;

    /* renamed from: k  reason: collision with root package name */
    private n f17059k;

    /* renamed from: l  reason: collision with root package name */
    private int f17060l;

    /* renamed from: m  reason: collision with root package name */
    private int f17061m;

    /* renamed from: n  reason: collision with root package name */
    private j f17062n;

    /* renamed from: o  reason: collision with root package name */
    private com.bumptech.glide.load.f f17063o;

    /* renamed from: p  reason: collision with root package name */
    private b<R> f17064p;

    /* renamed from: q  reason: collision with root package name */
    private int f17065q;

    /* renamed from: r  reason: collision with root package name */
    private EnumC0171h f17066r;

    /* renamed from: s  reason: collision with root package name */
    private g f17067s;

    /* renamed from: t  reason: collision with root package name */
    private long f17068t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f17069u;

    /* renamed from: v  reason: collision with root package name */
    private Object f17070v;

    /* renamed from: w  reason: collision with root package name */
    private Thread f17071w;

    /* renamed from: x  reason: collision with root package name */
    private com.bumptech.glide.load.c f17072x;

    /* renamed from: y  reason: collision with root package name */
    private com.bumptech.glide.load.c f17073y;

    /* renamed from: z  reason: collision with root package name */
    private Object f17074z;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.g<R> f17049a = new com.bumptech.glide.load.engine.g<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f17050b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f17051c = com.bumptech.glide.util.pool.c.a();

    /* renamed from: f  reason: collision with root package name */
    private final d<?> f17054f = new d<>();

    /* renamed from: g  reason: collision with root package name */
    private final f f17055g = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17075a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17076b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f17077c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f17077c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17077c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0171h.values().length];
            f17076b = iArr2;
            try {
                iArr2[EnumC0171h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17076b[EnumC0171h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17076b[EnumC0171h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17076b[EnumC0171h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17076b[EnumC0171h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f17075a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17075a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17075a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b<R> {
        void b(GlideException glideException);

        void c(u<R> uVar, DataSource dataSource);

        void d(h<?> hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public final class c<Z> implements i.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f17078a;

        c(DataSource dataSource) {
            this.f17078a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        @NonNull
        public u<Z> a(@NonNull u<Z> uVar) {
            return h.this.u(this.f17078a, uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        private com.bumptech.glide.load.c f17080a;

        /* renamed from: b  reason: collision with root package name */
        private com.bumptech.glide.load.h<Z> f17081b;

        /* renamed from: c  reason: collision with root package name */
        private t<Z> f17082c;

        d() {
        }

        void a() {
            this.f17080a = null;
            this.f17081b = null;
            this.f17082c = null;
        }

        void b(e eVar, com.bumptech.glide.load.f fVar) {
            com.bumptech.glide.util.pool.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f17080a, new com.bumptech.glide.load.engine.e(this.f17081b, this.f17082c, fVar));
            } finally {
                this.f17082c.e();
                com.bumptech.glide.util.pool.b.e();
            }
        }

        boolean c() {
            return this.f17082c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.h<X> hVar, t<X> tVar) {
            this.f17080a = cVar;
            this.f17081b = hVar;
            this.f17082c = tVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface e {
        com.bumptech.glide.load.engine.cache.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f17083a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17084b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17085c;

        f() {
        }

        private boolean a(boolean z3) {
            return (this.f17085c || z3 || this.f17084b) && this.f17083a;
        }

        synchronized boolean b() {
            this.f17084b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f17085c = true;
            return a(false);
        }

        synchronized boolean d(boolean z3) {
            this.f17083a = true;
            return a(z3);
        }

        synchronized void e() {
            this.f17084b = false;
            this.f17083a = false;
            this.f17085c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$h  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum EnumC0171h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, Pools.Pool<h<?>> pool) {
        this.f17052d = eVar;
        this.f17053e = pool;
    }

    private void A() {
        Throwable th;
        this.f17051c.c();
        if (this.D) {
            if (this.f17050b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f17050b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    private <Data> u<R> e(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long b4 = com.bumptech.glide.util.f.b();
            u<R> g4 = g(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                n("Decoded result " + g4, b4);
            }
            return g4;
        } finally {
            dVar.b();
        }
    }

    private <Data> u<R> g(Data data, DataSource dataSource) throws GlideException {
        return y(data, dataSource, (s<Data, ?, R>) this.f17049a.h(data.getClass()));
    }

    private int getPriority() {
        return this.f17058j.ordinal();
    }

    private void i() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j4 = this.f17068t;
            o("Retrieved data", j4, "data: " + this.f17074z + ", cache key: " + this.f17072x + ", fetcher: " + this.B);
        }
        u<R> uVar = null;
        try {
            uVar = e(this.B, this.f17074z, this.A);
        } catch (GlideException e4) {
            e4.setLoggingDetails(this.f17073y, this.A);
            this.f17050b.add(e4);
        }
        if (uVar != null) {
            q(uVar, this.A);
        } else {
            x();
        }
    }

    private com.bumptech.glide.load.engine.f j() {
        int i4 = a.f17076b[this.f17066r.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.f17066r);
                }
                return new y(this.f17049a, this);
            }
            return new com.bumptech.glide.load.engine.c(this.f17049a, this);
        }
        return new v(this.f17049a, this);
    }

    private EnumC0171h k(EnumC0171h enumC0171h) {
        int i4 = a.f17076b[enumC0171h.ordinal()];
        if (i4 == 1) {
            return this.f17062n.a() ? EnumC0171h.DATA_CACHE : k(EnumC0171h.DATA_CACHE);
        } else if (i4 == 2) {
            return this.f17069u ? EnumC0171h.FINISHED : EnumC0171h.SOURCE;
        } else if (i4 == 3 || i4 == 4) {
            return EnumC0171h.FINISHED;
        } else {
            if (i4 == 5) {
                return this.f17062n.b() ? EnumC0171h.RESOURCE_CACHE : k(EnumC0171h.RESOURCE_CACHE);
            }
            throw new IllegalArgumentException("Unrecognized stage: " + enumC0171h);
        }
    }

    @NonNull
    private com.bumptech.glide.load.f l(DataSource dataSource) {
        com.bumptech.glide.load.f fVar = this.f17063o;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z3 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f17049a.w();
        com.bumptech.glide.load.e<Boolean> eVar = com.bumptech.glide.load.resource.bitmap.n.f17445j;
        Boolean bool = (Boolean) fVar.c(eVar);
        if (bool == null || (bool.booleanValue() && !z3)) {
            com.bumptech.glide.load.f fVar2 = new com.bumptech.glide.load.f();
            fVar2.d(this.f17063o);
            fVar2.e(eVar, Boolean.valueOf(z3));
            return fVar2;
        }
        return fVar;
    }

    private void n(String str, long j4) {
        o(str, j4, null);
    }

    private void o(String str, long j4, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.f.a(j4));
        sb.append(", load key: ");
        sb.append(this.f17059k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void p(u<R> uVar, DataSource dataSource) {
        A();
        this.f17064p.c(uVar, dataSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q(u<R> uVar, DataSource dataSource) {
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
        t tVar = 0;
        if (this.f17054f.c()) {
            uVar = t.c(uVar);
            tVar = uVar;
        }
        p(uVar, dataSource);
        this.f17066r = EnumC0171h.ENCODE;
        try {
            if (this.f17054f.c()) {
                this.f17054f.b(this.f17052d, this.f17063o);
            }
            s();
        } finally {
            if (tVar != 0) {
                tVar.e();
            }
        }
    }

    private void r() {
        A();
        this.f17064p.b(new GlideException("Failed to load resource", new ArrayList(this.f17050b)));
        t();
    }

    private void s() {
        if (this.f17055g.b()) {
            w();
        }
    }

    private void t() {
        if (this.f17055g.c()) {
            w();
        }
    }

    private void w() {
        this.f17055g.e();
        this.f17054f.a();
        this.f17049a.a();
        this.D = false;
        this.f17056h = null;
        this.f17057i = null;
        this.f17063o = null;
        this.f17058j = null;
        this.f17059k = null;
        this.f17064p = null;
        this.f17066r = null;
        this.C = null;
        this.f17071w = null;
        this.f17072x = null;
        this.f17074z = null;
        this.A = null;
        this.B = null;
        this.f17068t = 0L;
        this.E = false;
        this.f17070v = null;
        this.f17050b.clear();
        this.f17053e.release(this);
    }

    private void x() {
        this.f17071w = Thread.currentThread();
        this.f17068t = com.bumptech.glide.util.f.b();
        boolean z3 = false;
        while (!this.E && this.C != null && !(z3 = this.C.b())) {
            this.f17066r = k(this.f17066r);
            this.C = j();
            if (this.f17066r == EnumC0171h.SOURCE) {
                d();
                return;
            }
        }
        if ((this.f17066r == EnumC0171h.FINISHED || this.E) && !z3) {
            r();
        }
    }

    private <Data, ResourceType> u<R> y(Data data, DataSource dataSource, s<Data, ResourceType, R> sVar) throws GlideException {
        com.bumptech.glide.load.f l4 = l(dataSource);
        com.bumptech.glide.load.data.e<Data> l5 = this.f17056h.h().l(data);
        try {
            return sVar.b(l5, l4, this.f17060l, this.f17061m, new c(dataSource));
        } finally {
            l5.b();
        }
    }

    private void z() {
        int i4 = a.f17075a[this.f17067s.ordinal()];
        if (i4 == 1) {
            this.f17066r = k(EnumC0171h.INITIALIZE);
            this.C = j();
            x();
        } else if (i4 == 2) {
            x();
        } else if (i4 == 3) {
            i();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f17067s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        EnumC0171h k4 = k(EnumC0171h.INITIALIZE);
        return k4 == EnumC0171h.RESOURCE_CACHE || k4 == EnumC0171h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f17050b.add(glideException);
        if (Thread.currentThread() != this.f17071w) {
            this.f17067s = g.SWITCH_TO_SOURCE_SERVICE;
            this.f17064p.d(this);
            return;
        }
        x();
    }

    public void b() {
        this.E = true;
        com.bumptech.glide.load.engine.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(@NonNull h<?> hVar) {
        int priority = getPriority() - hVar.getPriority();
        return priority == 0 ? this.f17065q - hVar.f17065q : priority;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void d() {
        this.f17067s = g.SWITCH_TO_SOURCE_SERVICE;
        this.f17064p.d(this);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void f(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f17072x = cVar;
        this.f17074z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.f17073y = cVar2;
        if (Thread.currentThread() != this.f17071w) {
            this.f17067s = g.DECODE_DATA;
            this.f17064p.d(this);
            return;
        }
        com.bumptech.glide.util.pool.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            com.bumptech.glide.util.pool.b.e();
        }
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f17051c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h<R> m(com.bumptech.glide.f fVar, Object obj, n nVar, com.bumptech.glide.load.c cVar, int i4, int i5, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z3, boolean z4, boolean z5, com.bumptech.glide.load.f fVar2, b<R> bVar, int i6) {
        this.f17049a.u(fVar, obj, cVar, i4, i5, jVar, cls, cls2, priority, fVar2, map, z3, z4, this.f17052d);
        this.f17056h = fVar;
        this.f17057i = cVar;
        this.f17058j = priority;
        this.f17059k = nVar;
        this.f17060l = i4;
        this.f17061m = i5;
        this.f17062n = jVar;
        this.f17069u = z5;
        this.f17063o = fVar2;
        this.f17064p = bVar;
        this.f17065q = i6;
        this.f17067s = g.INITIALIZE;
        this.f17070v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.pool.b.b("DecodeJob#run(model=%s)", this.f17070v);
        com.bumptech.glide.load.data.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    r();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.util.pool.b.e();
                    return;
                }
                z();
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.util.pool.b.e();
            } catch (com.bumptech.glide.load.engine.b e4) {
                throw e4;
            }
        }
    }

    @NonNull
    <Z> u<Z> u(DataSource dataSource, @NonNull u<Z> uVar) {
        u<Z> uVar2;
        com.bumptech.glide.load.i<Z> iVar;
        EncodeStrategy encodeStrategy;
        com.bumptech.glide.load.c dVar;
        Class<?> cls = uVar.get().getClass();
        com.bumptech.glide.load.h<Z> hVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.i<Z> r3 = this.f17049a.r(cls);
            iVar = r3;
            uVar2 = r3.a(this.f17056h, uVar, this.f17060l, this.f17061m);
        } else {
            uVar2 = uVar;
            iVar = null;
        }
        if (!uVar.equals(uVar2)) {
            uVar.recycle();
        }
        if (this.f17049a.v(uVar2)) {
            hVar = this.f17049a.n(uVar2);
            encodeStrategy = hVar.b(this.f17063o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.h hVar2 = hVar;
        if (this.f17062n.d(!this.f17049a.x(this.f17072x), dataSource, encodeStrategy)) {
            if (hVar2 != null) {
                int i4 = a.f17077c[encodeStrategy.ordinal()];
                if (i4 == 1) {
                    dVar = new com.bumptech.glide.load.engine.d(this.f17072x, this.f17057i);
                } else if (i4 == 2) {
                    dVar = new w(this.f17049a.b(), this.f17072x, this.f17057i, this.f17060l, this.f17061m, iVar, cls, this.f17063o);
                } else {
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                }
                t c4 = t.c(uVar2);
                this.f17054f.d(dVar, hVar2, c4);
                return c4;
            }
            throw new Registry.NoResultEncoderAvailableException(uVar2.get().getClass());
        }
        return uVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z3) {
        if (this.f17055g.d(z3)) {
            w();
        }
    }
}
