package com.kwad.components.core.p304n.p311b.p313b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.sdk.components.C9861c;

/* renamed from: com.kwad.components.core.n.b.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8737a implements ILive {
    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
        if (interfaceC8695a == null || !interfaceC8695a.mo28869oK()) {
            return null;
        }
        return interfaceC8695a.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i) {
        InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
        if (interfaceC8695a == null || !interfaceC8695a.mo28869oK()) {
            return null;
        }
        return interfaceC8695a.getView(context, i);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveEndRequest mIAdLiveEndRequest(String str) {
        InterfaceC8695a interfaceC8695a;
        if (TextUtils.isEmpty(str) || (interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class)) == null || !interfaceC8695a.mo28869oK()) {
            return null;
        }
        return interfaceC8695a.getAdLiveEndRequest(str);
    }
}
