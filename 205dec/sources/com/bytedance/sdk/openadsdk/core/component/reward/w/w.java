package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.gd;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.k;
import com.bytedance.sdk.openadsdk.core.u.ls;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv f32731a;
    private final com.bytedance.sdk.openadsdk.core.component.reward.view.c bk;

    /* renamed from: c  reason: collision with root package name */
    private final TTBaseVideoActivity f32732c;
    private ux ev;

    /* renamed from: f  reason: collision with root package name */
    private int f32733f;
    private com.bytedance.sdk.openadsdk.core.component.reward.w.c gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.w f32735k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.w f32736p;

    /* renamed from: r  reason: collision with root package name */
    private AbstractEndCardFrameLayout f32737r;
    private boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.c f32739t;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private me f32741w;
    private String xv;
    private boolean ys;
    private int fp = -1;
    private boolean ia = false;

    /* renamed from: s  reason: collision with root package name */
    private final AtomicBoolean f32738s = new AtomicBoolean(false);
    private final AtomicBoolean fz = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private int f32734i = 0;

    /* renamed from: u  reason: collision with root package name */
    private boolean f32740u = false;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.w.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0484w {
        void c();

        void w();

        ux xv();
    }

    public w(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f32732c = tTBaseVideoActivity;
        this.bk = new com.bytedance.sdk.openadsdk.core.component.reward.view.c(tTBaseVideoActivity);
    }

    private boolean gw() {
        return u.xv(this.f32741w) && !wx.a(this.f32741w);
    }

    private void up() {
        try {
            int gd = wv.gd(this.f32741w);
            if (ls.c(this.f32741w) && !com.bytedance.sdk.openadsdk.core.bk.sr.c(String.valueOf(gd))) {
                float[] c4 = com.bytedance.sdk.openadsdk.core.component.reward.ux.w.c(StubApp.getOrigApplicationContext(this.f32732c.getApplicationContext()), this.f32741w.yx(), this.f32741w.fh());
                float f4 = c4[0];
                float f5 = c4[1];
                if (this.f32741w.yx() == 100.0f) {
                    this.ux = (int) f4;
                    this.f32733f = (int) f5;
                } else {
                    int[] c5 = com.bytedance.sdk.openadsdk.core.component.reward.ux.w.c(StubApp.getOrigApplicationContext(this.f32732c.getApplicationContext()), this.f32741w.yx(), this.f32741w.ee(), this.f32741w.fh());
                    int i4 = c5[0];
                    int i5 = c5[1];
                    int i6 = c5[2];
                    int i7 = c5[3];
                    float f6 = i4;
                    float f7 = i6;
                    this.ux = (int) ((f4 - f6) - f7);
                    float f8 = i5;
                    float f9 = i7;
                    this.f32733f = (int) ((f5 - f8) - f9);
                    this.f32732c.getWindow().getDecorView().setPadding(xk.ux(this.f32732c, f6), xk.ux(this.f32732c, f8), xk.ux(this.f32732c, f7), xk.ux(this.f32732c, f9));
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc() {
        if (this.f32732c.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.f32732c);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.f32732c);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(xk.ux(this.f32732c, 20.0f), xk.ux(this.f32732c, 12.0f), xk.ux(this.f32732c, 20.0f), xk.ux(this.f32732c, 12.0f));
        TextView textView = new TextView(this.f32732c);
        textView.setTextColor(-1);
        textView.setText("\u8bf7\u6c42\u5f02\u5e38\u65e0\u6cd5\u53d1\u653e\u5956\u52b1\uff0c\u8bf7\u5173\u95ed\u91cd\u8bd5");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.f32732c.wx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.5
            @Override // java.lang.Runnable
            public void run() {
                w.this.vc();
            }
        }, 6000L);
    }

    public void a() {
        if (!m.ia(this.f32741w)) {
            gb();
        }
        this.ev.xv(false);
        this.ev.f(false);
        this.ev.w(this.f32741w.bx());
        this.ev.r(false);
        this.ev.ux(!(this.f32739t instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.w));
        up();
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.ux();
            this.f32739t.c(1);
        }
    }

    public void ba() {
        xv(false);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.yu();
            this.f32731a.f();
        }
        if (this.ia) {
            wx();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar != null) {
            this.f32739t = wVar;
        }
    }

    public boolean bk() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            return cVar.r();
        }
        return false;
    }

    public void bw() {
        this.f32734i = m.w(this.f32741w, this.f32732c.b().yu());
        this.fz.set(m.i(this.f32741w));
        com.bytedance.sdk.openadsdk.core.r.xv.xv = true;
    }

    public boolean ck() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        return xvVar != null && xvVar.xv();
    }

    public boolean eq() {
        return this.ys;
    }

    public int ev() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            return cVar.p();
        }
        return 0;
    }

    public boolean fp() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            return cVar.w();
        }
        return false;
    }

    public boolean fz() {
        if (this.ia) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv) {
            return this.f32731a.y();
        }
        return cVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.w;
    }

    public void gb() {
        if (u.ux(this.f32741w) || x()) {
            return;
        }
        this.fp = Math.max(c(this.f32741w), 0);
        c(0L);
    }

    public String gd() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        return cVar != null ? cVar.k() : "";
    }

    public void i() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar != null) {
            this.f32739t = wVar;
        }
    }

    public boolean ia() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            return cVar.xv();
        }
        return false;
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar != null) {
            wVar.gd();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.gd();
        }
    }

    public void k() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.fz();
        }
    }

    public long ls() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            return xvVar.ba();
        }
        return 0L;
    }

    public int m() {
        return this.f32734i;
    }

    public boolean me() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar == null) {
            return false;
        }
        return wVar.i();
    }

    public void n() {
        xv(true);
        if (this.f32731a != null && k.c(this.f32741w)) {
            this.f32731a.ck();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null && xvVar.xv()) {
            if (!this.f32731a.n() && wx.r(this.f32741w)) {
                u();
            } else {
                this.f32731a.c(this.f32732c.b() instanceof gd ? 2 : 0);
            }
        } else {
            ux(false);
        }
        if (this.f32735k != null) {
            this.f32739t = this.f32731a;
        }
    }

    public void p() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.ia();
        }
    }

    public String pr() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        return cVar != null ? cVar.ls() : CampaignEx.JSON_NATIVE_VIDEO_ENDCARD;
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar;
        if (this.f32739t != this.f32735k || (xvVar = this.f32731a) == null) {
            return;
        }
        xvVar.yu();
        this.f32731a.f();
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.fp();
        }
    }

    public boolean s() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            return cVar.sr();
        }
        return false;
    }

    public void t() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.ev();
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.xk();
        }
    }

    public void wv() {
        c(1000L);
    }

    public void wx() {
        this.bk.xv();
    }

    public boolean x() {
        return yu() && this.fz.get();
    }

    public boolean xk() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            return xvVar.me();
        }
        return false;
    }

    public boolean y() {
        return this.f32739t instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv;
    }

    public boolean ys() {
        boolean ia;
        if (ng.gd(this.f32741w)) {
            a.w("RewardFullWebViewManager", "can show end card follow js");
            ia = fp();
        } else {
            a.w("RewardFullWebViewManager", "can show end card follow js WebViewClient");
            ia = ia();
        }
        return s() && (ia || gw());
    }

    public boolean yu() {
        return this.f32738s.get();
    }

    public com.bytedance.sdk.openadsdk.core.xk z() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            return xvVar.eq();
        }
        return null;
    }

    public void c(ux uxVar, com.bytedance.sdk.openadsdk.core.component.reward.w.c cVar, boolean z3, String str, int i4, int i5) {
        this.sr = z3;
        this.ev = uxVar;
        this.gd = cVar;
        this.xv = str;
        this.ux = i4;
        this.f32733f = i5;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar != null) {
            wVar.ys();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.ys();
        }
    }

    public void sr() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.bk();
        }
    }

    public void ux() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.s();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar2 = this.f32739t;
        if (cVar2 != null) {
            cVar2.t();
        }
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void xv() {
        if (x()) {
            return;
        }
        int i4 = this.fp;
        if (i4 >= 0) {
            this.f32732c.w(i4);
            c(0L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.gb();
        }
    }

    public void sr(boolean z3) {
        this.f32738s.set(z3);
    }

    public void w(boolean z3) {
        if (this.fp >= 0) {
            this.f32732c.u();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.sr(z3);
        }
    }

    public void f(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.f(z3);
        }
    }

    public void ux(boolean z3) {
        if (yu() || eq()) {
            this.ia = true;
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
            if (cVar != null) {
                cVar.u();
                this.f32739t.f();
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
            if (xvVar != null) {
                xvVar.j();
                this.f32731a.ux(true);
            }
            ux uxVar = this.ev;
            if (uxVar != null) {
                uxVar.bk();
            }
            com.bytedance.sdk.openadsdk.core.fz.a.c().f(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.3
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    com.bytedance.sdk.openadsdk.core.fz.c.xv f4 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(w.this.sr ? 7 : 8).xv(String.valueOf(wv.gd(w.this.f32741w))).f(wv.a(w.this.f32741w));
                    f4.w(w.this.ev()).r(w.this.gd());
                    f4.ev(w.this.f32741w.cf()).sr(w.this.f32741w.jr());
                    return f4;
                }
            });
            this.bk.c();
            if (fp.c(this.f32741w)) {
                this.f32732c.a(8);
            }
            this.ev.c(true);
            this.ev.r(false);
            this.f32732c.wx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.4
                @Override // java.lang.Runnable
                public void run() {
                    w.this.ev.c(true);
                    if (w.this.ev.ux()) {
                        return;
                    }
                    w.this.ev.c(false, null, null, true, true);
                    if (w.this.xk() && w.this.sr) {
                        w.this.vc();
                    }
                }
            }, 500L);
            if (z3) {
                if (!m.ia(this.f32741w)) {
                    this.ev.c(false, null, null, true, true);
                }
                this.ev.ux(false);
                this.ev.w(this.f32741w.bx());
            }
        }
    }

    public void c(me meVar, com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.multipro.w.c cVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.f32740u) {
            return;
        }
        this.f32740u = true;
        this.f32741w = meVar;
        this.f32736p = wVar;
        this.bk.c(meVar);
        this.f32737r = abstractEndCardFrameLayout;
        c(abstractEndCardFrameLayout);
        c(cVar);
    }

    public void w(int i4, int i5) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.w(i4, i5);
        }
    }

    public void xv(boolean z3) {
        this.ys = z3;
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.r(z3);
        }
    }

    void c(AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.f32741w.t() == 1) {
            return;
        }
        if (u.xv(this.f32741w)) {
            this.f32731a = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv(this.f32732c, this.f32741w, this.xv, this.ux, this.f32733f, this.sr, this.f32737r);
        }
        if (!TextUtils.isEmpty(ng.c(this.f32741w))) {
            this.f32735k = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.w(this.f32732c, this.f32741w, this.xv, this.ux, this.f32733f, this.sr, this.f32737r);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32731a;
        if (cVar == null) {
            cVar = this.f32735k;
        }
        this.f32739t = cVar;
    }

    public void c(long j4, long j5, int i4) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.c(j4, j5, i4);
        }
    }

    public void c(int i4, int i5) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.c(i4, i5);
        }
    }

    public void c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.w(z3);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.multipro.w.c cVar) {
        Map<String, Object> gw = this.f32732c.gw();
        this.bk.c(this.f32736p);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
        if (xvVar != null) {
            xvVar.c(cVar);
            this.f32731a.c(this.sr, gw, this.ev.sr());
            this.f32731a.c(this.gd.r(), this.f32736p);
            this.f32731a.c(new c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.c
                public void c() {
                    w.this.ux(false);
                }
            });
            this.f32731a.c(new InterfaceC0484w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.InterfaceC0484w
                public void c() {
                    w.this.f32732c.w(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.InterfaceC0484w
                public void w() {
                    w.this.f32732c.ia();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.InterfaceC0484w
                public ux xv() {
                    return w.this.ev;
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar != null) {
            wVar.c(this.sr, gw, this.ev.sr());
            this.f32735k.c(this.gd.r(), this.f32736p);
        }
    }

    public void c() {
        a.w("RewardFullWebViewManager", "startLoadEndCard");
        if (this.f32731a != null && (!k.c(this.f32741w) || !wx.j(this.f32741w))) {
            this.f32731a.ck();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar != null) {
            wVar.ck();
        }
    }

    public void c(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.c(map);
        }
    }

    public void c(boolean z3, int i4, String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.c(z3, i4, str);
        }
    }

    private int c(me meVar) {
        if (meVar == null) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.w) {
            return meVar.uy();
        }
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv) {
            return u.p(meVar);
        }
        return 0;
    }

    private void c(long j4) {
        int i4 = this.fp / 1000;
        if (!m.ia(this.f32741w)) {
            if (i4 > 0) {
                ux uxVar = this.ev;
                uxVar.c(false, i4 + "s", null, false, false);
            } else {
                this.ev.c(false, null, null, true, true);
            }
        }
        if (i4 > 0) {
            this.fp = (int) (this.fp - j4);
            this.f32732c.c(j4);
        }
    }

    public void c(me meVar, com.bytedance.sdk.openadsdk.core.w.w wVar) {
        this.f32741w = meVar;
        this.f32736p = wVar;
        this.bk.c(meVar);
        this.bk.c(this.f32736p);
        if (u.xv(meVar)) {
            if (this.f32731a == null) {
                this.f32731a = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv(this.f32732c, meVar, this.xv, this.ux, this.f32733f, this.sr, this.f32737r);
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.xv xvVar = this.f32731a;
            this.f32739t = xvVar;
            xvVar.c(new c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.c
                public void c() {
                    w.this.ux(false);
                }
            });
            this.f32731a.c(new InterfaceC0484w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.7
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.InterfaceC0484w
                public void c() {
                    w.this.f32732c.w(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.InterfaceC0484w
                public void w() {
                    w.this.f32732c.ia();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.w.InterfaceC0484w
                public ux xv() {
                    return w.this.ev;
                }
            });
        } else {
            this.f32739t = this.f32735k;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
            if (cVar != null) {
                cVar.c(this.f32741w);
                this.f32739t.c(this.sr, this.f32732c.gw(), this.ev.sr());
                this.f32739t.c(this.gd.r(), this.f32736p);
                c();
            }
        } catch (Throwable unused) {
        }
    }

    public void c(final String str) {
        this.f32732c.wx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                w.this.bk.c(str);
            }
        });
    }

    public void c(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.c cVar = this.f32739t;
        if (cVar != null) {
            cVar.c(jSONObject);
        }
    }

    public void c(t tVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f32735k;
        if (wVar == null) {
            return;
        }
        wVar.c(tVar);
    }
}
