package com.bytedance.sdk.openadsdk.core.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.reward.c;
import com.bytedance.sdk.openadsdk.core.component.reward.gd;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.playable.c;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.bytedance.sdk.openadsdk.core.u.yu;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends gd {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile k ux;

    /* renamed from: f  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.fz.c.w.c.r f32394f;

    private k(Context context) {
        super(context);
    }

    private void w(me meVar) {
        Iterator<ox> it = m.u(meVar).iterator();
        while (it.hasNext()) {
            ox next = it.next();
            com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.f.c();
            cVar.c(next.sr());
            cVar.w(next.ux());
            cVar.xv(next.sr());
            com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c(cVar, null);
        }
        Iterator<ox> it2 = yu.ux(meVar).iterator();
        while (it2.hasNext()) {
            ox next2 = it2.next();
            com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.f.c();
            cVar2.c(next2.sr());
            cVar2.w(next2.ux());
            cVar2.xv(next2.sr());
            com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c(cVar2, null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd
    protected boolean c() {
        return true;
    }

    public static k c(Context context) {
        if (ux == null) {
            synchronized (k.class) {
                if (ux == null) {
                    ux = new k(context);
                }
            }
        }
        return ux;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd
    void c(me meVar) {
        if (this.f32394f == null || !(this.f32394f instanceof c.w)) {
            return;
        }
        ((c.w) this.f32394f).c(meVar);
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, c.w wVar2) {
        com.bytedance.sdk.component.utils.a.w("RewardVideoLoadManager", "load reward video: " + wVar);
        r.c(this.f32379c, c()).c(wVar);
        c(wVar, false, (com.bytedance.sdk.openadsdk.fz.c.w.c.r) wVar2, new ux());
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str, int i4, com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar) {
        ux uxVar = new ux();
        uxVar.c(str);
        uxVar.c(i4 + 1);
        c(wVar, false, rVar, uxVar);
    }

    public void w() {
        this.f32394f = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (wVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(wVar.j())) {
            c(wVar, (com.bytedance.sdk.openadsdk.fz.c.w.c.r) new c.w(null));
            return;
        }
        com.bytedance.sdk.component.utils.a.w("RewardVideoLoadManager", "preload reward video: " + wVar);
        c(wVar, true, (com.bytedance.sdk.openadsdk.fz.c.w.c.r) new c.w(null), new ux());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (c(r8, r10, r4) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.bytedance.sdk.openadsdk.ys.w.xv.w r8, boolean r9, com.bytedance.sdk.openadsdk.fz.c.w.c.r r10, com.bytedance.sdk.openadsdk.core.component.reward.ux r11) {
        /*
            r7 = this;
            long r4 = java.lang.System.currentTimeMillis()
            r0 = r9 ^ 1
            r1 = 0
            if (r9 == 0) goto Lc
            r7.f32394f = r10
            goto L13
        Lc:
            boolean r2 = r11.xv()
            if (r2 == 0) goto L13
            r0 = 0
        L13:
            java.lang.String r2 = "RewardVideoLoadManager"
            if (r0 == 0) goto L23
            java.lang.String r0 = "doLoad : do cache"
            com.bytedance.sdk.component.utils.a.w(r2, r0)
            boolean r0 = r7.c(r8, r10, r4)
            if (r0 == 0) goto L23
            goto L24
        L23:
            r1 = 1
        L24:
            if (r1 == 0) goto L33
            java.lang.String r0 = "doLoad : do network"
            com.bytedance.sdk.component.utils.a.w(r2, r0)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r6 = r11
            r0.c(r1, r2, r3, r4, r6)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.k.c(com.bytedance.sdk.openadsdk.ys.w.xv.w, boolean, com.bytedance.sdk.openadsdk.fz.c.w.c.r, com.bytedance.sdk.openadsdk.core.component.reward.ux):void");
    }

    private boolean c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar, final long j4) {
        final me ux2 = r.c(this.f32379c, c()).ux(wVar.f());
        if (TTLiveCommerceHelper.getInstance().getLiveRoomStatus(ux2) == 3 || !c(wVar, ux2, true) || ux2 == null) {
            return false;
        }
        final bk bkVar = new bk(this.f32379c, ux2, wVar);
        bkVar.w(true);
        bkVar.xv(101);
        if (ux2.lp() * 1000 <= 0) {
            bkVar.c(r.c(this.f32379c, c()).xv(wVar.f()));
        } else {
            bkVar.c(ux2.lp() * 1000);
        }
        c(wVar, ux2);
        final gd.c cVar = new gd.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.k.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
            public void c() {
                com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                if (rVar2 != null) {
                    rVar2.onRewardVideoAdLoad(bkVar);
                }
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(ux2, "stats_reward_full_ad_loaded");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
            public void w() {
                com.bytedance.sdk.openadsdk.core.a.xv.w(ux2, wv.w(wVar.q()), j4);
                com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                if (rVar2 != null) {
                    rVar2.onRewardVideoCached();
                    rVar.onRewardVideoCached(bkVar);
                }
            }
        };
        cVar.c();
        w(ux2);
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(ux2)) {
            cVar.w();
            return true;
        } else if (u.ux(ux2)) {
            com.bytedance.sdk.openadsdk.core.playable.c.c().c(ux2, new c.InterfaceC0502c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.k.2
                @Override // com.bytedance.sdk.openadsdk.core.playable.c.InterfaceC0502c
                public void c(boolean z3) {
                    cVar.w();
                }
            });
            return true;
        } else {
            if (!pr.c(ux2)) {
                bkVar.f();
            }
            c(wVar, ux2, cVar);
            return true;
        }
    }

    private void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final boolean z3, final com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar, final long j4, ux uxVar) {
        try {
            if ((this.f32394f instanceof c.w) && (rVar instanceof c.w) && ((c.w) this.f32394f).w() != null) {
                if (((c.w) this.f32394f).c(((c.w) rVar).w(), wVar)) {
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
        if (z3) {
            wvVar.f34869w = 2;
        }
        if (ls.w().bk(wVar.f()) || wVar.p() > 0.0f) {
            wvVar.f34867r = 2;
        }
        if (uxVar.xv()) {
            wvVar.xv = uxVar.c();
            wvVar.sr = uxVar.w();
            wvVar.ux = true;
        }
        if (rVar != null && (rVar instanceof c.w)) {
            wvVar.gd = ((c.w) rVar).c();
        }
        ls.c().c(wVar, wvVar, 7, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.k.3
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                if (rVar2 != null) {
                    rVar2.onError(i4, str);
                }
                wVar2.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                k.this.c(cVar, wVar2, wVar, z3, rVar, j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar2, boolean z3, final com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar, final long j4) {
        me.c rh;
        if (cVar.w() != null && !cVar.w().isEmpty()) {
            com.bytedance.sdk.component.utils.a.w("RewardVideoLoadManager", "get material data success isPreload=" + z3 + "; metaSize:" + cVar.w().size());
            final me meVar = cVar.w().get(0);
            if (c(wVar2.f(), meVar)) {
                return;
            }
            if (!meVar.df()) {
                if (rVar != null) {
                    rVar.onError(-4, com.bytedance.sdk.openadsdk.core.p.c(-4));
                }
                wVar.c(-4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
                return;
            }
            c(cVar);
            if (z3) {
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(meVar, "stats_reward_full_preload");
                r.c(this.f32379c, c()).c(wVar2, meVar);
            }
            if (yu.c(meVar)) {
                r.c(this.f32379c, c()).w(wVar2, yu.sr(meVar));
            }
            final bk bkVar = new bk(this.f32379c, meVar, wVar2);
            w(wVar2.f(), meVar);
            if (meVar.lp() <= 0) {
                bkVar.c(System.currentTimeMillis() + r.c(this.f32379c, c()).w());
            } else {
                bkVar.c(meVar.lp() * 1000);
            }
            if (com.bytedance.sdk.openadsdk.core.ugeno.f.gd(meVar) && !com.bytedance.sdk.openadsdk.core.ugeno.f.p(meVar) && (rh = meVar.rh()) != null) {
                com.bytedance.sdk.openadsdk.core.ugeno.f.c(rh.p(), rh.gd(), (t) null);
            }
            final gd.c cVar2 = new gd.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.k.4
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
                public void c() {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                    if (rVar2 != null) {
                        rVar2.onRewardVideoAdLoad(bkVar);
                    }
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(meVar, "stats_reward_full_ad_loaded");
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
                public void w() {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, wv.w(wVar2.q()), j4);
                    com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                    if (rVar2 != null) {
                        rVar2.onRewardVideoCached();
                        rVar.onRewardVideoCached(bkVar);
                    }
                }
            };
            cVar2.c();
            w(meVar);
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
                com.bytedance.sdk.openadsdk.core.video.xv.c.w(meVar);
                cVar2.w();
                return;
            } else if (u.ux(meVar)) {
                com.bytedance.sdk.openadsdk.core.playable.c.c().c(meVar, new c.InterfaceC0502c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.k.5
                    @Override // com.bytedance.sdk.openadsdk.core.playable.c.InterfaceC0502c
                    public void c(boolean z4) {
                        cVar2.w();
                    }
                });
                if (fp.c(meVar) && com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
                    c(z3, wVar2, meVar, cVar2);
                    return;
                }
                return;
            } else {
                c(z3, wVar2, meVar, cVar2);
                return;
            }
        }
        if (rVar != null) {
            rVar.onError(-3, com.bytedance.sdk.openadsdk.core.p.c(-3));
        }
        wVar.c(-3);
        com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
    }

    private void c(boolean z3, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, me meVar, gd.c cVar) {
        if (z3 && ls.w().sr(wVar.f()) == 1 && !ys.sr(this.f32379c)) {
            c(new gd.w(meVar, wVar));
        } else {
            c(wVar, meVar, cVar);
        }
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (ls.w().w(wVar.f())) {
            com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
            wvVar.f34869w = 2;
            if (ls.w().bk(wVar.f()) || wVar.p() > 0.0f) {
                wvVar.f34867r = 2;
            }
            ls.c().w(wVar, wvVar, c() ? 7 : 8, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.k.6
                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                    if (rVar2 != null) {
                        rVar2.onError(i4, str);
                    }
                    wVar2.c(i4);
                    com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    k.this.c(cVar, wVar2, wVar, true, rVar, currentTimeMillis);
                }
            });
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.u.c cVar) {
        if (cVar.w().size() <= 1) {
            return;
        }
        List<me> subList = cVar.w().subList(1, cVar.w().size());
        JSONArray jSONArray = new JSONArray();
        for (me meVar : subList) {
            if (pr.c(meVar)) {
                jSONArray.put(meVar.mo());
            }
        }
        if (jSONArray.length() > 0) {
            cVar.w().get(0).wv(jSONArray.toString());
        }
    }
}
