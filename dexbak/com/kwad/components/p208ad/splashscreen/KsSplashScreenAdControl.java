package com.kwad.components.p208ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.p208ad.p236h.C7668b;
import com.kwad.components.p208ad.splashscreen.p276a.AbstractC8352a;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsSplashScreenAdControl extends AbstrackKsSplashScreenAd implements InterfaceC8677a {

    /* renamed from: Cc */
    private KsScene f27591Cc;
    @NonNull
    private final AdResultData mAdResultData;
    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: bZ */
    private C8679c f27593bZ = new C8679c();

    /* renamed from: bT */
    private AbstractC10384b f27592bT = new AbstractC10384b() { // from class: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl.1
        @Override // com.kwad.sdk.core.p403h.AbstractC10384b
        /* renamed from: ah */
        public final void mo26184ah() {
            KsSplashScreenAdControl.this.f27593bZ.m30027h(KsSplashScreenAdControl.this);
        }

        @Override // com.kwad.sdk.core.p403h.AbstractC10384b
        /* renamed from: ai */
        public final void mo26183ai() {
            KsSplashScreenAdControl.this.f27593bZ.m30026i(KsSplashScreenAdControl.this);
        }
    };

    public KsSplashScreenAdControl(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.f27591Cc = ksScene;
        this.mAdTemplate = adResultData.getAdTemplateList().get(0);
        C7668b.m32688eI().m32692a(this);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: ag */
    public final boolean mo30033ag() {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f27593bZ.m30028b(interfaceC8678b);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return C10483a.m25944aR(C10487e.m25641dQ(this.mAdTemplate));
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    protected KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        C9828c.m27589by(this.mAdTemplate);
        AbstractC8352a abstractC8352a = (AbstractC8352a) C9861c.m27501f(AbstractC8352a.class);
        if (abstractC8352a != null) {
            return abstractC8352a.mo30654a(this.mAdResultData, this.f27592bT, splashScreenAdInteractionListener);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        return C10483a.m25945aQ(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public KSAdInfoData getKSAdInfoData() {
        if (C10251d.m26527a(C10250c.asX)) {
            return C10483a.m25798db(C10487e.m25641dQ(this.mAdTemplate));
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        return C10483a.m25875be(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (C10251d.m26570BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @Nullable
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null || !C10829k.m24699zd().m24700ys()) {
            return null;
        }
        C9828c.m27589by(this.mAdTemplate);
        return DialogInterface$OnDismissListenerC8364c.m30887a(context, this.mAdResultData, true, this.f27592bT, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        if (SplashPreloadManager.m30908ky().m30912e(this.mAdResultData)) {
            return true;
        }
        SplashPreloadManager.m30908ky();
        return SplashPreloadManager.m30911f(this.mAdResultData);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return C10483a.m25877bc(C10487e.m25641dQ(this.mAdResultData.getAdTemplateList().get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Keep
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f27593bZ.m30029a(interfaceC8678b);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        C9908c.m27292l(adTemplate, j2);
    }
}
