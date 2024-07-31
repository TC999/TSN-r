package com.kwad.components.core.p304n.p305a.p306a;

import android.content.Context;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.components.InterfaceC9848a;

/* renamed from: com.kwad.components.core.n.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC8695a extends InterfaceC9848a {
    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j);

    IAdLiveOfflineView getView(Context context, int i);

    /* renamed from: oK */
    boolean mo28869oK();
}
