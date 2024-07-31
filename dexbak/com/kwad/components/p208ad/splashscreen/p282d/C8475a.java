package com.kwad.components.p208ad.splashscreen.p282d;

import android.content.Context;
import com.kwad.components.p208ad.splashscreen.p276a.AbstractC8352a;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.response.model.AdResultData;

/* renamed from: com.kwad.components.ad.splashscreen.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8475a extends AbstractC8352a {
    @Override // com.kwad.components.p208ad.splashscreen.p276a.AbstractC8352a
    /* renamed from: a */
    public final KsFragment mo30654a(AdResultData adResultData, AbstractC10384b abstractC10384b, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return C8476b.m30652b(adResultData, abstractC10384b, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return AbstractC8352a.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }
}
