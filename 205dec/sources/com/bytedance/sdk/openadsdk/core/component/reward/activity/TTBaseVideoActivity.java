package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.ux;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.c;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.k;
import com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog;
import com.bytedance.sdk.openadsdk.core.component.reward.w.c;
import com.bytedance.sdk.openadsdk.core.component.reward.w.f;
import com.bytedance.sdk.openadsdk.core.component.reward.w.sr;
import com.bytedance.sdk.openadsdk.core.component.reward.w.xv;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.dislike.ui.c;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.r.w;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.w.c.xv.sr;
import com.bytedance.sdk.openadsdk.core.w.r;
import com.bytedance.sdk.openadsdk.ev.c.xv;
import com.bytedance.sdk.openadsdk.n.gd;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class TTBaseVideoActivity extends Activity implements n.c, w {

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicBoolean f32149a;
    private int au;

    /* renamed from: b  reason: collision with root package name */
    private long f32150b;
    protected me ba;
    private Double bj;
    protected final AtomicBoolean bk;
    private w.c bm;
    private final AtomicBoolean bw;

    /* renamed from: c  reason: collision with root package name */
    protected final String f32151c;
    protected c ck;
    protected String eq;
    protected final AtomicBoolean ev;

    /* renamed from: f  reason: collision with root package name */
    protected final AtomicBoolean f32152f;
    protected boolean fp;
    ux fz;
    sr gb;
    protected final AtomicBoolean gd;
    private c.w gw;

    /* renamed from: i  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.component.reward.w.ux f32153i;
    RewardFullBaseLayout ia;

    /* renamed from: j  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.component.reward.w.c f32154j;

    /* renamed from: k  reason: collision with root package name */
    protected final AtomicBoolean f32155k;
    f ls;

    /* renamed from: m  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.w f32156m;
    protected String me;
    private int mt;

    /* renamed from: n  reason: collision with root package name */
    protected xv f32157n;
    private final c.InterfaceC0499c ng;
    private AtomicBoolean ok;
    private int oo;
    private com.bytedance.sdk.openadsdk.core.component.reward.ux.xv ox;

    /* renamed from: p  reason: collision with root package name */
    protected final AtomicBoolean f32158p;
    protected xv.c pr;

    /* renamed from: q  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.component.reward.w.w f32159q;

    /* renamed from: r  reason: collision with root package name */
    protected final AtomicBoolean f32160r;

    /* renamed from: s  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.component.reward.layout.w f32161s;
    protected final AtomicBoolean sr;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f32162t;

    /* renamed from: u  reason: collision with root package name */
    AbstractEndCardFrameLayout f32163u;
    private float up;
    protected final ConcurrentHashMap<Integer, Boolean> ux;
    private c.InterfaceC0483c vc;

    /* renamed from: w  reason: collision with root package name */
    protected final n f32164w;
    private long wo;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.c wv;
    protected r wx;

    /* renamed from: x  reason: collision with root package name */
    private final AtomicBoolean f32165x;
    protected int xk;
    private com.bytedance.sdk.openadsdk.n.c xu;
    protected final AtomicBoolean xv;

    /* renamed from: y  reason: collision with root package name */
    protected int f32166y;
    protected boolean ys;
    protected int yu;

    /* renamed from: z  reason: collision with root package name */
    protected TTBaseVideoActivity f32167z;

    public TTBaseVideoActivity() {
        this.f32151c = c() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.f32164w = new n(Looper.getMainLooper(), this);
        this.xv = new AtomicBoolean(false);
        this.sr = new AtomicBoolean(false);
        this.ux = new ConcurrentHashMap<>();
        this.f32152f = new AtomicBoolean(false);
        this.f32160r = new AtomicBoolean(false);
        this.ev = new AtomicBoolean(false);
        this.bw = new AtomicBoolean(false);
        this.f32165x = new AtomicBoolean(false);
        this.gd = new AtomicBoolean(false);
        this.f32158p = new AtomicBoolean(false);
        this.f32155k = new AtomicBoolean(false);
        this.f32149a = new AtomicBoolean(false);
        this.bk = new AtomicBoolean(false);
        this.mt = 1;
        this.bj = null;
        this.f32150b = 0L;
        this.pr = new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.1
            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void c(long j4, int i4) {
                TTBaseVideoActivity.this.f32164w.removeMessages(300);
                TTBaseVideoActivity.this.i();
                if (!TTBaseVideoActivity.this.ls.bk()) {
                    if (TTBaseVideoActivity.this.be()) {
                        f fVar = TTBaseVideoActivity.this.ls;
                        fVar.w(fVar.wv());
                    } else {
                        f fVar2 = TTBaseVideoActivity.this.ls;
                        fVar2.w(fVar2.me() + 1000);
                    }
                }
                if (TTBaseVideoActivity.this.ck.f() && !TTBaseVideoActivity.this.ls.bk()) {
                    TTBaseVideoActivity.this.fz.w(true);
                }
                TTBaseVideoActivity.this.sr();
            }

            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void w(long j4, int i4) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity.ys) {
                    tTBaseVideoActivity.f32164w.removeMessages(300);
                    TTBaseVideoActivity.this.s();
                    TTBaseVideoActivity.this.ls.c(5);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tTBaseVideoActivity2.w(tTBaseVideoActivity2.ls.w());
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void c() {
                TTBaseVideoActivity.this.f32164w.removeMessages(300);
                TTBaseVideoActivity.this.i();
                TTBaseVideoActivity.this.c(false, false);
                TTBaseVideoActivity.this.ls.c(6);
                TTBaseVideoActivity.this.ls.gd();
            }

            @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
            public void c(long j4, long j5) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (!tTBaseVideoActivity.ys && tTBaseVideoActivity.ls.w()) {
                    TTBaseVideoActivity.this.ls.p();
                }
                boolean z3 = true;
                if (TTBaseVideoActivity.this.f32159q.yu()) {
                    TTBaseVideoActivity.this.ls.xv(true);
                    return;
                }
                TTBaseVideoActivity.this.f32164w.removeMessages(300);
                if (j4 != TTBaseVideoActivity.this.ls.me()) {
                    TTBaseVideoActivity.this.i();
                }
                if (TTBaseVideoActivity.this.ls.w() || j5 == j4) {
                    TTBaseVideoActivity.this.ls.w(j4);
                    if (TTBaseVideoActivity.this.ok()) {
                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                        ux uxVar = tTBaseVideoActivity2.fz;
                        String valueOf = String.valueOf(tTBaseVideoActivity2.ls.eq());
                        int me = (int) (TTBaseVideoActivity.this.ls.me() / 1000);
                        if (j4 != j5 && !TTBaseVideoActivity.this.ls.yu()) {
                            z3 = false;
                        }
                        uxVar.c(valueOf, me, 0, z3);
                    }
                    TTBaseVideoActivity.this.xv(0);
                    TTBaseVideoActivity.this.up();
                    TTBaseVideoActivity.this.ck.u();
                }
            }
        };
        this.ng = new c.InterfaceC0499c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
            public boolean ba() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
            public com.bytedance.sdk.openadsdk.core.multipro.w.c eq() {
                com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
                f fVar = TTBaseVideoActivity.this.ls;
                if (fVar != null) {
                    cVar.f33979r = fVar.ia();
                    cVar.f33977c = TTBaseVideoActivity.this.ls.c();
                    cVar.ev = TTBaseVideoActivity.this.f32162t;
                }
                return cVar;
            }
        };
        this.ok = new AtomicBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean be() {
        com.bykv.vk.openvk.component.video.api.sr.xv x3 = bj().x();
        if (x3 instanceof com.bytedance.sdk.openadsdk.core.video.w.c) {
            return ((com.bytedance.sdk.openadsdk.core.video.w.c) x3).wv();
        }
        return false;
    }

    private void bs() {
        final View view;
        try {
            view = getWindow().getDecorView();
        } catch (Throwable unused) {
            view = null;
        }
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    view.findViewById(16908335).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        view.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    view.findViewById(16908335).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    private void eu() {
        if (this.f32159q.yu() || !this.ys || this.ls.ck() || !this.ck.oo() || this.ls.gw()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if ((cVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.xv) || (cVar instanceof k)) {
            return;
        }
        this.f32164w.removeMessages(300);
        this.f32164w.sendEmptyMessageDelayed(300, 5000L);
    }

    private void fm() {
        a.w("TTBaseVideoActivity", "initAdType start");
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c c4 = com.bytedance.sdk.openadsdk.core.component.reward.sr.sr.c(this.f32167z, this.ba);
        this.ck = c4;
        if (c4 == null) {
            a.f("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        a.w("TTBaseVideoActivity", "initAdType end, type : " + this.ck.getClass().getSimpleName());
        this.f32162t = ls.w().c(this.ba, this.f32166y);
        this.ck.c(this.f32153i, this.ls, this.f32159q, this.gb, this.f32154j);
        this.ck.c(this.f32151c, this.f32162t, c());
        this.ck.ev();
    }

    private int g() {
        com.bykv.vk.openvk.component.video.api.sr.xv x3 = bj().x();
        if (x3 instanceof com.bytedance.sdk.openadsdk.core.video.w.c) {
            return ((com.bytedance.sdk.openadsdk.core.video.w.c) x3).bj();
        }
        return 0;
    }

    private void ge() {
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.ba, getClass().getName());
        this.f32166y = wv.gd(this.ba);
        this.up = this.ba.yx();
        this.mt = this.ba.fh();
        this.yu = c() ? ls.w().ux(this.f32166y) : ls.w().f(this.f32166y);
        m.c(this.ba, false);
        m.w(this.ba, false);
        com.bytedance.sdk.openadsdk.core.r.xv.xv = false;
        com.bytedance.sdk.openadsdk.core.r.xv.f34518w = 0;
        com.bytedance.sdk.openadsdk.core.r.xv.f34517c = 0;
        com.bytedance.sdk.openadsdk.core.r.xv.sr = false;
    }

    private boolean h() {
        if (this.ba != null && TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(this.ba)) {
            String my = this.ba.my();
            if (TextUtils.isEmpty(my)) {
                return false;
            }
            try {
                return new JSONObject(my).optInt("saas_play_time_type") == 1;
            } catch (JSONException e4) {
                a.xv("TTBaseVideoActivity", e4);
            }
        }
        return false;
    }

    private boolean lf() {
        w.c cVar = this.bm;
        return cVar != null && cVar.sr();
    }

    private void mu() {
        this.f32155k.set(true);
    }

    private void ng() {
        if (fp.sr(this.ba)) {
            this.ls.vc();
            return;
        }
        ia();
        if (!m.ia(this.ba)) {
            com.bykv.vk.openvk.component.video.api.sr.xv x3 = bj().x();
            if ((x3 instanceof com.bytedance.sdk.openadsdk.core.video.c.c) && ((com.bytedance.sdk.openadsdk.core.video.c.c) x3).wv()) {
                mu();
            } else {
                sr(0);
                this.f32153i.c(false, null, "\u8df3\u8fc7", false, true);
            }
        } else {
            mu();
        }
        if (m.r(this.ba) && this.ls.q() >= m.p(this.ba)) {
            sr(2);
        }
        this.ck.me();
    }

    private void oh() {
        this.ia = new RewardFullBaseLayout(this.f32167z);
        this.f32153i = new com.bytedance.sdk.openadsdk.core.component.reward.w.ux(this.f32167z);
        this.f32159q = new com.bytedance.sdk.openadsdk.core.component.reward.w.w(this.f32167z);
        this.f32154j = new com.bytedance.sdk.openadsdk.core.component.reward.w.c(this.f32167z);
        this.ls = new f(this.f32167z);
        this.gb = new sr(this.f32167z);
        this.f32157n = new com.bytedance.sdk.openadsdk.core.component.reward.w.xv(this.f32167z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ok() {
        return (this.ba.tz() == 180 && m.ia(this.ba) && gd.c(this.ba) && this.fz.gd() == 7) ? false : true;
    }

    private void ta() {
        try {
            requestWindowFeature(1);
            getWindow().addFlags(16777216);
            getWindow().addFlags(128);
            ls.c(this.f32167z);
            if (!this.ck.vc()) {
                getWindow().addFlags(1024);
            }
        } catch (Throwable unused) {
        }
        final View view = null;
        try {
            view = getWindow().getDecorView();
        } catch (Throwable unused2) {
        }
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (xk.w() && TTBaseVideoActivity.this.mt == 1 && TTBaseVideoActivity.this.f32167z.getResources().getConfiguration().orientation == 1 && Build.VERSION.SDK_INT >= 19) {
                        if (Math.abs(xk.gd((Context) TTBaseVideoActivity.this.f32167z) - TTBaseVideoActivity.this.getWindow().getDecorView().getHeight()) == 0 && view.isAttachedToWindow()) {
                            View view2 = view;
                            view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop() + ((int) xk.k(TTBaseVideoActivity.this.f32167z)), view.getPaddingRight(), view.getPaddingBottom());
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        });
    }

    private void te() {
        me meVar = this.ba;
        if (meVar == null || this.ia == null) {
            return;
        }
        String my = meVar.my();
        if (TextUtils.isEmpty(my)) {
            return;
        }
        try {
            int optInt = new JSONObject(my).optInt("auth_reward_gold");
            if (optInt > 0) {
                this.ia.addView(new RewardAuthToastLayout(this.f32167z, optInt));
            }
        } catch (JSONException e4) {
            a.xv("TTBaseVideoActivity", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        if (z()) {
            eu();
            this.ls.c(false, this, this.sr.getAndSet(true));
            return;
        }
        this.ls.up();
    }

    private void xu() {
        if (this.ls.xk().xu()) {
            if (this.ba.sc() == 9 && this.ls.wx()) {
                a.w("hlt", " 9 end");
                this.fz.w(true);
                this.ls.m();
            } else {
                a.w("hlt", " 6/8 end");
                this.fz.w(false);
            }
            f(1);
            return;
        }
        this.fz.w(true);
        if (this.ls.xk().bj() < 2) {
            ng();
        }
        if (this.ba.sc() == 8) {
            a.w("hlt", " 8 st");
            f(1);
            return;
        }
        a.w("hlt", " 6/9 st");
        j();
    }

    public Map<String, Object> a() {
        ux uxVar;
        Map<String, Object> gw = gw();
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (cVar == null) {
            return gw;
        }
        if (cVar.f() && (uxVar = this.fz) != null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.ls.c(gw, this.ba, uxVar.bk());
        }
        if (this.ck.bj() && u.sr(this.ba)) {
            gw.put("openPlayableLandingPage", this.fz.p());
        }
        return gw;
    }

    public boolean au() {
        return this.gb.ev() || this.f32159q.yu();
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.sr.c b() {
        return this.ck;
    }

    public int ba() {
        return 0;
    }

    public f bj() {
        return this.ls;
    }

    protected void bk() {
        float[] c4 = com.bytedance.sdk.openadsdk.core.component.reward.ux.w.c(StubApp.getOrigApplicationContext(this.f32167z.getApplicationContext()), this.up, this.mt);
        float f4 = c4[0];
        float f5 = c4[1];
        if (this.up == 100.0f) {
            this.oo = (int) f4;
            this.au = (int) f5;
            return;
        }
        int[] c5 = com.bytedance.sdk.openadsdk.core.component.reward.ux.w.c(StubApp.getOrigApplicationContext(this.f32167z.getApplicationContext()), this.up, this.ba.ee(), this.mt);
        int i4 = c5[0];
        int i5 = c5[1];
        int i6 = c5[2];
        int i7 = c5[3];
        float f6 = i4;
        float f7 = i6;
        this.oo = (int) ((f4 - f6) - f7);
        float f8 = i5;
        float f9 = i7;
        this.au = (int) ((f5 - f8) - f9);
        if (!com.bytedance.sdk.openadsdk.core.u.ls.c(this.ba) || com.bytedance.sdk.openadsdk.core.bk.sr.c(String.valueOf(this.f32166y))) {
            try {
                getWindow().getDecorView().setPadding(xk.ux(this.f32167z, f6), xk.ux(this.f32167z, f8), xk.ux(this.f32167z, f7), xk.ux(this.f32167z, f9));
            } catch (Throwable unused) {
            }
            a.w("TTBaseVideoActivity", "initScreenOrientationAndSize , orientation: " + this.mt + "; aspectRatio: " + this.up + "; width: " + f4 + "; height: " + f5);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.w.xv bm() {
        return this.f32157n;
    }

    public void bw() {
        this.f32164w.removeMessages(600);
    }

    protected abstract void c(String str);

    public abstract boolean c();

    public abstract boolean c(long j4, boolean z3);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ck() {
        return lf() || gb() || this.ck.y();
    }

    public String eq() {
        return "";
    }

    @Override // android.app.Activity
    public void finish() {
        HashMap hashMap = new HashMap();
        com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar = this.f32159q;
        if (wVar != null) {
            wVar.c(hashMap);
            this.f32159q.sr();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (cVar != null) {
            cVar.w(hashMap);
        }
        com.bytedance.sdk.openadsdk.core.a.xv.f(this.ba, this.f32151c, "click_close", hashMap);
        xv();
        super.finish();
    }

    public void fp() {
        if (!this.ck.oo()) {
            a.w("TTBaseVideoActivity", "video timeout but back because no video area");
            return;
        }
        this.ls.c(3);
        this.ls.u();
        this.ls.xv(true);
        c(false, false);
    }

    public void fz() {
        if (this.f32158p.get() || this.ev.getAndSet(true)) {
            return;
        }
        c("onSkippedVideo");
    }

    protected boolean gb() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.wv;
        if (cVar != null) {
            return cVar.xv();
        }
        return false;
    }

    public void gd(int i4) {
    }

    public Map<String, Object> gw() {
        HashMap hashMap = new HashMap();
        String str = this.me;
        if (str != null) {
            hashMap.put("rit_scene", str);
        }
        this.f32157n.c(hashMap);
        return hashMap;
    }

    protected void i() {
        this.f32164w.removeMessages(400);
    }

    public void ia() {
        if (this.f32158p.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.ba, "stats_reward_full_completed", this.f32157n.c(new JSONObject()));
        c("onVideoComplete");
    }

    public void j() {
        if (this.fz != null) {
            a.w("hlt", "vlb");
            this.fz.c("videoLoopBegin", (JSONObject) null);
        }
    }

    void k() {
        r rVar = new r(this.f32167z, this.ba, this.f32151c, c() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.w.r
            public void w(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                TTBaseVideoActivity.this.c(2);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.f32154j.c(view, tTBaseVideoActivity.vc, gdVar);
                TTBaseVideoActivity.this.ck.c(view);
            }
        };
        this.wx = rVar;
        if (this.ck instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.f) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) rVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.ng);
        }
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.wx.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        this.wx.c(this.f32161s.bk());
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.wx.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(gw());
        com.bytedance.sdk.openadsdk.core.w.w wVar = new com.bytedance.sdk.openadsdk.core.w.w(this.f32167z, this.ba, this.f32151c, c() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.13
            @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                TTBaseVideoActivity.this.f32157n.c(view, gdVar);
            }
        };
        this.f32156m = wVar;
        c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        this.vc = new c.InterfaceC0483c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.InterfaceC0483c
            public void c(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.f32157n.c(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.InterfaceC0483c
            public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
                TTBaseVideoActivity.this.f32157n.c(view, gdVar);
            }
        };
        this.gw = new c.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.w
            public void c(boolean z3) {
                if (z3) {
                    TTBaseVideoActivity.this.f32159q.c(1, 0);
                }
                TTBaseVideoActivity.this.w("\u70b9\u51fb\u5f00\u59cb\u4e0b\u8f7d");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.w
            public void w(boolean z3, long j4, long j5, String str, String str2) {
                if (z3) {
                    TTBaseVideoActivity.this.f32159q.c(j5, j4, 2);
                }
                TTBaseVideoActivity.this.w("\u4e0b\u8f7d\u6682\u505c");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.w
            public void xv(boolean z3, long j4, long j5, String str, String str2) {
                if (z3) {
                    TTBaseVideoActivity.this.f32159q.c(j5, j4, 4);
                }
                TTBaseVideoActivity.this.w("\u4e0b\u8f7d\u5931\u8d25");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.w
            public void c(boolean z3, long j4, long j5, String str, String str2) {
                if (z3) {
                    TTBaseVideoActivity.this.f32159q.c(j5, j4, 3);
                }
                if (j4 > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.w("\u5df2\u4e0b\u8f7d" + ((int) ((j5 * 100) / j4)) + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.w
            public void c(boolean z3, long j4, String str, String str2) {
                if (z3) {
                    TTBaseVideoActivity.this.f32159q.c(5, 100);
                }
                TTBaseVideoActivity.this.w("\u70b9\u51fb\u5b89\u88c5");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.c.w
            public void c(boolean z3, String str, String str2) {
                if (z3) {
                    TTBaseVideoActivity.this.f32159q.c(6, 100);
                }
                TTBaseVideoActivity.this.w("\u70b9\u51fb\u6253\u5f00");
            }
        };
        this.ck.c(this.wx);
    }

    public void ls() {
        ev();
    }

    public void m() {
        if (this.ck instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.gd) {
            this.f32164w.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.xg();
                }
            }, 500L);
        } else {
            xg();
        }
        if (ck()) {
            return;
        }
        if (this.f32159q.eq()) {
            this.f32164w.sendEmptyMessageDelayed(1200, 1000L);
        }
        if (!this.ls.ck() || this.f32159q.yu() || this.f32159q.eq()) {
            this.ck.q();
        }
        this.f32159q.xv();
    }

    public String me() {
        return "";
    }

    public void mt() {
        if (this.f32149a.getAndSet(true)) {
            return;
        }
        f(3);
    }

    public void n() {
        this.gb.r();
        this.f32159q.wx();
        this.ls.mt();
        this.f32153i.c(1);
        this.f32164w.removeMessages(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 0);
            if (c()) {
                jSONObject.put("reduce_duration", this.xk);
            }
            this.fz.c("playableStateChange", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xk.w((Activity) this.f32167z);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i4) {
                    if (i4 == 0) {
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.mt == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        xk.c((Activity) TTBaseVideoActivity.this.f32167z);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        xk.w((Activity) TTBaseVideoActivity.this.f32167z);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        me meVar = this.ba;
        if (meVar == null) {
            return;
        }
        if (me.xv(meVar) || this.ba.ms() == 1 || (this.ck instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.gd)) {
            this.f32159q.t();
        }
        if (fp.k(this.ba)) {
            t();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32167z = this;
        oh();
        c(getIntent());
        w(bundle);
        if (c(bundle)) {
            ge();
            fm();
            ta();
            bk();
            this.ck.c(this.oo, this.au);
            setContentView(this.ia);
            r();
            this.ck.w();
            ux uxVar = this.fz;
            if (uxVar != null) {
                uxVar.c(this.ng);
            }
            if (h()) {
                this.ox = new com.bytedance.sdk.openadsdk.core.component.reward.ux.xv();
            }
            SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
            if (saasAuthRewardDialog != null) {
                saasAuthRewardDialog.c(this.ba, this.f32151c, c() ? 7 : 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a.w("TTBaseVideoActivity", "onDestroy");
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.ba, "stats_reward_full_destroy");
        com.bytedance.sdk.openadsdk.core.r.xv.xv = false;
        com.bytedance.sdk.openadsdk.core.r.xv.f34518w = 0;
        com.bytedance.sdk.openadsdk.core.r.xv.f34517c = 0;
        com.bytedance.sdk.openadsdk.core.r.xv.sr = false;
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (cVar != null) {
            cVar.ys();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar2 = this.wv;
        if (cVar2 != null) {
            cVar2.w();
        }
        this.f32164w.removeCallbacksAndMessages(null);
        this.ls.n();
        this.f32154j.f();
        this.f32159q.f();
        this.gb.xv();
        w();
        xv();
        c("recycleRes");
        me meVar = this.ba;
        if (meVar != null) {
            gb.c(meVar.iy());
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        a.w("TTBaseVideoActivity", "onPause");
        x();
        this.ys = false;
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (cVar != null) {
            cVar.t();
        }
        this.f32154j.ux();
        this.gb.w();
        this.f32159q.sr();
        com.bytedance.sdk.openadsdk.core.component.reward.ux.xv xvVar = this.ox;
        if (xvVar != null) {
            xvVar.xv();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a.w("TTBaseVideoActivity", "onResume");
        com.bytedance.sdk.openadsdk.core.component.reward.ux.xv xvVar = this.ox;
        if (xvVar != null) {
            xvVar.sr();
            k((int) this.ox.c(TimeUnit.SECONDS));
            this.ox.ux();
            if (this.fz != null && !m.ia(this.ba)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", this.xk);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                this.fz.c("reduceTime", jSONObject);
            }
        }
        this.ys = true;
        this.f32159q.w();
        this.f32154j.sr();
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (cVar != null) {
            cVar.w(this.ux.containsKey(0));
            m();
            this.gb.c();
            bs();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.eq);
            bundle.putBoolean("is_preload", this.fp);
            bundle.putLong("video_current", this.ls.ia());
            bundle.putBoolean("is_mute", this.f32162t);
            bundle.putString("rit_scene", this.me);
            Double d4 = this.bj;
            bundle.putString("_client_bidding_aution_price", d4 == null ? "" : String.valueOf(d4));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSkipBorderClick(View view) {
        this.ck.w(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f32159q.k();
        com.bytedance.sdk.openadsdk.n.c cVar = this.xu;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        a.w("TTBaseVideoActivity", "onStop");
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (cVar != null) {
            cVar.xv(this.f32152f.get());
        }
        this.f32159q.ux();
        com.bytedance.sdk.openadsdk.n.c cVar2 = this.xu;
        if (cVar2 != null) {
            cVar2.w();
        }
    }

    public int oo() {
        return this.xk;
    }

    public void ox() {
        this.f32153i.a();
    }

    protected void p() {
    }

    public void p(int i4) {
        com.bytedance.sdk.openadsdk.core.video.w.w wv;
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        if (!(cVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.gd) || (wv = cVar.wv()) == null) {
            return;
        }
        if (wv.k() == 1 && i4 == 1 && this.ok.getAndSet(false)) {
            int ev = xk.ev(ls.getContext());
            float f4 = xk.f(ls.getContext());
            float r3 = xk.r(ls.getContext());
            Map<String, Object> gw = gw();
            gw.putAll(wv.r());
            com.bytedance.sdk.openadsdk.core.a.xv.c("click", this.ba, new ev.c().f(-1.0f).ux(-1.0f).sr(-1.0f).xv(-1.0f).w(-1L).c(-1L).xv(-1).sr(-1).ux(-1024).w(com.bytedance.sdk.openadsdk.core.k.sr().w() ? 1 : 2).c(ev).c(f4).w(r3).c(), this.f32151c, true, gw, -1, false);
        }
    }

    public int pr() {
        return Math.max(this.yu - (((int) (this.ls.me() / 1000)) + this.xk), 0);
    }

    protected void q() {
        if (!be()) {
            j();
        }
        this.ls.k();
    }

    public void s() {
        if (this.gd.getAndSet(true)) {
            return;
        }
        c("onVideoError");
    }

    public void sr(int i4) {
    }

    public void t() {
        if (this.f32159q.bk()) {
            this.f32159q.t();
        } else if (!this.f32159q.ck() && !com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.ba) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.ba)) {
            ux();
        } else {
            p pVar = new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.17
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void c() {
                    if (fp.k(TTBaseVideoActivity.this.ba)) {
                        new c.C0472c().ux(TTBaseVideoActivity.this.ba.jr()).c("rewarded_video").w("popup_play").sr(TTBaseVideoActivity.this.ba.cf()).c((com.bytedance.sdk.openadsdk.ux.c.c) null);
                        if (com.bytedance.sdk.openadsdk.core.ugeno.f.ux(TTBaseVideoActivity.this.ba) || com.bytedance.sdk.openadsdk.core.ugeno.f.sr(TTBaseVideoActivity.this.ba)) {
                            return;
                        }
                        TTBaseVideoActivity.this.xv("onClickModalCallback");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void w() {
                    if (fp.k(TTBaseVideoActivity.this.ba)) {
                        new c.C0472c().ux(TTBaseVideoActivity.this.ba.jr()).c("rewarded_video").w("popup_cancel").sr(TTBaseVideoActivity.this.ba.cf()).c((com.bytedance.sdk.openadsdk.ux.c.c) null);
                        TTBaseVideoActivity.this.fz();
                        TTBaseVideoActivity.this.ux();
                    }
                }
            };
            if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.ba) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.ba)) {
                xv(pVar);
            } else {
                w(pVar);
            }
        }
    }

    public void u() {
        this.f32164w.removeMessages(700);
        this.f32164w.removeMessages(600);
    }

    public void up() {
    }

    public Double vc() {
        return this.bj;
    }

    protected abstract void w();

    public boolean wo() {
        return this.ux.containsKey(0);
    }

    public RewardFullBaseLayout wv() {
        return this.ia;
    }

    public n wx() {
        return this.f32164w;
    }

    public void x() {
        sr(false);
    }

    public void xk() {
        boolean z3 = !this.f32162t;
        this.f32162t = z3;
        this.ck.ux(z3);
    }

    protected abstract void xv();

    public void xv(int i4) {
    }

    public String y() {
        return "";
    }

    public boolean ys() {
        if (c() && ls.w().ev(String.valueOf(this.f32166y)) && !this.ux.containsKey(0)) {
            if (System.currentTimeMillis() - this.f32150b < 1000) {
                return true;
            }
            this.f32150b = System.currentTimeMillis();
            x();
            this.f32164w.removeMessages(1200);
            com.bytedance.sdk.openadsdk.core.component.reward.xv.ev evVar = new com.bytedance.sdk.openadsdk.core.component.reward.xv.ev(this.f32167z, this.ba);
            evVar.c(this.f32159q.fz());
            evVar.c(this.ck.pr());
            evVar.w(true);
            w.c w3 = evVar.w(new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void c() {
                    TTBaseVideoActivity.this.m();
                    TTBaseVideoActivity.this.f32164w.sendEmptyMessageDelayed(1200, 1000L);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.f32157n.c("reward_retain_dialog_cancel", tTBaseVideoActivity.bm.c(), TTBaseVideoActivity.this.bm.w());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void w() {
                    TTBaseVideoActivity.this.m();
                    TTBaseVideoActivity.this.f32159q.c(true);
                    TTBaseVideoActivity.this.f32159q.i();
                    TTBaseVideoActivity.this.f();
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.f32157n.c("reward_retain_dialog_skip", tTBaseVideoActivity.bm.c(), TTBaseVideoActivity.this.bm.w());
                }
            });
            this.bm = w3;
            this.f32157n.c("reward_retain_dialog_show", w3.c(), this.bm.w());
            return this.bm.xv();
        }
        return false;
    }

    public void yu() {
        this.gb.f();
    }

    public boolean z() {
        if (ck() || this.ls.gw()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar = this.ck;
        return ((cVar != null && !cVar.oo()) || this.gb.ev() || this.f32159q.yu()) ? false : true;
    }

    private void xv(final p pVar) {
        final boolean[] zArr = {false};
        com.bytedance.sdk.openadsdk.ev.c.xv.c(new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.18
            @Override // com.bytedance.sdk.openadsdk.ev.c.xv.c
            public void c() {
                zArr[0] = true;
                pVar.w();
            }

            @Override // com.bytedance.sdk.openadsdk.ev.c.xv.c
            public void c(int i4) {
                zArr[0] = true;
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this.f32167z;
                if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
                    TTBaseVideoActivity.this.f32167z.getIntent().putExtra("remainTime", i4);
                }
                if (i4 <= 0 || !TTBaseVideoActivity.this.c(pVar)) {
                    pVar.w();
                }
            }
        });
        xv("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.ux();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(Bundle bundle) {
        me c4 = wv.c(getIntent());
        this.ba = c4;
        this.f32154j.c(c4, this.f32151c, this.eq);
        if (bundle != null) {
            this.f32154j.c();
        }
        com.bytedance.sdk.openadsdk.core.ux.c().w(this.ba);
        if (this.ba == null) {
            a.f("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
            ux();
            return false;
        }
        return true;
    }

    protected void ev() {
        com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar;
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.ba, "stats_reward_full_show_endcard");
        a.w("TTBaseVideoActivity", "showEndCard start");
        if (isDestroyed() || isFinishing() || (wVar = this.f32159q) == null || wVar.yu()) {
            return;
        }
        if (!fp.sr(this.ba)) {
            this.f32159q.sr(true);
        }
        this.ck.ls();
        if ((!(this.ck instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.ev) && !wx.q(this.ba)) || !this.f32159q.s() || (this.ck instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.gd)) {
            this.f32159q.i();
        }
        this.f32153i.c(true);
        this.gb.c(this.f32162t);
        this.f32159q.p();
        if ((this.ck instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.ev) && this.f32159q.y()) {
            return;
        }
        this.f32153i.r();
        this.f32153i.c(2);
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.wv;
        if (cVar != null) {
            cVar.w();
        }
        w.c cVar2 = this.bm;
        if (cVar2 != null) {
            cVar2.ux();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar2 = this.f32161s;
        if (wVar2 != null) {
            wVar2.ux(8);
        }
        this.f32159q.xv(false);
        if (this.f32159q.ys()) {
            if (!ng.gd(this.ba) && !u.xv(this.ba)) {
                a.w("TTBaseVideoActivity", "TimeTrackLog report Success from Android");
                this.f32159q.c(true, 0, (String) null);
            }
            this.f32159q.a();
            this.f32164w.sendEmptyMessageDelayed(500, 100L);
            return;
        }
        a.w("TTBaseVideoActivity", "showEndCard isEndCardLoadSuc=" + this.f32159q.fp() + " so load back up end card");
        if (!ng.gd(this.ba)) {
            a.w("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page");
            this.f32159q.c(false, 408, "end_card_timeout");
        }
        this.f32159q.ux(true);
        this.ls.ev();
        this.f32159q.q();
    }

    public void f() {
        this.ls.m();
        this.ls.c(2);
        this.ls.gd();
        fz();
        f(2);
    }

    public void gd() {
        if (!this.ck.oo()) {
            if (u.gd(this.ba)) {
                return;
            }
            w(true, true);
            return;
        }
        a.w("TTBaseVideoActivity", "bindVideoAd start");
        if (!c(this.ls.f(), false)) {
            c(true, true);
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        this.ia.c(this.ck);
        te();
        this.f32161s = this.ck.c(c());
        this.fz = this.ck.a();
        this.f32163u = this.ck.bk();
        this.f32161s.c();
        k();
        this.f32161s.c(this.wx, this.f32156m);
        this.f32161s.c(this.f32154j.r());
        this.f32153i.c(this.ba, this.f32159q, c(), this.wx);
        this.f32153i.sr(this.f32162t);
        if (this.f32154j.xv()) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wx.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f32154j.w());
            this.f32154j.c(this.vc);
        }
        this.f32154j.c(this.gw);
        this.f32154j.c(this.ng);
        this.f32159q.c(this.f32153i, this.f32154j, c(), this.f32151c, this.oo, this.au);
        this.f32159q.c(this.ba, this.wx, this.ng.eq(), this.f32163u);
        this.gb.c(this.f32159q, this.ba, this.f32151c, this.f32153i);
        this.f32157n.c(this.ba, this.f32151c, this.f32161s.bk());
        this.ls.c(this.ba);
        this.xu = new com.bytedance.sdk.openadsdk.n.c();
    }

    public void sr() {
        if (be()) {
            xu();
            return;
        }
        if (!this.ls.wx() && !this.ls.bk()) {
            ng();
        }
        f(1);
    }

    public void ux() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(long j4, boolean z3) {
        if (this.ls.ls()) {
            if (!z3 || !this.ls.gb()) {
                eu();
            }
            boolean c4 = this.ls.c(j4, this.f32162t, this.ck.j());
            if (c4 && !z3) {
                if (u.gd(this.ba)) {
                    return true;
                }
                w(true, true);
            }
            return c4;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r3 >= 1) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r7 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        if (r6.bk.get() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r7 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
        if (r7 != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int ux(int r7) {
        /*
            r6 = this;
            r0 = 2
            r1 = 1
            if (r7 != r0) goto L6
            r7 = 1
            goto L7
        L6:
            r7 = 0
        L7:
            com.bytedance.sdk.openadsdk.core.component.reward.sr.c r2 = r6.ck
            boolean r2 = r2.mt()
            com.bytedance.sdk.openadsdk.core.u.me r3 = r6.ba
            int r3 = r3.sc()
            r4 = 4
            r5 = 3
            switch(r3) {
                case 1: goto L42;
                case 2: goto L18;
                case 3: goto L40;
                case 4: goto L3b;
                case 5: goto L3b;
                case 6: goto L38;
                case 7: goto L2d;
                case 8: goto L1a;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r4 = 2
            goto L43
        L1a:
            boolean r3 = r6.be()
            if (r3 == 0) goto L2a
            int r3 = r6.g()
            if (r7 == 0) goto L27
            goto L42
        L27:
            if (r3 < r1) goto L43
            goto L18
        L2a:
            if (r7 == 0) goto L18
            goto L42
        L2d:
            if (r7 == 0) goto L18
            java.util.concurrent.atomic.AtomicBoolean r3 = r6.bk
            boolean r3 = r3.get()
            if (r3 == 0) goto L18
            goto L42
        L38:
            if (r7 == 0) goto L43
            goto L42
        L3b:
            if (r7 == 0) goto L3e
            goto L42
        L3e:
            r4 = 3
            goto L43
        L40:
            if (r7 == 0) goto L18
        L42:
            r4 = 1
        L43:
            com.bytedance.sdk.openadsdk.core.u.me r3 = r6.ba
            boolean r3 = com.bytedance.sdk.openadsdk.core.u.m.ia(r3)
            if (r3 == 0) goto L4e
            if (r4 != r5) goto L4e
            r4 = 1
        L4e:
            if (r4 != r0) goto L53
            if (r2 != 0) goto L53
            r4 = 1
        L53:
            com.bytedance.sdk.openadsdk.core.component.reward.sr.c r0 = r6.ck
            boolean r0 = r0 instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.f
            if (r0 == 0) goto L65
            com.bytedance.sdk.openadsdk.core.u.me r0 = r6.ba
            boolean r0 = com.bytedance.sdk.openadsdk.n.gd.c(r0)
            if (r0 == 0) goto L65
            if (r7 == 0) goto L64
            return r1
        L64:
            return r5
        L65:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.ux(int):int");
    }

    public void xv(String str) {
        com.bytedance.sdk.openadsdk.core.xk z3 = this.f32159q.z();
        if (z3 != null && !isFinishing()) {
            try {
                z3.w(str, (JSONObject) null);
                return;
            } catch (Exception e4) {
                ux();
                e4.printStackTrace();
                return;
            }
        }
        ux();
    }

    public void a(int i4) {
        this.f32161s.ux(i4);
    }

    protected void f(int i4) {
        int ux = ux(i4);
        if (i4 != 2) {
            if (this.gb.ev()) {
                return;
            }
            if (this.ls.bk()) {
                this.ls.k();
                return;
            } else if (m.ia(this.ba)) {
                if (this.f32155k.get() && !this.f32149a.get()) {
                    if (ux == 1 && !this.ux.containsKey(0) && c()) {
                        this.f32153i.w((this.ba.v() == 3 && m.s(this.ba)) ? "\u5956\u52b1\u5c31\u5feb\u6765\u4e86\n\u53bb\u8be6\u60c5\u9875\u770b\u770b\u4e5f\u7d2f\u8ba1\u65f6\u957f\u54e6\uff5e" : "\u5956\u52b1\u8fd8\u5728\u8def\u4e0a\u72c2\u5954\n\u518d\u7b49\u4e00\u4e0b\u4e0b\u54e6\uff5e");
                    }
                    this.ls.vc();
                }
                if (!this.f32155k.get() && this.f32149a.get() && (!be() || i4 == 3)) {
                    return;
                }
                if (ux == 1 && (!this.f32155k.get() || !this.f32149a.get())) {
                    return;
                }
            }
        }
        if (ux == 1) {
            ux();
        } else if (ux == 2) {
            if (this.f32160r.get()) {
                this.f32159q.i();
            }
            ev();
        } else if (ux == 3) {
            this.ls.vc();
        } else if (ux == 4 && i4 != 3) {
            q();
        }
    }

    public void sr(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.wv == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.c(this.f32167z, this.ba.ve(), this.f32151c, true);
            this.wv = cVar;
            com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.f32167z, cVar, this.ba);
            this.wv.c(new c.InterfaceC0490c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                public void c() {
                    TTBaseVideoActivity.this.x();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                public void w() {
                    TTBaseVideoActivity.this.m();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
                public void c(int i4, String str2, boolean z3) {
                    TTBaseVideoActivity.this.f32164w.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.m();
                        }
                    });
                }
            });
        }
        this.wv.c(str);
        this.wv.c();
    }

    public void w(String str) {
        this.f32159q.c(str);
    }

    private void w(p pVar) {
        int yu = this.ck.yu();
        TTBaseVideoActivity tTBaseVideoActivity = this.f32167z;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.f32167z.getIntent().putExtra("remainTime", yu);
        }
        if (yu > 0) {
            if (c(pVar)) {
                return;
            }
            pVar.w();
            return;
        }
        ux();
    }

    public void c(final com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar) {
        srVar.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.sr.c
            public boolean c() {
                srVar.w(TTBaseVideoActivity.this.a());
                srVar.c(TTBaseVideoActivity.this.f32151c);
                srVar.c(TTBaseVideoActivity.this.bj);
                boolean z3 = TTBaseVideoActivity.this.bw.get();
                TTBaseVideoActivity.this.f32165x.set(!z3);
                return z3;
            }
        });
    }

    public boolean c(final p pVar) {
        if (c() && ls.w().ev(String.valueOf(this.f32166y)) && !this.ux.containsKey(0) && !isFinishing()) {
            if (System.currentTimeMillis() - this.f32150b < 1000) {
                return true;
            }
            this.f32150b = System.currentTimeMillis();
            w.c c4 = this.ck.c(new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void c() {
                    p pVar2 = pVar;
                    if (pVar2 != null) {
                        pVar2.c();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.f32157n.c("reward_retain_dialog_cancel", tTBaseVideoActivity.bm.c(), TTBaseVideoActivity.this.bm.w());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void w() {
                    TTBaseVideoActivity.this.bk.set(true);
                    p pVar2 = pVar;
                    if (pVar2 != null) {
                        pVar2.w();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.f32157n.c("reward_retain_dialog_skip", tTBaseVideoActivity.bm.c(), TTBaseVideoActivity.this.bm.w());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void xv() {
                    p pVar2 = pVar;
                    if (pVar2 != null) {
                        pVar2.xv();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void c(int i4) {
                    TTBaseVideoActivity.this.k(i4);
                    com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar = TTBaseVideoActivity.this.f32153i;
                    uxVar.w("\u606d\u559c\u60a8\uff0c\u53ef\u63d0\u524d" + i4 + "s\u83b7\u5f97\u5956\u52b1\uff5e");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("time", i4);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    TTBaseVideoActivity.this.fz.c("reduceTime", jSONObject);
                }
            });
            this.bm = c4;
            this.f32157n.c("reward_retain_dialog_show", c4.c(), this.bm.w());
            return this.bm.xv();
        }
        return false;
    }

    public void xv(boolean z3) {
        this.f32154j.c(z3);
    }

    public void k(int i4) {
        this.xk += i4;
    }

    public void sr(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.sr.c cVar;
        if (this.ls.w()) {
            this.ls.p();
        }
        this.f32164w.removeMessages(300);
        this.f32164w.removeMessages(1200);
        if ((z3 && m.ia(this.ba) && this.gb.ev()) || (cVar = this.ck) == null) {
            return;
        }
        cVar.i();
        this.f32159q.w(z3);
    }

    public void w(int i4) {
        if (i4 <= 0) {
            this.f32153i.c(false, null, null, true, true);
        } else {
            this.f32164w.sendEmptyMessageDelayed(600, i4);
        }
    }

    protected void w(boolean z3) {
        Message message = new Message();
        message.what = 400;
        this.f32164w.sendMessageDelayed(message, z3 ? 2000L : 0L);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        a.w("TTBaseVideoActivity", "handleMsg:" + message.what);
        int i4 = message.what;
        if (i4 == 300) {
            fp();
        } else if (i4 == 400) {
            this.ls.gd();
            if (this.ck.f()) {
                this.fz.c(true);
            }
            c(false, true);
        } else if (i4 == 500) {
            this.f32159q.r();
            this.f32159q.q();
            this.ls.ev();
            this.f32161s.xv(false);
            this.fz.xv(false);
            this.fz.sr();
        } else if (i4 == 600) {
            this.f32153i.c(false, null, null, true, true);
        } else if (i4 != 700) {
            if (i4 == 1200 && !m.ia(this.ba)) {
                if (this.f32159q.eq()) {
                    k(1);
                    this.gb.c(pr(), this.ck.yu());
                    xv(0);
                }
                this.f32164w.sendEmptyMessageDelayed(1200, 1000L);
            }
        } else {
            this.f32159q.wv();
        }
    }

    public void w(boolean z3, boolean z4) {
        int valueOf;
        if (z3) {
            Map<String, Object> a4 = a();
            this.bw.set(true);
            if (!this.f32165x.get()) {
                try {
                    Integer remove = com.bytedance.sdk.openadsdk.core.r.xv.ux.remove(this.ba.xq());
                    if (remove == null) {
                        valueOf = 1;
                    } else {
                        valueOf = Integer.valueOf(remove.intValue() + 1);
                    }
                    com.bytedance.sdk.openadsdk.core.r.xv.ux.put(this.ba.xq(), valueOf);
                    a4.put("meta_show_count", valueOf);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.core.a.xv.c(this.ba, this.f32151c, a4, this.bj);
            }
        }
        if (z4) {
            c("onAdShow");
            if (this.ck.f()) {
                this.fz.r();
            }
        }
    }

    public void r(int i4) {
        this.ia.c(i4);
    }

    protected void w(Bundle bundle) {
        if (bundle != null) {
            this.eq = bundle.getString("multi_process_key");
            this.fp = bundle.getBoolean("is_preload");
            this.me = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.bj = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.f32162t = bundle.getBoolean("is_mute");
            long j4 = bundle.getLong("video_current");
            if (j4 > 0) {
                this.ls.c(j4);
            }
        }
    }

    public void ev(int i4) {
        int i5;
        boolean z3;
        a.w("TTBaseVideoActivity", "startPrePosePlayable");
        if (i4 == 1) {
            i5 = 3;
            z3 = true;
        } else {
            i5 = 1;
            z3 = false;
        }
        this.f32153i.c(i5);
        if (!m.ia(this.ba)) {
            this.f32153i.c(false, null, null, true, true);
        }
        this.f32153i.c(true);
        this.f32153i.ux(true);
        this.f32153i.f(z3);
        this.f32153i.w(this.ba.bx());
        this.gb.c(this.f32162t, this.ux.containsKey(0));
        this.f32164w.sendEmptyMessage(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 1);
            this.fz.c("playableStateChange", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(long j4) {
        Message obtain = Message.obtain();
        obtain.what = 700;
        this.f32164w.sendMessageDelayed(obtain, j4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.r.w
    public void c(boolean z3) {
        if (z3) {
            if (this.fz.f()) {
                return;
            }
            this.ck.sr(true);
            return;
        }
        if (this.fz.f() && this.ls.pr() != null) {
            this.ls.pr().c(8);
        }
        this.ck.sr(false);
        if (this.fz.f() || this.mt == 2 || !com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.ba)) {
            return;
        }
        this.f32161s.f(8);
    }

    protected void c(boolean z3, boolean z4) {
        this.ls.w(z4);
        s();
        if (z3) {
            if (m.ia(this.ba)) {
                this.ck.z();
            }
            ev();
            return;
        }
        boolean sr = m.sr(this.ba);
        if (m.i(this.ba)) {
            this.f32159q.bw();
        } else if (!sr) {
            sr(0);
        }
        if (this.ls.gw()) {
            return;
        }
        if (m.ia(this.ba)) {
            this.ck.z();
        }
        ev();
    }

    @Override // com.bytedance.sdk.openadsdk.core.r.w
    public void c(int i4) {
        this.f32152f.set(true);
        if (System.currentTimeMillis() - this.wo > 50) {
            this.wo = System.currentTimeMillis();
            c("onAdVideoBarClick");
        }
        p(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Intent intent) {
        if (intent != null) {
            this.me = intent.getStringExtra("rit_scene");
            this.fp = intent.getBooleanExtra("is_preload", false);
            this.eq = intent.getStringExtra("multi_process_key");
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.bj = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
        }
    }

    public void c(float f4, float f5, float f6, float f7, int i4) {
        ux uxVar = this.fz;
        if (uxVar == null || uxVar.c() == null) {
            return;
        }
        int measuredWidth = this.fz.c().getMeasuredWidth();
        int measuredHeight = this.fz.c().getMeasuredHeight();
        if (this.ls.x() instanceof com.bytedance.sdk.openadsdk.core.video.w.c ? ((com.bytedance.sdk.openadsdk.core.video.w.c) this.ls.x()).ox() : false) {
            this.fz.c().animate().translationY(-(measuredHeight * (1.0f - f5))).setDuration(i4).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f4, 1.0f, f5, measuredWidth * f6, measuredHeight * f7);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i4);
        this.fz.c().startAnimation(scaleAnimation);
    }

    public void c(me meVar, com.bytedance.sdk.openadsdk.core.w.w wVar) {
        this.f32159q.c(meVar, wVar);
        this.gb.c(meVar);
    }
}
