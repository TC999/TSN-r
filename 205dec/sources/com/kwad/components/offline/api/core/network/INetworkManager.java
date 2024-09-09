package com.kwad.components.offline.api.core.network;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface INetworkManager {
    void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);

    int getNetworkType(Context context);

    void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);
}
