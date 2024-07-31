package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11010ad;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.as */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9098as implements InterfaceC10625a {
    @Nullable

    /* renamed from: VG */
    private KsAppDownloadListener f29190VG;
    @Nullable

    /* renamed from: VX */
    private InterfaceC10627c f29191VX;

    /* renamed from: cO */
    private final C10605b f29192cO;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.as$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9100a extends C10482a {

        /* renamed from: XI */
        public double f29194XI;
        public int status;
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.as$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9101b extends C10482a {

        /* renamed from: XP */
        public long f29195XP;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;

        /* renamed from: qb */
        public String f29196qb;
        public String url;
        public String version;
        public int versionCode;
    }

    public C9098as(C10605b c10605b) {
        this.f29192cO = c10605b;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = c10605b.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: sm */
    private KsAppDownloadListener m29275sm() {
        return new AbstractC10298a() { // from class: com.kwad.components.core.webview.jshandler.as.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                C9098as.this.m29278a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                C9098as.this.m29278a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                C9098as.this.m29278a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                C9098as.this.m29278a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                C9098as.this.m29278a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                C9098as.this.m29278a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f29191VX = null;
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c == null || (ksAppDownloadListener = this.f29190VG) == null) {
            return;
        }
        c8619c.m30148c(ksAppDownloadListener);
        this.f29190VG = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            interfaceC10627c.onError(-1, "native photo is null");
            return;
        }
        if (C10483a.m25956aF(C10487e.m25641dQ(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new C8619c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.m30152as(2);
        } else {
            AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
            C9101b c9101b = new C9101b();
            try {
                c9101b.parseJson(new JSONObject(str));
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
            m29276a(m25641dQ, c9101b);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new C8619c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.m30152as(1);
        }
        this.f29191VX = interfaceC10627c;
        KsAppDownloadListener ksAppDownloadListener = this.f29190VG;
        if (ksAppDownloadListener == null) {
            KsAppDownloadListener m29275sm = m29275sm();
            this.f29190VG = m29275sm;
            this.mApkDownloadHelper.m30151b(m29275sm);
            return;
        }
        this.mApkDownloadHelper.m30146d(ksAppDownloadListener);
    }

    /* renamed from: a */
    private static void m29276a(@NonNull AdInfo adInfo, @NonNull C9101b c9101b) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = c9101b.pkgName;
        adBaseInfo.appName = c9101b.appName;
        adBaseInfo.appVersion = c9101b.version;
        adBaseInfo.packageSize = c9101b.f29195XP;
        adBaseInfo.appIconUrl = c9101b.icon;
        adBaseInfo.appDescription = c9101b.f29196qb;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = c9101b.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = C11010ad.m24144bu(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29278a(int i, float f) {
        if (this.f29191VX != null) {
            C9100a c9100a = new C9100a();
            c9100a.f29194XI = f;
            c9100a.status = i;
            this.f29191VX.mo25251a(c9100a);
        }
    }
}
