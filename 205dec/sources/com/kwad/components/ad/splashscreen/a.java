package com.kwad.components.ad.splashscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.b.h {
    @Override // com.kwad.components.ad.b.h
    public final List<String> R() {
        return SplashPreloadManager.ky().R();
    }

    @Override // com.kwad.sdk.components.a
    public final Class<com.kwad.components.ad.b.h> getComponentsType() {
        return com.kwad.components.ad.b.h.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        b.loadSplashScreenAd(ksScene, splashScreenAdListener);
    }
}
