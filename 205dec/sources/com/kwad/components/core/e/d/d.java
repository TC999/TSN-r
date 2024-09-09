package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bn;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private static boolean Lb;
    private static final b Lc = new b() { // from class: com.kwad.components.core.e.d.d.3
        long Li;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Li = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Li != 0) {
                com.kwad.sdk.core.adlog.c.m(getAdTemplate(), System.currentTimeMillis() - this.Li);
            }
            com.kwad.sdk.core.c.b.DD();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.Lc);
            setAdTemplate(null);
            this.Li = 0L;
        }
    };

    public static int a(final a.C0631a c0631a, int i4) {
        Context context = c0631a.getContext();
        final AdTemplate adTemplate = c0631a.getAdTemplate();
        String a4 = a(c0631a, adTemplate);
        if (TextUtils.isEmpty(a4)) {
            return 0;
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Activity dn = l.dn(context);
        if (dn != null && com.kwad.sdk.core.response.b.a.U(dQ) && !c0631a.nA()) {
            c0631a.ak(1);
            com.kwad.components.core.e.e.e.a(dn, c0631a);
            return 2;
        }
        final String a5 = a(a4, c0631a, dQ);
        return com.kwad.sdk.core.download.a.b.a(context, a5, new b.a() { // from class: com.kwad.components.core.e.d.d.1
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.core.adlog.c.b(AdTemplate.this, "", r3, null);
                com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a5, bn.t(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a5);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                d.Lc.setAdTemplate(AdTemplate.this);
                com.kwad.sdk.core.c.b.DD();
                com.kwad.sdk.core.c.b.a(d.Lc);
                com.kwad.sdk.core.adlog.c.apn = d.ah(a5);
                com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a5);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a5);
                com.kwad.sdk.core.adlog.c.a(AdTemplate.this, "", r3, c0631a.nL());
                d.a(AdTemplate.this, a5, r3);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void oo() {
                com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ah(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ax(boolean z3) {
        com.kwad.sdk.core.adlog.c.apo = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ay(boolean z3) {
        Lb = z3;
    }

    private static String l(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean om() {
        return Lb;
    }

    private static String b(a.C0631a c0631a, AdInfo adInfo, String str) {
        long j4 = c0631a.getAdTemplate().getmCurPlayTime();
        if (j4 > 0) {
            j4 = Math.max(j4 - com.kwad.sdk.core.response.b.a.bk(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j4)).toString();
    }

    private static String a(String str, a.C0631a c0631a, AdInfo adInfo) {
        AdTemplate adTemplate = c0631a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bj(adInfo)) {
            str = b(c0631a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cL(adInfo)) {
            str = a(c0631a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cD(adInfo) || com.kwad.sdk.core.response.b.a.cJ(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0631a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String a(a.C0631a c0631a, AdTemplate adTemplate) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : dQ.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0631a.cX()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0631a.nE()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + dQ.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cN(dQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i4) {
        if (om()) {
            return;
        }
        ay(true);
        int BT = com.kwad.sdk.core.config.d.BT();
        com.kwad.sdk.core.config.d.BU();
        int abs = Math.abs(BT);
        if (abs > 0) {
            bn.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.ay(false);
                    com.kwad.sdk.core.c.b.DD();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "", i4);
                    com.kwad.sdk.commercial.f.a.j(AdTemplate.this, str);
                }
            }, null, abs * 1000);
        } else {
            ay(false);
        }
    }

    private static String a(a.C0631a c0631a, AdInfo adInfo, String str) {
        String str2;
        if (com.kwad.sdk.core.response.b.a.bi(adInfo)) {
            String str3 = null;
            Callable<String> nz = c0631a.nz();
            if (nz != null) {
                try {
                    str3 = nz.call();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = c0631a.ny();
            }
            if (TextUtils.isEmpty(str3)) {
                return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.b.a.cN(adInfo) : str;
            }
            try {
                str2 = String.valueOf(com.kwad.components.core.e.b.a.ac(str3));
            } catch (Throwable unused2) {
                str2 = str3;
            }
            return str.replaceAll("__itemId__", str3).replaceAll("__simpleItemId__", str2);
        }
        return str;
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl != null) {
            int i4 = 0;
            if (!ak.an(context, "com.smile.gifmaker") && ak.an(context, "com.kuaishou.nebula")) {
                i4 = 3;
            }
            String backUrl = sceneImpl.getBackUrl();
            return a(str, i4, TextUtils.isEmpty(backUrl) ? "" : backUrl);
        }
        return "";
    }

    private static String a(String str, int i4, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i4 == 0 || i4 == 3) ? l(str, str2) : str;
    }
}
