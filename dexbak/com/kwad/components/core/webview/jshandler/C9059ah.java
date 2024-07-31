package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11010ad;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ah */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9059ah implements InterfaceC10625a {

    /* renamed from: WA */
    private final Handler f29128WA = new Handler(Looper.getMainLooper());

    /* renamed from: Wf */
    private final C10605b f29129Wf;
    private final AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.ah$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9062a extends C10482a {

        /* renamed from: Xg */
        public int f29132Xg;

        /* renamed from: Xh */
        public String f29133Xh;

        /* renamed from: Xi */
        public String f29134Xi;
        @Deprecated

        /* renamed from: Xj */
        public boolean f29135Xj;

        /* renamed from: Xk */
        public boolean f29136Xk;

        /* renamed from: Xl */
        public boolean f29137Xl;
        public String appId;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;

        /* renamed from: qb */
        public String f29138qb;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public C9059ah(C10605b c10605b) {
        this.f29129Wf = c10605b;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = c10605b.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29128WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (C10483a.m25956aF(C10487e.m25641dQ(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new C8619c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.m30152as(2);
        } else {
            AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
            C9062a c9062a = new C9062a();
            try {
                c9062a.parseJson(new JSONObject(str));
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
            m29319a(m25641dQ, c9062a);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new C8619c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.m30152as(1);
        }
        this.f29128WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ah.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8615a.m30233a(new C8615a.C8616a(C9059ah.this.f29129Wf.f29621OE.getContext()).m30198aq(C9059ah.this.mAdTemplate).m30189b(C9059ah.this.mApkDownloadHelper).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.core.webview.jshandler.ah.1.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        interfaceC10627c.mo25251a(null);
    }

    /* renamed from: a */
    private static void m29319a(@NonNull AdInfo adInfo, @NonNull C9062a c9062a) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = c9062a.f29133Xh;
        adConversionInfo.marketUrl = c9062a.f29134Xi;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = c9062a.type;
        adBaseInfo.appPackageName = c9062a.pkgName;
        adBaseInfo.appName = c9062a.appName;
        adBaseInfo.appVersion = c9062a.version;
        adBaseInfo.packageSize = c9062a.f29132Xg;
        adBaseInfo.appIconUrl = c9062a.icon;
        adBaseInfo.appDescription = c9062a.f29138qb;
        if (C10483a.m25956aF(adInfo)) {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = c9062a.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = C11010ad.m24144bu(str);
            return;
        }
        adInfo.adConversionInfo.h5Url = c9062a.url;
    }
}
