package com.kwad.components.offline.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements com.kwad.components.core.n.a.a.a {
    private final IAdLiveOfflineCompo acz;

    public a(@NonNull IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.acz = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.acz.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j4) {
        return this.acz.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j4);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveOfflineView getView(Context context, int i4) {
        return this.acz.getView(context, i4);
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final boolean oK() {
        return this.acz.getState() == IAdLiveOfflineCompo.AdLiveState.READY;
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acz.priority();
    }
}
