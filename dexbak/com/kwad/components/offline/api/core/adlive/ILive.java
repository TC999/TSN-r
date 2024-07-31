package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
