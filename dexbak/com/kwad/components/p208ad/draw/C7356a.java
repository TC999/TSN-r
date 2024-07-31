package com.kwad.components.p208ad.draw;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.p210b.InterfaceC7344b;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;

/* renamed from: com.kwad.components.ad.draw.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7356a extends AbstractC9863d implements InterfaceC7344b {
    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7344b.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7344b
    public final void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        C7402d.loadDrawAd(ksScene, drawAdListener);
    }
}
