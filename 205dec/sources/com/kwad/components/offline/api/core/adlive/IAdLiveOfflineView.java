package com.kwad.components.offline.api.core.adlive;

import android.view.TextureView;
import android.view.View;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopInfoListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.listener.KsAdLiveMessageListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IAdLiveOfflineView {
    TextureView getTextureView();

    View getView();

    void onDestroy();

    void registerAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener);

    void registerClickListener(AdLiveHandleClickListener adLiveHandleClickListener);

    void registerKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener);

    void registerLiveMessageListener(AdLiveMessageListener adLiveMessageListener);

    void registerLiveShopListener(AdLiveShopListener adLiveShopListener);

    void unRegisterAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener);

    void unRegisterClickListener(AdLiveHandleClickListener adLiveHandleClickListener);

    void unRegisterKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener);

    void unRegisterLiveMessageListener(AdLiveMessageListener adLiveMessageListener);

    void unRegisterLiveShopListener(AdLiveShopListener adLiveShopListener);
}
