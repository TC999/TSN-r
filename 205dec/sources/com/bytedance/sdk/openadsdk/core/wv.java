package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.util.Pair;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.reward.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wv extends com.bytedance.sdk.openadsdk.ys.c.w implements Loader {

    /* renamed from: c  reason: collision with root package name */
    private final ck f35534c = ls.c();

    /* renamed from: w  reason: collision with root package name */
    private volatile Context f35535w;

    public wv(Context context) {
        this.f35535w = context == null ? ls.getContext() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (this.f35535w == null) {
            this.f35535w = ls.getContext();
        }
        return this.f35535w;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void ev(ValueSet valueSet, Bridge bridge) {
        w(com.bytedance.sdk.openadsdk.core.eq.n.c(9, valueSet), new com.bytedance.sdk.openadsdk.core.c.ev(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void f(ValueSet valueSet, Bridge bridge) {
        c(com.bytedance.sdk.openadsdk.core.eq.n.c(8, valueSet), new com.bytedance.sdk.openadsdk.core.c.f(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void gd(ValueSet valueSet, Bridge bridge) {
        xv(com.bytedance.sdk.openadsdk.core.eq.n.c(1, valueSet), new com.bytedance.sdk.openadsdk.core.c.ev(bridge));
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i4, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null) {
            com.bytedance.sdk.component.utils.a.xv("load with null valueset");
            return;
        }
        Bridge bridge = (Bridge) valueSet.objectValue(1, Bridge.class);
        if (bridge == null) {
            com.bytedance.sdk.component.utils.a.xv("load with null callback");
            return;
        }
        b k4 = b.k(valueSet);
        k4.e(1, 0);
        ValueSet l4 = k4.l();
        if (i4 == 1) {
            if (l4.booleanValue(2)) {
                gd(l4, bridge);
            } else {
                sr(l4, bridge);
            }
        } else if (i4 != 3) {
            switch (i4) {
                case 5:
                    if (l4.booleanValue(2)) {
                        r(l4, bridge);
                        return;
                    } else {
                        c(l4, bridge);
                        return;
                    }
                case 6:
                    w(l4, bridge);
                    return;
                case 7:
                    ux(l4, bridge);
                    return;
                case 8:
                    f(l4, bridge);
                    return;
                case 9:
                    if (l4.booleanValue(2)) {
                        ev(l4, bridge);
                        return;
                    } else {
                        xv(l4, bridge);
                        return;
                    }
                default:
                    return;
            }
        } else {
            c(l4, bridge, l4.intValue(3));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void r(ValueSet valueSet, Bridge bridge) {
        c(com.bytedance.sdk.openadsdk.core.eq.n.c(5, valueSet), new com.bytedance.sdk.openadsdk.core.c.ev(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void sr(ValueSet valueSet, Bridge bridge) {
        c(1, com.bytedance.sdk.openadsdk.core.eq.n.c(1, valueSet), new com.bytedance.sdk.openadsdk.core.c.r(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void ux(ValueSet valueSet, Bridge bridge) {
        c(com.bytedance.sdk.openadsdk.core.eq.n.c(7, valueSet), new com.bytedance.sdk.openadsdk.core.c.gd(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void xv(ValueSet valueSet, Bridge bridge) {
        c(com.bytedance.sdk.openadsdk.core.eq.n.c(9, valueSet), new com.bytedance.sdk.openadsdk.core.c.sr(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void w(ValueSet valueSet, Bridge bridge) {
        w(com.bytedance.sdk.openadsdk.core.eq.n.c(6, valueSet), new com.bytedance.sdk.openadsdk.core.c.ux(bridge));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void c(ValueSet valueSet, Bridge bridge) {
        c(com.bytedance.sdk.openadsdk.core.eq.n.c(5, valueSet), new com.bytedance.sdk.openadsdk.core.c.ux(bridge));
    }

    public void xv(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        fVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                    } else if (wv.this.c(wVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.sr.c(wv.this.getContext()).c(wVar, 1, fVar, 5000);
                    } else {
                        fVar.onError(110, p.c(110));
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar2 = fVar;
                    fVar2.onError(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "Banner express error, pls check", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            fVar.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 1);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(1, wVar);
    }

    public void w(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.wv.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        com.bytedance.sdk.openadsdk.core.component.c.c.c().w(wv.this.getContext(), wVar, xvVar);
                    } else {
                        xvVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar2 = xvVar;
                    xvVar2.onError(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xvVar.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 6);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(6, wVar);
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        com.bytedance.sdk.openadsdk.core.component.c.c.c().c(wv.this.getContext(), wVar, xvVar);
                    } else {
                        xvVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar2 = xvVar;
                    xvVar2.onError(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xvVar.onError(10000, "Please exec  TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 5);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(5, wVar);
    }

    public void w(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        fVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                    } else if (wv.this.c(wVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.sr.c(wv.this.getContext()).c(wVar, 9, fVar, 5000);
                    } else {
                        fVar.onError(110, p.c(110));
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar2 = fVar;
                    fVar2.onError(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "Error msg =", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            fVar.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 9);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(9, wVar);
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar2) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        wVar2.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                        return;
                    }
                    wv.this.c(wVar);
                    com.bytedance.sdk.openadsdk.core.component.c.c.c().c(wv.this.getContext(), wVar, wVar2);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar3 = wVar2;
                    wVar3.onError(4000, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            wVar2.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 9);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(9, wVar);
    }

    private boolean w() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    public void c(final int i4, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.ux uxVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        uxVar.c(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
                    wvVar.gd = currentTimeMillis;
                    wv.this.f35534c.c(wVar, wvVar, i4, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.wv.5.1
                        @Override // com.bytedance.sdk.openadsdk.core.ck.w
                        public void c(int i5, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                            uxVar.c(i5, str);
                            wVar2.c(i5);
                            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.ck.w
                        public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                            if (cVar.w() != null && !cVar.w().isEmpty()) {
                                List<com.bytedance.sdk.openadsdk.core.u.me> w3 = cVar.w();
                                ArrayList arrayList = new ArrayList(w3.size());
                                for (com.bytedance.sdk.openadsdk.core.u.me meVar : w3) {
                                    if (meVar.df()) {
                                        Context context = wv.this.getContext();
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        arrayList.add(new com.bytedance.sdk.openadsdk.core.i.c(context, meVar, i4, wVar, false));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.core.a.xv.w(w3.get(0), com.bytedance.sdk.openadsdk.core.eq.wv.w(wVar.q()), currentTimeMillis);
                                    uxVar.c(arrayList);
                                    return;
                                }
                                uxVar.c(-4, p.c(-4));
                                wVar2.c(-4);
                                com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                                return;
                            }
                            uxVar.c(-3, p.c(-3));
                            wVar2.c(-3);
                            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.ux uxVar2 = uxVar;
                    uxVar2.c(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.sr("TTAdNativeImpl", "Error msg = ", th.getMessage());
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            uxVar.c(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, i4);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(i4, wVar.f());
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public void c(ValueSet valueSet, Bridge bridge, int i4) {
        c(com.bytedance.sdk.openadsdk.core.eq.n.c(3, valueSet), new com.bytedance.sdk.openadsdk.core.c.xv(bridge), i4);
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar, final int i4) {
        int gd = ls.w().gd(com.bytedance.sdk.openadsdk.core.eq.wv.c(wVar));
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.wv.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        cVar.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458"));
                    }
                    k.sr().r(1);
                    com.bytedance.sdk.openadsdk.core.component.splash.ev.c(wv.this.getContext()).c(wVar, cVar, i4);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.c cVar2 = cVar;
                    cVar2.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(4000, " msg = " + th.getMessage()));
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cVar.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ys.w.r(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad"));
            return;
        }
        if (AdSdkInitializerHolder.isSdkInitSuccess() && gd == 4) {
            pVar.run();
        } else if (w()) {
            com.bytedance.sdk.component.gd.ev.ux(pVar);
        } else {
            com.bytedance.sdk.component.gd.a.f29806w.k().execute(pVar);
        }
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(3, wVar);
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        rVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.k.c(wv.this.getContext()).c(wVar, new c.w(rVar));
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar2 = rVar;
                    rVar2.onError(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            rVar.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 7);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(7, wVar);
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        srVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.sr.c(wv.this.getContext()).c(wVar, new c.C0476c(srVar));
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar2 = srVar;
                    srVar2.onError(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.w("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            srVar.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 8);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(8, wVar);
    }

    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar) {
        com.bytedance.sdk.component.gd.p pVar = new com.bytedance.sdk.component.gd.p("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.wv.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
                        fVar.onError(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
                    } else if (wv.this.c(wVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.sr.c(wv.this.getContext()).c(wVar, 5, fVar, 5000);
                    } else {
                        fVar.onError(110, p.c(110));
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.fz.c.w.c.f fVar2 = fVar;
                    fVar2.onError(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.a.xv("TTAdNativeImpl", "Error msg = ", th);
                }
            }
        };
        if (!q.f34486c) {
            com.bytedance.sdk.component.utils.a.f("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            fVar.onError(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            return;
        }
        c(pVar, 5);
        com.bytedance.sdk.openadsdk.core.sr.c.xv().c(5, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.w
    public Pair<Integer, String> c(Exception exc) {
        return new Pair<>(-15, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        com.bytedance.sdk.component.utils.ia.c(wVar.ev() > 0, "\u5fc5\u987b\u8bbe\u7f6e\u56fe\u7247\u7d20\u6750\u5c3a\u5bf8");
        com.bytedance.sdk.component.utils.ia.c(wVar.gd() > 0, "\u5fc5\u987b\u8bbe\u7f6e\u56fe\u7247\u7d20\u6750\u5c3a\u5bf8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, boolean z3) {
        if (wVar == null) {
            return false;
        }
        return (z3 && !ls.w().bk(wVar.f())) || wVar.p() > 0.0f;
    }

    private void c(com.bytedance.sdk.component.gd.p pVar, int i4) {
        if (w()) {
            com.bytedance.sdk.component.gd.ev.ux(pVar);
        } else {
            com.bytedance.sdk.component.gd.a.f29806w.k().execute(pVar);
        }
    }
}
