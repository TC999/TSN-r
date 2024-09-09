package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements com.kwad.components.core.n.a.c.a {
    private final IObiwanOfflineCompo acL;

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.acL = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.acL.getLog();
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acL.priority();
    }

    public final void updateConfigs() {
        this.acL.updateConfigs();
    }
}
