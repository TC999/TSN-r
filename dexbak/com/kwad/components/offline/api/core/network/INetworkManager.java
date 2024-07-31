package com.kwad.components.offline.api.core.network;

import android.content.Context;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface INetworkManager {
    void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);

    int getNetworkType(Context context);

    void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);
}
