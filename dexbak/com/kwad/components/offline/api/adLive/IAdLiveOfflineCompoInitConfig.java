package com.kwad.components.offline.api.adLive;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate;
import com.kwad.components.offline.api.core.soloader.ISoLoader;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IAdLiveOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    AdLiveHttpRequestListenerDelegate getAdLiveHttpRequestListenerDelegate();

    ISoLoader soLoader();

    boolean usePhoneStateDisable();
}
