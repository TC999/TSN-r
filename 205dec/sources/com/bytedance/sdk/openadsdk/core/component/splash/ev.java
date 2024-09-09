package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.bj;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.vc;
import com.bytedance.sdk.openadsdk.core.u.wv;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements n.c {

    /* renamed from: a  reason: collision with root package name */
    private long f32903a;
    private long bk;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private final n f32905f;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fp;
    private com.bytedance.sdk.openadsdk.ys.w.w.w fz;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr gb;
    private xv gd;

    /* renamed from: i  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd f32906i;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.f ia;

    /* renamed from: j  reason: collision with root package name */
    private bj f32907j;

    /* renamed from: k  reason: collision with root package name */
    private long f32908k;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr ls;

    /* renamed from: p  reason: collision with root package name */
    private c f32910p;

    /* renamed from: q  reason: collision with root package name */
    private bj f32911q;

    /* renamed from: r  reason: collision with root package name */
    private int f32912r;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev f32913s;

    /* renamed from: t  reason: collision with root package name */
    private long f32914t;

    /* renamed from: u  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd f32915u;
    private Context ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.xv.w f32916w;
    private wv xv;
    private long ys;

    /* renamed from: c  reason: collision with root package name */
    private int f32904c = 2;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.c sr = null;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f32909n = new AtomicBoolean(false);
    private final AtomicBoolean ck = new AtomicBoolean(false);

    /* renamed from: z  reason: collision with root package name */
    private final AtomicBoolean f32918z = new AtomicBoolean(false);
    private final AtomicBoolean ba = new AtomicBoolean(false);

    /* renamed from: y  reason: collision with root package name */
    private final AtomicBoolean f32917y = new AtomicBoolean(false);
    private final AtomicBoolean eq = new AtomicBoolean(false);
    private final AtomicBoolean me = new AtomicBoolean(false);
    private final AtomicBoolean wv = new AtomicBoolean(false);
    private final AtomicBoolean xk = new AtomicBoolean(false);
    private final AtomicBoolean yu = new AtomicBoolean(false);
    private final AtomicBoolean wx = new AtomicBoolean(false);
    private final AtomicInteger pr = new AtomicInteger(0);
    private boolean bw = false;

    private ev(Context context) {
        if (context != null) {
            this.ux = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.ux = ls.getContext();
        }
        this.f32905f = new n(Looper.getMainLooper(), this);
        this.f32910p = new c();
        com.bytedance.sdk.openadsdk.core.k.sr().p(false);
        p();
    }

    private void a() {
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.ls.w.c.w();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        this.gd.c(new vc(this.fp.sr(), this.fp.w(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        n nVar = this.f32905f;
        if (nVar != null) {
            nVar.removeMessages(4);
        }
        n nVar2 = this.f32905f;
        if (nVar2 != null) {
            nVar2.removeMessages(2);
        }
        r();
    }

    private void gd() {
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar;
        if (this.gd == null || (wVar = this.f32916w) == null || !TextUtils.isEmpty(wVar.j())) {
            return;
        }
        this.gd.w(this.f32916w, this.xv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return this.f32904c == 2;
    }

    private void p() {
        this.f32911q = new bj();
        bj bjVar = new bj();
        this.f32907j = bjVar;
        gd.c(this.f32911q, bjVar);
        this.ls = new com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr();
        this.gb = new com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr();
    }

    private void r() {
        n nVar = this.f32905f;
        if (nVar != null) {
            nVar.removeMessages(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        if (this.f32910p == null) {
            return;
        }
        if (c(c(true))) {
            AtomicBoolean atomicBoolean = this.ck;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "buffer_time\u8d85\u65f6-\u5e76\u53d1 \u7f13\u5b58\u7d20\u6750\u52a0\u8f7d\u6210\u529f\uff0c\u5f00\u59cb\u7ed9\u52a0\u8f7d\u6210\u529f\u56de\u8c03");
            com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar = this.f32913s;
            if (evVar != null) {
                evVar.c(this.fz);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                sr();
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.5
                @Override // java.lang.Runnable
                public void run() {
                    gd.sr(ev.this.f32907j, currentTimeMillis);
                    ev.this.sr();
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.ck;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "buffer_time\u8d85\u65f6-\u4e32\u884c \u7f13\u5b58\u7d20\u6750\u52a0\u8f7d\u6210\u529f\uff0c\u5f00\u59cb\u7ed9\u52a0\u8f7d\u6210\u529f\u56de\u8c03\u4ee5\u53ca\u5f00\u59cb\u6e32\u67d3");
        final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c w3 = w(this.ia, this.f32913s, this.f32910p);
        com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar2 = this.f32913s;
        if (evVar2 != null) {
            evVar2.c(w3.c());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f32910p.c(this.f32913s);
            c(this.ia, w3, this.f32913s.f());
            return;
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.6
            @Override // java.lang.Runnable
            public void run() {
                gd.sr(ev.this.f32907j, currentTimeMillis2);
                ev.this.f32910p.c(ev.this.f32913s);
                ev evVar3 = ev.this;
                evVar3.c(evVar3.ia, w3, ev.this.f32913s.f());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c {

        /* renamed from: w  reason: collision with root package name */
        private final AtomicBoolean f32946w = new AtomicBoolean(false);

        c() {
        }

        private void sr(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
            if (rVar == null || ev.this.sr == null) {
                return;
            }
            ev.this.sr.onSplashRenderFail(rVar.gd(), new com.bytedance.sdk.openadsdk.ys.w.r(rVar.sr(), rVar.ux()));
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "onSplashRenderFail\u56de\u8c03 true " + rVar.sr());
            ev.this.w();
        }

        public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
            if (rVar == null) {
                return;
            }
            ev.this.f();
            if (this.f32946w.get()) {
                return;
            }
            this.f32946w.set(true);
            if (ev.this.sr != null) {
                ev.this.sr.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(rVar.sr(), rVar.ux()));
                com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "onSplashLoadFail \u56de\u8c03 true");
                ev.this.w();
            }
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "onLoadSplashAdFail\u56de\u8c03 \u5e7f\u544a\u83b7\u53d6\u5931\u8d25");
            gd.c(rVar.ev(), ev.this.c(rVar.ev()), ev.this.f32916w, rVar);
        }

        public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
            if (rVar == null) {
                return;
            }
            ev.this.f();
            if (this.f32946w.get()) {
                return;
            }
            this.f32946w.set(true);
            if (ev.this.sr != null) {
                if (ev.this.me.get()) {
                    ev.this.sr.onSplashRenderFail(null, new com.bytedance.sdk.openadsdk.ys.w.r(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.f33027t, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.ys));
                } else {
                    ev.this.sr.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(rVar.sr(), rVar.ux()));
                }
                ev.this.w();
            }
            com.bytedance.sdk.openadsdk.core.ux.c.ux("Splash_FullLink", "onSplashLoadFail \u7d20\u6750\u52a0\u8f7d\u52a0\u8f7d\u5931\u8d25 code: " + rVar.sr());
            gd.c(rVar.ev(), ev.this.c(rVar.ev()), ev.this.f32916w, rVar);
        }

        public void xv(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
            ev.this.f();
            if (this.f32946w.get()) {
                return;
            }
            this.f32946w.set(true);
            gd.c(rVar.ev(), ev.this.c(rVar.ev()), ev.this.f32916w, rVar);
            sr(rVar);
            com.bytedance.sdk.component.utils.a.f("SplashLoadManager", "\u6e32\u67d3\u5931\u8d25 code " + rVar.sr() + " msg " + rVar.ux());
        }

        public boolean sr() {
            return this.f32946w.get();
        }

        public void xv() {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u89e6\u53d1\u6e32\u67d3\u8d85\u65f6 onRenderTimeOut ");
            if (this.f32946w.get()) {
                return;
            }
            this.f32946w.set(true);
            if (ev.this.me.get()) {
                ev.this.sr.onSplashRenderFail(ev.this.fz, new com.bytedance.sdk.openadsdk.ys.w.r(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.ok, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.f33017h));
            } else {
                ev.this.sr.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.oh, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.fm));
            }
            ev evVar = ev.this;
            evVar.c(evVar.fp, false, false, true);
            ev.this.w();
            boolean z3 = ev.this.bw;
            ev evVar2 = ev.this;
            gd.c(z3, evVar2.c(evVar2.bw), ev.this.f32916w, new com.bytedance.sdk.openadsdk.core.component.splash.w.c.r(23, "load splash time out", ev.this.bw));
            boolean z4 = ev.this.bw;
            ev evVar3 = ev.this;
            gd.c(z4, evVar3.c(evVar3.bw), ev.this.f32916w);
        }

        public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
            if (this.f32946w.get() || evVar == null) {
                return;
            }
            bj bjVar = evVar.bk() ? ev.this.f32907j : ev.this.f32911q;
            if (bjVar != null) {
                bjVar.f(evVar.c());
                bjVar.s(evVar.fp());
                bjVar.i(System.currentTimeMillis() - bjVar.ls());
            }
            c(ev.this.sr, bjVar, evVar.w(), evVar.t(), evVar.bk(), evVar.ia());
        }

        public void w() {
            if (this.f32946w.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u89e6\u53d1 buffer_time\u8d85\u65f6 \u5f00\u59cb\u7ed9\u52a0\u8f7d\u6210\u529f\u56de\u8c03\u4ee5\u53ca\u5f00\u59cb\u6e32\u67d3");
            ev.this.ux();
        }

        private void c(com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar, bj bjVar, me meVar, com.bytedance.sdk.openadsdk.ys.w.w.w wVar, boolean z3, boolean z4) {
            if (cVar == null || bjVar == null || ev.this.me.get()) {
                return;
            }
            ev.this.yu.set(z3);
            ev.this.me.set(true);
            long currentTimeMillis = System.currentTimeMillis();
            cVar.onSplashLoadSuccess(wVar);
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "onSplashLoadSuccess() \u5a92\u4f53\u5904\u7406\u5b8c\u6210");
            bjVar.ia(System.currentTimeMillis() - currentTimeMillis);
            if (z4) {
                gd.c(ev.this.ux, bjVar, meVar, z3, currentTimeMillis);
            }
        }

        public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd gdVar) {
            ev.this.f();
            if (this.f32946w.get()) {
                return;
            }
            boolean z3 = true;
            this.f32946w.set(true);
            z3 = (gdVar == null || !gdVar.xv()) ? false : false;
            ev.this.c(gdVar);
            ev evVar = ev.this;
            evVar.c(z3, z3 ? evVar.f32907j : evVar.f32911q);
            if (ev.this.sr == null || gdVar == null) {
                return;
            }
            ev.this.sr.onSplashRenderSuccess(gdVar.c());
        }

        public void c() {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "onTimeOut start");
            ev.this.f32909n.set(true);
            if (this.f32946w.get()) {
                return;
            }
            this.f32946w.set(true);
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5f00\u5c4f\u8d85\u65f6");
            if (ev.this.sr != null) {
                if (ev.this.me.get()) {
                    ev.this.sr.onSplashRenderFail(null, new com.bytedance.sdk.openadsdk.ys.w.r(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.f33027t, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.ys));
                } else {
                    ev.this.sr.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(23, "load splash time out"));
                }
                com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u56de\u8c03\u5f00\u5c4f\u8d85\u65f6 true");
                ev.this.w();
            }
            boolean z3 = ev.this.bw;
            ev evVar = ev.this;
            gd.c(z3, evVar.c(evVar.bw), ev.this.f32916w, new com.bytedance.sdk.openadsdk.core.component.splash.w.c.r(23, "load splash time out", ev.this.bw));
            boolean z4 = ev.this.bw;
            ev evVar2 = ev.this;
            gd.c(z4, evVar2.c(evVar2.bw), ev.this.f32916w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.f32910p.c(this.f32913s);
        this.xk.set(true);
        if (!this.ba.get() || this.wv.get()) {
            return;
        }
        this.wv.set(true);
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7d20\u6750\u52a0\u8f7d\u548c\u6e32\u67d3\u5e76\u53d1 buffer_time\u8d85\u65f6 \u7f13\u5b58\u7d20\u6750\u52a0\u8f7d\u6210\u529f\uff0c\u6e32\u67d3\u6210\u529f\u5f00\u59cb\u7ed9 onRenderSplashSuccess\u56de\u8c03");
        this.f32910p.c(this.f32906i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        n nVar = this.f32905f;
        if (nVar != null) {
            nVar.removeMessages(4);
        }
        c cVar = this.f32910p;
        if (cVar != null) {
            cVar.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        xv xvVar = this.gd;
        if (xvVar != null) {
            xvVar.c(this.f32916w, this.xv);
        }
    }

    private void f(boolean z3) {
        if (this.f32905f != null) {
            if (!k()) {
                this.f32905f.removeMessages(2);
            } else if (z3) {
            } else {
                this.f32905f.removeMessages(4);
                this.f32905f.removeMessages(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar;
        return (z3 || this.gd == null || (fVar = this.fp) == null || fVar.sr() == null || this.fp.w() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xv(boolean z3) {
        return z3 && k();
    }

    private void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, long j4) {
        if (evVar.bk()) {
            if (this.eq.get()) {
                return;
            }
            this.gb.w(j4 - this.bk);
            this.f32907j.xv(evVar.r());
            this.f32907j.w(evVar.f());
        } else if (this.f32917y.get()) {
        } else {
            this.ls.w(j4 - this.f32903a);
            this.f32911q.xv(evVar.r());
            this.f32911q.w(evVar.f());
        }
    }

    private int xv(me meVar) {
        return (this.ev - ((int) (System.currentTimeMillis() - this.f32908k))) - (meVar != null ? meVar.st() : 100);
    }

    private void sr(boolean z3) {
        if (z3) {
            this.ys = System.currentTimeMillis();
        } else {
            this.f32914t = System.currentTimeMillis();
        }
    }

    public static ev c(Context context) {
        return new ev(context);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar, int i4) {
        this.sr = cVar;
        c(wVar, i4);
    }

    private void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, int i4) {
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", " \u52a0\u8f7d\u5f00\u5c4f\u5e7f\u544a--begin ");
        this.f32908k = System.currentTimeMillis();
        this.xv = c(wVar);
        this.f32916w = wVar;
        this.f32912r = com.bytedance.sdk.openadsdk.core.eq.wv.c(wVar);
        this.gd = xv.c(this.ux);
        int gd = ls.w().gd(this.f32912r);
        long currentTimeMillis = System.currentTimeMillis();
        this.f32904c = com.bytedance.sdk.openadsdk.core.ls.sr.c.c(this.f32912r, gd);
        this.xv.c("splpty", System.currentTimeMillis() - currentTimeMillis, true);
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5f53\u524drit\u4f4d " + this.f32912r);
        int r3 = ls.w().r(wVar.f());
        c(wVar.f(), r3, i4);
        wv wvVar = this.xv;
        long j4 = i4;
        wvVar.f34866p = j4;
        wvVar.f34865k = r3;
        wvVar.f34862a = this.ev;
        gd.c(wVar, j4);
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u52a0\u8f7d\u7269\u6599--begin ");
        c();
        c(wVar, this.xv, gd);
        gd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, c cVar) {
        if (fVar == null || cVar == null) {
            return;
        }
        me w3 = fVar.w();
        boolean ux = fVar.ux();
        com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c c4 = c(fVar, new com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev(w3, ux), cVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar = new com.bytedance.sdk.openadsdk.core.component.splash.w.c.w(w3, ux);
        wVar.c(ux);
        wVar.c(fVar.sr());
        wVar.c(fVar.c());
        wVar.c(fVar.xv());
        com.bytedance.sdk.openadsdk.core.component.splash.w.xv.f c5 = c(fVar, cVar, c4.c(), wVar, elapsedRealtime);
        gd.xv(ux ? this.f32907j : this.f32911q, System.currentTimeMillis());
        c5.c();
        int xv = xv(w3);
        c4.c(xv);
        if (this.f32909n.get()) {
            return;
        }
        if (c(w3, wVar.sr()) && this.f32905f != null) {
            if (xv <= 0) {
                xv = 0;
            }
            if (!xv(ux)) {
                this.f32905f.sendEmptyMessageDelayed(6, xv + 100);
            }
        }
        c(c4, ux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(boolean z3) {
        if (z3) {
            this.gb.xv(System.currentTimeMillis() - this.ys);
        } else {
            this.ls.xv(System.currentTimeMillis() - this.f32914t);
        }
    }

    private void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar, int i4) {
        if (wVar == null) {
            return;
        }
        gd.c(this.f32911q, this.f32907j, wvVar, this.f32904c, i4);
        c(wVar, wvVar, this.f32910p);
    }

    private void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar, final c cVar) {
        if (cVar == null) {
            return;
        }
        new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux(new com.bytedance.sdk.openadsdk.core.component.splash.w.c.ux(wVar, wvVar), new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
            /* renamed from: c */
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                if (fVar != null && fVar.w() != null) {
                    me w3 = fVar.w();
                    if (!fVar.ux()) {
                        ev.this.fp = fVar;
                        ev.this.bw = false;
                    } else {
                        ev.this.pr.set(1);
                        ev.this.ia = fVar;
                        if (!ev.this.k()) {
                            ev.this.bw = true;
                        }
                    }
                    if (!ev.this.f32909n.get() && !ev.this.f32910p.sr() && !ev.this.me.get()) {
                        ev.this.c(fVar);
                        if (ev.this.c(w3)) {
                            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5f00\u59cb\u5e76\u53d1\u52a0\u8f7d\u7d20\u6750 ");
                            ev.this.w(fVar, cVar);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5f00\u59cb\u4e32\u884c\u52a0\u8f7d\u7d20\u6750 getReqId " + fVar.w().xq());
                        ev.this.c(fVar, cVar);
                        return;
                    }
                    ev.this.c(fVar, fVar.ux(), true, false);
                    return;
                }
                cVar.c(new com.bytedance.sdk.openadsdk.core.component.splash.w.c.r(25, "load splash fail", false));
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
            public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
                if (ev.this.xv(rVar.ev())) {
                    ev.this.pr.set(-1);
                    if (ev.this.wx.get()) {
                        cVar.c(rVar);
                    }
                } else if (ev.this.k() && com.bytedance.sdk.openadsdk.core.xv.ux.c().gb()) {
                    ev.this.wx.set(true);
                    if (ev.this.pr.get() >= 0) {
                        ev.this.xv();
                    } else {
                        cVar.c(rVar);
                    }
                } else {
                    cVar.c(rVar);
                }
            }
        }, this.gd).c(this.f32904c);
        a();
    }

    private boolean w(me meVar) {
        return meVar != null && meVar.y() == 2;
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c w(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, final c cVar) {
        if (fVar == null || evVar == null || cVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c(new com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv(this.ux, "splash_ad", fVar, evVar, this.f32916w), new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr<com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr
            /* renamed from: c */
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd gdVar) {
                ev.this.ux(fVar.ux());
                if (ev.this.yu.get()) {
                    if (fVar.ux()) {
                        cVar.c(gdVar);
                    }
                } else if (fVar.ux()) {
                } else {
                    cVar.c(gdVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr
            public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
                cVar.xv(rVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr
            public void c() {
                ev.this.w(fVar);
            }
        });
    }

    private void c() {
        this.f32909n.set(false);
        this.ck.set(false);
        this.f32918z.set(false);
        this.ba.set(false);
        this.wv.set(false);
        this.xk.set(false);
        this.f32917y.set(false);
        this.eq.set(false);
        this.yu.set(false);
        this.wx.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
        if (fVar != null && fVar.ux()) {
            return;
        }
        w();
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 2) {
            c cVar = this.f32910p;
            if (cVar != null) {
                cVar.c();
            }
            n nVar = this.f32905f;
            if (nVar != null) {
                nVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            xv();
        }
        if (message.what == 6) {
            c cVar2 = this.f32910p;
            if (cVar2 != null) {
                cVar2.xv();
            }
            r();
        }
    }

    private boolean c(me meVar, boolean z3) {
        return (meVar == null || z3 || meVar.ox() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public me c(boolean z3) {
        if (z3) {
            com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar = this.ia;
            if (fVar == null) {
                return null;
            }
            return fVar.w();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar2 = this.fp;
        if (fVar2 == null) {
            return null;
        }
        return fVar2.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z3, final bj bjVar) {
        com.bytedance.sdk.openadsdk.n.f.c(new com.bytedance.sdk.component.gd.p("preloadSplash") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.7
            @Override // java.lang.Runnable
            public void run() {
                if (ev.this.w(z3)) {
                    com.bytedance.sdk.component.utils.a.f("lqmt", "saveNetAd start");
                    ev.this.ev();
                } else {
                    com.bytedance.sdk.component.utils.a.f("lqmt", "preLoadSplashAd start");
                    ev.this.w();
                }
                bj bjVar2 = bjVar;
                boolean z4 = true;
                boolean z5 = bjVar2 != null && bjVar2.wv();
                bj bjVar3 = bjVar;
                z4 = (bjVar3 == null || !bjVar3.me()) ? false : false;
                boolean z6 = z3;
                gd.c(z6, ev.this.c(z6), ev.this.f32916w, z5, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
        boolean ux = fVar.ux();
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = currentTimeMillis - this.f32908k;
        if (ux) {
            gd.c(this.f32907j);
            this.gb.c(c(ux).y());
            this.gb.w(c(ux).ld());
            this.gb.c(j4);
            this.bk = currentTimeMillis;
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u52a0\u8f7d\u7269\u6599--end \u8017\u65f6S1\uff1a " + j4);
            return;
        }
        gd.c(this.f32911q);
        this.ls.c(c(ux).y());
        this.ls.w(c(ux).ld());
        this.ls.c(j4);
        this.f32903a = currentTimeMillis;
        gd.c(this.f32911q, fVar);
        com.bytedance.sdk.openadsdk.core.q.ux.c().xv().c(this.f32911q);
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5b9e\u65f6\u52a0\u8f7d\u7269\u6599--end \u8017\u65f6S1\uff1a " + j4);
    }

    private void c(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, final c cVar) {
        if (evVar == null || this.me.get()) {
            return;
        }
        final boolean bk = evVar.bk();
        final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c w3 = w(fVar, evVar, cVar);
        evVar.c(w3.c());
        if (!xv(evVar.bk())) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u4e0d\u9700\u8981\u7b49\u5f85\u5b9e\u65f6\u5e7f\u544a isCacheAd " + bk);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                cVar.c(evVar);
                c(fVar, w3, evVar.f());
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.8
                @Override // java.lang.Runnable
                public void run() {
                    gd.sr(bk ? ev.this.f32907j : ev.this.f32911q, currentTimeMillis);
                    cVar.c(evVar);
                    ev.this.c(fVar, w3, evVar.f());
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u7d20\u6750\u52a0\u8f7d\u6210\u529f\uff0c\u7b49\u5f85\u5b9e\u65f6\u5e7f\u544a isCacheAd " + bk);
        this.f32913s = evVar;
        this.fz = w3.c();
        this.ck.set(true);
        if (this.wx.get()) {
            xv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, final c cVar) {
        if (fVar == null || cVar == null) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        gd.xv(fVar.ux() ? this.f32907j : this.f32911q, System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar = new com.bytedance.sdk.openadsdk.core.component.splash.w.c.w(fVar.w(), fVar.ux());
        wVar.c(fVar.sr());
        wVar.c(fVar.ux());
        wVar.c(fVar.c());
        wVar.c(fVar.xv());
        new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.f(wVar, new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.9
            private com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev ux;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
            /* renamed from: c */
            public void xv(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
                this.ux = evVar;
                ev.this.c(evVar, fVar, cVar, (com.bytedance.sdk.openadsdk.ys.w.w.w) null, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar2 = this.ux;
                if (evVar2 != null) {
                    evVar2.ux(true);
                }
                ev.this.c(evVar, fVar, cVar, (com.bytedance.sdk.openadsdk.ys.w.w.w) null, elapsedRealtime, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
            public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
                ev.this.c(fVar, rVar, cVar, elapsedRealtime);
            }
        }, this.gd).c();
    }

    private void c(final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c cVar, boolean z3) {
        if (cVar == null) {
            return;
        }
        sr(z3);
        if (com.bytedance.sdk.openadsdk.n.f.c()) {
            cVar.w();
        } else {
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.10
                @Override // java.lang.Runnable
                public void run() {
                    cVar.w();
                }
            });
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean bk = evVar.bk();
        if (bk) {
            gd.c(this.f32907j, evVar);
            gd.c(this.f32907j, evVar, j4, c(bk));
            gd.c(c(bk), this.f32907j, evVar);
            c(bk, evVar, currentTimeMillis - this.bk);
            com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar2 = this.f32913s;
            if (evVar2 != null) {
                evVar2.ux(true);
            }
        } else {
            gd.c(this.f32911q, evVar);
            gd.c(this.f32911q, evVar, j4, c(bk));
            gd.c(c(bk), this.f32911q, evVar);
            c(bk, evVar, currentTimeMillis - this.f32903a);
        }
        w(evVar, currentTimeMillis);
        if (!this.me.get() || this.f32909n.get()) {
            return;
        }
        if (this.yu.get()) {
            if (bk) {
                gd.c(this.ux, this.f32907j, evVar.w(), true, currentTimeMillis);
            }
        } else if (bk) {
        } else {
            gd.c(this.ux, this.f32911q, evVar.w(), false, currentTimeMillis);
        }
    }

    private void c(boolean z3, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, long j4) {
        String str = z3 ? "\u7f13\u5b58\u5e7f\u544a" : "\u5b9e\u65f6\u5e7f\u544a";
        if (evVar.f()) {
            if (evVar.k()) {
                com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", str + "\uff1a \u52a0\u8f7d\u7f13\u5b58\u89c6\u9891\u7d20\u6750--end, \u8017\u65f6S2\uff1a " + j4);
                return;
            }
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", str + "\uff1a \u52a0\u8f7d\u7f51\u7edc\u89c6\u9891\u7d20\u6750--end, \u8017\u65f6S2\uff1a " + j4);
        } else if (evVar.r()) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", str + "\uff1a \u52a0\u8f7d\u7f13\u5b58\u56fe\u7247\u7d20\u6750--end, \u8017\u65f6S2\uff1a " + j4);
        } else {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", str + "\uff1a \u52a0\u8f7d\u7f51\u7edc\u56fe\u7247\u7d20\u6750--end, \u8017\u65f6S2\uff1a" + j4);
        }
    }

    private void c(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, final c cVar, com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        if (evVar == null || this.me.get()) {
            return;
        }
        final boolean bk = evVar.bk();
        if (!xv(bk)) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5b9e\u65f6\u7d20\u6750\u52a0\u8f7d\u6210\u529f\uff0c\u4e0d\u9700\u8981\u7b49\u5f85\u5b9e\u65f6\u5e7f\u544a, \u6b64\u65f6\u6e32\u67d3\u7ed3\u679c: " + this.f32918z.get());
            evVar.c(wVar);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                cVar.c(evVar);
                if (this.f32918z.get()) {
                    cVar.c(this.f32915u);
                    return;
                }
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.11
                @Override // java.lang.Runnable
                public void run() {
                    gd.sr(bk ? ev.this.f32907j : ev.this.f32911q, currentTimeMillis);
                    cVar.c(evVar);
                    if (ev.this.f32918z.get()) {
                        cVar.c(ev.this.f32915u);
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u5e7f\u544a: \u7d20\u6750\u52a0\u8f7d\u6210\u529f\uff0c\u9700\u8981\u7b49\u5f85\u5b9e\u65f6\u5e7f\u544a");
        this.f32913s = evVar;
        this.fz = wVar;
        this.ck.set(true);
        if (this.wx.get()) {
            xv();
        }
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.w.xv.f c(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, final c cVar, final com.bytedance.sdk.openadsdk.ys.w.w.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar2, final long j4) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.f(wVar2, new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.12

            /* renamed from: f  reason: collision with root package name */
            private com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev f32926f;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
            /* renamed from: c */
            public void xv(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
                this.f32926f = evVar;
                ev.this.c(evVar, fVar, cVar, wVar, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar2 = this.f32926f;
                if (evVar2 != null) {
                    evVar2.ux(true);
                }
                ev.this.c(evVar, fVar, cVar, wVar, j4, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
            public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
                ev.this.c(fVar, rVar, cVar, j4);
            }
        }, this.gd);
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c c(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, final c cVar) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c(new com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv(this.ux, "splash_ad", fVar, evVar, this.f32916w), new com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr<com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ev.2
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr
            /* renamed from: c */
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd gdVar) {
                ev.this.ux(fVar.ux());
                if (!ev.this.xv(gdVar.xv())) {
                    ev.this.f32918z.set(true);
                    ev.this.f32915u = gdVar;
                    if (ev.this.me.get()) {
                        if (ev.this.k()) {
                            if (ev.this.yu.get()) {
                                return;
                            }
                            cVar.c(gdVar);
                            return;
                        }
                        cVar.c(gdVar);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u6e32\u67d3\u6210\u529f \u9700\u8981\u7b49\u5f85\u5b9e\u65f6\u5e7f\u544a: ");
                if (ev.this.xk.get() && !ev.this.wv.get()) {
                    com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5df2\u7ecf\u8d85\u65f6\u8d70\u7f13\u5b58\u5e7f\u544a");
                    ev.this.wv.set(true);
                    cVar.c(gdVar);
                }
                ev.this.ba.set(true);
                ev.this.f32906i = gdVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr
            public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
                if (!ev.this.xv(rVar.ev())) {
                    ev.this.f32918z.set(false);
                    cVar.xv(rVar);
                    return;
                }
                ev.this.ba.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr
            public void c() {
                ev.this.w(fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(me meVar) {
        return meVar != null && p.w(meVar) && w(meVar) && meVar.be() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xv.c cVar, boolean z3) {
        if (cVar == null) {
            return;
        }
        int xv = xv(c(fVar.ux()));
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u6e32\u67d3 timeout " + xv);
        cVar.c(xv);
        if (this.f32909n.get()) {
            return;
        }
        if (c(fVar.w(), z3) && this.f32905f != null) {
            if (xv <= 0) {
                xv = 0;
            }
            if (!xv(fVar.ux())) {
                this.f32905f.sendEmptyMessageDelayed(6, xv + 100);
            }
        }
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5f00\u59cb\u6e32\u67d3 isCache " + fVar.ux());
        c(cVar, fVar.ux());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd gdVar) {
        if (gdVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean xv = gdVar.xv();
        if (xv) {
            gd.c(c(xv), this.gb, gdVar);
            this.gb.sr(currentTimeMillis - this.f32908k);
            this.gb.sr(this.f32904c);
            this.gb.c(xv);
            gd.c(c(xv), this.gb);
            gd.w(c(xv), this.gb);
        } else {
            gd.c(c(xv), this.ls, gdVar);
            this.ls.sr(currentTimeMillis - this.f32908k);
            this.ls.sr(this.f32904c);
            this.ls.c(xv);
            gd.c(c(xv), this.ls);
            gd.w(c(xv), this.ls);
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5f00\u5c4f\u5e7f\u544a\u6e32\u67d3--end, \u8017\u65f6S3\uff1a " + (currentTimeMillis - this.f32914t));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\u6e32\u67d3\u6210\u529f\u56de\u8c03 \u5f00\u5c4f\u5e7f\u544a\u7c7b\u578b\uff1a ");
        sb.append(xv ? "\u7f13\u5b58" : "\u5b9e\u65f6");
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", sb.toString());
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u52a0\u8f7d\u5f00\u5c4f\u5e7f\u544a--end\uff0c\u603b\u8017\u65f6\uff1a " + (currentTimeMillis - this.f32908k));
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u52a0\u8f7d\u5f00\u5c4f\u5e7f\u544a--end\uff0cgetReqId\uff1a " + c(xv).xq());
    }

    private wv c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        long currentTimeMillis = System.currentTimeMillis();
        wv wvVar = new wv();
        wvVar.ev = currentTimeMillis;
        wvVar.f34868t = com.bytedance.sdk.openadsdk.core.k.sr().wx();
        com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar = this.sr;
        if (cVar != null && (cVar instanceof com.bytedance.sdk.openadsdk.core.c.w)) {
            wvVar.gd = ((com.bytedance.sdk.openadsdk.core.c.w) cVar).c();
        }
        return wvVar;
    }

    private void c(String str, int i4, int i5) {
        int fp = ls.w().fp(str);
        if (fp == 1) {
            this.ev = i4 > 0 ? Math.min(i4, i5) : Math.max(i5, 500);
        } else if (fp != 2) {
            this.ev = i4 > 0 ? Math.max(i4, i5) : Math.max(i5, 500);
        } else {
            this.ev = i4 > 0 ? i4 : Math.max(i5, 500);
        }
        int currentTimeMillis = (int) (this.ev - (System.currentTimeMillis() - this.xv.gd));
        if (currentTimeMillis <= 0) {
            currentTimeMillis = this.ev;
        }
        this.ev = currentTimeMillis;
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "splashTimeOutControlType = " + fp + "; devTimeOut = " + i5 + "; cloudTimeOut = " + i4 + "; realTimeOut = " + this.ev);
        this.f32905f.sendEmptyMessageDelayed(2, (long) this.ev);
        c(this.ev);
    }

    private void c(int i4) {
        int p3 = ls.w().p(this.f32912r);
        if (p3 >= i4 || p3 <= 0 || !k() || this.f32905f == null) {
            return;
        }
        int i5 = i4 - p3;
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "buffer time: " + p3 + "  \u51cf\u53bbbuffer time\u540e\u8d85\u65f6\u65f6\u95f4\uff1a" + i5);
        this.f32905f.sendEmptyMessageDelayed(4, (long) i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, c cVar, com.bytedance.sdk.openadsdk.ys.w.w.w wVar, boolean z3) {
        if (this.f32909n.get()) {
            return;
        }
        w(evVar, System.currentTimeMillis());
        if (evVar.bk()) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u5e7f\u544a\uff1a \u7d20\u6750\u9996\u5305\u56de\u8c03");
            this.eq.set(true);
        } else {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5b9e\u65f6\u5e7f\u544a\uff1a \u7d20\u6750\u9996\u5305\u56de\u8c03");
            this.f32917y.set(true);
        }
        f(evVar.bk());
        if (z3) {
            c(evVar, fVar, cVar);
        } else {
            c(evVar, fVar, cVar, wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, c cVar, com.bytedance.sdk.openadsdk.ys.w.w.w wVar, long j4, boolean z3) {
        if (evVar == null) {
            return;
        }
        c(fVar, fVar.ux(), false, false);
        if (this.f32909n.get()) {
            return;
        }
        c(evVar, j4);
        if (evVar.bk() && this.eq.get()) {
            return;
        }
        if (evVar.bk() || !this.f32917y.get()) {
            if (c(evVar.w(), evVar.f())) {
                f(evVar.bk());
            }
            if (z3) {
                c(evVar, fVar, cVar);
            } else {
                c(evVar, fVar, cVar, wVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar, c cVar, long j4) {
        if (rVar == null) {
            return;
        }
        boolean ev = rVar.ev();
        if (!xv(ev)) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5b9e\u65f6cac\u5e7f\u544a: \u7d20\u6750\u52a0\u8f7d\u5931\u8d25\uff0c\u76f4\u63a5\u7ed9\u56de\u8c03");
            cVar.w(rVar);
        } else {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u5e7f\u544a: \u7d20\u6750\u52a0\u8f7d\u5931\u8d25");
            this.ck.set(false);
            if (this.wx.get()) {
                cVar.w(rVar);
            }
        }
        c(fVar, ev, false, false);
        int i4 = rVar.f() ? -14 : -7;
        if (!rVar.f()) {
            p.c(j4, false, false, c(rVar.ev()), i4, rVar.ux());
        }
        String str = ev ? "\u7f13\u5b58\u5e7f\u544a" : "\u5b9e\u65f6\u5e7f\u544a";
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", str + "\u52a0\u8f7d\u7d20\u6750\u5931\u8d25 " + rVar.sr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, boolean z3, boolean z4, boolean z5) {
        if (z3) {
            return;
        }
        try {
            if (this.me.get() && !this.yu.get() && !z5) {
                com.bytedance.sdk.openadsdk.core.ux.c.sr("lqmt", "\u8be5\u5b9e\u65f6\u5e7f\u544a\u5df2\u56de\u8c03\u5a92\u4f53");
            } else if (this.me.get() || this.f32910p.sr()) {
                this.gd.c(fVar, this.f32916w, z4);
            }
        } catch (Exception unused) {
        }
    }
}
