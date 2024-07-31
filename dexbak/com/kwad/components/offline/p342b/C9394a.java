package com.kwad.components.offline.p342b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p304n.p305a.p308c.InterfaceC8697a;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* renamed from: com.kwad.components.offline.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9394a implements InterfaceC8697a {
    private final IObiwanOfflineCompo acL;

    public C9394a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.acL = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return C9394a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.acL.getLog();
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        return this.acL.priority();
    }

    public final void updateConfigs() {
        this.acL.updateConfigs();
    }
}
