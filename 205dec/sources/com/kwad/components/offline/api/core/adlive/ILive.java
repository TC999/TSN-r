package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j4);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i4);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
