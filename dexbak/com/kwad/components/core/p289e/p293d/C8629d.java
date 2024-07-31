package com.kwad.components.core.p289e.p293d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.p289e.p291b.C8596a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p294e.DialogFragmentC8639e;
import com.kwad.sdk.commercial.p377f.C9833a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.p395a.C10299b;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11064bn;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.e.d.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8629d {

    /* renamed from: Lb */
    private static boolean f28259Lb;

    /* renamed from: Lc */
    private static final C8618b f28260Lc = new C8618b() { // from class: com.kwad.components.core.e.d.d.3

        /* renamed from: Li */
        long f28268Li;

        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.f28268Li = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.f28268Li != 0) {
                C9908c.m27290m(getAdTemplate(), System.currentTimeMillis() - this.f28268Li);
            }
            C10232b.m26625DD();
            C10232b.m26621b((InterfaceC10246c) C8629d.f28260Lc);
            setAdTemplate(null);
            this.f28268Li = 0L;
        }
    };

    /* renamed from: a */
    public static int m30119a(final C8615a.C8616a c8616a, int i) {
        Context context = c8616a.getContext();
        final AdTemplate adTemplate = c8616a.getAdTemplate();
        String m30117a = m30117a(c8616a, adTemplate);
        if (TextUtils.isEmpty(m30117a)) {
            return 0;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null && C10483a.m25967U(m25641dQ) && !c8616a.m30182nA()) {
            c8616a.m30211ak(1);
            DialogFragmentC8639e.m30093a(m24559dn, c8616a);
            return 2;
        }
        final String m30113a = m30113a(m30117a, c8616a, m25641dQ);
        return C10299b.m26366a(context, m30113a, new C10299b.InterfaceC10300a() { // from class: com.kwad.components.core.e.d.d.1
            @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onError(Throwable th) {
                C9908c.m27333b(AdTemplate.this, "", r3, null);
                C9833a.m27567d(AdTemplate.this, m30113a, C11064bn.m23856t(th));
            }

            @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onPreStart() {
                C9833a.m27566f(AdTemplate.this, m30113a);
            }

            @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onStart() {
                C8629d.f28260Lc.setAdTemplate(AdTemplate.this);
                C10232b.m26625DD();
                C10232b.m26622a(C8629d.f28260Lc);
                C9908c.apn = C8629d.m30112ah(m30113a);
                C9833a.m27564h(AdTemplate.this, m30113a);
            }

            @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onSuccess() {
                C9833a.m27563i(AdTemplate.this, m30113a);
                C9908c.m27339a(AdTemplate.this, "", r3, c8616a.m30171nL());
                C8629d.m30116a(AdTemplate.this, m30113a, r3);
            }

            @Override // com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            /* renamed from: oo */
            public final void mo26365oo() {
                C9833a.m27565g(AdTemplate.this, m30113a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ah */
    public static JSONObject m30112ah(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: ax */
    public static void m30110ax(boolean z) {
        C9908c.apo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ay */
    public static void m30109ay(boolean z) {
        f28259Lb = z;
    }

    /* renamed from: l */
    private static String m30105l(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    /* renamed from: om */
    private static boolean m30104om() {
        return f28259Lb;
    }

    /* renamed from: b */
    private static String m30107b(C8615a.C8616a c8616a, AdInfo adInfo, String str) {
        long j = c8616a.getAdTemplate().getmCurPlayTime();
        if (j > 0) {
            j = Math.max(j - C10483a.m25869bk(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j)).toString();
    }

    /* renamed from: a */
    private static String m30113a(String str, C8615a.C8616a c8616a, AdInfo adInfo) {
        AdTemplate adTemplate = c8616a.getAdTemplate();
        if (C10483a.m25870bj(adInfo)) {
            str = m30107b(c8616a, adInfo, str);
        }
        if (C10483a.m25842cL(adInfo)) {
            str = m30118a(c8616a, adInfo, str);
        }
        return ((C10483a.m25850cD(adInfo) || C10483a.m25844cJ(adInfo)) && adTemplate.mAdScene != null) ? m30114a(str, c8616a.getContext(), adTemplate.mAdScene) : str;
    }

    /* renamed from: a */
    private static String m30117a(C8615a.C8616a c8616a, AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : m25641dQ.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c8616a.m30186cX()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c8616a.m30178nE()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + m25641dQ.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return C10483a.m25840cN(m25641dQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m30116a(final AdTemplate adTemplate, final String str, final int i) {
        if (m30104om()) {
            return;
        }
        m30109ay(true);
        int m26574BT = C10251d.m26574BT();
        C10251d.m26573BU();
        int abs = Math.abs(m26574BT);
        if (abs > 0) {
            C11064bn.m23862a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    C8629d.m30109ay(false);
                    C10232b.m26625DD();
                    if (C10232b.isAppOnForeground()) {
                        return;
                    }
                    C9908c.m27315c(AdTemplate.this, "", i);
                    C9833a.m27562j(AdTemplate.this, str);
                }
            }, null, abs * 1000);
        } else {
            m30109ay(false);
        }
    }

    /* renamed from: a */
    private static String m30118a(C8615a.C8616a c8616a, AdInfo adInfo, String str) {
        String str2;
        if (C10483a.m25871bi(adInfo)) {
            String str3 = null;
            Callable<String> m30161nz = c8616a.m30161nz();
            if (m30161nz != null) {
                try {
                    str3 = m30161nz.call();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = c8616a.m30162ny();
            }
            if (TextUtils.isEmpty(str3)) {
                return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? C10483a.m25840cN(adInfo) : str;
            }
            try {
                str2 = String.valueOf(C8596a.m30287ac(str3));
            } catch (Throwable unused2) {
                str2 = str3;
            }
            return str.replaceAll("__itemId__", str3).replaceAll("__simpleItemId__", str2);
        }
        return str;
    }

    /* renamed from: a */
    private static String m30114a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl != null) {
            int i = 0;
            if (!C11017ak.m24114an(context, "com.smile.gifmaker") && C11017ak.m24114an(context, "com.kuaishou.nebula")) {
                i = 3;
            }
            String backUrl = sceneImpl.getBackUrl();
            return m30115a(str, i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
        }
        return "";
    }

    /* renamed from: a */
    private static String m30115a(String str, int i, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? m30105l(str, str2) : str;
    }
}
