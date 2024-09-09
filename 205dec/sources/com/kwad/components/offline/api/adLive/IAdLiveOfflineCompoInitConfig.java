package com.kwad.components.offline.api.adLive;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate;
import com.kwad.components.offline.api.core.soloader.ISoLoader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IAdLiveOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    AdLiveHttpRequestListenerDelegate getAdLiveHttpRequestListenerDelegate();

    ISoLoader soLoader();

    boolean usePhoneStateDisable();
}
