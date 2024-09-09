package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class as implements com.kwad.sdk.core.webview.c.a {
    @Nullable
    private KsAppDownloadListener VG;
    @Nullable
    private com.kwad.sdk.core.webview.c.c VX;
    private final com.kwad.sdk.core.webview.b cO;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: XI  reason: collision with root package name */
        public double f38650XI;
        public int status;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public long XP;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String qb;
        public String url;
        public String version;
        public int versionCode;
    }

    public as(com.kwad.sdk.core.webview.b bVar) {
        this.cO = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = bVar.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    private KsAppDownloadListener sm() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.as.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                as.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                as.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                as.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                as.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i4) {
                as.this.a(3, (i4 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                as.this.a(2, (i4 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.VX = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.VG) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.VG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.as(2);
        } else {
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
            a(dQ, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.as(1);
        }
        this.VX = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.VG;
        if (ksAppDownloadListener == null) {
            KsAppDownloadListener sm = sm();
            this.VG = sm;
            this.mApkDownloadHelper.b(sm);
            return;
        }
        this.mApkDownloadHelper.d(ksAppDownloadListener);
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.pkgName;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.XP;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.qb;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.ad.bu(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, float f4) {
        if (this.VX != null) {
            a aVar = new a();
            aVar.f38650XI = f4;
            aVar.status = i4;
            this.VX.a(aVar);
        }
    }
}
