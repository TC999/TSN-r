package com.kwad.components.p208ad.fullscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.p210b.InterfaceC7346d;
import com.kwad.components.p208ad.p210b.InterfaceC7349g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.InterfaceC9848a;

/* renamed from: com.kwad.components.ad.fullscreen.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7604a extends AbstractC9863d implements InterfaceC7346d {
    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7346d.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7346d
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        C7652f.m32715a(ksScene, new C7651e(ksScene.getPosId(), fullScreenVideoAdListener));
    }

    @Override // com.kwad.sdk.components.AbstractC9863d, com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        InterfaceC9848a m27501f = C9861c.m27501f(InterfaceC7349g.class);
        if (m27501f != null) {
            return m27501f.priority() + 1;
        }
        return 1;
    }
}
