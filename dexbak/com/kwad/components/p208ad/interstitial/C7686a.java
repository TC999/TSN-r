package com.kwad.components.p208ad.interstitial;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.p210b.InterfaceC7347e;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;

/* renamed from: com.kwad.components.ad.interstitial.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7686a extends AbstractC9863d implements InterfaceC7347e {
    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7347e.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7347e
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        C7729e.loadInterstitialAd(ksScene, interstitialAdListener);
    }
}
