package com.kwad.components.offline.api.core.adlive;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IAdLivePlayModule {
    void addInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor);

    LiveShopItemInfo getCurrentShowShopItemInfo();

    long getPlayDuration();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener);

    void registerAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener);

    void release();

    void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor);

    void resume();

    void setAudioEnabled(boolean z3, boolean z4);

    void setForceGetAudioFocus(boolean z3);

    void skipToEnd();

    void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener);

    void unRegisterAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener);
}
