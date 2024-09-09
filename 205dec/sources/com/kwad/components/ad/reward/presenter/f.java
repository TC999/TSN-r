package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    private static long sg;

    private static boolean E(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
    }

    private static boolean F(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.F(adTemplate);
    }

    private static boolean M(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.ak(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z3) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (!gVar.oY) {
            m(gVar);
            return;
        }
        o(gVar);
        boolean z4 = !gVar.fN() && M(gVar.mAdTemplate);
        if (E(adTemplate) || F(adTemplate) || gVar.pv < com.kwad.sdk.core.response.b.a.ag(dQ)) {
            if (z4) {
                a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                    public final void F(boolean z5) {
                        super.F(z5);
                        if (com.kwad.components.ad.reward.a.b.k(AdInfo.this)) {
                            gVar.hp();
                        } else if (com.kwad.sdk.core.response.b.a.bS(AdInfo.this)) {
                            f.n(gVar);
                        } else {
                            f.p(gVar);
                            com.kwad.components.ad.reward.k.h(gVar);
                        }
                    }
                });
            } else if (com.kwad.sdk.core.response.b.a.bS(dQ)) {
                n(gVar);
            } else {
                p(gVar);
                com.kwad.components.ad.reward.k.h(gVar);
            }
        } else if (gVar.pp) {
            gVar.hp();
        } else if (!gVar.pw && gVar.pv < com.kwad.sdk.core.response.b.a.ag(dQ)) {
            if (z3) {
                gVar.hp();
            }
        } else {
            if (gVar.pw) {
                gVar.L(2);
            } else {
                gVar.L(1);
            }
            w(gVar);
            if (com.kwad.sdk.core.response.b.a.bS(dQ)) {
                n(gVar);
                return;
            }
            p(gVar);
            com.kwad.components.ad.reward.k.h(gVar);
        }
    }

    private static void m(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.bR(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate))) {
            n(gVar);
        } else if (gVar.pa) {
            p(gVar);
        } else {
            gVar.pd = true;
            com.kwad.components.ad.reward.g.a(gVar.oR, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: c */
                public void accept(com.kwad.components.ad.reward.k.a aVar) {
                    aVar.iL();
                }
            });
            gVar.oI.onVideoSkipToEnd(0L);
            com.kwad.sdk.core.adlog.c.h(gVar.mAdTemplate, gVar.mReportExtData);
            com.kwad.components.ad.reward.m.e eVar = gVar.oJ;
            if (eVar != null) {
                eVar.release();
            }
            gVar.fB();
            s(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(final com.kwad.components.ad.reward.g gVar) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.ad.reward.g.this.fO();
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.oI.onVideoSkipToEnd(gVar2.pv);
                com.kwad.components.ad.reward.g.this.release();
                com.kwad.components.ad.reward.g.this.hp();
            }
        });
    }

    private static void o(com.kwad.components.ad.reward.g gVar) {
        long j4 = gVar.pu;
        int i4 = j4 != 0 ? (int) (j4 / 1000) : 0;
        long j5 = gVar.pv;
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().cM(69).cP(i4).cQ(j5 != 0 ? (int) (j5 / 1000) : 0));
    }

    public static void p(final com.kwad.components.ad.reward.g gVar) {
        gVar.pd = true;
        gVar.fO();
        if (i.x(gVar)) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.q(com.kwad.components.ad.reward.g.this);
                }
            }, 200L);
        } else {
            q(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.oR, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.iL();
            }
        });
        com.kwad.components.ad.reward.m.e eVar = gVar.oJ;
        if (eVar != null) {
            eVar.skipToEnd();
        }
    }

    public static void r(com.kwad.components.ad.reward.g gVar) {
        v(gVar);
        gVar.hp();
    }

    public static void s(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.e.c.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - sg < 300) {
            com.kwad.sdk.core.e.c.d("openAppMarket", "\u8fde\u7eed\u70b9\u51fb");
            return;
        }
        sg = elapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (a(dQ, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, dQ)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b cW = new com.kwad.sdk.core.adlog.c.b().cK(182).cW(8);
        boolean z3 = com.kwad.sdk.core.download.a.b.D(context, com.kwad.sdk.core.response.b.a.cN(dQ)) == 1;
        com.kwad.sdk.core.e.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z3);
        if (z3) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cW, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.H(context);
            return;
        }
        String cQ = com.kwad.sdk.core.response.b.a.cQ(dQ);
        com.kwad.sdk.core.e.c.i("openAppMarket", "tryOpenMiAppStore url\uff1a" + cQ);
        if (com.kwad.sdk.utils.d.a(context, cQ, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cW, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.d(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.H(context);
        } else if (com.kwad.sdk.utils.d.h(context, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cW, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.d(adTemplate, 0, 8);
            com.kwad.components.ad.reward.h.a.H(context);
        } else {
            com.kwad.sdk.core.e.c.i("openAppMarket", "tryOpenMiAppStore failed");
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (!gVar.oY) {
            v(gVar);
            gVar.hp();
            return;
        }
        boolean z3 = true;
        if (!E(adTemplate) && !F(adTemplate)) {
            long ag = com.kwad.sdk.core.response.b.a.ag(dQ);
            if (!gVar.pw && gVar.pv < ag) {
                z3 = false;
            }
            if (z3) {
                w(gVar);
            }
            v(gVar);
            gVar.hp();
            return;
        }
        o(gVar);
        if ((gVar.fN() || !M(gVar.mAdTemplate) || gVar.pd) ? false : false) {
            u(gVar);
            return;
        }
        v(gVar);
        gVar.hp();
    }

    private static void u(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void F(boolean z3) {
                com.kwad.components.ad.reward.g.this.D(false);
                if (!z3) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
                }
                f.v(com.kwad.components.ad.reward.g.this);
                com.kwad.components.ad.reward.g.this.hp();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fR() {
                com.kwad.components.ad.reward.g.this.D(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, 149, com.kwad.components.ad.reward.g.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void ga() {
                com.kwad.components.ad.reward.g.this.D(false);
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(com.kwad.components.ad.reward.g gVar) {
        gVar.oI.h(false);
    }

    private static void w(com.kwad.components.ad.reward.g gVar) {
        gVar.oI.onRewardVerify();
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bH(adInfo)) {
            com.kwad.sdk.core.e.c.i(str, "is playable return");
            return true;
        } else if (!com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            com.kwad.sdk.core.e.c.i(str, "is not Download type");
            return true;
        } else if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.e.c.i(str, "isRewardLaunchAppTask");
            return true;
        } else if (com.kwad.components.ad.reward.g.g(adInfo)) {
            com.kwad.sdk.core.e.c.i(str, "is Aggregation return");
            return true;
        } else {
            return false;
        }
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.gB()) {
            com.kwad.sdk.core.e.c.e(str, "isEnable false");
            return true;
        } else if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cQ(adInfo))) {
            return true;
        } else {
            int gA = com.kwad.components.ad.reward.a.b.gA();
            com.kwad.sdk.core.e.c.d(str, "JumpDirectMaxCount " + gA);
            return gA <= 0 || com.kwad.components.ad.reward.h.a.cM() >= gA;
        }
    }

    private static void a(final com.kwad.components.ad.reward.g gVar, @NonNull final h.b bVar) {
        String str;
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long ad = com.kwad.sdk.core.response.b.a.ad(dQ);
        if (ad <= 0 || com.kwad.sdk.core.response.b.a.L(dQ) <= ad) {
            str = "\u89c2\u770b\u5b8c\u6574\u89c6\u9891\u5373\u53ef\u83b7\u53d6\u5956\u52b1";
        } else {
            str = "\u89c2\u770b\u89c6\u9891" + ad + "s\u5373\u53ef\u83b7\u53d6\u5956\u52b1";
        }
        final h.c a4 = com.kwad.components.ad.reward.h.a(gVar, str);
        com.kwad.components.ad.reward.g.a(gVar, a4, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void F(boolean z3) {
                com.kwad.components.ad.reward.g.this.D(false);
                if (!z3) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.F(z3);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fR() {
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.oJ;
                if (eVar != null) {
                    eVar.pause();
                }
                com.kwad.components.ad.reward.g.this.D(true);
                if (a4.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.i(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void fY() {
                super.fY();
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fZ() {
                super.fZ();
                com.kwad.components.ad.reward.g.this.D(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void g(int i4, int i5) {
                super.g(i4, i5);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, i4, i5);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void ga() {
                com.kwad.components.ad.reward.g.this.D(false);
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.oJ;
                if (eVar != null) {
                    eVar.resume();
                }
                if (a4.getStyle() != 1 && a4.getStyle() != 2 && a4.getStyle() != 5 && a4.getStyle() != 8) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
                }
            }
        });
    }
}
