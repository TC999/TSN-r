package com.bytedance.sdk.openadsdk.core.component.splash.xv;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.k;
import com.bytedance.sdk.openadsdk.core.component.splash.p;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.f;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.eq.ck;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.mt;
import com.bytedance.sdk.openadsdk.core.u.oo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.xv;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.core.ys.c;
import com.bytedance.sdk.openadsdk.mediation.MediationSplashManagerDefault;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.openadsdk.ys.w.w.w implements n.c, TsView.c {
    private static com.bytedance.sdk.component.f.c ge = ba.c("tt_materialMeta");
    protected xv ba;
    private boolean bj;
    private boolean bw;

    /* renamed from: c  reason: collision with root package name */
    protected TsView f33080c;
    protected boolean ck;
    protected com.bytedance.sdk.openadsdk.sr.c.w.c.c ev;

    /* renamed from: f  reason: collision with root package name */
    protected View.OnTouchListener f33081f;
    private com.bytedance.sdk.openadsdk.ys.w.xv.w fm;
    protected ev fp;
    protected boolean fz;

    /* renamed from: j  reason: collision with root package name */
    protected r f33084j;
    private com.bytedance.sdk.openadsdk.core.q.c.w mt;

    /* renamed from: n  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.q.c.w f33087n;
    private Activity ng;
    private k oh;
    private boolean ok;
    private com.bytedance.sdk.openadsdk.sr.c.w.c.w ox;
    private float pr;

    /* renamed from: r  reason: collision with root package name */
    protected w f33090r;
    protected SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> sr;
    private sr<gd, r> te;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f33093u;
    protected com.bytedance.sdk.openadsdk.core.w.c ux;

    /* renamed from: w  reason: collision with root package name */
    protected me f33094w;
    private float wx;
    private Context xk;
    private com.bytedance.sdk.openadsdk.sr.c.w.c.xv xu;
    protected com.bytedance.sdk.openadsdk.core.p.w.xv xv;
    protected f ys;
    private String yu;
    protected final Map<String, Object> gd = new HashMap();

    /* renamed from: x  reason: collision with root package name */
    private Double f33095x = null;

    /* renamed from: m  reason: collision with root package name */
    private boolean f33086m = false;
    private boolean gw = false;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f33088p = false;
    private int vc = 3;

    /* renamed from: k  reason: collision with root package name */
    protected int f33085k = -1;
    private final n up = new n(Looper.getMainLooper(), this);

    /* renamed from: a  reason: collision with root package name */
    protected boolean f33078a = false;
    protected boolean bk = false;

    /* renamed from: t  reason: collision with root package name */
    protected long f33092t = 0;
    protected Map<String, Object> ia = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    protected AtomicBoolean f33091s = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    protected boolean f33083i = true;

    /* renamed from: q  reason: collision with root package name */
    protected boolean f33089q = false;
    private com.bytedance.sdk.openadsdk.core.component.splash.w oo = new com.bytedance.sdk.openadsdk.core.component.splash.w();
    private com.bytedance.sdk.openadsdk.core.component.splash.c au = new com.bytedance.sdk.openadsdk.core.component.splash.c();
    private boolean bm = false;

    /* renamed from: b  reason: collision with root package name */
    private long f33079b = 0;
    private long wo = 5;
    protected AtomicBoolean ls = new AtomicBoolean(false);
    protected AtomicBoolean gb = new AtomicBoolean(false);

    /* renamed from: z  reason: collision with root package name */
    protected AtomicBoolean f33097z = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private boolean f33082h = true;

    /* renamed from: y  reason: collision with root package name */
    protected AtomicBoolean f33096y = new AtomicBoolean(false);
    protected AtomicBoolean eq = new AtomicBoolean(false);
    protected AtomicBoolean me = new AtomicBoolean(false);
    protected AtomicBoolean wv = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.xv.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0487c implements c.w {

        /* renamed from: c  reason: collision with root package name */
        me f33115c;

        public C0487c(me meVar) {
            this.f33115c = meVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
        public void c() {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.f33115c, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
        public void w() {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.f33115c, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void H_();

        void I_();

        void J_();

        void K_();

        void ev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz() {
        ge.c("net_ad_already_shown", this.f33094w.xq());
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb() {
        boolean z3 = false;
        this.ok = false;
        k kVar = new k();
        this.oh = kVar;
        kVar.c(this.xk, this.f33094w);
        boolean z4 = !this.au.xv() && ls();
        if (this.oo != null && fp()) {
            z3 = true;
        }
        if (z4) {
            SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = this.sr;
            if (softReference == null) {
                this.oh.c(this.yu, this.f33085k, this.au, (com.bytedance.sdk.openadsdk.ys.w.c.w) null);
            } else {
                this.oh.c(this.yu, this.f33085k, this.au, softReference.get());
            }
            this.f33093u = true;
            this.oh.c(2);
            com.bytedance.sdk.openadsdk.core.component.splash.c cVar = this.au;
            if (cVar != null) {
                cVar.c(this);
            }
            com.bytedance.sdk.openadsdk.core.component.splash.w wVar = this.oo;
            if (wVar != null) {
                wVar.xv();
            }
        } else if (z3) {
            sr(true);
            SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference2 = this.sr;
            if (softReference2 == null) {
                this.oh.c(this.yu, this.f33085k, this.oo, (com.bytedance.sdk.openadsdk.ys.w.c.w) null);
            } else {
                this.oh.c(this.yu, this.f33085k, this.oo, softReference2.get());
            }
            this.f33093u = true;
            this.oh.c(1);
            com.bytedance.sdk.openadsdk.core.component.splash.w wVar2 = this.oo;
            if (wVar2 != null) {
                wVar2.c(this);
            }
            this.au.sr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.bytedance.sdk.openadsdk.core.k.sr().xv().xv(new C0487c(this.f33094w));
    }

    private void ia() {
        if (this.f33094w == null) {
            return;
        }
        this.f33088p = false;
        TsView tsView = new TsView(this.xk, this.yu, this.f33094w);
        this.f33080c = tsView;
        tsView.setAttachedToWindowListener(this);
        s();
        this.f33080c.setCountDownViewPosition(this.f33094w);
        if (this.f33094w.vc() == 0) {
            TsView tsView2 = this.f33080c;
            if (tsView2 != null) {
                tsView2.setAdlogoViewVisibility(8);
            }
        } else {
            TsView tsView3 = this.f33080c;
            if (tsView3 != null) {
                tsView3.setAdlogoViewVisibility(0);
            }
        }
        if (this.f33094w.al() <= 0) {
            c(3);
        } else {
            int al = this.f33094w.al();
            this.vc = al;
            c(al);
        }
        w(this.f33094w);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        TsView tsView = this.f33080c;
        if (tsView != null) {
            tsView.c(this.f33094w.xu(), this.ux);
            if (this.f33094w.y() == 1) {
                t();
            }
        }
    }

    private boolean ls() {
        return (!oo.c(this.f33094w) || this.f33078a || this.bk || this.fz) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        sr(false);
        if (!this.bj) {
            this.f33083i = false;
        } else if (this.bm) {
        } else {
            this.bm = true;
            com.bytedance.sdk.openadsdk.core.component.splash.c cVar = this.au;
            if (cVar != null) {
                cVar.c();
                this.au = null;
            }
            com.bytedance.sdk.openadsdk.core.component.splash.w wVar = this.oo;
            if (wVar != null) {
                wVar.c();
                this.oo = null;
            }
            xv xvVar = this.ba;
            if (xvVar != null) {
                xvVar.p();
            }
            if (this.eq.get()) {
                this.ev = null;
            } else {
                this.me.set(true);
            }
            this.xv = null;
            this.ng = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        TsView tsView = this.f33080c;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i4 = 0; i4 < this.f33080c.getChildCount(); i4++) {
                View childAt = this.f33080c.getChildAt(i4);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.f33080c.removeView(childAt);
                    return;
                }
            }
        }
    }

    private void s() {
        if (!this.ck || this.f33080c == null) {
            return;
        }
        me meVar = this.f33094w;
        if ((meVar == null || meVar.bb() == null || this.f33094w.bb().w() != 0) ? false : true) {
            this.f33080c.setVideoViewVisibility(8);
            return;
        }
        this.f33080c.setVideoViewVisibility(0);
        this.f33080c.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.f33080c.setVoiceViewImageDrawable(c.this.f33082h ? i.xv(c.this.xk, "tt_splash_unmute") : i.xv(c.this.xk, "tt_splash_mute"));
                c cVar = c.this;
                cVar.f33082h = !cVar.f33082h;
                c cVar2 = c.this;
                xv xvVar = cVar2.ba;
                if (xvVar != null) {
                    xvVar.w(cVar2.f33082h);
                }
            }
        });
    }

    private void u() {
        this.xv = c(this.f33094w);
        EmptyView emptyView = new EmptyView(this.xk, this.f33080c, this.f33094w.ek());
        emptyView.setAdType(3);
        this.f33080c.addView(emptyView);
        me meVar = this.f33094w;
        if (meVar != null && meVar.y() != 1) {
            xv(true);
        } else {
            xv(false);
        }
        emptyView.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.4
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c.this.xv;
                if (xvVar != null) {
                    if (z3) {
                        xvVar.sr();
                    } else {
                        xvVar.ux();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
                TsView tsView;
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c.this.xv;
                if (xvVar != null) {
                    xvVar.xv();
                }
                c cVar = c.this;
                if (cVar.xv == null || (tsView = cVar.f33080c) == null || tsView.getParent() == null) {
                    return;
                }
                Context context = null;
                try {
                    context = ((View) c.this.f33080c.getParent()).getContext();
                } catch (Exception unused) {
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                c.this.xv.c((Activity) context);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view) {
                f fVar;
                c.this.fz();
                c.this.f33091s.set(true);
                c.this.f33092t = System.currentTimeMillis();
                w wVar = c.this.f33090r;
                if (wVar != null) {
                    wVar.H_();
                }
                c cVar = c.this;
                me meVar2 = cVar.f33094w;
                if (meVar2 != null && (fVar = cVar.ys) != null) {
                    meVar2.f(fVar.ux());
                    c.this.ia.put("cache_type", Integer.valueOf(ls.w().gd(wv.gd(c.this.f33094w))));
                }
                c cVar2 = c.this;
                me meVar3 = cVar2.f33094w;
                String str = cVar2.yu;
                c cVar3 = c.this;
                com.bytedance.sdk.openadsdk.core.a.xv.c(meVar3, str, cVar3.ia, cVar3.f33095x);
                c.this.j();
                c.this.q();
                c cVar4 = c.this;
                cVar4.c(cVar4.bw);
                c cVar5 = c.this;
                com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar6 = cVar5.ev;
                if (cVar6 != null) {
                    cVar6.onSplashAdShow(cVar5);
                }
                if (c.this.me.get()) {
                    c.this.ev = null;
                } else {
                    c.this.eq.set(true);
                }
                c.this.i();
                c.this.f33097z.set(true);
                TsView tsView = c.this.f33080c;
                if (tsView != null) {
                    tsView.setIsShowSuccess(true);
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        this.gd.put("splash_show_type", Integer.valueOf(this.f33085k));
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.xk, this.f33094w, this.yu, 4) { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.5
            @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                if ((view instanceof SplashClickBarBtn) && c.this.f33088p) {
                    return;
                }
                super.c(view, gdVar);
            }
        };
        this.ux = cVar;
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.ux.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(this.gd);
        this.ux.w(this.f33080c.getDislikeView());
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.ux.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.ux.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.6
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view, int i4) {
                c cVar2 = c.this;
                com.bytedance.sdk.openadsdk.core.a.xv.w(cVar2.f33092t, cVar2.f33094w);
                c cVar3 = c.this;
                com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar4 = cVar3.ev;
                if (cVar4 != null) {
                    cVar4.onSplashAdClick(cVar3);
                }
                c.this.bk();
            }
        });
        this.f33080c.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar2 = c.this;
                cVar2.bk = true;
                if (!TextUtils.isEmpty(cVar2.f33094w.cf())) {
                    com.bytedance.sdk.openadsdk.core.a.xv.c(c.this.f33092t > 0 ? System.currentTimeMillis() - c.this.f33092t : 0L, c.this.f33094w);
                }
                if (!oo.ia(c.this.f33094w)) {
                    c.this.gb();
                }
                c cVar3 = c.this;
                com.bytedance.sdk.openadsdk.core.a.xv.w(cVar3.f33092t, cVar3.f33094w);
                c cVar4 = c.this;
                if (cVar4.ev != null) {
                    cVar4.vc = 0;
                    c cVar5 = c.this;
                    cVar5.f33088p = true;
                    cVar5.ev.onSplashAdClose(cVar5, 1);
                    if (c.this.eq.get()) {
                        c.this.ev = null;
                    } else {
                        c.this.me.set(true);
                    }
                    c.this.a();
                }
                w wVar = c.this.f33090r;
                if (wVar != null) {
                    wVar.K_();
                }
                c.this.ys();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void L_() {
        gb();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public View c() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(ViewGroup viewGroup) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.k(super.values()).e(1, eq.f33190w).l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.f33096y.get()) {
            return;
        }
        com.bytedance.sdk.component.f.c cVar = ge;
        String w3 = cVar.w("net_ad_save_success" + wv.gd(this.f33094w), "");
        if (TextUtils.isEmpty(w3) || !w3.equals(this.f33094w.xq())) {
            return;
        }
        this.f33096y.set(true);
        com.bytedance.sdk.openadsdk.core.ux.c.w("lqmt", "\u7f13\u5b58reqId:  " + w3);
        p.c(this.xk, this.fm);
        sr<gd, r> srVar = this.te;
        if (srVar != null) {
            srVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bk() {
        this.up.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.8
            @Override // java.lang.Runnable
            public void run() {
                c.this.f33078a = true;
                if (!com.bytedance.sdk.openadsdk.core.p.xv.xv.f.f34385c) {
                    if (c.this.oh != null) {
                        c.this.oh.w();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.p.xv.xv.f.f34385c = false;
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = c.this.xv;
                if (xvVar instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
                    ((com.bytedance.sdk.openadsdk.core.p.xv.f) xvVar).c().c(new com.bytedance.sdk.openadsdk.core.p.xv.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.8.1
                        @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.c
                        public void c() {
                            if (c.this.oh != null) {
                                c.this.oh.w();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.c
                        public void w() {
                        }
                    });
                }
            }
        }, 100L);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public int[] f() {
        return oo.ys(this.f33094w);
    }

    protected boolean fp() {
        me meVar = this.f33094w;
        if (meVar == null) {
            return false;
        }
        boolean z3 = oo.s(meVar) == 0;
        if (oo.xv(this.f33094w)) {
            return (!this.f33083i || this.f33078a || z3) ? false : true;
        }
        ev evVar = this.fp;
        if (evVar != null) {
            this.mt = evVar.ux();
        }
        return oo.sr(this.f33094w) && !this.f33078a && !z3 && (this.mt != null);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r gd() {
        return new MediationSplashManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.c
    public void k() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.f();
        }
        me meVar = this.f33094w;
        if (meVar != null) {
            gb.c(meVar.iy());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.c
    public void p() {
        AtomicBoolean atomicBoolean = this.f33097z;
        if (atomicBoolean == null || !atomicBoolean.get()) {
            return;
        }
        a.xv("\u5f00\u5c4fview\u91cd\u590d\u5c55\u793a");
        TsView tsView = this.f33080c;
        if (tsView != null && tsView.getCountDownView() != null && this.f33080c.getCountDownView().getView() != null) {
            this.f33080c.getCountDownView().getView().setVisibility(0);
        }
        w(this.bw);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void r() {
        this.bw = true;
        TsView tsView = this.f33080c;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public int sr() {
        me meVar = this.f33094w;
        if (meVar == null) {
            return -1;
        }
        return meVar.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        mt gp;
        me meVar = this.f33094w;
        if (meVar == null || (gp = meVar.gp()) == null || gp.gd() != 5) {
            return;
        }
        final int ys = gp.ys();
        final mt.c t3 = gp.t();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c cVar;
                com.bytedance.sdk.openadsdk.core.w.c cVar2;
                TsView tsView;
                int sr = xk.sr(c.this.xk, view.getWidth());
                int sr2 = xk.sr(c.this.xk, view.getHeight());
                int sr3 = xk.sr(c.this.xk, motionEvent.getX());
                int sr4 = xk.sr(c.this.xk, motionEvent.getY());
                boolean z3 = sr3 >= t3.c() && sr4 >= t3.xv() && sr - sr3 >= t3.w() && sr2 - sr4 >= t3.sr();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            c.this.pr = motionEvent.getY();
                        }
                    } else if (!z3) {
                        return false;
                    } else {
                        c.this.pr = motionEvent.getY();
                        int sr5 = xk.sr(c.this.xk, Math.abs(c.this.pr - c.this.wx));
                        if (c.this.pr - c.this.wx < 0.0f && sr5 > ys && (cVar2 = (cVar = c.this).ux) != null && (tsView = cVar.f33080c) != null) {
                            cVar2.onClick(tsView);
                        }
                    }
                } else if (!z3) {
                    return false;
                } else {
                    c.this.wx = motionEvent.getY();
                }
                return true;
            }
        };
        this.f33081f = onTouchListener;
        TsView tsView = this.f33080c;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public Map<String, Object> ux() {
        me meVar = this.f33094w;
        if (meVar != null) {
            com.bytedance.sdk.openadsdk.core.u.gb gbVar = meVar.nc().get(0);
            if (gbVar == null) {
                return this.f33094w.tc();
            }
            if (!gbVar.f()) {
                return this.f33094w.tc();
            }
            String c4 = gbVar.c();
            Map<String, Object> tc = this.f33094w.tc();
            tc.put(CampaignEx.JSON_KEY_IMAGE_URL, c4);
            return tc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ys() {
        com.bytedance.sdk.openadsdk.core.k.sr().p(true);
        com.bytedance.sdk.openadsdk.core.eq.c xv = com.bytedance.sdk.openadsdk.core.k.sr().xv();
        if (xv == null) {
            return;
        }
        xv.xv(null);
    }

    private void sr(boolean z3) {
        com.bytedance.sdk.component.f.c c4 = ba.c("sp_multi_native_video_data");
        if (c4 != null) {
            c4.c("key_video_is_form_splash_click_eye", z3);
        }
    }

    private void xv(final boolean z3) {
        if (this.xv == null) {
            return;
        }
        me meVar = this.f33094w;
        final String jr = meVar != null ? meVar.jr() : "";
        this.xv.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.2
            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c() {
                SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = c.this.sr;
                if (softReference != null && softReference.get() != null) {
                    c.this.sr.get().onIdle();
                }
                if (z3) {
                    c.C0525c.c(jr, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void w(long j4, long j5, String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = c.this.sr;
                if (softReference != null && softReference.get() != null) {
                    c.this.sr.get().onDownloadPaused(j4, j5, str, str2);
                }
                if (!z3 || j4 <= 0) {
                    return;
                }
                c.C0525c.c(jr, 2, (int) ((j5 * 100) / j4));
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void xv(long j4, long j5, String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = c.this.sr;
                if (softReference != null && softReference.get() != null) {
                    c.this.sr.get().onDownloadFailed(j4, j5, str, str2);
                }
                if (!z3 || j4 <= 0) {
                    return;
                }
                c.C0525c.c(jr, 4, (int) ((j5 * 100) / j4));
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, long j5, String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = c.this.sr;
                if (softReference != null && softReference.get() != null) {
                    c.this.sr.get().onDownloadActive(j4, j5, str, str2);
                }
                if (!z3 || j4 <= 0) {
                    return;
                }
                c.C0525c.c(jr, 3, (int) ((j5 * 100) / j4));
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = c.this.sr;
                if (softReference != null && softReference.get() != null) {
                    c.this.sr.get().onDownloadFinished(j4, str, str2);
                }
                if (z3) {
                    c.C0525c.c(jr, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(String str, String str2) {
                SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = c.this.sr;
                if (softReference != null && softReference.get() != null) {
                    c.this.sr.get().onInstalled(str, str2);
                }
                if (z3) {
                    c.C0525c.c(jr, 6, 100);
                }
            }
        });
    }

    private void w(me meVar) {
        TsView tsView;
        if (meVar == null || (tsView = this.f33080c) == null) {
            return;
        }
        tsView.c(meVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv xvVar, sr<gd, r> srVar) {
        if (xvVar == null || srVar == null) {
            return;
        }
        this.wv.set(xvVar.gd());
        this.te = srVar;
        r rVar = new r();
        this.f33084j = rVar;
        rVar.w(xvVar.gd());
        this.f33084j.c(xvVar.w());
        this.f33084j.c(this);
        this.xk = xvVar.getContext();
        this.yu = xvVar.f();
        this.ys = xvVar.sr();
        this.fp = xvVar.ux();
        this.fm = xvVar.r();
        if (this.ys == null) {
            this.f33084j.w(r.f33022n);
            this.f33084j.c(r.ck);
            srVar.c(this.f33084j);
            return;
        }
        ev evVar = this.fp;
        if (evVar == null) {
            this.f33084j.w(r.f33031z);
            this.f33084j.c(r.ba);
            srVar.c(this.f33084j);
            return;
        }
        this.ck = evVar.f();
        this.f33094w = this.ys.w();
        this.f33087n = this.fp.sr();
        ia();
        sr(false);
    }

    private void w(boolean z3) {
        TsView tsView;
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w countDownView;
        if (z3 || (tsView = this.f33080c) == null || (countDownView = tsView.getCountDownView()) == null) {
            return;
        }
        countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.11
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.c
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.c
            public void w() {
                TsView tsView2 = c.this.f33080c;
                if (tsView2 != null && tsView2.getCountDownView() != null && c.this.f33080c.getCountDownView().getView() != null) {
                    c.this.f33080c.getCountDownView().getView().setVisibility(8);
                }
                c cVar = c.this;
                com.bytedance.sdk.openadsdk.core.a.xv.w(cVar.f33092t, cVar.f33094w);
                c cVar2 = c.this;
                com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar3 = cVar2.ev;
                if (cVar3 != null) {
                    cVar2.f33088p = true;
                    cVar3.onSplashAdClose(cVar2, 2);
                    if (c.this.eq.get()) {
                        c.this.ev = null;
                    } else {
                        c.this.me.set(true);
                    }
                    c.this.a();
                }
                c.this.ys();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.c
            public void xv() {
            }
        });
        countDownView.c();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public View xv() {
        k kVar;
        if (this.f33093u && (kVar = this.oh) != null) {
            return kVar.c();
        }
        return null;
    }

    private void xv(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.f33093u || (tsView = this.f33080c) == null || this.f33094w == null || this.oh == null || this.bj) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.bj = true;
        ViewGroup c4 = this.oh.c();
        if (c4 == null) {
            return;
        }
        xv xvVar = this.ba;
        if (xvVar != null) {
            xvVar.f();
        }
        if (c4.getParent() != null) {
            ((ViewGroup) c4.getParent()).removeView(c4);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(c4);
            xk.ev(this.f33080c);
            this.f33080c.removeAllViews();
            this.f33080c = null;
        }
        c4.setOnClickListener(null);
        c4.setOnTouchListener(null);
        if (this.f33089q || Build.VERSION.SDK_INT <= 19) {
            xv xvVar2 = this.ba;
            if (xvVar2 != null) {
                xvVar2.p();
            }
            this.ba = null;
        }
        this.oh.c(this.mt, this.ba, new k.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.k.c
            public void c(long j4) {
                c.this.up.removeMessages(1);
                if (j4 < 0) {
                    c.this.up.sendEmptyMessageDelayed(1, 1000L);
                } else if (j4 == 0) {
                    c.this.up.sendEmptyMessage(2);
                } else {
                    c.this.wo = j4;
                    c.this.f33079b = 0L;
                    c.this.up.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.k.c
            public Context getActivity() {
                return c.this.ng;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.k.c
            public void w() {
                c.this.ok = true;
                c.this.n();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.k.c
            public void c() {
                c.this.up.removeMessages(1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public View w() {
        k kVar;
        if (this.f33093u && (kVar = this.oh) != null) {
            return kVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void w(ViewGroup viewGroup) {
        xv(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
        this.f33095x = d4;
    }

    private void c(int i4) {
        TsView tsView = this.f33080c;
        if (tsView != null) {
            tsView.setCountDownTime(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(w wVar) {
        this.f33090r = wVar;
    }

    protected com.bytedance.sdk.openadsdk.core.p.w.xv c(me meVar) {
        if (meVar.v() == 4) {
            return com.bytedance.sdk.openadsdk.core.p.xv.c(this.xk, meVar, this.yu);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3) {
        TsView tsView;
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w countDownView;
        if (z3 || (tsView = this.f33080c) == null || (countDownView = tsView.getCountDownView()) == null) {
            return;
        }
        countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.10
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.c
            public void c() {
                w wVar = c.this.f33090r;
                if (wVar != null) {
                    wVar.I_();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.c
            public void w() {
                TsView tsView2 = c.this.f33080c;
                if (tsView2 != null && tsView2.getCountDownView() != null && c.this.f33080c.getCountDownView().getView() != null) {
                    c.this.f33080c.getCountDownView().getView().setVisibility(8);
                }
                c.this.gb();
                w wVar = c.this.f33090r;
                if (wVar != null) {
                    wVar.J_();
                }
                c cVar = c.this;
                com.bytedance.sdk.openadsdk.core.a.xv.w(cVar.f33092t, cVar.f33094w);
                c cVar2 = c.this;
                com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar3 = cVar2.ev;
                if (cVar3 != null) {
                    cVar2.f33088p = true;
                    cVar3.onSplashAdClose(cVar2, 2);
                    if (c.this.eq.get()) {
                        c.this.ev = null;
                    } else {
                        c.this.me.set(true);
                    }
                    c.this.a();
                }
                c.this.ys();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.c
            public void xv() {
                w wVar = c.this.f33090r;
                if (wVar != null) {
                    wVar.ev();
                }
            }
        });
        countDownView.c();
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        if (i4 == 1) {
            long j4 = this.f33079b + 1;
            this.f33079b = j4;
            if (j4 >= this.wo) {
                this.up.sendEmptyMessage(2);
            } else {
                this.up.sendEmptyMessageDelayed(1, 1000L);
            }
        } else if (i4 != 2) {
        } else {
            if (!this.ok && oo.c(this.f33094w)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("splash_card_close_type", 0);
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f33094w, "splash_ad", "splash_card_close", jSONObject);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        if (wVar == null) {
            return;
        }
        this.sr = new SoftReference<>(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar) {
        this.ev = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar) {
        this.xu = xvVar;
        com.bytedance.sdk.openadsdk.core.component.splash.w wVar = this.oo;
        if (wVar != null) {
            wVar.c(xvVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar) {
        this.ox = wVar;
        com.bytedance.sdk.openadsdk.core.component.splash.c cVar = this.au;
        if (cVar != null) {
            cVar.c(wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(ViewGroup viewGroup, Activity activity) {
        this.ng = activity;
        xv(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
        if (this.f33086m) {
            return;
        }
        ck.c(this.f33094w, d4);
        this.f33086m = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
        if (this.gw) {
            return;
        }
        ck.c(this.f33094w, d4, str, str2);
        this.gw = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
        me meVar = this.f33094w;
        if (meVar != null) {
            gb.c(meVar.iy(), cVar);
        }
    }
}
