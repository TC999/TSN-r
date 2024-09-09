package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.ck;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.w.c;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.yu;
import com.bytedance.sdk.openadsdk.mediation.MediationRewardManagerDefault;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends fp {

    /* renamed from: a  reason: collision with root package name */
    private String f32207a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private final Context f32208c;

    /* renamed from: f  reason: collision with root package name */
    private String f32209f;
    private String fp;
    private boolean fz;
    private com.bytedance.sdk.openadsdk.gb.c.w.c.c gd;
    private String ia;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.gb.c.w.c.w f32212k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.gb.c.w.c.c f32213p;

    /* renamed from: r  reason: collision with root package name */
    private long f32215r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f32216s;
    private com.bytedance.sdk.openadsdk.core.p.w.xv sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f32217t;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private final me f32219w;
    private final com.bytedance.sdk.openadsdk.ys.w.xv.w xv;
    private final AtomicBoolean ev = new AtomicBoolean(false);
    private int ys = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f32218u = 102;

    /* renamed from: i  reason: collision with root package name */
    private Double f32210i = null;

    /* renamed from: q  reason: collision with root package name */
    private boolean f32214q = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f32211j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.f32208c = context;
        this.f32219w = meVar;
        this.xv = wVar;
        if (c() == 4) {
            this.sr = com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, "rewarded_video");
        }
        this.ux = false;
        this.f32207a = meVar.hashCode() + meVar.xq() + hashCode();
    }

    private void ev() {
        com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar = this.gd;
        if (cVar != null) {
            ev.c(this.f32207a, cVar);
        }
        if (this.f32213p != null) {
            ev.c(yu.c(this.f32207a), this.f32213p);
        }
        if (this.f32212k != null) {
            sr(true);
            ev.c(yu.w(this.f32207a), this.f32212k);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(boolean z3) {
    }

    public void f() {
        if (this.ev.get()) {
            return;
        }
        this.ux = true;
    }

    public void r() {
        if (this.f32217t) {
            return;
        }
        try {
            boolean z3 = this.ux;
            me meVar = this.f32219w;
            com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = null;
            if (meVar != null) {
                wVar = k.c(this.f32208c).w(wv.c(meVar, (String) null));
            }
            k.c(this.f32208c).c(this.xv.f());
            if (wVar != null) {
                if (z3) {
                    k.c(this.f32208c).c(wVar);
                } else {
                    k.c(this.f32208c).w(wVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public long sr() {
        return this.f32215r;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.f ux() {
        return new MediationRewardManagerDefault();
    }

    public void w(int i4) {
        this.ys = i4;
    }

    public void xv(int i4) {
        this.f32218u = i4;
    }

    public void c(int i4) {
        this.bk = i4;
    }

    public void sr(boolean z3) {
        this.f32216s = z3;
    }

    public void w(String str) {
        this.ia = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public int xv() {
        me meVar = this.f32219w;
        if (meVar == null) {
            return -1;
        }
        if (u.ux(meVar)) {
            return 2;
        }
        if (u.f(this.f32219w)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f32219w) ? 3 : 0;
    }

    public void c(String str) {
        this.fp = str;
    }

    public void w(boolean z3) {
        this.fz = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar) {
        if (this.ev.get()) {
            ev.c(this.f32207a, cVar);
        } else {
            this.gd = cVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void w(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar) {
        if (this.ev.get()) {
            ev.c(yu.c(this.f32207a), cVar);
        } else {
            this.f32213p = cVar;
        }
    }

    public void xv(boolean z3) {
        this.f32217t = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(com.bytedance.sdk.openadsdk.gb.c.w.c.w wVar) {
        if (this.ev.get()) {
            sr(true);
            ev.c(yu.w(this.f32207a), wVar);
            return;
        }
        this.f32212k = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public Map<String, Object> w() {
        me meVar = this.f32219w;
        if (meVar != null) {
            Map<String, Object> tc = meVar.tc();
            tc.put("expireTimestamp", Long.valueOf(sr()));
            tc.put("materialMetaIsFromPreload", Boolean.valueOf(this.fz));
            tc.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.sr.sr.c(this.f32219w)));
            return tc;
        }
        return null;
    }

    public void xv(String str) {
        this.f32207a = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.sr;
        if (xvVar != null) {
            xvVar.c(c.C0501c.c(wVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
        this.f32210i = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public int c() {
        me meVar = this.f32219w;
        if (meVar == null) {
            return -1;
        }
        return meVar.v();
    }

    public void c(long j4) {
        this.f32215r = j4;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(Activity activity) {
        final Intent intent;
        me meVar = this.f32219w;
        String cf = meVar != null ? meVar.cf() : "";
        me meVar2 = this.f32219w;
        new c.C0472c().ux(meVar2 != null ? meVar2.jr() : "0").c("rewarded_video").w("show_start").sr(cf).c((com.bytedance.sdk.openadsdk.ux.c.c) null);
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.a.f("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.ev.get()) {
            return;
        }
        this.ev.set(true);
        me meVar3 = this.f32219w;
        if (meVar3 == null || ng.bk(meVar3) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xv.c().c("reward_video_show_time", System.currentTimeMillis());
        final Context context = activity == null ? this.f32208c : activity;
        if (context == null) {
            context = ls.getContext();
        }
        ev();
        if (this.f32219w.fh() == 2) {
            intent = new Intent(context, TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(268435456);
        }
        if (this.f32217t) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.ys);
        } else {
            this.bk = wv.gd(this.f32219w);
        }
        intent.putExtra("source_rit_id", this.bk);
        intent.putExtra("custom_play_again", this.f32216s);
        intent.putExtra("media_extra", this.xv.ys());
        intent.putExtra("user_id", this.xv.fp());
        if (eq.f33190w >= 5204) {
            if (this.f32217t && !TextUtils.isEmpty(this.fp) && !TextUtils.isEmpty(this.ia)) {
                intent.putExtra("reward_again_name", this.fp);
                intent.putExtra("reward_again_amount", this.ia);
            }
            intent.putExtra("reward_name", this.xv.n());
            intent.putExtra("reward_amount", this.xv.ck());
        }
        intent.putExtra("is_preload", this.ux);
        Double d4 = this.f32210i;
        intent.putExtra("_client_bidding_aution_price", d4 != null ? String.valueOf(d4) : "");
        if (!TextUtils.isEmpty(this.f32209f)) {
            intent.putExtra("rit_scene", this.f32209f);
        }
        this.f32219w.f(this.fz);
        this.f32219w.me(this.f32218u);
        wv.c(intent, this.f32219w);
        intent.putExtra("multi_process_key", this.f32207a);
        if (this.f32219w.y() == 2) {
            c(context, intent);
        } else {
            q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.bk.1
                @Override // java.lang.Runnable
                public void run() {
                    bk.this.c(context, intent);
                }
            }, this.f32219w.hv());
        }
        com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.f32219w).c(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.w.c(context, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.bk.2
            @Override // com.bytedance.sdk.component.utils.w.c
            public void c() {
            }

            @Override // com.bytedance.sdk.component.utils.w.c
            public void c(Throwable th) {
                com.bytedance.sdk.component.utils.a.xv("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            com.bytedance.sdk.component.utils.a.f("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.f32209f = str;
        } else {
            this.f32209f = ritScenes.getScenesName();
        }
        c(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
        if (this.f32214q) {
            return;
        }
        ck.c(this.f32219w, d4);
        this.f32214q = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
        if (this.f32211j) {
            return;
        }
        ck.c(this.f32219w, d4, str, str2);
        this.f32211j = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
        me meVar = this.f32219w;
        if (meVar != null) {
            gb.c(meVar.iy(), cVar);
        }
    }
}
