package com.bytedance.sdk.openadsdk.core.component.reward.sr;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends w implements n.c {

    /* renamed from: a  reason: collision with root package name */
    protected String f32501a;
    protected boolean bk;

    /* renamed from: c  reason: collision with root package name */
    protected final TTBaseVideoActivity f32502c;
    com.bytedance.sdk.openadsdk.core.component.reward.w.c ck;
    protected com.bytedance.sdk.openadsdk.core.w.r ev;

    /* renamed from: f  reason: collision with root package name */
    protected int f32503f;
    protected int fp;
    protected boolean fz;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.f gb;
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w gd;

    /* renamed from: i  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.w.ux f32504i;

    /* renamed from: j  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.w.w f32505j;

    /* renamed from: k  reason: collision with root package name */
    protected AbstractEndCardFrameLayout f32506k;
    protected com.bytedance.sdk.openadsdk.core.component.reward.w.sr ls;

    /* renamed from: n  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.ux f32507n;

    /* renamed from: p  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.layout.ux f32508p;

    /* renamed from: q  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.w.f f32509q;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f32511s;
    protected float sr;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f32512t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f32513u;
    protected int ux;

    /* renamed from: w  reason: collision with root package name */
    protected me f32514w;
    protected int xv;
    protected int ys;

    /* renamed from: r  reason: collision with root package name */
    protected int f32510r = -1;
    protected AtomicBoolean ia = new AtomicBoolean(false);

    /* renamed from: z  reason: collision with root package name */
    protected int f32516z = -5;
    protected boolean ba = false;

    /* renamed from: y  reason: collision with root package name */
    protected final n f32515y = new n(Looper.getMainLooper(), this);
    protected int eq = Integer.MIN_VALUE;
    public int me = 1000;

    public c(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        this.f32502c = tTBaseVideoActivity;
        this.f32514w = meVar;
        this.xv = meVar.fh();
        this.sr = meVar.yx();
    }

    private void ng() {
        this.f32504i.c(false);
        this.gd.f(8);
        this.gd.ux(8);
        this.gd.xv(8);
        ox();
    }

    private int ok() {
        long max = Math.max(((long) (this.f32509q.y() * 1000.0d)) - this.f32509q.me(), 0L);
        return Math.max((((int) (max / 1000)) + (((int) (max % 1000)) > 500 ? 1 : 0)) - this.f32502c.oo(), 0);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.ux a() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ux(this.f32502c);
        this.f32508p = uxVar;
        return uxVar;
    }

    public int ba() {
        return 0;
    }

    public AbstractEndCardFrameLayout bk() {
        return this.f32506k;
    }

    protected int bw() {
        return (int) (this.f32509q.me() / 1000);
    }

    public void c(int i4) {
    }

    public void c(int i4, int i5, Intent intent) {
    }

    public void c(View view) {
    }

    public void c(com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar, com.bytedance.sdk.openadsdk.core.component.reward.w.f fVar, com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar, com.bytedance.sdk.openadsdk.core.component.reward.w.sr srVar, com.bytedance.sdk.openadsdk.core.component.reward.w.c cVar) {
        this.f32504i = uxVar;
        this.f32509q = fVar;
        this.f32505j = wVar;
        this.ls = srVar;
        this.ck = cVar;
    }

    public void c(Map<String, Object> map) {
    }

    public void c(JSONObject jSONObject) {
    }

    protected void ck() {
        if (this.f32516z < 0) {
            this.f32516z = this.f32505j.m();
        }
        int i4 = this.f32516z;
        if (i4 <= 0) {
            if (i4 == 0) {
                this.f32502c.sr(0);
                this.f32504i.c(false, "\u5956\u52b1\u5df2\u9886\u53d6", null, true, true);
                return;
            }
            return;
        }
        this.f32516z = i4 - 1;
        com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = this.f32504i;
        uxVar.c(false, this.f32516z + "s", null, true, true);
    }

    public boolean eq() {
        return true;
    }

    public void ev() {
        this.ys = this.f32512t ? ls.w().ux(wv.gd(this.f32514w)) : ls.w().f(wv.gd(this.f32514w));
        if ((this.f32512t || !m.j(this.f32514w)) && !(this instanceof k)) {
            return;
        }
        gw();
    }

    public boolean f() {
        return this.f32514w.y() == 2;
    }

    public void fp() {
        this.gd.fp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] fz() {
        TTBaseVideoActivity tTBaseVideoActivity = this.f32502c;
        int sr = xk.sr(tTBaseVideoActivity, xk.k(tTBaseVideoActivity));
        float f4 = this.f32503f;
        float f5 = this.ux;
        int i4 = this.xv;
        if ((i4 == 1) != (f4 > f5)) {
            float f6 = f4 + f5;
            f5 = f6 - f5;
            f4 = f6 - f5;
        }
        if (i4 == 1) {
            f4 -= sr;
        } else {
            f5 -= sr;
        }
        return new float[]{f5, f4};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int gb() {
        return this.fp + this.f32502c.oo();
    }

    public View gd() {
        int up = this.f32514w.up();
        if (up != 1) {
            if (up != 3) {
                return com.bytedance.sdk.openadsdk.res.ux.c(this.f32502c);
            }
            return com.bytedance.sdk.openadsdk.res.ux.sr(this.f32502c);
        }
        return com.bytedance.sdk.openadsdk.res.ux.xv(this.f32502c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gw() {
        if (this.f32513u || Build.VERSION.SDK_INT == 26) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.f32502c;
        tTBaseVideoActivity.setTheme(i.ux(tTBaseVideoActivity, "tt_full_screen_interaction"));
        xk.f((Activity) this.f32502c);
        this.f32513u = true;
    }

    public void i() {
        this.f32504i.gd();
        this.f32515y.removeMessages(11);
    }

    public boolean ia() {
        return false;
    }

    public final int j() {
        return this.f32510r;
    }

    public View k() {
        return com.bytedance.sdk.openadsdk.res.ux.ux(this.f32502c);
    }

    public void ls() {
        if (m.ia(this.f32514w)) {
            q();
        }
        if (this.f32505j.x()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (bm() && this.f32505j.x()) {
            ck();
        } else {
            wo();
        }
    }

    public void me() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.ia.getAndSet(true)) {
            return;
        }
        this.f32515y.sendEmptyMessage(11);
    }

    public View p() {
        if (this.f32506k == null) {
            this.f32506k = new CommonEndCardFrameLayout(this.f32502c, this.f32514w);
        }
        return this.f32506k;
    }

    public int pr() {
        int i4 = this.eq;
        return i4 == Integer.MIN_VALUE ? f(true) : i4;
    }

    public void q() {
        this.f32504i.p();
        if (!this.ia.get() || this.f32515y.hasMessages(11)) {
            return;
        }
        this.f32515y.sendEmptyMessageDelayed(11, this.me);
    }

    public boolean r() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar;
        return f() && (uxVar = this.f32508p) != null && uxVar.f();
    }

    public FrameLayout s() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar;
        if (fp.sr(this.f32514w)) {
            return this.f32506k.getVideoArea();
        }
        if (f() && (uxVar = this.f32508p) != null && uxVar.f()) {
            return this.f32508p.c();
        }
        return this.gd.a();
    }

    protected void sr() {
        boolean f4 = this.f32508p.f();
        if (!this.f32505j.yu() && !f4) {
            fp();
        }
        this.f32505j.c(this.f32508p.a());
        if (f4) {
            this.f32508p.c().setBackgroundColor(-16777216);
        }
        this.gd.xv(!f4);
        this.f32508p.xv(f4);
        this.f32504i.c(au() || !f4);
        this.f32502c.gd();
        if (m.ia(this.f32514w)) {
            n();
        }
    }

    public void t() {
    }

    public void u() {
        if (this.f32512t) {
            this.gd.w((int) (this.f32509q.me() / 1000));
        }
    }

    protected void ux() {
        this.f32502c.r(0);
        this.f32504i.c(au());
        float[] fArr = {this.ux, this.f32503f};
        if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
            fArr = fz();
        }
        this.f32508p.c(this.f32514w, com.bytedance.sdk.openadsdk.core.eq.n.c(this.f32502c.c() ? 7 : 8, String.valueOf(wv.gd(this.f32514w)), fArr[0], fArr[1]), this.f32501a, this.bk);
        this.gd.xv(false);
        this.f32508p.xv(true);
        this.f32508p.c(new com.bytedance.sdk.openadsdk.core.nativeexpress.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.c.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public int S_() {
                if (c.this.f32508p.w()) {
                    return 4;
                }
                if (c.this.f32508p.xv()) {
                    return 5;
                }
                if (c.this.f32509q.sr()) {
                    return 1;
                }
                if (c.this.f32509q.w()) {
                    return 2;
                }
                c.this.f32509q.xv();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public int T_() {
                return c.this.gb();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void U_() {
                c.this.f32502c.ev(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void V_() {
                c.this.ba = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void W_() {
                c.this.ba = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void X_() {
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(c.this.f32514w, "stats_reward_full_click_express_close");
                c.this.f32504i.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void Y_() {
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(c.this.f32514w, "stats_reward_full_click_express_close");
                c.this.f32502c.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void a_(boolean z3) {
                c cVar = c.this;
                if (cVar.bk != z3) {
                    cVar.bk = z3;
                    cVar.f32504i.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(int i4) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        c.this.f32509q.z();
                        return;
                    } else if (i4 == 3) {
                        c.this.f32509q.ba();
                        return;
                    } else if (i4 == 4) {
                        c.this.f32509q.r();
                        return;
                    } else if (i4 != 5) {
                        return;
                    }
                }
                if (c.this.f32509q.w() || c.this.f32509q.xv() || c.this.f32509q.gw()) {
                    return;
                }
                c.this.f32502c.c(0L, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(int i4, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void ev() {
                c.this.f32502c.gd(3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void f() {
                c.this.f32504i.xv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public long getActualPlayDuration() {
                return c.this.f32509q.xk().oo();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void setPauseFromExpressView(boolean z3) {
                c.this.f32509q.sr(z3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void w(int i4) {
                if (m.ux(c.this.f32514w)) {
                    c.this.f32502c.sr(1);
                } else {
                    c.this.f32502c.k(i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public long xv() {
                c cVar = c.this;
                cVar.w(cVar.f(true));
                return c.this.f32509q.me();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(float f4, float f5, float f6, float f7, int i4) {
                c.this.f32502c.c(f4, f5, f6, f7, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
            public void c(float f4) {
                c.this.xv((int) (1000.0f / f4));
                c.this.f32502c.bj().c(f4);
            }
        });
        this.f32508p.c(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.c.4
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, String str, int i4) {
                c.this.f32505j.c();
                c.this.f32502c.r(8);
                c.this.f32504i.c(true);
                c.this.f32515y.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.c.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f32502c.ls();
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void w(View view, int i4) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                c.this.f32505j.c();
                c.this.f32502c.r(8);
                c cVar = c.this;
                cVar.f32510r = cVar.f32508p.gd();
                c cVar2 = c.this;
                if (cVar2.f32510r == 0) {
                    m.w(cVar2.f32514w, true);
                }
                c.this.xv();
            }
        });
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.gb.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(this.f32502c.gw());
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f32507n.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(this.f32502c.gw());
        this.f32502c.c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.gb.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        this.f32502c.c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.f32507n.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        this.f32508p.c(this.gb, this.f32507n);
        this.f32508p.ev();
    }

    public boolean vc() {
        return !this.f32512t && m.j(this.f32514w) && this.xv == 1;
    }

    public void w() {
        com.bytedance.sdk.component.utils.a.w("RewardFullAdType", "startBindAd");
        ng();
        xu();
        if (b()) {
            m.c(this.f32514w, true);
        }
        if (up()) {
            this.f32505j.c();
        }
        if (f()) {
            ux();
        } else {
            xv();
        }
    }

    public void w(View view) {
    }

    public void w(Map<String, Object> map) {
    }

    public com.bytedance.sdk.openadsdk.core.video.w.w wv() {
        return null;
    }

    protected int wx() {
        return ev(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int x() {
        if (u.ux(this.f32514w)) {
            return u.r(this.f32514w);
        }
        return m.ys(this.f32514w);
    }

    protected int xk() {
        if (b() && m.ia(this.f32514w)) {
            return gb();
        }
        return bw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.sr.w
    protected void xv() {
        sr();
    }

    public void xv(boolean z3) {
    }

    public boolean y() {
        return false;
    }

    public void ys() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.f32506k;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.w();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar = this.f32508p;
        if (uxVar != null) {
            uxVar.sr();
        }
        if (mt() || this.f32505j.yu()) {
            return;
        }
        this.f32505j.j();
    }

    public int yu() {
        if (bm() && this.f32505j.x()) {
            return this.f32516z;
        }
        if (b() && m.ia(this.f32514w)) {
            return (int) Math.max((x() * (this.f32514w.wq() / 100.0f)) - gb(), 0.0f);
        }
        return wx();
    }

    public void z() {
        this.f32511s = true;
    }

    public int f(boolean z3) {
        if (bm() && this.f32505j.x()) {
            return this.f32516z;
        }
        if (b() && m.ia(this.f32514w)) {
            return Math.max(x() - gb(), 0);
        }
        return r(z3);
    }

    protected int r(boolean z3) {
        if (z3) {
            return ev(false);
        }
        return ok();
    }

    public void xv(int i4) {
        this.me = i4;
    }

    private int ev(boolean z3) {
        long max;
        long me = this.f32509q.me();
        if (z3) {
            long c4 = m.c();
            double wq = this.f32514w.wq() / 100.0f;
            Double.isNaN(wq);
            return (int) Math.max(((int) (max / 1000)) + (((int) (Math.max(Math.min(c4, (long) ((this.f32509q.y() * 1000.0d) * wq)) - (me + (this.f32502c.oo() * 1000)), 0L) % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long min = Math.min(m.c(), (long) (this.f32509q.y() * 1000.0d));
        long oo = this.f32502c.oo() * 1000;
        long y3 = (long) ((this.f32509q.y() % 1.0d) * 1000.0d);
        if (y3 > 0) {
            me -= 1000 - y3;
        }
        return Math.round(((float) (min - (me + oo))) / 1000.0f);
    }

    public void c(String str, boolean z3, boolean z4) {
        this.f32501a = str;
        this.bk = z3;
        this.f32512t = z4;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.w.ux c() {
        return this.f32504i;
    }

    public final void c(com.bytedance.sdk.openadsdk.core.w.r rVar) {
        this.ev = rVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.f32502c;
        me meVar = this.f32514w;
        String str = this.f32501a;
        this.gb = new com.bytedance.sdk.openadsdk.core.nativeexpress.f(tTBaseVideoActivity, meVar, str, wv.c(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.c.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.f, com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                super.c(view, gdVar);
                c.this.f32502c.c(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.f32502c;
        me meVar2 = this.f32514w;
        String str2 = this.f32501a;
        this.f32507n = new com.bytedance.sdk.openadsdk.core.nativeexpress.ux(tTBaseVideoActivity2, meVar2, str2, wv.c(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.c.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ux, com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                super.c(view, gdVar);
                com.bytedance.sdk.openadsdk.core.w.c.w wVar = (com.bytedance.sdk.openadsdk.core.w.c.w) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.w.class);
                if (wVar == null || !wVar.w(view)) {
                    return;
                }
                c.this.f32502c.c(2);
            }
        };
        this.f32506k.setClickListener(this.ev);
    }

    public void w(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ux uxVar = this.f32508p;
        if (uxVar != null) {
            uxVar.ux();
        }
    }

    public void sr(boolean z3) {
        if (z3) {
            if (this.xv == 1) {
                this.gd.sr(0);
            }
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f32514w)) {
                this.gd.f(0);
            }
        } else if (this.xv == 1) {
            this.gd.sr(8);
        }
    }

    public void w(int i4) {
        this.eq = i4;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.w c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xv xvVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.xv(this.f32502c, this.f32514w, z3);
        this.gd = xvVar;
        return xvVar;
    }

    public void c(int i4, int i5) {
        this.ux = i4;
        this.f32503f = i5;
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 11) {
            if (!this.fz) {
                this.fp++;
            }
            m();
            this.f32515y.sendEmptyMessageDelayed(11, this.me);
        }
    }

    public void ux(boolean z3) {
        this.bk = z3;
        this.f32509q.xv(z3);
    }

    public w.c c(final com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.xv.xv xvVar = new com.bytedance.sdk.openadsdk.core.component.reward.xv.xv(this.f32502c, this.f32514w);
        xvVar.c(pr());
        xvVar.w(xk());
        xvVar.xv(this.f32502c.eq());
        xvVar.sr(this.f32502c.me());
        xvVar.xv(this.ba);
        this.f32502c.x();
        return xvVar.w(new com.bytedance.sdk.openadsdk.core.component.reward.xv.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.c.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void c() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c();
                }
                c.this.f32502c.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void w() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void xv() {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.xv();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void c(int i4) {
                com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c(i4);
                }
            }
        });
    }
}
