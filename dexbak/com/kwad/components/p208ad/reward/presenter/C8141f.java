package com.kwad.components.p208ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C7957k;
import com.kwad.components.p208ad.reward.DialogFragmentC7931h;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p255h.C7945a;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7958a;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.download.p395a.C10299b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11079d;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.presenter.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8141f {

    /* renamed from: sg */
    private static long f27044sg;

    /* renamed from: E */
    private static boolean m31475E(AdTemplate adTemplate) {
        return C10487e.m25624i(adTemplate, C7844b.m32176k(C10487e.m25641dQ(adTemplate)));
    }

    /* renamed from: F */
    private static boolean m31474F(AdTemplate adTemplate) {
        return C10487e.m25654F(adTemplate);
    }

    /* renamed from: M */
    private static boolean m31473M(AdTemplate adTemplate) {
        return C10483a.m25925ak(C10487e.m25641dQ(adTemplate));
    }

    /* renamed from: a */
    public static void m31471a(final C7907g c7907g, boolean z) {
        AdTemplate adTemplate = c7907g.mAdTemplate;
        final AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (!c7907g.f26544oY) {
            m31465m(c7907g);
            return;
        }
        m31463o(c7907g);
        boolean z2 = !c7907g.m32001fN() && m31473M(c7907g.mAdTemplate);
        if (m31475E(adTemplate) || m31474F(adTemplate) || c7907g.f26573pv < C10483a.m25929ag(m25641dQ)) {
            if (z2) {
                m31472a(c7907g, new DialogFragmentC7931h.C7943b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
                    /* renamed from: F */
                    public final void mo29100F(boolean z3) {
                        super.mo29100F(z3);
                        if (C7844b.m32176k(AdInfo.this)) {
                            c7907g.m30013hp();
                        } else if (C10483a.m25889bS(AdInfo.this)) {
                            C8141f.m31464n(c7907g);
                        } else {
                            C8141f.m31462p(c7907g);
                            C7957k.m31924h(c7907g);
                        }
                    }
                });
            } else if (C10483a.m25889bS(m25641dQ)) {
                m31464n(c7907g);
            } else {
                m31462p(c7907g);
                C7957k.m31924h(c7907g);
            }
        } else if (c7907g.f26567pp) {
            c7907g.m30013hp();
        } else if (!c7907g.f26574pw && c7907g.f26573pv < C10483a.m25929ag(m25641dQ)) {
            if (z) {
                c7907g.m30013hp();
            }
        } else {
            if (c7907g.f26574pw) {
                c7907g.m32061L(2);
            } else {
                c7907g.m32061L(1);
            }
            m31455w(c7907g);
            if (C10483a.m25889bS(m25641dQ)) {
                m31464n(c7907g);
                return;
            }
            m31462p(c7907g);
            C7957k.m31924h(c7907g);
        }
    }

    /* renamed from: m */
    private static void m31465m(final C7907g c7907g) {
        if (C10483a.m25890bR(C10487e.m25641dQ(c7907g.mAdTemplate))) {
            m31464n(c7907g);
        } else if (c7907g.f26552pa) {
            m31462p(c7907g);
        } else {
            c7907g.f26555pd = true;
            C7907g.m32038a(c7907g.f26537oR, new InterfaceC10761a<InterfaceC7958a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.p434g.InterfaceC10761a
                /* renamed from: c */
                public void accept(InterfaceC7958a interfaceC7958a) {
                    interfaceC7958a.mo31476iL();
                }
            });
            c7907g.f26528oI.onVideoSkipToEnd(0L);
            C9908c.m27301h(c7907g.mAdTemplate, c7907g.mReportExtData);
            C8025e c8025e = c7907g.f26529oJ;
            if (c8025e != null) {
                c8025e.release();
            }
            c7907g.m32013fB();
            m31459s(c7907g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m31464n(final C7907g c7907g) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C7907g.this.m32000fO();
                C7907g c7907g2 = C7907g.this;
                c7907g2.f26528oI.onVideoSkipToEnd(c7907g2.f26573pv);
                C7907g.this.release();
                C7907g.this.m30013hp();
            }
        });
    }

    /* renamed from: o */
    private static void m31463o(C7907g c7907g) {
        long j = c7907g.f26572pu;
        int i = j != 0 ? (int) (j / 1000) : 0;
        long j2 = c7907g.f26573pv;
        C9908c.m27306e(c7907g.mAdTemplate, c7907g.mReportExtData, new C9913b().m27264cM(69).m27261cP(i).m27260cQ(j2 != 0 ? (int) (j2 / 1000) : 0));
    }

    /* renamed from: p */
    public static void m31462p(final C7907g c7907g) {
        c7907g.f26555pd = true;
        c7907g.m32000fO();
        if (C8209i.m31264x(c7907g)) {
            C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    C8141f.m31461q(C7907g.this);
                }
            }, 200L);
        } else {
            m31461q(c7907g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static void m31461q(final C7907g c7907g) {
        C7907g.m32038a(c7907g.f26537oR, new InterfaceC10761a<InterfaceC7958a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: c */
            public void accept(InterfaceC7958a interfaceC7958a) {
                interfaceC7958a.mo31476iL();
            }
        });
        C8025e c8025e = c7907g.f26529oJ;
        if (c8025e != null) {
            c8025e.skipToEnd();
        }
    }

    /* renamed from: r */
    public static void m31460r(C7907g c7907g) {
        m31456v(c7907g);
        c7907g.m30013hp();
    }

    /* renamed from: s */
    public static void m31459s(C7907g c7907g) {
        C10331c.m26254d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f27044sg < 300) {
            C10331c.m26254d("openAppMarket", "连续点击");
            return;
        }
        f27044sg = elapsedRealtime;
        AdTemplate adTemplate = c7907g.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (m31470a(m25641dQ, "openAppMarket")) {
            return;
        }
        Context context = c7907g.mContext;
        if (m31469a("openAppMarket", adTemplate, m25641dQ)) {
            return;
        }
        C9913b m27254cW = new C9913b().m27266cK(Opcodes.INVOKEVIRTUAL).m27254cW(8);
        boolean z = C10299b.m26367D(context, C10483a.m25840cN(m25641dQ)) == 1;
        C10331c.m26248i("openAppMarket", "handleDeepLink dpSuccess: " + z);
        if (z) {
            C7955b.m31927a(adTemplate, "native_id", "autoLaunchMarket", m27254cW, (JSONObject) null);
            C7945a.m31965H(context);
            return;
        }
        String m25837cQ = C10483a.m25837cQ(m25641dQ);
        C10331c.m26248i("openAppMarket", "tryOpenMiAppStore url：" + m25837cQ);
        if (C11079d.m23838a(context, m25837cQ, adTemplate)) {
            C7955b.m31927a(adTemplate, "native_id", "autoLaunchMarket", m27254cW, (JSONObject) null);
            C9908c.m27312d(adTemplate, 1, 8);
            C7945a.m31965H(context);
        } else if (C11079d.m23835h(context, adTemplate)) {
            C7955b.m31927a(adTemplate, "native_id", "autoLaunchMarket", m27254cW, (JSONObject) null);
            C9908c.m27312d(adTemplate, 0, 8);
            C7945a.m31965H(context);
        } else {
            C10331c.m26248i("openAppMarket", "tryOpenMiAppStore failed");
        }
    }

    /* renamed from: t */
    public static void m31458t(C7907g c7907g) {
        AdTemplate adTemplate = c7907g.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (!c7907g.f26544oY) {
            m31456v(c7907g);
            c7907g.m30013hp();
            return;
        }
        boolean z = true;
        if (!m31475E(adTemplate) && !m31474F(adTemplate)) {
            long m25929ag = C10483a.m25929ag(m25641dQ);
            if (!c7907g.f26574pw && c7907g.f26573pv < m25929ag) {
                z = false;
            }
            if (z) {
                m31455w(c7907g);
            }
            m31456v(c7907g);
            c7907g.m30013hp();
            return;
        }
        m31463o(c7907g);
        if ((c7907g.m32001fN() || !m31473M(c7907g.mAdTemplate) || c7907g.f26555pd) ? false : false) {
            m31457u(c7907g);
            return;
        }
        m31456v(c7907g);
        c7907g.m30013hp();
    }

    /* renamed from: u */
    private static void m31457u(final C7907g c7907g) {
        final AdTemplate adTemplate = c7907g.mAdTemplate;
        C7907g.m32046a(c7907g, DialogFragmentC7931h.m31973a(c7907g, (String) null), new DialogFragmentC7931h.C7943b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: F */
            public final void mo29100F(boolean z) {
                C7907g.this.m32066D(false);
                if (!z) {
                    C9908c.m27287p(adTemplate, 151);
                }
                C8141f.m31456v(C7907g.this);
                C7907g.this.m30013hp();
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: fR */
            public final void mo29099fR() {
                C7907g.this.m32066D(true);
                C9908c.m27337b(adTemplate, 149, C7907g.this.mReportExtData);
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: ga */
            public final void mo29097ga() {
                C7907g.this.m32066D(false);
                C9908c.m27287p(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public static void m31456v(C7907g c7907g) {
        c7907g.f26528oI.mo32084h(false);
    }

    /* renamed from: w */
    private static void m31455w(C7907g c7907g) {
        c7907g.f26528oI.onRewardVerify();
    }

    /* renamed from: a */
    private static boolean m31469a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (C10483a.m25900bH(adInfo)) {
            C10331c.m26248i(str, "is playable return");
            return true;
        } else if (!C10483a.m25956aF(adInfo)) {
            C10331c.m26248i(str, "is not Download type");
            return true;
        } else if (C10487e.m25624i(adTemplate, C7844b.m32176k(adInfo))) {
            C10331c.m26248i(str, "isRewardLaunchAppTask");
            return true;
        } else if (C7907g.m31991g(adInfo)) {
            C10331c.m26248i(str, "is Aggregation return");
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m31470a(AdInfo adInfo, String str) {
        if (!C7844b.m32193gB()) {
            C10331c.m26250e(str, "isEnable false");
            return true;
        } else if (TextUtils.isEmpty(C10483a.m25837cQ(adInfo))) {
            return true;
        } else {
            int m32194gA = C7844b.m32194gA();
            C10331c.m26254d(str, "JumpDirectMaxCount " + m32194gA);
            return m32194gA <= 0 || C7945a.m31964cM() >= m32194gA;
        }
    }

    /* renamed from: a */
    private static void m31472a(final C7907g c7907g, @NonNull final DialogFragmentC7931h.C7943b c7943b) {
        String str;
        final AdTemplate adTemplate = c7907g.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        final JSONObject jSONObject = c7907g.mReportExtData;
        long m25932ad = C10483a.m25932ad(m25641dQ);
        if (m25932ad <= 0 || C10483a.m25976L(m25641dQ) <= m25932ad) {
            str = "观看完整视频即可获取奖励";
        } else {
            str = "观看视频" + m25932ad + "s即可获取奖励";
        }
        final DialogFragmentC7931h.C7944c m31973a = DialogFragmentC7931h.m31973a(c7907g, str);
        C7907g.m32046a(c7907g, m31973a, new DialogFragmentC7931h.C7943b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: F */
            public final void mo29100F(boolean z) {
                C7907g.this.m32066D(false);
                if (!z) {
                    C9908c.m27287p(adTemplate, 151);
                }
                DialogFragmentC7931h.C7943b c7943b2 = c7943b;
                if (c7943b2 != null) {
                    c7943b2.mo29100F(z);
                }
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: fR */
            public final void mo29099fR() {
                C8025e c8025e = C7907g.this.f26529oJ;
                if (c8025e != null) {
                    c8025e.pause();
                }
                C7907g.this.m32066D(true);
                if (m31973a.getStyle() == 0) {
                    C9908c.m27298i(adTemplate, jSONObject);
                } else {
                    C9908c.m27337b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.p208ad.reward.DialogFragmentC7931h.InterfaceC7942a
            /* renamed from: fY */
            public final void mo31452fY() {
                super.mo31452fY();
                C9908c.m27287p(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME);
                C7907g c7907g2 = C7907g.this;
                c7907g2.m32060a(1, c7907g2.mContext, 156, 1);
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: fZ */
            public final void mo29098fZ() {
                super.mo29098fZ();
                C7907g.this.m32066D(false);
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.p208ad.reward.DialogFragmentC7931h.InterfaceC7942a
            /* renamed from: g */
            public final void mo31451g(int i, int i2) {
                super.mo31451g(i, i2);
                C7907g c7907g2 = C7907g.this;
                c7907g2.m32060a(1, c7907g2.mContext, i, i2);
            }

            @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
            /* renamed from: ga */
            public final void mo29097ga() {
                C7907g.this.m32066D(false);
                C8025e c8025e = C7907g.this.f26529oJ;
                if (c8025e != null) {
                    c8025e.resume();
                }
                if (m31973a.getStyle() != 1 && m31973a.getStyle() != 2 && m31973a.getStyle() != 5 && m31973a.getStyle() != 8) {
                    C9908c.m27296j(adTemplate, jSONObject);
                } else {
                    C9908c.m27287p(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME);
                }
            }
        });
    }
}
