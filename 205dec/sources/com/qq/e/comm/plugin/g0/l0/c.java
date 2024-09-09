package com.qq.e.comm.plugin.g0.l0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.g0.l0.e;
import com.qq.e.comm.plugin.g0.l0.f.c;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.h0;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.w0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c<T extends com.qq.e.comm.plugin.g0.e> {

    /* renamed from: o  reason: collision with root package name */
    public static final String f43616o = "c";

    /* renamed from: p  reason: collision with root package name */
    private static final ConcurrentHashMap<String, c> f43617p = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.l0.f.c f43618a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.l0.e f43619b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.b.g f43620c;

    /* renamed from: g  reason: collision with root package name */
    private boolean f43624g;

    /* renamed from: h  reason: collision with root package name */
    private int f43625h;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f43628k;

    /* renamed from: l  reason: collision with root package name */
    private i f43629l;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f43621d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f43622e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f43623f = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    private int f43626i = -1;

    /* renamed from: j  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, c<T>.j> f43627j = new ConcurrentHashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private com.qq.e.comm.plugin.edgeanalytics.g f43630m = null;

    /* renamed from: n  reason: collision with root package name */
    private boolean f43631n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements c.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.f f43632a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f43633b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43634c;

        a(c.f fVar, m mVar, com.qq.e.comm.plugin.n0.c cVar) {
            this.f43632a = fVar;
            this.f43633b = mVar;
            this.f43634c = cVar;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.f.c.f
        public void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, int i4) {
            d1.a(c.f43616o, "onRemoved, \u6570\u636e\u5220\u9664\u540e\u7f13\u5b58\u6c60\u8fd8\u5269\u4f59 %s \u6761\u6570\u636e", Integer.valueOf(i4));
            c.f fVar = this.f43632a;
            if (fVar != null) {
                fVar.a(dVar, bVar, i4);
            }
            if (c.this.f43618a.a(c.this.f43628k)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c.this.f43628k);
                c.this.f43629l.a(arrayList);
                c.this.f43628k = null;
            }
            c.this.f43622e.set(false);
            if (c.this.f43623f.get()) {
                d1.a(c.f43616o, "onRemoved, \u73b0\u5728\u9700\u8981\u68c0\u67e5\u662f\u5426\u9700\u8981\u9884\u52a0\u8f7d");
                c.this.f43623f.set(false);
                c.this.b(dVar, bVar, this.f43633b, this.f43634c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.g0.l0.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0835c implements c.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f43641a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43642b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f43643c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.d f43644d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43645e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f43646f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f43647g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.s.b f43648h;

        C0835c(int i4, com.qq.e.comm.plugin.b.d dVar, h hVar, com.qq.e.comm.plugin.n0.d dVar2, com.qq.e.comm.plugin.n0.c cVar, boolean z3, int i5, com.qq.e.comm.plugin.s.b bVar) {
            this.f43641a = i4;
            this.f43642b = dVar;
            this.f43643c = hVar;
            this.f43644d = dVar2;
            this.f43645e = cVar;
            this.f43646f = z3;
            this.f43647g = i5;
            this.f43648h = bVar;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.f.c.d
        public void a(com.qq.e.comm.plugin.g0.l0.f.d dVar) {
            int i4;
            if (!c.this.a(Integer.valueOf(this.f43641a)).b()) {
                com.qq.e.comm.plugin.g0.l0.b.a(this.f43642b, c.this.f43620c, 7);
                return;
            }
            c.this.a(Integer.valueOf(this.f43641a), 4);
            dVar.a(System.currentTimeMillis());
            d1.a(c.f43616o, "onAdLoaded, \u8fd4\u56de\u672c\u5730\u7f13\u5b58\u6570\u636e");
            com.qq.e.comm.plugin.g0.e a4 = this.f43643c.a(dVar.b());
            a4.b(true);
            this.f43644d.a("data", Integer.valueOf(a4.Z()));
            this.f43644d.a("data2", Integer.valueOf(a4.f1() ? 1 : 0));
            h0.a(a4);
            int Q = a4.Q();
            if (Q > 0) {
                i4 = Math.min(Q, c.this.f43618a.e() - 1);
                c.this.a(2, a4, Q == i4 ? 0 : 1);
            } else {
                i4 = 0;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                c cVar = c.this;
                cVar.a((c) a4, (h<c>) this.f43643c, cVar.f43618a.a(this.f43642b).b(), i5);
            }
            c.this.a((h<h>) this.f43643c, (h) a4, (com.qq.e.comm.plugin.s.b) null, Integer.valueOf(this.f43641a), this.f43642b);
            com.qq.e.comm.plugin.g0.l0.d.c(this.f43645e, c.this.f43625h, this.f43644d);
            if (this.f43646f) {
                v.a(1407020, this.f43645e, 0, this.f43644d);
            }
            com.qq.e.comm.plugin.g0.l0.d.a(this.f43645e, this.f43647g, this.f43644d);
            com.qq.e.comm.plugin.n0.h b4 = new com.qq.e.comm.plugin.n0.h(2301004).b(((System.currentTimeMillis() - a4.i()) / 1000) / 60).b(3);
            b4.a(this.f43645e);
            v.a(b4);
        }

        @Override // com.qq.e.comm.plugin.g0.l0.f.c.d
        public void b(com.qq.e.comm.plugin.g0.l0.f.d dVar) {
            if (!this.f43646f || c.this.a(Integer.valueOf(this.f43641a)).d()) {
                c.this.a(Integer.valueOf(this.f43641a), 3);
                d1.a(c.f43616o, "onNoAd, \u672c\u5730\u6ca1\u6709\u7f13\u5b58\u6570\u636e");
                com.qq.e.comm.plugin.g0.l0.d.a(this.f43645e, c.this.f43625h, dVar, this.f43644d);
                if (this.f43646f) {
                    v.a(1407019, this.f43645e, 0, this.f43644d);
                }
                c.this.a(this.f43643c, (h) null, this.f43648h, Integer.valueOf(this.f43641a), this.f43642b);
                return;
            }
            c.this.a(Integer.valueOf(this.f43641a), 3);
            com.qq.e.comm.plugin.g0.l0.b.a(this.f43642b, c.this.f43620c, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f43658c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43659d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f43660e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.s.b f43661f;

        e(h hVar, com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.s.b bVar) {
            this.f43658c = hVar;
            this.f43659d = dVar;
            this.f43660e = eVar;
            this.f43661f = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            h hVar = this.f43658c;
            if (hVar == 0) {
                d1.b(c.f43616o, "getAd callback is null");
                com.qq.e.comm.plugin.g0.l0.b.a(this.f43659d, c.this.f43620c, 2);
                return;
            }
            com.qq.e.comm.plugin.g0.e eVar = this.f43660e;
            if (eVar == null) {
                hVar.a(this.f43661f);
                com.qq.e.comm.plugin.g0.l0.b.a(this.f43659d, c.this.f43620c);
                return;
            }
            hVar.a((h) eVar);
            com.qq.e.comm.plugin.g0.l0.b.c(this.f43659d, c.this.f43620c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43663c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43664d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ h f43665e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43666f;

        f(int i4, com.qq.e.comm.plugin.b.d dVar, h hVar, com.qq.e.comm.plugin.n0.c cVar) {
            this.f43663c = i4;
            this.f43664d = dVar;
            this.f43665e = hVar;
            this.f43666f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a(c.f43616o, "\u89e6\u53d1\u5185\u90e8\u8d85\u65f6,\u68c0\u67e5\u672c\u5730\u7f13\u5b58\uff0cobjectId = %s ,", Integer.valueOf(this.f43663c));
            if (c.this.a()) {
                d1.a(c.f43616o, "\u89e6\u53d1\u5185\u90e8\u8d85\u65f6,\u672c\u5730\u6709\u7f13\u5b58\uff0c\u5f00\u59cb\u8bfb\u53d6\u7f13\u5b58\uff0cobjectId = %s ,", Integer.valueOf(this.f43663c));
                c.this.a(this.f43664d, (h) this.f43665e, this.f43666f, true, 1, new com.qq.e.comm.plugin.s.b("No Ad Error", 5004), this.f43663c);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface h<T extends com.qq.e.comm.plugin.g0.e> {
        T a(JSONObject jSONObject);

        void a(T t3);

        void a(com.qq.e.comm.plugin.s.b bVar);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface i {
        void a(List<JSONObject> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j {

        /* renamed from: a  reason: collision with root package name */
        private int f43678a;

        /* synthetic */ j(c cVar, int i4, a aVar) {
            this(cVar, i4);
        }

        private j(c cVar, int i4) {
            this.f43678a = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            return this.f43678a == 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            int i4 = this.f43678a;
            return i4 == 2 || i4 == 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            int i4 = this.f43678a;
            return i4 == 4 || i4 == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return this.f43678a == 7;
        }
    }

    private c(String str, com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.b.g gVar) {
        this.f43618a = new com.qq.e.comm.plugin.g0.l0.f.c(str, cVar, gVar);
        this.f43619b = new com.qq.e.comm.plugin.g0.l0.e(str);
        this.f43620c = gVar;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, com.qq.e.comm.plugin.n0.c cVar) {
        boolean z3 = false;
        if (com.qq.e.comm.plugin.t.c.a("tprwic", bVar.a().b(), dVar.w(), 0) == 0 && com.qq.e.comm.plugin.t.c.a(a(bVar), dVar.w(), 0, (b0) null) == 0) {
            if (this.f43618a.e() <= 0) {
                z3 = true;
            }
        } else {
            z3 = !this.f43618a.a(false);
        }
        if (z3) {
            dVar.b(this.f43625h);
            a(dVar, bVar, mVar, cVar, new AtomicInteger(1), false);
            return;
        }
        d1.a(f43616o, "preloadIfNeeded, \u4e0d\u9700\u8981\u9884\u52a0\u8f7d");
    }

    public c<T> b(int i4) {
        int c4 = com.qq.e.comm.plugin.edgeanalytics.e.c(this.f43620c);
        if (c4 <= 0) {
            c4 = i4;
        }
        this.f43626i = c4;
        String str = f43616o;
        d1.a(str, "timeoutPeriod value = " + i4);
        return this;
    }

    public void b() {
        this.f43618a.f();
    }

    public void b(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, com.qq.e.comm.plugin.n0.c cVar) {
        if (!this.f43624g) {
            d1.a(f43616o, "preloadIfNeeded, \u4e0d\u9700\u8981\u9884\u52a0\u8f7d");
        } else if (this.f43622e.get()) {
            d1.a(f43616o, "preloadIfNeeded, \u5f53\u524d\u6b63\u5728\u5220\u9664\u4e2d\uff0c\u7b49\u5220\u9664\u540e\u518d\u5224\u65ad\u662f\u5426\u9700\u8981\u9884\u52a0\u8f7d");
            this.f43623f.set(true);
        } else if (a(dVar, bVar, mVar, cVar)) {
        } else {
            d1.a(f43616o, "preloadByEA, \u8fd4\u56defalse");
            c(dVar, bVar, mVar, cVar);
        }
    }

    public static <T extends com.qq.e.comm.plugin.g0.e> c<T> a(String str, com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.b.g gVar) {
        c<T> cVar2 = f43617p.get(str);
        if (cVar2 == null) {
            f43617p.putIfAbsent(str, new c(str, cVar, gVar));
            return f43617p.get(str);
        }
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.edgeanalytics.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43637b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f43638c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ m f43639d;

        b(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.l0.b bVar, m mVar) {
            this.f43636a = dVar;
            this.f43637b = cVar;
            this.f43638c = bVar;
            this.f43639d = mVar;
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(boolean z3, JSONObject jSONObject) {
            c.this.f43631n = jSONObject.optInt("disable", 0) == 1;
            if (z3 && !c.this.f43631n) {
                int optInt = jSONObject.optInt("ltimes", -1);
                int optInt2 = jSONObject.optInt("lcnt", -1);
                if (optInt > 0 && optInt2 > 0) {
                    this.f43636a.b(optInt2);
                    v.a(1407023, this.f43637b, Integer.valueOf(optInt), Integer.valueOf(optInt2), null);
                    c.this.a(this.f43636a, this.f43638c, this.f43639d, this.f43637b, new AtomicInteger(optInt), true);
                    return;
                }
            }
            c.this.c(this.f43636a, this.f43638c, this.f43639d, this.f43637b);
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.g
        public void a(int i4) {
            c.this.c(this.f43636a, this.f43638c, this.f43639d, this.f43637b);
        }
    }

    public c<T> a(boolean z3) {
        this.f43624g = z3;
        return this;
    }

    public c<T> a(int i4) {
        int b4 = com.qq.e.comm.plugin.edgeanalytics.e.b(this.f43620c);
        if (b4 > 0) {
            i4 = b4;
        }
        this.f43625h = i4;
        return this;
    }

    private boolean b(com.qq.e.comm.plugin.l0.b bVar) {
        boolean z3;
        boolean z4;
        boolean c4 = this.f43618a.c();
        d1.a(f43616o, "\u672c\u5730\u7f13\u5b58\u521d\u59cb\u5316\u72b6\u6001: %s, ", Boolean.valueOf(c4));
        if (c4) {
            z3 = false;
        } else {
            z3 = com.qq.e.comm.plugin.t.c.a("iaraci", bVar.a().b(), bVar.b(), 0) != 0;
            if (z3) {
                z4 = true;
                d1.a(f43616o, "hitLocalCacheUninitialized, \u5f00\u5173\u72b6\u6001\uff1a %s, ", Boolean.valueOf(z3));
                return z4;
            }
        }
        z4 = false;
        d1.a(f43616o, "hitLocalCacheUninitialized, \u5f00\u5173\u72b6\u6001\uff1a %s, ", Boolean.valueOf(z3));
        return z4;
    }

    public c<T> a(i iVar) {
        this.f43629l = iVar;
        return this;
    }

    public void a(T t3, com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, c.f fVar, com.qq.e.comm.plugin.n0.c cVar) {
        if (t3 != null && t3.e1()) {
            d1.a(f43616o, "remove\uff0c\u5373\u5c06\u79fb\u9664 traceId = %s \u7684\u6570\u636e", t3.K0());
            this.f43622e.set(true);
            this.f43618a.a(t3.K0(), this.f43628k, dVar, bVar, new a(fVar, mVar, cVar));
            return;
        }
        d1.a(f43616o, "remove, \u6570\u636e\u4e3a\u7a7a\u6216\u975e\u9884\u52a0\u8f7d\uff0c\u65e0\u9700\u4ece\u7f13\u5b58\u6c60\u5220\u9664 ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f43650a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f43651b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f43652c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43653d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43654e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f43655f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ m f43656g;

        d(int i4, boolean z3, AtomicInteger atomicInteger, com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar) {
            this.f43650a = i4;
            this.f43651b = z3;
            this.f43652c = atomicInteger;
            this.f43653d = cVar;
            this.f43654e = dVar;
            this.f43655f = bVar;
            this.f43656g = mVar;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.e.b
        public void a(com.qq.e.comm.plugin.g0.l0.a aVar) {
            int size = aVar.a().size();
            d1.a(c.f43616o, "preLoad, hash = %s, \u7f13\u5b58\u6c60\u6dfb\u52a0 %s \u6761\u6570\u636e", Integer.valueOf(this.f43650a), Integer.valueOf(size));
            if (size > 0) {
                if (this.f43651b) {
                    c.this.f43618a.a(aVar, this.f43652c.get() == 1);
                } else {
                    c.this.f43618a.a(aVar);
                }
            }
            c.this.f43621d.set(false);
            d1.a(c.f43616o, "preLoad, hash = %s, \u8bbe\u7f6e\u72b6\u6001\u4e3a\u9884\u52a0\u8f7d\u7ed3\u675f", Integer.valueOf(this.f43650a));
            if (size > 0 && c.this.f43629l != null) {
                c.this.f43629l.a(aVar.a());
            }
            v.a(1407021, this.f43653d, 1, Integer.valueOf(size), null);
            if (this.f43652c.decrementAndGet() > 0) {
                c.this.a(this.f43654e, this.f43655f, this.f43656g, this.f43653d, this.f43652c, this.f43651b);
            }
        }

        @Override // com.qq.e.comm.plugin.g0.l0.e.b
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            if (this.f43651b) {
                c.this.f43618a.a(new com.qq.e.comm.plugin.g0.l0.a(new CopyOnWriteArrayList()), true);
            }
            c.this.f43621d.set(false);
            d1.a(c.f43616o, "preLoad, hash = %s, \u8bbe\u7f6e\u72b6\u6001\u4e3a\u9884\u52a0\u8f7d\u7ed3\u675f", Integer.valueOf(this.f43650a));
            int a4 = bVar != null ? bVar.a() : 0;
            d1.a(c.f43616o, "preLoad, hash = %s, \u9884\u52a0\u8f7d\u8bf7\u6c42\u5931\u8d25%d", Integer.valueOf(this.f43650a), Integer.valueOf(a4));
            v.a(1407021, this.f43653d, 2, Integer.valueOf(a4), null);
        }
    }

    private boolean a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, com.qq.e.comm.plugin.n0.c cVar) {
        if (this.f43631n) {
            return false;
        }
        String b4 = bVar.b();
        String b5 = com.qq.e.comm.plugin.edgeanalytics.d.b(this.f43620c, b4);
        if (!this.f43618a.c() || com.qq.e.comm.plugin.edgeanalytics.d.a(b5)) {
            return false;
        }
        int b6 = this.f43618a.b();
        com.qq.e.comm.plugin.edgeanalytics.c b7 = com.qq.e.comm.plugin.edgeanalytics.d.b(b5, this.f43620c, b4, new ArrayList(this.f43618a.a()), b6);
        b bVar2 = new b(dVar, cVar, bVar, mVar);
        this.f43630m = bVar2;
        b7.a(bVar2);
        com.qq.e.comm.plugin.edgeanalytics.b.c().e(b7);
        return true;
    }

    public void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, com.qq.e.comm.plugin.n0.c cVar, h<T> hVar) {
        com.qq.e.comm.plugin.g0.l0.b.b(dVar, this.f43620c);
        b();
        a(dVar, bVar, mVar, hVar, cVar);
    }

    void a(com.qq.e.comm.plugin.b.d dVar, h<T> hVar, com.qq.e.comm.plugin.n0.c cVar, boolean z3, int i4, com.qq.e.comm.plugin.s.b bVar, int i5) {
        a(Integer.valueOf(i5), 2);
        com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
        dVar2.a("du", Integer.valueOf(this.f43626i));
        com.qq.e.comm.plugin.g0.l0.d.b(cVar, this.f43625h, dVar2);
        this.f43618a.a(dVar, new C0835c(i5, dVar, hVar, dVar2, cVar, z3, i4, bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f43668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f43669b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43670c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f43671d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43672e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f43673f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f43674g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f43675h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ m f43676i;

        g(Runnable runnable, int i4, com.qq.e.comm.plugin.b.d dVar, h hVar, com.qq.e.comm.plugin.n0.c cVar, int i5, boolean z3, com.qq.e.comm.plugin.l0.b bVar, m mVar) {
            this.f43668a = runnable;
            this.f43669b = i4;
            this.f43670c = dVar;
            this.f43671d = hVar;
            this.f43672e = cVar;
            this.f43673f = i5;
            this.f43674g = z3;
            this.f43675h = bVar;
            this.f43676i = mVar;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.e.b
        public void a(com.qq.e.comm.plugin.g0.l0.a aVar) {
            int i4;
            d1.a(c.f43616o, "onAdLoaded, \u5b9e\u65f6\u8bf7\u6c42\u6210\u529f");
            CopyOnWriteArrayList<JSONObject> a4 = aVar.a();
            JSONObject jSONObject = !a4.isEmpty() ? a4.get(0) : null;
            Runnable runnable = this.f43668a;
            if (runnable != null) {
                p0.e(runnable);
                d1.a(c.f43616o, "onAdLoaded, \u505c\u6b62\u5185\u90e8\u8d85\u65f6\u68c0\u6d4b ");
            }
            if (c.this.a(Integer.valueOf(this.f43669b)).c()) {
                d1.a(c.f43616o, "onAdLoaded, objectId= %s , \u5df2\u89e6\u53d1\u5185\u90e8\u8d85\u65f6", Integer.valueOf(this.f43669b));
                if (jSONObject != null) {
                    c.this.f43618a.b(jSONObject);
                    com.qq.e.comm.plugin.g0.l0.b.a(this.f43670c, c.this.f43620c, 4);
                    return;
                }
                d1.a(c.f43616o, "onAdLoaded, \u5b9e\u65f6\u8bf7\u6c42\u7684\u56de\u5305\u4e3a null");
                com.qq.e.comm.plugin.g0.l0.b.a(this.f43670c, c.this.f43620c, 3);
            } else if (jSONObject != null) {
                c.this.a(Integer.valueOf(this.f43669b), 5);
                d1.a(c.f43616o, "onAdLoaded, \u8fd4\u56de\u5b9e\u65f6\u8bf7\u6c42\u5230\u7684\u6570\u636e");
                com.qq.e.comm.plugin.g0.e a5 = this.f43671d.a(jSONObject);
                int Q = a5.Q();
                if (Q > 0) {
                    i4 = Math.min(Q, a4.size() - 1);
                    c.this.a(1, a5, Q == i4 ? 0 : 1);
                } else {
                    i4 = 0;
                }
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = i5 + 1;
                    c.this.a((c) a5, (h<c>) this.f43671d, a4.get(i6), i5);
                    i5 = i6;
                }
                c.this.a((h<h>) this.f43671d, (h) a5, (com.qq.e.comm.plugin.s.b) null, Integer.valueOf(this.f43669b), this.f43670c);
                com.qq.e.comm.plugin.g0.l0.d.a(this.f43672e, c.this.f43624g, this.f43673f, this.f43674g, c.this.f43618a.e());
                if (a5 == null || !c.this.f43624g || this.f43674g || com.qq.e.comm.plugin.t.c.a("ipraars", this.f43670c.w(), 0, a5.p0()) == 0) {
                    return;
                }
                c.this.b(this.f43670c, this.f43675h, this.f43676i, this.f43672e);
            } else {
                a(new com.qq.e.comm.plugin.s.b("json error", 5000));
            }
        }

        @Override // com.qq.e.comm.plugin.g0.l0.e.b
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            d1.a(c.f43616o, "onNoAd\uff0c\u5b9e\u65f6\u8bf7\u6c42\u5931\u8d25");
            Runnable runnable = this.f43668a;
            if (runnable != null) {
                p0.e(runnable);
                d1.a(c.f43616o, "onNoAd\uff0c\u505c\u6b62\u5185\u90e8\u8d85\u65f6\u68c0\u6d4b");
            }
            j a4 = c.this.a(Integer.valueOf(this.f43669b));
            if (a4.c()) {
                com.qq.e.comm.plugin.g0.l0.b.a(this.f43670c, c.this.f43620c, 5);
            } else if (!a4.b()) {
                if (a4.a() && c.this.a()) {
                    d1.a(c.f43616o, "objectId= %s ,onNoAd\uff0c\u672a\u89e6\u53d1\u5185\u90e8\u8d85\u65f6,\u5c1d\u8bd5\u52a0\u8f7d\u7f13\u5b58", Integer.valueOf(this.f43669b));
                    c.this.a(this.f43670c, (h) this.f43671d, this.f43672e, false, 3, bVar, this.f43669b);
                    return;
                }
                d1.a(c.f43616o, "onNoAd\uff0c\u5b9e\u65f6\u8bf7\u6c42\u5931\u8d25\u4e14\u672c\u5730\u65e0\u7f13\u5b58\uff0c\u629b\u51fa\u5931\u8d25\u56de\u8c03");
                c.this.a(Integer.valueOf(this.f43669b), 6);
                c.this.a(this.f43671d, (h) null, bVar, Integer.valueOf(this.f43669b), this.f43670c);
            } else {
                c.this.a(Integer.valueOf(this.f43669b), 7);
                com.qq.e.comm.plugin.g0.l0.b.a(this.f43670c, c.this.f43620c, 6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, com.qq.e.comm.plugin.n0.c cVar, AtomicInteger atomicInteger, boolean z3) {
        int hashCode = dVar.hashCode();
        d1.a(f43616o, "preLoad, hash = %s, \u5c1d\u8bd5\u5f00\u59cb\u9884\u52a0\u8f7d\u5e7f\u544a%d", Integer.valueOf(hashCode), Integer.valueOf(atomicInteger.get()));
        if (this.f43621d.get()) {
            d1.a(f43616o, "preLoad\uff0chash = %s, \u5f53\u524d\u6b63\u5728\u8fdb\u884c\u9884\u52a0\u8f7d\u4e2d\uff0c\u65e0\u9700\u91cd\u590d\u9884\u52a0\u8f7d", Integer.valueOf(hashCode));
            return;
        }
        this.f43621d.set(true);
        d1.a(f43616o, "preLoad, hash = %s, \u8bbe\u7f6e\u72b6\u6001\u4e3a\u9884\u52a0\u8f7d\u4e2d", Integer.valueOf(hashCode));
        dVar.n(1);
        if (dVar.c() <= 0) {
            dVar.b(this.f43625h);
        }
        d1.a(f43616o, "preLoad, hash = %s, \u5f00\u59cb\u9884\u52a0\u8f7d, \u671f\u671b\u9884\u52a0\u8f7d\u6761\u6570%s", Integer.valueOf(hashCode), Integer.valueOf(dVar.c()));
        com.qq.e.comm.plugin.g0.l0.d.c(cVar);
        this.f43619b.a(dVar, bVar, mVar, new d(hashCode, z3, atomicInteger, cVar, dVar, bVar, mVar), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<T> hVar, T t3, com.qq.e.comm.plugin.s.b bVar, Integer num, com.qq.e.comm.plugin.b.d dVar) {
        if (this.f43627j.remove(num) == null) {
            com.qq.e.comm.plugin.g0.l0.b.a(dVar, this.f43620c, 1);
        } else {
            p0.a((Runnable) new e(hVar, dVar, t3, bVar));
        }
    }

    private void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, h<T> hVar, com.qq.e.comm.plugin.n0.c cVar) {
        f fVar;
        d1.a(f43616o, "\u9884\u52a0\u8f7d\u529f\u80fd\u5f00\u5173: %s, ", Boolean.valueOf(this.f43624g));
        int i4 = this.f43626i;
        d1.a(f43616o, "\u5185\u90e8\u8d85\u65f6\u65f6\u95f4: %s, ", Integer.valueOf(i4));
        boolean a4 = a();
        d1.a(f43616o, "\u662f\u5426\u6709\u7f13\u5b58 %s", Boolean.valueOf(a4));
        int a5 = w0.a();
        a(Integer.valueOf(a5), 1);
        if (this.f43624g && i4 > 0) {
            if (a4 || b(bVar)) {
                d1.a(f43616o, "\u542f\u52a8\u5185\u90e8\u8d85\u65f6\u68c0\u6d4b\uff0cobjectId = %s", Integer.valueOf(a5));
                f fVar2 = new f(a5, dVar, hVar, cVar);
                p0.a(fVar2, i4);
                fVar = fVar2;
                d1.a(f43616o, "\u53d1\u8d77\u5b9e\u65f6\u7f51\u7edc\u8bf7\u6c42");
                this.f43619b.a(dVar, bVar, mVar, new g(fVar, a5, dVar, hVar, cVar, i4, a4, bVar, mVar), cVar);
            }
        }
        fVar = null;
        d1.a(f43616o, "\u53d1\u8d77\u5b9e\u65f6\u7f51\u7edc\u8bf7\u6c42");
        this.f43619b.a(dVar, bVar, mVar, new g(fVar, a5, dVar, hVar, cVar, i4, a4, bVar, mVar), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c<T>.j a(Integer num) {
        c<T>.j jVar = this.f43627j.get(num);
        if (jVar == null) {
            return new j(this, 0, null);
        }
        d1.a(f43616o, "getStatus %d", Integer.valueOf(((j) jVar).f43678a));
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Integer num, int i4) {
        d1.a(f43616o, "setStatus %d", Integer.valueOf(i4));
        this.f43627j.put(num, new j(this, i4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        com.qq.e.comm.plugin.g0.l0.f.c cVar;
        return this.f43624g && (cVar = this.f43618a) != null && cVar.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T a(T t3, h<T> hVar, JSONObject jSONObject, int i4) {
        if (jSONObject == null) {
            return null;
        }
        T a4 = hVar.a(jSONObject);
        if (a4 != null && (a4.l1() || !TextUtils.isEmpty(a4.X()))) {
            t3.a(i4, a4);
        }
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, com.qq.e.comm.plugin.g0.e eVar, int i5) {
        v.a(9200016, com.qq.e.comm.plugin.n0.c.a(eVar), Integer.valueOf(i4), Integer.valueOf(i5), null);
    }

    private String a(com.qq.e.comm.plugin.l0.b bVar) {
        com.qq.e.comm.plugin.b.g a4;
        if (bVar != null && (a4 = bVar.a()) != null) {
            if (a4.j()) {
                return "tprwic_rv";
            }
            if (a4.g()) {
                return "tprwic_ifs";
            }
            if (a4.h()) {
                return "tprwic_ihs";
            }
        }
        return "";
    }
}
