package com.bytedance.sdk.openadsdk.core.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.reward.c;
import com.bytedance.sdk.openadsdk.core.component.reward.gd;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.playable.c;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wv;
import java.util.List;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends gd {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile sr ux;

    /* renamed from: f  reason: collision with root package name */
    private volatile c.C0476c f32484f;

    private sr(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd
    protected boolean c() {
        return false;
    }

    public void w() {
        this.f32484f = null;
    }

    public static sr c(Context context) {
        if (ux == null) {
            synchronized (sr.class) {
                if (ux == null) {
                    ux = new sr(context);
                }
            }
        }
        return ux;
    }

    private boolean w(com.bytedance.sdk.openadsdk.core.u.c cVar) {
        boolean z3 = false;
        boolean z4 = false;
        for (me meVar : cVar.w()) {
            if (meVar.yx() == 100.0f) {
                z3 = true;
            } else {
                z4 = true;
            }
        }
        return (z3 && z4) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd
    void c(me meVar) {
        if (this.f32484f != null) {
            this.f32484f.c(meVar);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, c.C0476c c0476c) {
        com.bytedance.sdk.component.utils.a.w("FullScreenVideoLoadManager", "load full screen video: " + wVar);
        r.c(this.f32379c, c()).c(wVar);
        c(wVar, false, c0476c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (wVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(wVar.j())) {
            c(wVar, (com.bytedance.sdk.openadsdk.fz.c.w.c.sr) new c.C0476c(null));
            return;
        }
        com.bytedance.sdk.component.utils.a.w("FullScreenVideoLoadManager", "preload full screen video: " + wVar);
        c(wVar, true, new c.C0476c(null));
    }

    private void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (ls.w().w(wVar.f())) {
            wv wvVar = new wv();
            wvVar.f34869w = 2;
            if (ls.w().bk(wVar.f()) || wVar.p() > 0.0f) {
                wvVar.f34867r = 2;
            }
            ls.c().w(wVar, wvVar, c() ? 7 : 8, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.1
                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar2 = srVar;
                    if (srVar2 != null) {
                        srVar2.onError(i4, str);
                    }
                    wVar2.c(i4);
                    com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    sr.this.c(cVar, wVar2, wVar, true, srVar, currentTimeMillis);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.bytedance.sdk.openadsdk.ys.w.xv.w r7, boolean r8, com.bytedance.sdk.openadsdk.core.component.reward.c.C0476c r9) {
        /*
            r6 = this;
            long r4 = java.lang.System.currentTimeMillis()
            r0 = r8 ^ 1
            if (r8 == 0) goto La
            r6.f32484f = r9
        La:
            java.lang.String r1 = "FullScreenVideoLoadManager"
            if (r0 == 0) goto L1b
            java.lang.String r0 = "doLoad : do cache"
            com.bytedance.sdk.component.utils.a.w(r1, r0)
            boolean r0 = r6.c(r7, r9, r4)
            if (r0 == 0) goto L1b
            r0 = 0
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 == 0) goto L2a
            java.lang.String r0 = "doLoad : do network"
            com.bytedance.sdk.component.utils.a.w(r1, r0)
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.c(r1, r2, r3, r4)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.sr.c(com.bytedance.sdk.openadsdk.ys.w.xv.w, boolean, com.bytedance.sdk.openadsdk.core.component.reward.c$c):void");
    }

    private boolean c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar, final long j4) {
        final me ux2 = r.c(this.f32379c, c()).ux(wVar.f());
        if (TTLiveCommerceHelper.getInstance().getLiveRoomStatus(ux2) == 3 || !c(wVar, ux2, false) || ux2 == null) {
            return false;
        }
        final a aVar = new a(this.f32379c, ux2, wVar);
        aVar.w(true);
        aVar.c(101);
        if (ux2.lp() * 1000 <= 0) {
            aVar.c(r.c(this.f32379c, c()).xv(wVar.f()));
        } else {
            aVar.c(ux2.lp() * 1000);
        }
        c(wVar, ux2);
        final gd.c cVar = new gd.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
            public void c() {
                com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar2 = srVar;
                if (srVar2 != null) {
                    srVar2.onFullScreenVideoAdLoad(aVar);
                }
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(ux2, "stats_reward_full_ad_loaded");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
            public void w() {
                com.bytedance.sdk.openadsdk.core.a.xv.w(ux2, com.bytedance.sdk.openadsdk.core.eq.wv.w(wVar.q()), j4);
                com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar2 = srVar;
                if (srVar2 != null) {
                    srVar2.onFullScreenVideoCached();
                    srVar.onFullScreenVideoCached(aVar);
                }
            }
        };
        cVar.c();
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(ux2)) {
            cVar.w();
            return true;
        } else if (u.ux(ux2)) {
            com.bytedance.sdk.openadsdk.core.playable.c.c().c(ux2, new c.InterfaceC0502c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.3
                @Override // com.bytedance.sdk.openadsdk.core.playable.c.InterfaceC0502c
                public void c(boolean z3) {
                    cVar.w();
                }
            });
            return true;
        } else {
            aVar.f();
            c(wVar, ux2, cVar);
            return true;
        }
    }

    private void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final boolean z3, final c.C0476c c0476c, final long j4) {
        if (c0476c != null) {
            try {
                if (this.f32484f != null && this.f32484f.w() == null) {
                    if (this.f32484f.c(c0476c.w(), wVar)) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        wv wvVar = new wv();
        if (z3) {
            wvVar.f34869w = 2;
        }
        if (ls.w().bk(wVar.f()) || wVar.p() > 0.0f) {
            wvVar.f34867r = 2;
        }
        if (c0476c != null) {
            wvVar.gd = c0476c.c();
        }
        ls.c().c(wVar, wvVar, 8, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.4
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                c.C0476c c0476c2 = c0476c;
                if (c0476c2 != null) {
                    c0476c2.onError(i4, str);
                }
                wVar2.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                sr.this.c(cVar, wVar2, wVar, z3, c0476c, j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar2, boolean z3, final com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar, final long j4) {
        me.c rh;
        if (cVar.w() != null && !cVar.w().isEmpty()) {
            com.bytedance.sdk.component.utils.a.w("FullScreenVideoLoadManager", "get material data success isPreload=" + z3 + "; metaSize:" + cVar.w().size());
            final me meVar = cVar.w().get(0);
            if (c(wVar2.f(), meVar)) {
                return;
            }
            if (!meVar.df()) {
                if (srVar != null) {
                    srVar.onError(-4, com.bytedance.sdk.openadsdk.core.p.c(-4));
                }
                wVar.c(-4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
                return;
            }
            if (c(cVar, wVar2.f()) && w(cVar)) {
                com.bytedance.sdk.openadsdk.core.u.ls dc = meVar.dc();
                if (dc != null && dc.xv() != 1) {
                    if (srVar != null) {
                        srVar.onError(-4, com.bytedance.sdk.openadsdk.core.p.c(-4));
                    }
                    wVar.c(-4);
                    com.bytedance.sdk.openadsdk.core.u.w.c(wVar);
                    return;
                }
                c(cVar);
            }
            if (com.bytedance.sdk.openadsdk.core.ugeno.f.gd(meVar) && !com.bytedance.sdk.openadsdk.core.ugeno.f.p(meVar) && (rh = meVar.rh()) != null) {
                com.bytedance.sdk.openadsdk.core.ugeno.f.c(rh.p(), rh.gd(), (t) null);
            }
            if (z3) {
                com.bytedance.sdk.openadsdk.core.fz.a.c().c(meVar, "stats_reward_full_preload");
                r.c(this.f32379c, c()).c(wVar2, meVar);
            }
            final a aVar = new a(this.f32379c, meVar, wVar2);
            w(wVar2.f(), meVar);
            if (meVar.lp() <= 0) {
                aVar.c(System.currentTimeMillis() + r.c(this.f32379c, c()).w());
            } else {
                aVar.c(meVar.lp() * 1000);
            }
            final gd.c cVar2 = new gd.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.5
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
                public void c() {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar2 = srVar;
                    if (srVar2 != null) {
                        srVar2.onFullScreenVideoAdLoad(aVar);
                    }
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(meVar, "stats_reward_full_ad_loaded");
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.gd.c
                public void w() {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, com.bytedance.sdk.openadsdk.core.eq.wv.w(wVar2.q()), j4);
                    com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar2 = srVar;
                    if (srVar2 != null) {
                        srVar2.onFullScreenVideoCached();
                        srVar.onFullScreenVideoCached(aVar);
                    }
                }
            };
            cVar2.c();
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
                com.bytedance.sdk.openadsdk.core.video.xv.c.w(meVar);
                cVar2.w();
                return;
            } else if (u.ux(meVar)) {
                com.bytedance.sdk.openadsdk.core.playable.c.c().c(meVar, new c.InterfaceC0502c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.sr.6
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
        if (srVar != null) {
            srVar.onError(-3, com.bytedance.sdk.openadsdk.core.p.c(-3));
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

    private void c(com.bytedance.sdk.openadsdk.core.u.c cVar) {
        if (cVar.w().size() <= 1) {
            return;
        }
        List<me> subList = cVar.w().subList(1, cVar.w().size());
        JSONArray jSONArray = new JSONArray();
        for (me meVar : subList) {
            com.bytedance.sdk.openadsdk.core.u.ls dc = meVar.dc();
            if (dc != null) {
                dc.c(true);
            }
            jSONArray.put(meVar.mo());
        }
        if (jSONArray.length() > 0) {
            cVar.w().get(0).wv(jSONArray.toString());
        }
    }

    public boolean c(com.bytedance.sdk.openadsdk.core.u.c cVar, String str) {
        return ls.w().ia(str) && com.bytedance.sdk.openadsdk.core.u.ls.c(cVar.w().get(0)) && !com.bytedance.sdk.openadsdk.core.bk.sr.c(str);
    }
}
