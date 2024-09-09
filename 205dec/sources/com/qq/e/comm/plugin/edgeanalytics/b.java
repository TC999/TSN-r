package com.qq.e.comm.plugin.edgeanalytics;

import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.dynamic.c;
import com.qq.e.comm.plugin.edgeanalytics.h.b.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    private static volatile b f42941i;

    /* renamed from: a  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.edgeanalytics.h.a.b f42942a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.edgeanalytics.h.b.a f42943b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f42944c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.dynamic.b f42945d;

    /* renamed from: e  reason: collision with root package name */
    private IEAB f42946e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, l> f42947f;

    /* renamed from: g  reason: collision with root package name */
    private volatile AtomicBoolean f42948g = null;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f42949h = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.g f42950c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f42951d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ JSONObject f42952e;

        a(b bVar, com.qq.e.comm.plugin.edgeanalytics.g gVar, boolean z3, JSONObject jSONObject) {
            this.f42950c = gVar;
            this.f42951d = z3;
            this.f42952e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42950c.a(this.f42951d, this.f42952e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.edgeanalytics.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0812b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.g f42953c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f42954d;

        RunnableC0812b(b bVar, com.qq.e.comm.plugin.edgeanalytics.g gVar, int i4) {
            this.f42953c = gVar;
            this.f42954d = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42953c.a(this.f42954d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements ThreadFactory {
        c(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_EA_THREAD");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f42943b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends com.qq.e.comm.plugin.edgeanalytics.f {
        e(com.qq.e.comm.plugin.edgeanalytics.h.a.b bVar) {
            super(bVar);
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.f, com.qq.e.comm.plugin.edgeanalytics.IEAB
        public String oc(String str, String str2, String str3) {
            String oc = super.oc(str, str2, str3);
            l lVar = (l) b.this.f42947f.get(str);
            if (lVar != null) {
                d1.a("GDTEAM", "evaluateScript result %s", oc);
                lVar.f42983d = oc;
            }
            return oc;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.c f42957c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f42958d;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                b.this.a(fVar.f42957c, fVar.f42958d);
            }
        }

        f(com.qq.e.comm.plugin.edgeanalytics.c cVar, JSONObject jSONObject) {
            this.f42957c = cVar;
            this.f42958d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f42944c.submit(new a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.c f42961c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f42962d;

        g(com.qq.e.comm.plugin.edgeanalytics.c cVar, JSONObject jSONObject) {
            this.f42961c = cVar;
            this.f42962d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f42961c, this.f42962d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class h implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.c f42964a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f42965b;

        h(com.qq.e.comm.plugin.edgeanalytics.c cVar, JSONObject jSONObject) {
            this.f42964a = cVar;
            this.f42965b = jSONObject;
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.h.b.a.c
        public void a(String str, byte[] bArr) {
            b.this.a(this.f42964a, str, bArr, this.f42965b);
        }

        @Override // com.qq.e.comm.plugin.edgeanalytics.h.b.a.c
        public void a(int i4, String str) {
            b.this.a(this.f42964a, 2, String.valueOf(i4), str);
            d1.a("GDTEAM", "onLoadFailed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.c f42967c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f42968d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ byte[] f42969e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONObject f42970f;

        i(com.qq.e.comm.plugin.edgeanalytics.c cVar, String str, byte[] bArr, JSONObject jSONObject) {
            this.f42967c = cVar;
            this.f42968d = str;
            this.f42969e = bArr;
            this.f42970f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f42967c, this.f42968d, this.f42969e, this.f42970f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j implements c.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.c f42972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f42973b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f42974c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f42975d;

        j(com.qq.e.comm.plugin.edgeanalytics.c cVar, String str, byte[] bArr, JSONObject jSONObject) {
            this.f42972a = cVar;
            this.f42973b = str;
            this.f42974c = bArr;
            this.f42975d = jSONObject;
        }

        @Override // com.qq.e.comm.dynamic.c.e
        public void c() {
            d1.a("GDTEAM", "ScriptEngineLibManager prepared");
            b.this.a(this.f42972a, this.f42973b, this.f42974c, this.f42975d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class k implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f42977c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.edgeanalytics.c f42978d;

        k(AtomicBoolean atomicBoolean, com.qq.e.comm.plugin.edgeanalytics.c cVar) {
            this.f42977c = atomicBoolean;
            this.f42978d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42977c.set(true);
            b bVar = b.this;
            com.qq.e.comm.plugin.edgeanalytics.c cVar = this.f42978d;
            bVar.a(cVar, 4, String.valueOf(cVar.k()), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        private com.qq.e.comm.plugin.edgeanalytics.c f42980a;

        /* renamed from: b  reason: collision with root package name */
        private Runnable f42981b;

        /* renamed from: c  reason: collision with root package name */
        private AtomicBoolean f42982c;

        /* renamed from: d  reason: collision with root package name */
        private String f42983d;

        /* renamed from: e  reason: collision with root package name */
        private long f42984e;

        /* renamed from: f  reason: collision with root package name */
        private long f42985f;

        /* synthetic */ l(com.qq.e.comm.plugin.edgeanalytics.c cVar, c cVar2) {
            this(cVar);
        }

        private l(com.qq.e.comm.plugin.edgeanalytics.c cVar) {
            this.f42982c = new AtomicBoolean(false);
            this.f42980a = cVar;
        }
    }

    private b() {
    }

    private boolean e() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("emanaed", 0);
        d1.a("GDTEAM", "prepare config " + a4);
        if (a4 == 1) {
            return true;
        }
        if (a4 == 0) {
            if (this.f42948g == null) {
                this.f42948g = new AtomicBoolean(true);
            }
        } else if (a4 == -1) {
            com.qq.e.comm.plugin.edgeanalytics.h.a.b.a();
        }
        return false;
    }

    public synchronized void d() {
        if (!this.f42949h.get() && e()) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new c(this));
            this.f42944c = newSingleThreadScheduledExecutor;
            this.f42942a = new com.qq.e.comm.plugin.edgeanalytics.h.a.b(newSingleThreadScheduledExecutor);
            this.f42946e = a();
            this.f42947f = new ConcurrentHashMap();
            this.f42943b = new com.qq.e.comm.plugin.edgeanalytics.h.b.a();
            this.f42944c.submit(new d());
            this.f42949h.set(true);
        }
    }

    public static b c() {
        if (f42941i == null) {
            synchronized (b.class) {
                if (f42941i == null) {
                    f42941i = new b();
                }
            }
        }
        return f42941i;
    }

    public void b() {
        if (this.f42948g == null || !this.f42948g.compareAndSet(true, false)) {
            return;
        }
        d1.a("GDTEAM", "delayInit");
        d();
    }

    private IEAB a() {
        return new e(this.f42942a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.edgeanalytics.c cVar, JSONObject jSONObject) {
        l lVar = this.f42947f.get(cVar.g());
        if (lVar != null) {
            lVar.f42984e = System.currentTimeMillis();
        }
        if (cVar.n() && a(cVar, this.f42945d)) {
            b(cVar, (String) null, (byte[]) null, jSONObject);
            return;
        }
        a("ea execute %s", cVar.g());
        this.f42943b.a(cVar.i(), cVar.o(), new h(cVar, jSONObject));
    }

    private void b(com.qq.e.comm.plugin.edgeanalytics.c cVar, int i4, String str, String str2) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (!TextUtils.isEmpty(str)) {
            dVar.a("msg", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.a("data2", str2);
        }
        dVar.a("data", cVar.i());
        v.a(9900001, null, Integer.valueOf(cVar.b()), Integer.valueOf(i4), dVar);
    }

    private void c(com.qq.e.comm.plugin.edgeanalytics.c cVar) {
        l remove = this.f42947f.remove(cVar.g());
        if (remove == null) {
            return;
        }
        a(remove);
        p0.e(remove.f42981b);
        if (remove.f42982c.get() || remove.f42980a.d() == null) {
            return;
        }
        a(remove, true, new j0(remove.f42983d).a());
    }

    public boolean e(com.qq.e.comm.plugin.edgeanalytics.c cVar) {
        d1.a("GDTEAM", "startAnalyze ");
        if (this.f42949h.get() && cVar.m()) {
            l lVar = this.f42947f.get(cVar.g());
            if (lVar != null) {
                lVar.f42980a.a(cVar.d());
                return true;
            }
            JSONObject a4 = a(cVar);
            l lVar2 = new l(cVar, null);
            if (this.f42942a.a(a4, cVar.e())) {
                a(lVar2, false, a4);
                return true;
            }
            this.f42947f.put(cVar.g(), lVar2);
            if (cVar.j() < 0) {
                p0.c(new f(cVar, a4));
            } else {
                this.f42944c.schedule(new g(cVar, a4), cVar.j(), TimeUnit.MILLISECONDS);
            }
            return true;
        }
        d1.b("GDTEAM", "startAnalyze return false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.qq.e.comm.plugin.edgeanalytics.c cVar, String str, byte[] bArr, JSONObject jSONObject) {
        String a4;
        if (!com.qq.e.comm.dynamic.c.a().d()) {
            com.qq.e.comm.dynamic.c.a().a((c.e) new j(cVar, str, bArr, jSONObject), false);
            return;
        }
        l lVar = this.f42947f.get(cVar.g());
        if (lVar != null) {
            lVar.f42985f = System.currentTimeMillis();
        }
        com.qq.e.comm.dynamic.b b4 = b(cVar);
        if (b4 == null) {
            d1.b("GDTEAM", "ScriptEngine create failed");
            a(cVar, 3);
        } else if (!d(cVar)) {
            a(cVar, 5);
        } else {
            boolean n4 = cVar.n();
            int i4 = 1;
            try {
                if (TextUtils.isEmpty(str) && bArr == null) {
                    a4 = cVar.a(jSONObject);
                } else if (cVar.o()) {
                    if (bArr == null) {
                        try {
                            bArr = a(b4, cVar.i(), cVar.a(str, jSONObject, false));
                        }
                    }
                    if (bArr != null) {
                        b4.a(bArr);
                        a4 = cVar.a(jSONObject);
                    } else {
                        a4 = cVar.a(str, jSONObject, true);
                    }
                } else {
                    a4 = cVar.a(str, jSONObject, true);
                }
                d1.a("GDTEAM", "evaluate %s", a4);
                b4.b(a4);
                c(cVar);
                d1.a("GDTEAM", "evaluateScript finished");
            } catch (Throwable th) {
                if (n4) {
                    try {
                        b4.a();
                        this.f42945d = null;
                    } finally {
                        if (!n4) {
                            b4.a();
                        }
                    }
                }
                String stackTraceString = Log.getStackTraceString(th);
                if (!TextUtils.isEmpty(stackTraceString) && stackTraceString.length() > 256) {
                    stackTraceString = stackTraceString.substring(0, 256);
                }
                if (0 != 0) {
                    i4 = 0;
                }
                a(cVar, i4, th.getMessage(), stackTraceString);
                d1.a("GDTEAM", th.getMessage(), th);
                if (n4) {
                    return;
                }
                b4.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.edgeanalytics.c cVar, String str, byte[] bArr, JSONObject jSONObject) {
        if ("GDT_EA_THREAD".equals(Thread.currentThread().getName())) {
            b(cVar, str, bArr, jSONObject);
        } else {
            this.f42944c.submit(new i(cVar, str, bArr, jSONObject));
        }
    }

    private boolean d(com.qq.e.comm.plugin.edgeanalytics.c cVar) {
        l lVar = this.f42947f.get(cVar.g());
        if (lVar == null) {
            return false;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        k kVar = new k(atomicBoolean, cVar);
        lVar.f42982c = atomicBoolean;
        lVar.f42981b = kVar;
        if (cVar.k() > 0) {
            p0.a(kVar, cVar.k());
            return true;
        }
        return true;
    }

    private byte[] a(com.qq.e.comm.dynamic.b bVar, String str, String str2) throws Throwable {
        byte[] a4 = bVar.a(str2);
        if (a4 == null || a4.length == 0) {
            return null;
        }
        this.f42943b.a(str, a4);
        return a4;
    }

    private void a(l lVar, boolean z3, JSONObject jSONObject) {
        com.qq.e.comm.plugin.edgeanalytics.g d4 = lVar.f42980a.d();
        if (d4 == null) {
            return;
        }
        d1.a("GDTEAM", "callbackComplete:%s", jSONObject);
        p0.a((Runnable) new a(this, d4, z3, jSONObject));
    }

    private boolean a(com.qq.e.comm.plugin.edgeanalytics.c cVar, com.qq.e.comm.dynamic.b bVar) {
        if (bVar == null) {
            return false;
        }
        String h4 = cVar.h();
        try {
            Object b4 = bVar.b("typeof(" + h4 + ")=='function' && " + h4 + "!= null;");
            d1.a("GDTEAM", "hasFunction %s,%s", h4, b4);
            if (b4 instanceof Boolean) {
                return ((Boolean) b4).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            d1.a("GDTEAM", th.getMessage(), th);
            return false;
        }
    }

    private void a(l lVar) {
        int f4 = lVar.f42980a.f();
        if (f4 > 0 && lVar.f42984e > 0 && lVar.f42985f > 0) {
            long currentTimeMillis = System.currentTimeMillis() - lVar.f42984e;
            long currentTimeMillis2 = System.currentTimeMillis() - lVar.f42985f;
            d1.a("GDTEAM", "time cost %d:%d,%d", Integer.valueOf(f4), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2));
            com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(9900001);
            hVar.b(f4);
            hVar.b(currentTimeMillis);
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("du", Long.valueOf(currentTimeMillis2));
            hVar.a(dVar);
            v.a(hVar);
            com.qq.e.comm.plugin.n0.h hVar2 = new com.qq.e.comm.plugin.n0.h(9900002);
            hVar2.b(f4);
            hVar2.b(currentTimeMillis2);
            com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
            dVar2.a("du", Long.valueOf(currentTimeMillis));
            hVar2.a(dVar2);
            v.a(hVar2);
        }
    }

    private void a(com.qq.e.comm.plugin.edgeanalytics.c cVar, int i4) {
        a(cVar, i4, (String) null, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.edgeanalytics.c cVar, int i4, String str, String str2) {
        d1.b("GDTEAM", "callbackFailed " + cVar.d());
        this.f42947f.remove(cVar.g());
        b(cVar, i4, str, str2);
        com.qq.e.comm.plugin.edgeanalytics.g d4 = cVar.d();
        if (d4 == null) {
            return;
        }
        p0.a((Runnable) new RunnableC0812b(this, d4, i4));
    }

    public JSONObject a(com.qq.e.comm.plugin.edgeanalytics.c cVar) {
        if (this.f42942a == null) {
            return null;
        }
        JSONObject a4 = this.f42942a.a(cVar.g(), cVar.a(), cVar.l());
        return (a4 != null || cVar.c() == null) ? a4 : cVar.c();
    }

    public void a(String str) {
        if (this.f42942a == null) {
            return;
        }
        this.f42942a.c(str);
    }

    public void a(com.qq.e.comm.plugin.n0.e eVar, boolean z3) {
        if (this.f42942a != null) {
            this.f42942a.a(eVar, z3);
        }
    }

    private void a(String str, Object... objArr) {
        if (com.qq.e.comm.plugin.d0.a.d().f().a("eaplir", 0) == 0) {
            return;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        GDTLogger.w(str);
    }

    private com.qq.e.comm.dynamic.b b(com.qq.e.comm.plugin.edgeanalytics.c cVar) {
        com.qq.e.comm.dynamic.b bVar;
        boolean n4 = cVar.n();
        if (!n4 || (bVar = this.f42945d) == null) {
            com.qq.e.comm.dynamic.b a4 = com.qq.e.comm.dynamic.b.a(1);
            if (a4 != null) {
                a4.a("GDTEAB", IEAB.class, this.f42946e);
            }
            if (n4) {
                this.f42945d = a4;
            }
            return a4;
        }
        return bVar;
    }
}
