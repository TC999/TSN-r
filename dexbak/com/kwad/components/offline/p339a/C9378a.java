package com.kwad.components.offline.p339a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* renamed from: com.kwad.components.offline.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9378a implements InterfaceC8695a {
    private final IAdLiveOfflineCompo acz;

    public C9378a(@NonNull IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.acz = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.acz.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        return this.acz.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class<C9378a> getComponentsType() {
        return C9378a.class;
    }

    @Override // com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a
    public final IAdLiveOfflineView getView(Context context, int i) {
        return this.acz.getView(context, i);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a
    /* renamed from: oK */
    public final boolean mo28869oK() {
        return this.acz.getState() == IAdLiveOfflineCompo.AdLiveState.READY;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        return this.acz.priority();
    }
}
