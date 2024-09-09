package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.util.pool.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Engine.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k implements m, j.a, p.a {

    /* renamed from: i  reason: collision with root package name */
    private static final String f17108i = "Engine";

    /* renamed from: j  reason: collision with root package name */
    private static final int f17109j = 150;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f17110k = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final r f17111a;

    /* renamed from: b  reason: collision with root package name */
    private final o f17112b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.j f17113c;

    /* renamed from: d  reason: collision with root package name */
    private final b f17114d;

    /* renamed from: e  reason: collision with root package name */
    private final x f17115e;

    /* renamed from: f  reason: collision with root package name */
    private final c f17116f;

    /* renamed from: g  reason: collision with root package name */
    private final a f17117g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a f17118h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final h.e f17119a;

        /* renamed from: b  reason: collision with root package name */
        final Pools.Pool<h<?>> f17120b = com.bumptech.glide.util.pool.a.e(150, new C0172a());

        /* renamed from: c  reason: collision with root package name */
        private int f17121c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.k$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0172a implements a.d<h<?>> {
            C0172a() {
            }

            @Override // com.bumptech.glide.util.pool.a.d
            /* renamed from: b */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f17119a, aVar.f17120b);
            }
        }

        a(h.e eVar) {
            this.f17119a = eVar;
        }

        <R> h<R> a(com.bumptech.glide.f fVar, Object obj, n nVar, com.bumptech.glide.load.c cVar, int i4, int i5, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z3, boolean z4, boolean z5, com.bumptech.glide.load.f fVar2, h.b<R> bVar) {
            h hVar = (h) com.bumptech.glide.util.j.d(this.f17120b.acquire());
            int i6 = this.f17121c;
            this.f17121c = i6 + 1;
            return hVar.m(fVar, obj, nVar, cVar, i4, i5, cls, cls2, priority, jVar, map, z3, z4, z5, fVar2, bVar, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Engine.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f17123a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f17124b;

        /* renamed from: c  reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f17125c;

        /* renamed from: d  reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f17126d;

        /* renamed from: e  reason: collision with root package name */
        final m f17127e;

        /* renamed from: f  reason: collision with root package name */
        final Pools.Pool<l<?>> f17128f = com.bumptech.glide.util.pool.a.e(150, new a());

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: Engine.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class a implements a.d<l<?>> {
            a() {
            }

            @Override // com.bumptech.glide.util.pool.a.d
            /* renamed from: b */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f17123a, bVar.f17124b, bVar.f17125c, bVar.f17126d, bVar.f17127e, bVar.f17128f);
            }
        }

        b(com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, m mVar) {
            this.f17123a = aVar;
            this.f17124b = aVar2;
            this.f17125c = aVar3;
            this.f17126d = aVar4;
            this.f17127e = mVar;
        }

        <R> l<R> a(com.bumptech.glide.load.c cVar, boolean z3, boolean z4, boolean z5, boolean z6) {
            return ((l) com.bumptech.glide.util.j.d(this.f17128f.acquire())).l(cVar, z3, z4, z5, z6);
        }

        @VisibleForTesting
        void b() {
            com.bumptech.glide.util.d.c(this.f17123a);
            com.bumptech.glide.util.d.c(this.f17124b);
            com.bumptech.glide.util.d.c(this.f17125c);
            com.bumptech.glide.util.d.c(this.f17126d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Engine.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class c implements h.e {

        /* renamed from: a  reason: collision with root package name */
        private final a.InterfaceC0166a f17130a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.cache.a f17131b;

        c(a.InterfaceC0166a interfaceC0166a) {
            this.f17130a = interfaceC0166a;
        }

        @Override // com.bumptech.glide.load.engine.h.e
        public com.bumptech.glide.load.engine.cache.a a() {
            if (this.f17131b == null) {
                synchronized (this) {
                    if (this.f17131b == null) {
                        this.f17131b = this.f17130a.build();
                    }
                    if (this.f17131b == null) {
                        this.f17131b = new com.bumptech.glide.load.engine.cache.b();
                    }
                }
            }
            return this.f17131b;
        }

        @VisibleForTesting
        synchronized void b() {
            if (this.f17131b == null) {
                return;
            }
            this.f17131b.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Engine.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private final l<?> f17132a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.request.i f17133b;

        d(com.bumptech.glide.request.i iVar, l<?> lVar) {
            this.f17133b = iVar;
            this.f17132a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f17132a.s(this.f17133b);
            }
        }
    }

    public k(com.bumptech.glide.load.engine.cache.j jVar, a.InterfaceC0166a interfaceC0166a, com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, boolean z3) {
        this(jVar, interfaceC0166a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z3);
    }

    private p<?> f(com.bumptech.glide.load.c cVar) {
        u<?> e4 = this.f17113c.e(cVar);
        if (e4 == null) {
            return null;
        }
        if (e4 instanceof p) {
            return (p) e4;
        }
        return new p<>(e4, true, true);
    }

    @Nullable
    private p<?> h(com.bumptech.glide.load.c cVar, boolean z3) {
        if (z3) {
            p<?> e4 = this.f17118h.e(cVar);
            if (e4 != null) {
                e4.a();
            }
            return e4;
        }
        return null;
    }

    private p<?> i(com.bumptech.glide.load.c cVar, boolean z3) {
        if (z3) {
            p<?> f4 = f(cVar);
            if (f4 != null) {
                f4.a();
                this.f17118h.a(cVar, f4);
            }
            return f4;
        }
        return null;
    }

    private static void j(String str, long j4, com.bumptech.glide.load.c cVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.util.f.a(j4) + "ms, key: " + cVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.j.a
    public void a(@NonNull u<?> uVar) {
        this.f17115e.a(uVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void b(l<?> lVar, com.bumptech.glide.load.c cVar, p<?> pVar) {
        if (pVar != null) {
            pVar.f(cVar, this);
            if (pVar.d()) {
                this.f17118h.a(cVar, pVar);
            }
        }
        this.f17111a.e(cVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void c(l<?> lVar, com.bumptech.glide.load.c cVar) {
        this.f17111a.e(cVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.p.a
    public synchronized void d(com.bumptech.glide.load.c cVar, p<?> pVar) {
        this.f17118h.d(cVar);
        if (pVar.d()) {
            this.f17113c.d(cVar, pVar);
        } else {
            this.f17115e.a(pVar);
        }
    }

    public void e() {
        this.f17116f.a().clear();
    }

    public synchronized <R> d g(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.c cVar, int i4, int i5, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z3, boolean z4, com.bumptech.glide.load.f fVar2, boolean z5, boolean z6, boolean z7, boolean z8, com.bumptech.glide.request.i iVar, Executor executor) {
        boolean z9 = f17110k;
        long b4 = z9 ? com.bumptech.glide.util.f.b() : 0L;
        n a4 = this.f17112b.a(obj, cVar, i4, i5, map, cls, cls2, fVar2);
        p<?> h4 = h(a4, z5);
        if (h4 != null) {
            iVar.c(h4, DataSource.MEMORY_CACHE);
            if (z9) {
                j("Loaded resource from active resources", b4, a4);
            }
            return null;
        }
        p<?> i6 = i(a4, z5);
        if (i6 != null) {
            iVar.c(i6, DataSource.MEMORY_CACHE);
            if (z9) {
                j("Loaded resource from cache", b4, a4);
            }
            return null;
        }
        l<?> a5 = this.f17111a.a(a4, z8);
        if (a5 != null) {
            a5.a(iVar, executor);
            if (z9) {
                j("Added to existing load", b4, a4);
            }
            return new d(iVar, a5);
        }
        l<R> a6 = this.f17114d.a(a4, z5, z6, z7, z8);
        h<R> a7 = this.f17117g.a(fVar, obj, a4, cVar, i4, i5, cls, cls2, priority, jVar, map, z3, z4, z8, fVar2, a6);
        this.f17111a.d(a4, a6);
        a6.a(iVar, executor);
        a6.t(a7);
        if (z9) {
            j("Started new load", b4, a4);
        }
        return new d(iVar, a6);
    }

    public void k(u<?> uVar) {
        if (uVar instanceof p) {
            ((p) uVar).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void l() {
        this.f17114d.b();
        this.f17116f.b();
        this.f17118h.h();
    }

    @VisibleForTesting
    k(com.bumptech.glide.load.engine.cache.j jVar, a.InterfaceC0166a interfaceC0166a, com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, r rVar, o oVar, com.bumptech.glide.load.engine.a aVar5, b bVar, a aVar6, x xVar, boolean z3) {
        this.f17113c = jVar;
        c cVar = new c(interfaceC0166a);
        this.f17116f = cVar;
        com.bumptech.glide.load.engine.a aVar7 = aVar5 == null ? new com.bumptech.glide.load.engine.a(z3) : aVar5;
        this.f17118h = aVar7;
        aVar7.g(this);
        this.f17112b = oVar == null ? new o() : oVar;
        this.f17111a = rVar == null ? new r() : rVar;
        this.f17114d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.f17117g = aVar6 == null ? new a(cVar) : aVar6;
        this.f17115e = xVar == null ? new x() : xVar;
        jVar.f(this);
    }
}
