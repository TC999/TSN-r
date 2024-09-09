package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.util.Log;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.p;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.n.ev;
import com.bytedance.sdk.openadsdk.ux.xv.ia;
import java.io.File;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private me f32710a;
    private FrameLayout bk;
    com.bykv.vk.openvk.component.video.api.sr.xv ev;

    /* renamed from: f  reason: collision with root package name */
    protected int f32712f;
    private com.bytedance.sdk.openadsdk.core.w.c fp;
    long gd;
    private com.bykv.vk.openvk.component.video.api.xv.sr ia;

    /* renamed from: k  reason: collision with root package name */
    private TTBaseVideoActivity f32713k;

    /* renamed from: r  reason: collision with root package name */
    boolean f32715r;

    /* renamed from: t  reason: collision with root package name */
    private String f32717t;
    protected long ux;
    private long ys;

    /* renamed from: p  reason: collision with root package name */
    private final int f32714p = 210;

    /* renamed from: c  reason: collision with root package name */
    boolean f32711c = false;

    /* renamed from: w  reason: collision with root package name */
    protected boolean f32718w = false;
    protected boolean xv = false;
    protected boolean sr = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f32716s = false;

    public f(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f32713k = tTBaseVideoActivity;
    }

    private void au() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null || xvVar.ia() == null) {
            return;
        }
        this.gd = this.ev.k();
        if (this.ev.ia().p() || !this.ev.ia().gd()) {
            this.ev.f();
            this.ev.gd();
            this.f32718w = true;
        }
    }

    public boolean a() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.sr();
        }
        return false;
    }

    public void ba() {
        try {
            this.xv = false;
            this.f32713k.m();
        } catch (Throwable th) {
            a.f("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public boolean bk() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.ux();
        }
        return false;
    }

    public boolean bw() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null || xvVar.ia() == null) {
            return false;
        }
        return this.ev.ia().f();
    }

    public void c(me meVar) {
        this.f32710a = meVar;
    }

    public boolean ck() {
        return this.xv;
    }

    public int eq() {
        return this.f32712f;
    }

    public void ev() {
        if (this.ev != null && w()) {
            this.ev.w(true);
        }
    }

    public long f() {
        return this.gd;
    }

    public int fp() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.ys();
        }
        return 0;
    }

    public int fz() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.bk();
        }
        return 0;
    }

    public boolean gb() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        return xvVar != null && xvVar.ia() == null;
    }

    public void gd() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            xvVar.p();
        }
    }

    public boolean gw() {
        return this.sr;
    }

    public long i() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.t() + this.ev.a();
        }
        return 0L;
    }

    public long ia() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.k();
        }
        return this.gd;
    }

    public boolean j() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            if (xvVar.ia() != null) {
                com.bykv.vk.openvk.component.video.api.c ia = this.ev.ia();
                if (ia.t() || ia.ys()) {
                    ((com.bytedance.sdk.openadsdk.core.video.w.c) this.ev).wo();
                    return true;
                }
            } else if (ux()) {
                c(false);
                ((com.bytedance.sdk.openadsdk.core.video.w.c) this.ev).wo();
                return true;
            }
        }
        return false;
    }

    public void k() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            xvVar.w();
        }
    }

    public boolean ls() {
        return this.ev != null;
    }

    public void m() {
        ia.c cVar = new ia.c();
        long i4 = i();
        long ia = ia();
        if (xk() != null) {
            cVar.c(xk().c(ia, i4));
        }
        cVar.xv(i4);
        cVar.w(s());
        cVar.ux(3);
        cVar.f(fz());
        com.bytedance.sdk.openadsdk.ux.w.w.c(pr(), cVar, this.f32713k.a());
    }

    public long me() {
        long wv = wv();
        com.bytedance.sdk.openadsdk.core.video.w.c xk = xk();
        return (xk == null || !xk.wv()) ? wv : xk.c(this.ux, q());
    }

    public void mt() {
    }

    public void n() {
        r();
    }

    public void oo() {
        try {
            com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
            if (xvVar instanceof com.bytedance.sdk.openadsdk.core.video.w.c) {
                ((com.bytedance.sdk.openadsdk.core.video.w.c) xvVar).te();
            }
        } catch (Throwable unused) {
        }
    }

    public void p() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null || this.sr) {
            return;
        }
        xvVar.f();
    }

    public com.bykv.vk.openvk.component.video.api.sr.w pr() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.s();
        }
        return null;
    }

    public long q() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.t();
        }
        return 0L;
    }

    public void r() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null) {
            return;
        }
        xvVar.gd();
        this.ev = null;
    }

    public long s() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.a();
        }
        return 0L;
    }

    public boolean sr() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        return xvVar != null && xvVar.q();
    }

    public boolean t() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.fz();
        }
        return false;
    }

    public void u() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null || xvVar.ia() == null) {
            return;
        }
        this.ev.ia().sr();
    }

    public void up() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if ((xvVar instanceof com.bytedance.sdk.openadsdk.core.video.w.c) && this.sr) {
            ((com.bytedance.sdk.openadsdk.core.video.w.c) xvVar).b();
        }
    }

    public boolean ux() {
        return this.f32718w;
    }

    public void vc() {
        this.sr = true;
    }

    public boolean w() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        return (xvVar == null || xvVar.ia() == null || !this.ev.ia().bk()) ? false : true;
    }

    public long wv() {
        if (a()) {
            double bj = xk().bj();
            Double.isNaN(bj);
            double f4 = ng.ys(this.f32710a).f() * 1000.0d * bj;
            long j4 = this.ux;
            double d4 = j4;
            Double.isNaN(d4);
            if (f4 - d4 > 210.0d) {
                double d5 = j4;
                Double.isNaN(d5);
                long j5 = (long) (d5 + f4);
                this.ys = j5;
                return j5;
            }
        }
        return Math.max(this.ux, this.ys);
    }

    public boolean wx() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null) {
            return false;
        }
        return xvVar.xv();
    }

    public com.bykv.vk.openvk.component.video.api.sr.xv x() {
        return this.ev;
    }

    public com.bytedance.sdk.openadsdk.core.video.w.c xk() {
        return (com.bytedance.sdk.openadsdk.core.video.w.c) x();
    }

    public boolean xv() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        return (xvVar == null || xvVar.ia() == null || !this.ev.ia().t()) ? false : true;
    }

    public double y() {
        if (ng.bk(this.f32710a) != null) {
            double ux = ng.ux(this.f32710a);
            if (this.f32710a.ab() != 2 || ux <= 60.0d) {
                return ux;
            }
            return 60.0d;
        }
        return 0.0d;
    }

    public long ys() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            return xvVar.t();
        }
        return 0L;
    }

    public boolean yu() {
        com.bytedance.sdk.openadsdk.core.video.w.c xk = xk();
        if (xk == null) {
            return false;
        }
        return xk.oh();
    }

    public void z() {
        try {
            this.xv = true;
            this.f32713k.sr(true);
        } catch (Throwable th) {
            a.f("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void c(FrameLayout frameLayout, String str, boolean z3) {
        if (this.f32716s) {
            return;
        }
        this.f32716s = true;
        this.bk = frameLayout;
        this.f32717t = str;
        this.f32715r = z3;
        if (z3) {
            this.ev = new p(this.f32713k, frameLayout, this.f32710a, this.fp);
        } else {
            this.ev = new com.bytedance.sdk.openadsdk.core.component.reward.xv(this.f32713k, frameLayout, this.f32710a, this.fp);
        }
        this.f32712f = (int) y();
    }

    public void sr(boolean z3) {
        this.xv = z3;
    }

    public void w(boolean z3) {
        int i4;
        if (this.ev == null) {
            return;
        }
        if (z3) {
            i4 = bw() ? 2 : 4;
        } else {
            i4 = bw() ? 0 : 1;
        }
        ia.c cVar = new ia.c();
        cVar.w(s());
        long i5 = i();
        cVar.xv(i5);
        long ia = ia();
        if (xk() != null) {
            cVar.c(xk().c(ia, i5));
        }
        cVar.xv(1 ^ bw());
        cVar.sr(i4);
        com.bytedance.sdk.openadsdk.ux.w.w.ux(this.ev.s(), cVar);
    }

    public void xv(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            xvVar.w(z3);
        }
    }

    public boolean c() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        return (xvVar == null || xvVar.ia() == null || !this.ev.ia().gd()) ? false : true;
    }

    public void c(boolean z3) {
        this.f32718w = z3;
    }

    public void c(long j4) {
        this.gd = j4;
    }

    public void c(long j4, boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar == null || this.sr) {
            return;
        }
        if (j4 != 0) {
            xvVar.c(j4);
            this.ev.w(z3);
            return;
        }
        xvVar.ev();
    }

    public void w(long j4) {
        this.ux = j4;
        com.bytedance.sdk.openadsdk.core.video.w.c xk = xk();
        if (!bk() && a()) {
            double y3 = y();
            double d4 = this.ux;
            Double.isNaN(d4);
            this.f32712f = (int) Math.max(0L, Math.round(y3 - ((d4 + (ng.ys(this.f32710a).f() * 1000.0d)) / 1000.0d)));
        } else if (xk != null && !(this.f32713k.b() instanceof gd)) {
            long oo = xk.oo();
            double y4 = y();
            double d5 = oo / 1000;
            Double.isNaN(d5);
            this.f32712f = Math.max(0, (int) (y4 - d5));
        } else {
            double y5 = y();
            double d6 = this.ux / 1000;
            Double.isNaN(d6);
            this.f32712f = Math.max(0, (int) (y5 - d6));
        }
    }

    public void c(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            xvVar.c(map);
        }
    }

    public void c(xv.c cVar) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            xvVar.c(cVar);
        }
    }

    public boolean c(long j4, boolean z3, int i4) {
        a.w("TTBaseVideoActivity", "playVideo start");
        if (this.ev != null && ng.bk(this.f32710a) != null) {
            com.bykv.vk.openvk.component.video.api.xv.sr srVar = this.ia;
            if (srVar == null) {
                File file = new File(ev.c(this.f32710a.ou()).c(), ng.f(this.f32710a));
                if (file.exists() && file.length() > 0) {
                    this.f32711c = true;
                }
                srVar = ng.c(1, this.f32710a);
                srVar.w(this.f32710a.jr());
                FrameLayout frameLayout = this.bk;
                srVar.w(frameLayout == null ? 100 : frameLayout.getWidth());
                FrameLayout frameLayout2 = this.bk;
                srVar.xv(frameLayout2 != null ? frameLayout2.getHeight() : 100);
                srVar.xv(this.f32710a.cf());
                srVar.c(j4);
                srVar.w(z3);
                if (com.bytedance.sdk.openadsdk.n.gd.c(this.f32710a)) {
                    srVar.c(true);
                }
            }
            return this.ev.c(srVar);
        }
        a.w("TTBaseVideoActivity", "playVideo controller or video is Empty");
        return false;
    }

    public void c(boolean z3, TTBaseVideoActivity tTBaseVideoActivity, boolean z4) {
        boolean z5;
        if (!z4 || z3 || this.xv) {
            return;
        }
        if (xv()) {
            com.bytedance.sdk.openadsdk.core.video.w.w wv = this.f32713k.b().wv();
            long j4 = 0;
            boolean z6 = false;
            if (wv != null) {
                z6 = wv.sr();
                j4 = wv.ux();
                z5 = wv.f();
            } else {
                z5 = false;
            }
            if (z6) {
                au();
                c(tTBaseVideoActivity);
            } else {
                c(j4, z5);
            }
            Log.i("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
            return;
        }
        au();
        c(tTBaseVideoActivity);
        Log.i("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
    }

    protected void c(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!j() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.c(f(), true);
    }

    public void c(int i4) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ev;
        if (xvVar != null) {
            xvVar.c(i4);
        }
    }

    public void c(me meVar, com.bykv.vk.openvk.component.video.api.sr.xv xvVar, com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        this.f32710a = meVar;
        this.ev = xvVar;
        this.ia = srVar;
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        this.fp = cVar;
    }

    public void c(float f4) {
        if (this.ev.ia() != null) {
            this.ev.ia().c(f4);
        }
    }
}
