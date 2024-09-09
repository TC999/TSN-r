package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.eq.ck;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.w.c;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.mediation.MediationFullScreenManagerDefault;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.sdk.openadsdk.ys.w.w.a {

    /* renamed from: c  reason: collision with root package name */
    private final Context f32139c;

    /* renamed from: f  reason: collision with root package name */
    private String f32140f;
    private String gd;

    /* renamed from: p  reason: collision with root package name */
    private boolean f32142p;

    /* renamed from: r  reason: collision with root package name */
    private long f32143r;
    private com.bytedance.sdk.openadsdk.core.p.w.xv sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private final me f32145w;
    private final com.bytedance.sdk.openadsdk.ys.w.xv.w xv;
    private com.bytedance.sdk.openadsdk.q.c.w.c.c ys;
    private AtomicBoolean ev = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private int f32141k = 102;

    /* renamed from: a  reason: collision with root package name */
    private Double f32138a = null;
    private boolean bk = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f32144t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.f32139c = context;
        this.f32145w = meVar;
        this.xv = wVar;
        if (c() == 4) {
            this.sr = com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, "fullscreen_interstitial_ad");
        }
        this.ux = false;
        this.gd = meVar.hashCode() + meVar.xq() + hashCode();
    }

    private void r() {
        com.bytedance.sdk.openadsdk.q.c.w.c.c cVar = this.ys;
        if (cVar != null) {
            ev.c(this.gd, cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(boolean z3) {
    }

    public void f() {
        if (this.ev.get()) {
            return;
        }
        this.ux = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public long sr() {
        return this.f32143r;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.sr ux() {
        return new MediationFullScreenManagerDefault();
    }

    public void w(boolean z3) {
        this.f32142p = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public int xv() {
        me meVar = this.f32145w;
        if (meVar == null) {
            return -1;
        }
        if (u.ux(meVar)) {
            return 2;
        }
        if (u.f(this.f32145w)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f32145w) ? 3 : 0;
    }

    public void c(int i4) {
        this.f32141k = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public Map<String, Object> w() {
        me meVar = this.f32145w;
        if (meVar != null) {
            Map<String, Object> tc = meVar.tc();
            tc.put("expireTimestamp", Long.valueOf(sr()));
            tc.put("materialMetaIsFromPreload", Boolean.valueOf(this.f32142p));
            tc.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.sr.sr.c(this.f32145w)));
            return tc;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(com.bytedance.sdk.openadsdk.q.c.w.c.c cVar) {
        if (this.ev.get()) {
            ev.c(this.gd, cVar);
        }
        this.ys = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.sr;
        if (xvVar != null) {
            xvVar.c(c.C0501c.c(wVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
        this.f32138a = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public int c() {
        me meVar = this.f32145w;
        if (meVar == null) {
            return -1;
        }
        return meVar.v();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(Activity activity) {
        final Intent intent;
        me meVar = this.f32145w;
        String cf = meVar != null ? meVar.cf() : "";
        me meVar2 = this.f32145w;
        new c.C0472c().ux(meVar2 != null ? meVar2.jr() : "0").c("fullscreen_interstitial_ad").w("show_start").sr(cf).c((com.bytedance.sdk.openadsdk.ux.c.c) null);
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.a.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.ev.get()) {
            return;
        }
        this.ev.set(true);
        me meVar3 = this.f32145w;
        if (meVar3 != null) {
            if (ng.bk(meVar3) == null && this.f32145w.nc() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.xv.c().w("full_video_show_time", System.currentTimeMillis());
            final Context context = activity == null ? this.f32139c : activity;
            if (context == null) {
                context = ls.getContext();
            }
            r();
            if (this.f32145w.fh() == 2) {
                intent = new Intent(context, TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(268435456);
            }
            intent.putExtra("is_preload", this.ux);
            Double d4 = this.f32138a;
            intent.putExtra("_client_bidding_aution_price", d4 != null ? String.valueOf(d4) : "");
            if (!TextUtils.isEmpty(this.f32140f)) {
                intent.putExtra("rit_scene", this.f32140f);
            }
            this.f32145w.f(this.f32142p);
            this.f32145w.me(this.f32141k);
            wv.c(intent, this.f32145w);
            intent.putExtra("multi_process_key", this.gd);
            int hv = this.f32145w.hv();
            if (this.f32145w.y() == 2) {
                c(context, intent);
            } else {
                q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(context, intent);
                    }
                }, hv);
            }
            com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.f32145w).c(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.w.c(context, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.2
            @Override // com.bytedance.sdk.component.utils.w.c
            public void c() {
            }

            @Override // com.bytedance.sdk.component.utils.w.c
            public void c(Throwable th) {
                com.bytedance.sdk.component.utils.a.xv("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        me meVar = this.f32145w;
        if (meVar != null) {
            try {
                com.bytedance.sdk.openadsdk.ys.w.xv.w w3 = sr.c(this.f32139c).w(wv.c(meVar, (String) null));
                sr.c(this.f32139c).c(this.xv.f());
                if (w3 != null) {
                    if (this.ux) {
                        sr.c(this.f32139c).c(w3);
                    } else {
                        sr.c(this.f32139c).w(w3);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            com.bytedance.sdk.component.utils.a.f("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.f32140f = str;
        } else {
            this.f32140f = ritScenes.getScenesName();
        }
        c(activity);
    }

    public void c(long j4) {
        this.f32143r = j4;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
        if (this.bk) {
            return;
        }
        ck.c(this.f32145w, d4);
        this.bk = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
        if (this.f32144t) {
            return;
        }
        ck.c(this.f32145w, d4, str, str2);
        this.f32144t = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
        me meVar = this.f32145w;
        if (meVar != null) {
            gb.c(meVar.iy(), cVar);
        }
    }
}
