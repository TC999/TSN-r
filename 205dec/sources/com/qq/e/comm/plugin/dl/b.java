package com.qq.e.comm.plugin.dl;

import com.qq.e.comm.plugin.util.p0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b implements com.qq.e.dl.c {

    /* renamed from: c  reason: collision with root package name */
    protected com.qq.e.comm.plugin.g0.e f42364c;

    /* renamed from: d  reason: collision with root package name */
    protected com.qq.e.comm.plugin.k0.b f42365d;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f42367f;

    /* renamed from: g  reason: collision with root package name */
    protected com.qq.e.dl.l.h f42368g;

    /* renamed from: h  reason: collision with root package name */
    protected com.qq.e.dl.l.j.c f42369h;

    /* renamed from: i  reason: collision with root package name */
    protected WeakReference<com.qq.e.dl.l.d> f42370i;

    /* renamed from: j  reason: collision with root package name */
    protected long f42371j;

    /* renamed from: k  reason: collision with root package name */
    protected long f42372k;

    /* renamed from: l  reason: collision with root package name */
    protected int f42373l;

    /* renamed from: m  reason: collision with root package name */
    protected int f42374m;

    /* renamed from: e  reason: collision with root package name */
    protected final Map<com.qq.e.dl.l.h, com.qq.e.dl.l.j.c> f42366e = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    protected long f42375n = 0;

    /* renamed from: o  reason: collision with root package name */
    protected float f42376o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f42377p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.dl.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0801b implements Runnable {
        RunnableC0801b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.k0.b bVar = b.this.f42365d;
            if (bVar == null || !bVar.isComplete()) {
                return;
            }
            b bVar2 = b.this;
            com.qq.e.comm.plugin.k0.c.a(bVar2.f42364c, bVar2.f42365d, "\u5ef6\u8fdf\u91cd\u7f6e");
            b.this.f42365d.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (com.qq.e.comm.plugin.k0.c.a(this.f42366e.keySet(), this.f42374m, this.f42373l) != null) {
            j();
        } else {
            i();
        }
        if (this.f42365d == null) {
            return;
        }
        p0.a(new a(), this.f42371j);
    }

    private void e() {
        p0.a(new RunnableC0801b(), this.f42372k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.dl.l.j.c f() {
        com.qq.e.dl.l.j.c cVar = this.f42366e.get(this.f42368g);
        return cVar == null ? this.f42369h : cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f42371j = com.qq.e.comm.plugin.k0.c.a(this.f42364c);
        this.f42372k = com.qq.e.comm.plugin.k0.c.i(this.f42364c);
        this.f42373l = com.qq.e.comm.plugin.k0.c.c(this.f42364c);
        this.f42374m = com.qq.e.comm.plugin.k0.c.l(this.f42364c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        if (com.qq.e.comm.plugin.k0.c.a(this.f42372k)) {
            com.qq.e.comm.plugin.k0.c.a(this.f42364c, this.f42365d, "\u6447\u4e00\u6447/\u626d\u4e00\u626d\u8fc7\u4e8e\u9891\u7e41\u88ab\u62e6\u622a");
            return false;
        }
        com.qq.e.dl.l.h a4 = com.qq.e.comm.plugin.k0.c.a(this.f42366e.keySet(), this.f42374m, this.f42373l);
        this.f42368g = a4;
        if (a4 == null) {
            com.qq.e.comm.plugin.k0.c.a(this.f42364c, this.f42365d, "\u6447\u4e00\u6447/\u626d\u4e00\u626d\u4e0d\u53ef\u89c1\u88ab\u62e6\u622a");
            i();
            return false;
        }
        com.qq.e.comm.plugin.k0.c.a(this.f42364c, this.f42365d, "\u6447\u4e00\u6447/\u626d\u4e00\u626d\u5b8c\u6210");
        com.qq.e.comm.plugin.k0.c.d();
        e();
        return true;
    }

    public void i() {
        com.qq.e.comm.plugin.k0.b bVar = this.f42365d;
        if (bVar != null) {
            com.qq.e.comm.plugin.k0.c.b(this.f42364c, bVar, "try pauseAndReset");
            if (this.f42365d.pause()) {
                this.f42365d.reset();
                com.qq.e.comm.plugin.k0.c.a(this.f42364c, this.f42365d, "pauseAndReset success");
            }
        }
    }

    public void j() {
        com.qq.e.comm.plugin.k0.b bVar = this.f42365d;
        if (bVar != null) {
            com.qq.e.comm.plugin.k0.c.b(this.f42364c, bVar, "try resume");
            if (this.f42365d.resume()) {
                com.qq.e.comm.plugin.k0.c.a(this.f42364c, this.f42365d, "resume success");
            }
        }
    }

    @Override // com.qq.e.dl.c
    public void start() {
        WeakReference<com.qq.e.dl.l.d> weakReference;
        if (this.f42365d != null || this.f42366e.isEmpty() || (weakReference = this.f42370i) == null || weakReference.get() == null || this.f42369h == null) {
            return;
        }
        g();
        com.qq.e.comm.plugin.k0.b bVar = this.f42365d;
        if (bVar != null) {
            bVar.start();
            d();
        }
    }

    @Override // com.qq.e.dl.c
    public void stop() {
        com.qq.e.comm.plugin.k0.b bVar = this.f42365d;
        if (bVar != null) {
            com.qq.e.comm.plugin.k0.c.a(this.f42364c, bVar, "stop");
            this.f42365d.stop();
            this.f42365d = null;
        }
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f42364c = eVar;
    }

    @Override // com.qq.e.dl.c
    public void a(com.qq.e.dl.l.h hVar, com.qq.e.dl.l.j.c cVar, com.qq.e.dl.l.d dVar) {
        if (hVar == null || cVar == null || dVar == null) {
            return;
        }
        com.qq.e.comm.plugin.k0.c.a(this.f42364c, (com.qq.e.comm.plugin.k0.b) null, "init");
        this.f42366e.put(hVar, cVar);
        if (cVar.f47127h) {
            this.f42367f = true;
        }
        if (this.f42369h == null) {
            this.f42369h = cVar;
        }
        if (this.f42370i == null) {
            this.f42370i = new WeakReference<>(dVar);
        }
    }
}
