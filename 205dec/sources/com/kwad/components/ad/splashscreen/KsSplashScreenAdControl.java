package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsSplashScreenAdControl extends AbstrackKsSplashScreenAd implements com.kwad.components.core.internal.api.a {
    private KsScene Cc;
    @NonNull
    private final AdResultData mAdResultData;
    @NonNull
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.h.b bT = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl.1
        @Override // com.kwad.sdk.core.h.b
        public final void ah() {
            KsSplashScreenAdControl.this.bZ.h(KsSplashScreenAdControl.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void ai() {
            KsSplashScreenAdControl.this.bZ.i(KsSplashScreenAdControl.this);
        }
    };

    public KsSplashScreenAdControl(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.Cc = ksScene;
        this.mAdTemplate = adResultData.getAdTemplateList().get(0);
        com.kwad.components.ad.h.b.eI().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    protected KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        com.kwad.sdk.commercial.d.c.by(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.a.a aVar = (com.kwad.components.ad.splashscreen.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.splashscreen.a.a.class);
        if (aVar != null) {
            return aVar.a(this.mAdResultData, this.bT, splashScreenAdInteractionListener);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public KSAdInfoData getKSAdInfoData() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asX)) {
            return com.kwad.sdk.core.response.b.a.db(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @Nullable
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null || !k.zd().ys()) {
            return null;
        }
        com.kwad.sdk.commercial.d.c.by(this.mAdTemplate);
        return c.a(context, this.mAdResultData, true, this.bT, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        if (SplashPreloadManager.ky().e(this.mAdResultData)) {
            return true;
        }
        SplashPreloadManager.ky();
        return SplashPreloadManager.f(this.mAdResultData);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.dQ(this.mAdResultData.getAdTemplateList().get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i4, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i4, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i4) {
        setBidEcpm(i4, -1L);
    }

    @Keep
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(long j4, long j5) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j4;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j5);
    }
}
