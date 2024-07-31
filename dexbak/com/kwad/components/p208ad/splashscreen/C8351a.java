package com.kwad.components.p208ad.splashscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.p210b.InterfaceC7350h;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;
import java.util.List;

/* renamed from: com.kwad.components.ad.splashscreen.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8351a extends AbstractC9863d implements InterfaceC7350h {
    @Override // com.kwad.components.p208ad.p210b.InterfaceC7350h
    /* renamed from: R */
    public final List<String> mo30903R() {
        return SplashPreloadManager.m30908ky().m30915R();
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class<InterfaceC7350h> getComponentsType() {
        return InterfaceC7350h.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7350h
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        C8353b.loadSplashScreenAd(ksScene, splashScreenAdListener);
    }
}
