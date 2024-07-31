package com.kwad.components.p208ad.p221f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.p210b.InterfaceC7348f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;

/* renamed from: com.kwad.components.ad.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7415a extends AbstractC9863d implements InterfaceC7348f {
    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7348f.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7348f
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        C7451c.loadNativeAd(ksScene, nativeAdListener);
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7348f
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        C7451c.loadNativeAd(str, nativeAdListener);
    }
}
