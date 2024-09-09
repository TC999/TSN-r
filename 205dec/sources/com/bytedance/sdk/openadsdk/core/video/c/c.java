package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.eq.ls;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.u.gw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.ux;
import com.bytedance.sdk.openadsdk.n.ev;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.ux.xv.ia;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements xv, n.c, c.InterfaceC0499c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c {

    /* renamed from: f  reason: collision with root package name */
    protected me f35110f;
    protected long fp;
    private long gb;
    protected WeakReference<Context> gd;

    /* renamed from: i  reason: collision with root package name */
    protected w f35111i;

    /* renamed from: k  reason: collision with root package name */
    protected List<Runnable> f35113k;
    private long ls;

    /* renamed from: q  reason: collision with root package name */
    protected InterfaceC0517c f35115q;
    protected com.bykv.vk.openvk.component.video.api.c sr;

    /* renamed from: u  reason: collision with root package name */
    protected sr f35119u;
    protected ux ux;

    /* renamed from: w  reason: collision with root package name */
    protected SurfaceHolder f35120w;
    protected SurfaceTexture xv;

    /* renamed from: c  reason: collision with root package name */
    protected final n f35109c = new n(Looper.getMainLooper(), this);

    /* renamed from: r  reason: collision with root package name */
    protected long f35116r = 0;
    protected long ev = 0;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f35114p = false;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f35108a = true;
    protected long bk = 0;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f35118t = false;
    protected boolean ys = false;
    protected boolean ia = false;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f35117s = false;
    protected boolean fz = false;

    /* renamed from: j  reason: collision with root package name */
    protected Runnable f35112j = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            a.w("BaseController", "resumeVideo: run ", Boolean.valueOf(c.this.f35114p));
            c.this.wx();
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0517c {
        void c(com.bykv.vk.openvk.component.video.api.c cVar);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(long j4, long j5);
    }

    private boolean ls() {
        int i4 = Build.VERSION.SDK_INT;
        me meVar = this.f35110f;
        if (meVar == null || meVar.ou() != 1 || i4 >= 23) {
            if ((!ls.w() || i4 < 30) && !me.sr(this.f35110f)) {
                return k.sr().ls();
            }
            return true;
        }
        return true;
    }

    private long ux(long j4) {
        long k4 = k();
        return wv() ? c(k4, j4) : k4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public long a() {
        if (ia() == null) {
            return 0L;
        }
        return ia().fp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
    public boolean ba() {
        return false;
    }

    public boolean bw() {
        return this.f35108a;
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Runnable runnable) {
        if (runnable == null || this.f35110f == null) {
            return;
        }
        if ((this.ux.bk() && this.f35114p) || gd.c(this.f35110f)) {
            runnable.run();
        } else {
            w(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ck() {
        if (this.sr == null) {
            return;
        }
        if (z()) {
            SurfaceTexture surfaceTexture = this.xv;
            if (surfaceTexture == null || surfaceTexture == this.sr.ev()) {
                return;
            }
            this.sr.c(this.xv);
            return;
        }
        SurfaceHolder surfaceHolder = this.f35120w;
        if (surfaceHolder == null || surfaceHolder == this.sr.r()) {
            return;
        }
        this.sr.c(this.f35120w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
    public com.bytedance.sdk.openadsdk.core.multipro.w.c eq() {
        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
        cVar.f33979r = this.f35116r;
        cVar.f33977c = u();
        cVar.ev = fz();
        cVar.sr = i();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ev(boolean z3) {
        this.fz = z3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean fp() {
        return this.ys;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean fz() {
        return this.ia;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gw() {
        ia.c cVar = new ia.c();
        long t3 = t();
        cVar.c(ux(t3));
        cVar.xv(t3);
        cVar.w(a());
        sr c4 = com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux);
        if (c4 != null) {
            c4.c("EXTRA_PLAY_ACTION", mt());
        }
        com.bytedance.sdk.openadsdk.ux.w.w.xv(s(), cVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public com.bykv.vk.openvk.component.video.api.c ia() {
        return this.sr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean j() {
        return com.bytedance.sdk.openadsdk.core.ls.w().u() || ls();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public long k() {
        return this.f35116r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        ia.c cVar = new ia.c();
        long t3 = t();
        cVar.c(ux(t3));
        cVar.xv(t3);
        cVar.w(a());
        sr c4 = com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux);
        if (c4 != null) {
            c4.c("EXTRA_PLAY_ACTION", mt());
        }
        com.bytedance.sdk.openadsdk.ux.w.w.w(this.ux, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int me() {
        int i4 = gw.c(this.f35110f) ? 3 : 0;
        if (wv()) {
            return 3;
        }
        return i4;
    }

    protected Map<String, Object> mt() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    /* renamed from: pr */
    public ux s() {
        return this.ux;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void sr(long j4) {
        this.fp = j4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean sr() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public long t() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar == null) {
            return 0L;
        }
        return cVar.s();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean u() {
        return this.f35117s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void up() {
        sr srVar = this.f35119u;
        if (srVar == null) {
            return;
        }
        srVar.c("EXTRA_PLAY_START", mt());
        com.bytedance.sdk.openadsdk.ux.w.w.w(this.f35110f, this.ux, this.f35119u);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean ux() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vc() {
        ia.c cVar = new ia.c();
        cVar.w(true);
        sr c4 = com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux);
        if (c4 != null) {
            c4.c("EXTRA_PLAY_START", mt());
        }
        com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux, cVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void w(long j4) {
        this.f35116r = j4;
        long j5 = this.ev;
        if (j5 > j4) {
            j4 = j5;
        }
        this.ev = j4;
    }

    public boolean w(int i4) {
        return i4 == 6 || i4 == 8 || i4 == 9;
    }

    public boolean wv() {
        return this.ls > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wx() {
        this.f35109c.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                if (cVar.sr != null) {
                    a.w("BaseController", "resumeVideo: execResumePlay", Boolean.valueOf(cVar.f35114p));
                    c.this.sr.w();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        ia.c cVar = new ia.c();
        long t3 = t();
        cVar.c(ux(t3));
        cVar.xv(t3);
        cVar.w(a());
        cVar.f(bk());
        sr c4 = com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux);
        if (c4 != null) {
            c4.c("EXTRA_PLAY_ACTION", mt());
        }
        com.bytedance.sdk.openadsdk.ux.w.w.f(this.ux, cVar);
    }

    public long xk() {
        return this.ls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long xv(sr srVar) {
        com.bykv.vk.openvk.component.video.api.xv.xv gb;
        if (srVar == null || (gb = srVar.gb()) == null) {
            return 0L;
        }
        int sc = this.f35110f.sc();
        me meVar = this.f35110f;
        if (meVar != null) {
            int ev = wv.ev(meVar);
            if (!w(sc)) {
                return 0L;
            }
            if ((ev != 7 && ev != 8) || gw.c(this.f35110f)) {
                return 0L;
            }
        }
        double r3 = gb.r();
        if (r3 >= 0.0d && r3 < gb.f()) {
            long w3 = ev.c(srVar.s()).w(srVar);
            int fp = gb.fp();
            boolean z3 = fp > 0 && w3 >= ((long) fp);
            a.w("hlt", "st:" + r3 + " vc:" + z3 + " vr:" + sc);
            if (z3) {
                long j4 = (long) (r3 * 1000.0d);
                this.ls = j4;
                return j4;
            }
        }
        a.w("hlt", "st:" + r3 + " d:" + gb.f());
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y() {
        WeakReference<Context> weakReference = this.gd;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    protected void yu() {
        a.xv("BaseController", "execPendingActions: before ");
        List<Runnable> list = this.f35113k;
        if (list == null || list.isEmpty()) {
            return;
        }
        a.xv("BaseController", "execPendingActions:  exec");
        Iterator it = new ArrayList(this.f35113k).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f35113k.clear();
    }

    protected boolean z() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            return uxVar.ia() instanceof SSRenderTextureView;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(Runnable runnable) {
        if (this.f35113k == null) {
            this.f35113k = new ArrayList();
        }
        this.f35113k.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, SurfaceHolder surfaceHolder) {
        this.f35114p = true;
        this.f35120w = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar == null) {
            return;
        }
        if (cVar != null) {
            cVar.c(surfaceHolder);
        }
        a.xv("BaseController", "surfaceCreated: ");
        yu();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, SurfaceHolder surfaceHolder) {
        this.f35114p = false;
        this.f35120w = null;
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.w(false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, SurfaceTexture surfaceTexture) {
        this.f35114p = false;
        a.xv("BaseController", "surfaceTextureDestroyed: ");
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.w(false);
        }
        this.xv = null;
        yu();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, SurfaceTexture surfaceTexture) {
        this.f35114p = true;
        this.xv = surfaceTexture;
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.c(surfaceTexture);
            this.sr.w(this.f35114p);
        }
        a.xv("BaseController", "surfaceTextureCreated: ");
        yu();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void xv(long j4) {
        this.bk = j4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void xv(boolean z3) {
        this.f35117s = z3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void w(boolean z3) {
        this.ia = z3;
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.c(z3);
        }
    }

    public void xv(int i4) {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.w(i4);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(boolean z3) {
        this.f35108a = z3;
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.sr(z3);
        }
    }

    public long c(long j4, long j5) {
        long xk = xk();
        if (xv() || !(j4 == xk || j4 - xk < 0 || j4 == 0)) {
            me meVar = this.f35110f;
            if (meVar == null) {
                return j4;
            }
            long j6 = 60000;
            if (meVar.ab() != 2 || j5 <= 60000) {
                j6 = j5;
            } else if (this.f35118t) {
                long j7 = this.gb;
                if (j4 - j7 >= j5 - 60000) {
                    return j7;
                }
            }
            long j8 = j4 - xk;
            long j9 = j8 + (j6 * (j8 > 0 ? 0 : 1));
            this.gb = j9;
            return j9;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, int i5) {
        if (this.gd == null) {
            return;
        }
        ia.c cVar = new ia.c();
        cVar.w(a());
        long t3 = t();
        cVar.xv(t3);
        cVar.c(ux(t3));
        cVar.c(i4);
        cVar.w(i5);
        com.bytedance.sdk.openadsdk.ux.w.w.sr(s(), cVar);
    }

    public void c(w wVar) {
        this.f35111i = wVar;
    }
}
