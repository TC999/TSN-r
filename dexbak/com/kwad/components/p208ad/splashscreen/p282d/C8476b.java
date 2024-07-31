package com.kwad.components.p208ad.splashscreen.p282d;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.p287c.C8552f;
import com.kwad.components.core.proxy.C8888e;
import com.kwad.components.p208ad.splashscreen.DialogInterface$OnDismissListenerC8364c;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10485c;

/* renamed from: com.kwad.components.ad.splashscreen.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8476b extends C8888e {

    /* renamed from: Ce */
    private KsSplashScreenAd.SplashScreenAdInteractionListener f27847Ce;

    /* renamed from: bT */
    private AbstractC10384b f27848bT;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;

    /* renamed from: a */
    private void m30653a(AbstractC10384b abstractC10384b) {
        this.f27848bT = abstractC10384b;
    }

    /* renamed from: b */
    public static C8476b m30652b(@NonNull AdResultData adResultData, AbstractC10384b abstractC10384b, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("ad_result_cache_idx", C8552f.m30378mE().m30379i(adResultData));
        C8476b c8476b = new C8476b();
        c8476b.setArguments(bundle);
        c8476b.m30653a(abstractC10384b);
        c8476b.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return c8476b;
    }

    private void initData() {
        int i = getArguments().getInt("ad_result_cache_idx");
        if (i > 0) {
            AdResultData m30380d = C8552f.m30378mE().m30380d(i, true);
            this.mAdResultData = m30380d;
            this.mAdTemplate = C10485c.m25661n(m30380d);
        }
    }

    private void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.f27847Ce = splashScreenAdInteractionListener;
    }

    @Override // com.kwad.components.core.proxy.C8888e
    /* renamed from: lN */
    public final ViewGroup mo29672lN() {
        initData();
        if (this.mAdTemplate == null) {
            C8497b.m30550kV();
            C8497b.m30572a((AdTemplate) null, "adTemplate null", false);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f27847Ce;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowError(0, "data parse error");
            }
            return null;
        }
        return DialogInterface$OnDismissListenerC8364c.m30887a(this.mContext, this.mAdResultData, false, this.f27848bT, this.f27847Ce);
    }
}
